# Amazon RDS

## Theory

Amazon Relational Database Service (RDS) is a fully managed service that provides the ability to create, configure and operate different relational databases. In this definition fully managed means that you don't have to think about the server management tasks(i.e., OS configuration and patching, software patching, backup creation). Instead, Amazon RDS takes care of these tasks for you allowing you to focus on using the database itself.

Apart from that, there are lots of other features that come out-of-the-box when you start using RDS. Here are some of those features:
• Amazon RDS allows you to choose how much memory, storage, IOPS and CPU resources your RDS instance will have with the ability to scale each of those independently.
• To deliver a managed service experience, Amazon RDS doesn't provide shell access to DB instances. It also restricts access to certain system procedures and tables that require advanced privileges.
• You can have automated backups performed on a particular schedule(which are turned on by default), or manually create your own backup snapshot.
• You can control who can access your RDS databases by using AWS Identity and Access Management (IAM) to define users and permissions.

As with EC2 instances, RDS instances are created inside a VPC, they can have a VPC security group and a public IP address assigned to them. Although there is a slight difference between EC2 and RDS instances - the latter are created inside *DB subnet groups* instead of ordinary VPC subnets.

### Key concepts

In order to get familiar with the service some key concepts should be described:
1. *Instance* - an isolated database environment running in the cloud. Think of it as a virtual server with a database installed on it.
2. *Engine* - a specific database software that runs on your DB instance(e.g., MySQL, PostgreSQL, Oracle, etc.).
3. *DB subnet group* - a collection of subnets (typically private) that you create in a VPC and that you then designate for your DB instances. Each DB subnet group should have subnets in at least two Availability Zones in a given AWS Region. When creating a DB instance in a VPC, you choose a DB subnet group for it.

### RDS authentication options

Amazon RDS supports several ways to authenticate database users:
1. Password authentication - based on the database itself(by way of creating internal database users and specifying passwords for them).
2. IAM authentication - based on IAM capabilities and resources(users).
3. Kerberos authentication - external type of authentication which uses Kerberos protocol and Microsoft Active Directory.

[Read more](https://docs.aws.amazon.com/AmazonRDS/latest/UserGuide/database-authentication.html)

### RDS replication options

Amazon RDS replication is the option which allows you to have replicas(copies) of your DB instance. You can create 2 kinds of these replicas:
1. Standby replica - data is synchronously replicated between it and the original DB instance, cannot accept connections for reading data.
2. Read replica - data is asynchronously replicated between it and the original DB instance, can accept connections for reading data(thus decreasing the workload on your original DB instance).

[Read more about read replicas](https://docs.aws.amazon.com/AmazonRDS/latest/UserGuide/USER_ReadRepl.html#USER_ReadRepl.Overview)

[Read more about standby replicas](https://docs.aws.amazon.com/AmazonRDS/latest/UserGuide/Concepts.MultiAZ.html)

### RDS backup options

Amazon RDS creates and saves automated backups of your DB instance during the backup window of your DB instance. Here's it works: 
• If a DB instance is available and a DB snapshot copy isn't being created for this DB instance, then DB instance can be backed up.
• RDS creates a storage volume snapshot of your DB instance(backing up the entire DB instance, not just individual databases). 
• RDS saves the automated backups of your DB instance according to the backup retention period that you specify.

If you need to, you can also create your backups manually.

[Read more](https://docs.aws.amazon.com/AmazonRDS/latest/UserGuide/USER_WorkingWithAutomatedBackups.html)

## Pricing considerations

Amazon RDS pricing depends on a number of factors, such as RDS instance type, the database engine that is used(MySQL, PostgreSQL, etc.) and also the size of the storage for your data(in GBs).

Apart from that, similar to EC2, Amazon RDS offers 2 types of pricing: 
1. On-demand - pay-per-hour, no upfront costs, no long time commitments
2. Reserved Instances - reservation of a particular instance for long periods of time(1 year or 3 years), full upfront/partial upfront/no upfront costs, no ability to cancel your purchase

[Read more](https://aws.amazon.com/rds/pricing/)

## Quiz

1. Which of the following features are you responsible for when working with RDS instances?
- a) Database configuration & operation
- b) Creating backups
- c) Software patching
- d) All of the above
2. Can you connect directly to the DB instance(for example, to install some additional software on it)?
- a) Yes
- b) No
- c) No by default, but can be configured to yes
3. Will you be billed if you stop your RDS instance?
- a) No
- b) Yes, only for provisioned storage
- c) Yes, for backup storage and provisioned storage
- d) Yes, only for backup storage
4. Which database engine is not supported by Amazon RDS?
- a) MySQL
- b) Microsoft SQL Server
- c) MariaDB
- d) SQLite
5. Which DB instance storage is the most optimized for fast and consistent throughput of input and output operations?
- a) Provisioned IOPS
- b) General Purpose SSD
- c) Magnetic Storage
6. Which purchasing options are supported in Amazon RDS?
- a) On-demand instances
- b) Dedicated instances
- c) Reserved instances
- d) Spot instances
7. What are the basic conditions which has to be followed in order to create a DB instance backup?
- a) DB instance should be in the "Available" state
- b) DB backup window and DB maintenance window cannot overlap
- c) DB instance cannot have any active connections
- d) All of the above
8. Can a standby replica accept connections for read queries in a Multi-AZ DB deployment?
- a) Yes
- b) No
9. Can you connect directly to the database on a DB instance(for example, from an EC2 instance inside the same VPC)?
- a) Yes
- b) No
10. What type of replication is used when working with read replicas?
- a) Asynchronous replication
- b) Synchronous replication
- c) All of the above

## General requirements
1. A mentee should be able to explain the general purpose of the service
2. A mentee should be able to answer all the questions during a demo session.

## Keys

1. a
2. b
3. c
4. d
5. a
6. a, c
7. a, b
8. b
9. a
10. a

## Extra Materials

1. [Amazon RDS Official Documentation](https://docs.aws.amazon.com/AmazonRDS/latest/UserGuide/)
2. [Amazon RDS Official FAQ](https://aws.amazon.com/rds/faqs/)
3. [Amazon RDS Tutorial (video)](https://www.youtube.com/watch?v=KpVNEzpvaY0)
