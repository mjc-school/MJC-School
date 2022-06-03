1. Scaling approaches
    1. Imagine you have a web site that is hosted on some server. When a site becomes popular, it has to handle more and more users. One day it will run out of resources
    2. The easiest way is to simply give it more resources - vertical scaling. Cons - cost, single point of failure, you can't do it forever
    3. Horizontal scaling - adding more servers. Pros - infinite scaling, some servers may break down. Cons - you have to balance load between them. Is considered best practice.
2. Problems with SQL databases
    1. Scaling - you can't really scale it horizontally
    2. Performance - normalized data requires many joins, ACID transactions have a huge overhead
    3. Cost - comes from scaling and performance
    4. Strict schema - reliable, but difficult to change in production
3. Variants on the meaning of the term NoSQL
    1. Not-SQL - don't support SQL standard
    2. Not-only SQL - they have structured query language, but their own
4. General difference with SQL db
    1. Schema
    2. Data structure
    3. Scaling - NoSQL databases support huge clusters
    4. Data access approach - SQL uses joins, NoSQL uses denormalization
    5. Transaction model - BASE vs ACID
        1. ACID - to be sure that data isn't lost, that operations are executed atomically, you don't want to lose finantial data. Disk breaks down and we can't record a transaction - exception when committing it
        2. BASE - high availability, if one server in cluster breaks down, we replace it with another
    6. Sharding and replication
        1. Sharding is basically horizontal scaling. Data is distributed between several nodes, each serves specific subset of data
        2. Replication - we copy data in case something breaks down. Also replicas can serve read requests
5. NoSQL types
    1. Document store - documents don't have to be plain
    2. KV store - fewer functions available. Usually used as cache for time-consuming operations. Used for cache
    3. Graph db
6. Demo 1
    1. MongoDB Compass
        1. Insert data
        2. View it's structure
        3. Simple filter - `{ status: "PUBLISH" }`
        4. Aggregation pipeline
            1. Match `{ status: "PUBLISH" }` 
            2. AddField `{ authorsCount: { $size: "$authors"}}`
            3. Match `{ authorsCount: { $gt: 2 }}` 
            4. Count `total`
    2. Redis
        1. `SET key value`
        2. `GET key`
        3. `DEL key`
        4. `GET key`
        5. `SET expiring value`
        6. `EXPIRE expiring 20`
        7. `TTL expiring`
        8. `GET expiring`
        9. `LPUSH list element`
        10. `LSCAN list`
7. Graphs 
8. Demo 2
    1. Neo4j
        1. `MATCH (entity) RETURN entity` 
        2. `MATCH (tom {name: "Tom Hanks"}) RETURN tom`
        3. `MATCH (tom:Person {name: "Tom Hanks"})-[:ACTED_IN]->(tomHanksMovies: Movie) RETURN tom,tomHanksMovies`
        4. `MATCH (bacon:Person {name:"Kevin Bacon"})-[:ACTED_IN]-(movie:Movie)-[:DIRECTED]-(director:Person) RETURN DISTINCT bacon, movie, director` 
9. Other NoSQL DB types
    1. Wide-column - used in Big Data, can store hundreds of terabytes of data
    2. Full text search - can look not only for exact matches, but also for other word forms (plural / singular), synonyms, etc.
    3. Time-series data
10. Will SQL DBs die - no, because they provide some guarantees that NoSQL dbs can't provide. SQL dbs will probably lose some influence, but they are with us for ever. Many projects now have multiple DBs, SQL + NoSQL
11. Choosing NoSQL
    1. Don't choose "the most popular", or "trendy"
    2. First choose type required by your project, then implementation
