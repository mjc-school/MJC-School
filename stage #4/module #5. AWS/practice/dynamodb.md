# AWS DynamoDB

## Practice

You're going to create a simple table called *MJC-<Your_Name>-Fleet*<br/>

**IMPORTANT: do not forget to remove all the created resources within AWS after the task has been completed**

### Prerequisites

* Use the [sample data](resources/dynamodb/dump.csv) to fill out the table
* Examine the table and think of what field can be a partition key and a sort one
* Pay attention there is no native date type supported, so normally string is used instead

### Amazon Web Services

#### First task
* Retrieve particular items performing necessary operations
    * perform a Scan operation and find all the added
    * get *USS Crossfield* ship's data via query operation
    * get registry of the ship named *SS Vico*
    * get description of the ship with registry *NCC-06*
    * get all the ships with class *Constitution*
    
#### Second task
Next, you're going to work with DynamoDB via *AWS CLI*<br/>
Please use the [documentation](https://awscli.amazonaws.com/v2/documentation/api/latest/reference/dynamodb/index.html) to use relevant commands<br/>
1. Do the same retrieval as in the first task with CLI only
2. Perform extra tasks:
  * execute describe command and examine its output
  * add some items to the table via batches - note here you should convert the csv into a json file
  * read some data with batch reading operation

### LocalStack

#### Task
* Retrieve particular items performing necessary operations
  * perform a Scan operation and find all the added
  * get *USS Crossfield* ship's data via query operation
  * get registry of the ship named *SS Vico*
  * get description of the ship with registry *NCC-06*
  * get all the ships with class *Constitution*
  * execute describe command and examine its output
  * add some items to the table via batches - note here you should convert the csv into a json file
  * read some data with batch reading operation


## Solution
In case you face any issues while doing the task please peek into the [AWS solution](solution/dynamodb/dynamodb_solution_console.md) or [LocalStack solution](solution/dynamodb/dynamodb_solution_localstack.md) 