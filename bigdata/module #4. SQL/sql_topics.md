## SQL

### Topics

_NOTE : Consider ANSI SQL as a subject of discussion in the scope of this topic. 
Knowledge of the details of a particular DBMS and the ability to compare it with others ( ideally ) is appreciated._

- DDL, DML Basics
- Keys
    - Give short description of all the key types
    - What is auto increment, when is it used and what problems we might have when using it?
    - How to reset it?
    - What's the best way to implement many-to-many connection?
- SELECT statement, execution order
- Joins
    - Join types and their definitions
    - What is Semi-join/anti-join?
    - What is the difference between anti-join with "not exists" and "not in" clause?
    - Lateral word with joins
- GROUP BY, HAVING, WHERE
    - Description and examples
    - How group by with multiple columns work?
- DROP, DELETE vs TRUNCATE
    - What happens to indexes?
    - What is faster? Why?
- Window functions
    - Window functions types 
    - Difference between rank/row_number/dense_rank
    - PARTITION BY and ORDER BY clauses 
- Indexes
    - Index meaning, structure, physical meaning. Know valid Oracle index structures.
    - When we need to create manual index based on some column?
    - Pros/cons of using indexes.
    - Why are indexes faster for retrieving data?
- View
    - What do we need them for?
    - How to create one?
    - Indexed view
    - Materialized view
    - Partitioned view
- Stored procedure, package
    - What is it?
    - How can you check the text of the stored procedure that you created?
    - Stored procedures vs functions?
    - Stored procedures vs view?
- Trigger
    - What Are Ddl Triggers And Types Of Ddl Trigger?
    - What Are Dml Triggers And Types Of Dml Trigger?
    - After/Instead triggers?
- Transactions
    - Transaction isolation levels
    - Issues with parallel transactions
    - What is the default isolation level?
    
__Links:__ 
- [SQL language reference from oracle 19 release](https://docs.oracle.com/en/database/oracle/oracle-database/19/sqlrf/sql-language-reference.pdf)
- [Good Join dive in. Part 1](http://datareview.info/article/8-sposobov-obedineniya-join-tablic-v-sql-chast-1/)
- [Good Join dive in. Part 2](http://datareview.info/article/8-sposobov-obedineniya-join-tablic-v-sql-chast-2/)
- [Issue with "not in" clause](http://daleburnett.com/2011/10/the-danger-of-not-in-or-you-keep-using-that-word-i-do-not-think-it-means-what-you-think-it-means/)
- [Materialized view](https://oracle-base.com/articles/misc/materialized-views)
    
## Task 1 (theoretic task)

Transaction table `t` is given:

| record_type | tr_date    | tr_id | amount | cust_id |
| ----------- | ---------- | ----: | -----: | ------: |
| HEADER      | 2018-01-01 | 1     |   5	| 2       |
| ITEM        | 2018-01-01 | 1     |   2	| 2       |
| ITEM        | 2018-01-02 | 1     |   1	| 2       |
| ITEM        | 2018-01-03 | 1     |   2	| 2       |
| HEADER      | 2018-01-02 | 1     | -12	| 2       |
| ITEM        | 2019-03-27 | 2     |  22	| 2       |
| ITEM        | 2019-03-26 | 2     |  11	| 2       |
| ITEM        | 2019-03-28 | 2     |   7	| 2       |
| HEADER      | 2019-03-27 | 2     |  40	| 2       |
| ITEM        | 2018-01-01 | 3     |   2	| 3       |
| ITEM        | 2018-01-02 | 3     |   1	| 3       |
| ITEM        | 2018-01-03 | 3     |   2	| 3       |

Complete the following tasks:
1) Select records with the top 3 _amount_ for each customer's(_cust_id_) transaction (_tr_id_) 
2) Select all "HEADER" transactions, in addition, for each transaction calculate the number of days that have passed since the previous transaction of the same customer (let's say there's a function *days_between(one_date, second_date)*)
3) Calculate cumulative sum (sum of the transaction amount from the beginning to the current moment(_tr_date_)) and the total sum for each customer's(_cust_id_) transaction (_tr_id_). Output schema example: " *, tr_cum_sum, total_sum "
4) Select transaction data without duplicates by _record_type_, _tr_id_ and _amount_ for each customer. In several ways