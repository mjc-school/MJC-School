# Amazon RDS

## Practice

As part of this module, you'll work with the following resources: 
1. RDS instances
2. DB Subnet groups(do not confuse this with VPC Subnets!)
3. VPC security groups

IMPORTANT: do not forget to remove all the created resources after the task has been completed.

### Amazon Web Services

1. Create a publicly available DB instance in one of the DB subnets of your VPC. Do not forget to: <br />
• Choose a free-tier eligible engine <br />
• Choose a free-tier eligible template <br />
• Choose a free-tier eligible instance configuration <br />
• Provide just enough storage to get the DB instance to work(i.e., DO NOT allocate hundrends of GBs of storage) <br />
2. Configure your DB instance in a way that will allow you to connect to it from your computer.
3. Connect to your DB instance(for example, using MySQL Workbench if you had previously chosen a MySQL engine)
4. Run DDL, DML and DQL queries against your database.

### LocalStack

Unfortunately, there are no tasks to do in LocalStack in this module.

## Solution

In case you face any issues while doing the task please peek into the [AWS solution](./solution/rds/rds_solution_console.md)