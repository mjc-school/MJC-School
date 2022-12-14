# Amazon RDS

## Solution

### Creating an RDS instance running a MySQL database

* Go to the RDS service
* Click on "Create database"
* Choose a MySQL engine option
* Choose a Free tier in Templates
* Specify a master username and a master password
* Choose a free-tier eligible instance configuration
* Specify the minimum possible value of allocated storage
* Disable storage autoscaling
* Choose one of your custom VPCs or leave the default one as it is
* Choose one of your DB subnet groups or leave th default one as it is
* Click on "Yes" in Public access
* Choose one of your existing security groups or create a new one(keep in mind: it has to allow inbound TCP/IP connections over port 3306)
* Click on "Create database"

### Connecting to your MySQL database

* To connect to your MySQL database running on the RDS instance that you've created, you can use any tool that's available to you
* To connect to your MySQL database using MySQL Workbench, while on the home page, click on the "Database" tab, then choose "Connect to database"(OR simply use Ctrl+U hotkey)
* In Hostname, specify the endpoint of your RDS instance
* In Username, specify the master username
* In Password, specify the master password
* Click on "Ok", then connect to your instance

### Running queries

* To run DDL queries, create a table and then alter it
* To run DML queries, insert, update and delete some rows in the previously created table
* To run DQL queries, retrieve some rows from the table