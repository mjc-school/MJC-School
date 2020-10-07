# SQL - Practical task
__Deadline:__ 7 working days.  

__Disclaimer:__ In case of any questions related to the task please immediately contact any of the mentors to avoid misunderstanding.

## Legend

Customer would like to extend analysis with another feed - [Stop and Search](https://www.lincs.police.uk/reporting-advice/stop-and-search/) data.
Then downloaded data needs to be analyzed in order to provide various statistics for future reports.

## Requirements

### Stop and Search Implementation

Extend the application from the previous task with the new implementation - [Stop and searches by force](https://data.police.uk/docs/method/stops-force/) data. Implementation should align the similar requirements:

* Map API method response object to the __existing__ database schema (i.e. already existing tables shall not be duplicated). Schema creation SQL script should be committed to the git repository as well.
* List of forces should be fetched from the another API method for the specific month - [List of forces](https://data.police.uk/docs/method/forces/).
* Date range to fetch should be provided as an option as well.
* All database constraints should be preserved and duplicates eliminated.
* Implementation should properly handle [API call limits](https://data.police.uk/docs/api-call-limits/).
* `5xx` and `404` API errors should be properly handled and do not stop application execution.

### Database

Download at least 5 months of data for each station and for each implementation (i.e. [Stops At Location](https://data.police.uk/docs/method/stops-street/) and [Street Level Crimes](https://data.police.uk/docs/method/crime-street/)) using the application from the previous task.

### Queries

Write several SQL queries by the given specification (below). Queries should align with the following constraints:
* Subqueries in `SELECT` clause are not allowed.
* [Correlated subqueries](https://en.wikipedia.org/wiki/Correlated_subquery) are not allowed.
* Each query should be stored in a separate file. Name of the file should start with the index of the query and can contain short query description.
* Each query should be properly formatted using common SQL code style (there is no single code style, but [Kickstarter SQL Style Guide](https://gist.github.com/fredbenenson/7bb92718e19138c20591) can be used as good example).

__Hint:__ for some queries [Window Functions](https://www.postgresql.org/docs/9.5/tutorial-window.html) might be extremely helpful.


#### 1. Most dangerous streets

**Description:**

Top streets by crime number within specified period.

**Input:**

* Start month.
* End month.

**Output:**

* Street ID.
* Street name.
* Period (format: `from <start> till <end>`, e.g. `from 2016-01 till 2018-01`).
* Crime count.

<!--
SELECT 
    s.id AS street_id,
    s.name AS street_name,
    concat('from ', @start_month, ' till ', @end_month) AS period,
    count(*) AS crime_count
FROM crime c
INNER JOIN location l ON c.location_id = l.id
INNER JOIN street s ON s.id = l.street_id
WHERE c.month BETWEEN @start_month AND @end_month
GROUP BY street_id, street_name, period
ORDER BY crime_count DESC;
-->

#### 2. Month to month crime volume comparison

**Description:**

Changes between each month in crime counts within each category and specified period.

**Input:**

* Start month.
* End month.

**Output:**

* Crime category.
* Month.
* Previous month count.
* Current month count.
* Delta count.
* [Basic growth rate](https://www.wikihow.com/Calculate-Growth-Rate), e.g. `5.55%`, `-15.7%`.

<!--
SELECT 
    category,
    month,
    current_month_count,
    lag(current_month_count) OVER w AS previous_month_count,
    current_month_count - lag(current_month_count) OVER w AS delta_count,
    concat((current_month_count - lag(current_month_count)) / lag(current_month_count) * 100, '%') OVER w AS growth_rate
FROM (
    SELECT 
        base.category,
        base.month,
        nvl(current_month_count, 0)
    FROM (
        SELECT DISTINCT
            c.category,
            c.month
        FROM crime c
    ) base
    LEFT JOIN (
        SELECT
            c.category,
            c.month,
            count(*) as current_month_count
        FROM crime c
        WHERE c.month BETWEEN @start_month AND @end_month
        GROUP BY c.category, c.month
    ) counted
    ON base.category = counted.category AND base.month = counted.month
)
WINDOW w AS (PARTITION BY category ORDER BY month);
-->

#### 3. Crimes with specified outcome status

**Description:**

Count and percentage of crimes per each location (street), within the given period, where outcome category equals to the given value. Taken into account only crimes where outcome status is present.

**Input:**

* Outcome category.
* Start month.
* End month.

**Output:**

* Street ID.
* Street name.
* Outcome category value.
* Count of crimes with the specified outcome category.
* Percentage of the total crimes (where outcome category is present).

<!-- 
SELECT 
    s.id AS street_id,
    s.name AS street_name,
    @outcome_category AS outcome_category,
    sum(if(o.category = @outcome_category, 1, 0)) AS outcome_category_count
    concat((sum(if(o.category = @outcome_category, 1, 0)) / count(*)) * 100, '%') AS percentage_of_total
FROM crime c
INNER JOIN outcome_status o ON c.outcome_status_id = o.id
INNER JOIN location l ON c.location_id = l.id
INNER JOIN street s ON s.id = l.street_id
WHERE c.month BETWEEN @start_month AND @end_month
  AND o.category IS NOT NULL
GROUP BY street_id, street_name, outcome_category;
-->

#### 4. Stop and search statistics by ethnicity

**Description:**

Various Stop and Search statistics by ethnicity (officer_defined_ethnicity) within specified period:
* Total number of occurrences.
* Rate of Stop and Search with 'Arrest' outcome.
* Rate of Stop and Search with 'A no further action disposal' outcome.
* Rate of Stop and Search with other outcomes.
* Most popular object of search.

**Input:**

* Start date.
* End date.

**Output:**

* Officer-defined ethnicity.
* Total number of stop and search for ethnicity.
* Arrest rate.
* No action rate.
* Other outcome rate.
* Most popular object of search.

<!-- 
SELECT 
   s.officer_defined_ethnicity,
   count(*) AS total_number_for_ethnicity,
   concat((sum(if(s.outcome = 'Arrest', 1, 0)) / count(*)) * 100, '%') AS arrest_rate,
   concat((sum(if(s.outcome = 'A no further action disposal', 1, 0)) / count(*)) * 100, '%') AS no_action_rate,
   concat((sum(if(s.outcome NOT IN ('Arrest', 'A no further action disposal'), 1, 0)) / count(*)) * 100, '%') AS other_outcome_rate,
   most_popular_object.object_of_search
FROM stop_and_search s
INNER JOIN (   
    SELECT 
        officer_defined_ethnicity,
        object_of_search,
        count_per_object,
        row_number() OVER (PARTITION BY officer_defined_ethnicity, object_of_search ORDER BY count_per_object DESC) AS rn
    FROM (
        SELECT
            officer_defined_ethnicity,
            object_of_search,
            count(*) AS count_per_object
        FROM stop_and_search s
        WHERE substr(datetime,0,10) BETWEEN @start_date AND @end_date
        GROUP BY officer_defined_ethnicity, object_of_search
    ) counts_per_objects
) most_popular_object
ON s.officer_defined_ethnicity = most_popular_object.officer_defined_ethnicity 
   AND most_popular_object.rn = 1

-->

#### 5. Most probable Stop and Search snapshot on street level

**Description:**

Within specified date range, find the most probable Stop and Search characteristics for each street:
* Most popular age range.
* Most popular gender.
* Most popular ethnicity.
* Most popular object_of_search.
* Most popular outcome.

__Note:__ each person parameter do not depend on the others.

**Input:**

* Start date.
* End date.

**Output:**

* Street ID.
* Street name.
* Age Range.
* Gender.
* Ethnicity.
* Object of search.
* Outcome.

<!-- 
WITH base AS (
    SELECT
        s.id AS street_id,
        s.name AS street_name,
        sas.age_range
        sas.gender,
        sas.officer_defined_ethnicity AS ethnicity,
        sas.object_of_search,
        sas.outcome
    FROM stop_and_search sas
    INNER JOIN location l ON sas.location_id = l.id
    INNER JOIN street s ON l.street_id = s.id
    WHERE substr(datetime,0,10) BETWEEN @start_date AND @end_date
),
age_range AS (
    SELECT DISTINCT
        street_id,
        first_value(parameter) OVER (PARTITION BY street_id ORDER BY cnt DESC) AS most_probable
    FROM (
        SELECT
            street_id,
            age_range AS parameter,
            count(*) AS cnt
        FROM base
        GROUP BY street_id, parameter
    )
),
gender AS (
    SELECT DISTINCT
        street_id,
        first_value(parameter) OVER (PARTITION BY street_id ORDER BY cnt DESC) AS most_probable
    FROM (
        SELECT
            street_id,
            gender AS parameter,
            count(*) AS cnt
        FROM base
        GROUP BY street_id, parameter
    )
),
ethnicity AS (
    SELECT DISTINCT
        street_id,
        first_value(parameter) OVER (PARTITION BY street_id ORDER BY cnt DESC) AS most_probable
    FROM (
        SELECT
            street_id,
            ethnicity AS parameter,
            count(*) AS cnt
        FROM base
        GROUP BY street_id, parameter
    )
),
object_of_search AS (
    SELECT DISTINCT
        street_id,
        first_value(parameter) OVER (PARTITION BY street_id ORDER BY cnt DESC) AS most_probable
    FROM (
        SELECT
            street_id,
            object_of_search AS parameter,
            count(*) AS cnt
        FROM base
        GROUP BY street_id, parameter
    )
),
outcome AS (
    SELECT DISTINCT
        street_id,
        first_value(parameter) OVER (PARTITION BY street_id ORDER BY cnt DESC) AS most_probable
    FROM (
        SELECT
            street_id,
            outcome AS parameter,
            count(*) AS cnt
        FROM base
        GROUP BY street_id, parameter
    )
)
SELECT 
    s.id AS street_id,
    s.name AS street_name,
    age_range.most_probable AS age_range,
    gender.most_probable AS gender,
    ethnicity.most_probable AS ethnicity,
    object_of_search.most_probable AS object_of_search,
    outcome.most_probable AS outcome
FROM street s
LEFT JOIN age_range ON age_range.street_id = s.id
LEFT JOIN gender ON gender.street_id = s.id
LEFT JOIN ethnicity ON ethnicity.street_id = s.id
LEFT JOIN object_of_search ON object_of_search.street_id = s.id
LEFT JOIN age_range ON outcome.street_id = s.id
-->

#### 6. Stop and Search correlation with crimes 

**Description:**

Comparison between Stop and Search data with "Arrest" outcome and Crime data on the street level by the following _Object of Search_/_Crime category_ pairs:
* "drugs" _to_ "Controlled drugs"
* "possession-of-weapons" _to_ "Offensive weapons" and "Firearms"
* "theft-from-the-person" and "shoplifting" _to_ "Stolen goods"

**Input:**

* Start month.
* End month.

**Output:**

* Street ID.
* Street Name.
* Month.
* Drugs crimes count.
* Drugs stop-and-search count.
* Weapons crimes count.
* Weapons stop-and-search count.
* Theft crimes count.
* Theft stop-and-search count.

## Deployment Script
Write deployment Bash script which should help to review and use implemented code.

### Common script requirements:
* Execute in batch mode.
* Perform all necessary input and path validations, check that required services running, perform some error handling.
* Print user-friendly output during script execution (consider providing ability to enable/disable non-script output (i.e. preserve only script-specific echo output) at all through an option `-v`/`--verbose`).
* Show Unix-like help message which describes all features and usage of the script.
* Refer [Google Shell Style Guide](https://google.github.io/styleguide/shell.xml) to make your code more readable and [Shell Check](https://www.shellcheck.net/) to avoid common mistakes.

### Business features:
* Run any of the implemented queries by it's index (specified in the option) with the sample hardcoded arguments.
* Collect the results to the file (name can be either generated automatically or passed through an option).
* Print several rows of query result to the console (number of rows to print specified through an option).  
  **Hint:** `column` Unix command suits well for printing tables.

## Acceptance

* The most recent available at `master` branch setup/deployment scripts are used every time.
* Reviewer has OS version, configured by the script from Task 1, database configured and loaded by the script from Task 2.
* Reviewer can be able to execute the script correctly after referring built-in help message.