# Java - Practical task
__Deadline:__ 9 working days.  

__Disclaimer:__ In case of any questions related to the task please immediately contact any of the mentors to avoid misunderstanding.

### Legend

UK Police department would like to analyze existing crime information in London streets and figure out the main trends and relations between the crimes.
First of all you need to download the data from [existing API](https://data.police.uk/docs/) and store it in the database for further analysis.

### Requirements

#### Database

* Investigate the following [Street Level Crimes API method](https://data.police.uk/docs/method/crime-street/).
* Map API method response object to the database schema, each DB table should represent a single JSON object (same for nested objects) with required relations and constraints (API objects IDs, if present, should be primary keys in the target schema as well).
* Schema creation SQL script should be committed to the git repository as well.

#### Application

Implement __extensible__ command line java application which should be able to download data from the mentioned API and save it in various targets (DB, file).

* "Extensible" in this context means that it's possible to support other API methods (e.g. [Outcomes](https://data.police.uk/docs/method/outcomes-at-location/) or [Stop and search](https://data.police.uk/docs/method/stops-street/)) and targets just by adding corresponding implementations with a few code changes.
* Consider using java-style arguments (`-Dproperty.name=value`) in case of implementation-specific options ([Apache Commons CLI](https://www.tutorialspoint.com/commons_cli/commons_cli_properties_option.htm) can be used for this). 
* Proper error handling and user-friendly output during script execution should be implemented.
* All available options and command line arguments should be listed in help message (as well as implementation-specific options).
* JDBC wrapper library ([FluentJDBC](https://github.com/zsoltherpai/fluent-jdbc), [Spring JDBC Template](https://spring.io/guides/gs/relational-data-access/), [Apache Commons DbUtils](https://commons.apache.org/proper/commons-dbutils/), etc.) can be used in order to simplify DB access.
* __Feel free to implement other unmentioned options and features that you think will improve your application__

#### Street Level Crimes Implementation

Write an implementation for the application above which should be able to download street level crimes from the list of existing coordinates, parse the result and save it into the database.

* Target API method is `https://data.police.uk/api/crimes-street/all-crime` ([Documentation](https://data.police.uk/docs/method/crime-street/))
* List of existing coordinates should be provided from a file (path to the file passed as an option). Kindly use [LondonStations.csv](https://gist.github.com/Meosit/bd4d42dcf7e863fef4283c7b3d28f663) as the input file for this task.
* Date range to fetch should be provided as option as well.
* All database constraints should be preserved and duplicates eliminated.
* Implementation should properly handle [API call limits](https://data.police.uk/docs/api-call-limits/).
* `5xx` and `404` API errors should be properly handled and do not stop application execution.

### Deployment Script

Write deployment Bash script, which should be able to:
* Execute in __batch__ mode.
* Ensure that PostgreSQL is running and check that required tables already present (if not, schema creation script should be executed).
* Provide an option to clear database data.
* Build the project with maven (option to disable/enable this stage should be present as well).
* Run your application for a sample month range.
* Perform all necessary input and path validations, check that required services running, perform some error handling.
* Print user-friendly output during script execution (consider providing ability to enable/disable non-script output (i.e. preserve only script-specific echo output) at all through an option `-v`/`--verbose`).
* Show Unix-like help message which describes all features and usage of the script.
* Refer [Google Shell Style Guide](https://google.github.io/styleguide/shell.xml) to make your code more readable and [Shell Check](https://www.shellcheck.net/) to avoid common mistakes.

### Technology stack

* Build tool: Maven (Gradle can also be used).
* Logging framework: SLF4J.
* Database: PostgreSQL 9.4 or higher.
* Database connection pooling: HikariCP.

### Acceptance

* The most recent available at `master` branch setup/deployment scripts are used every time.
* Reviewer has OS version, configured by the script from Task 1.
* Reviewer can be able to execute the script correctly after referring built-in help message.