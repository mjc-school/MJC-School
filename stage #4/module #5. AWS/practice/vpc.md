# AWS VPC

## Practice

### Prerequisites

* Please use this [table](resources/vpc/names.csv) to name your resources<br/>

### AWS & LocalStack
In this section you are going to create your own private net that spreads through 2 availability zones<br/>
Each of them includes 2 subnets namely a public and a private ones<br/>
Also you'll add an Internet gateway to provide the net with an Internet access and NAT gateways, too<br/>
Below there is a scheme to let you better visualize the net<br/>

![Sample net](resources/vpc/media/img_1.png)

**IMPORTANT: do not forget to remove all the created resources within AWS after the task has been completed**

See the recommended step guide to create a VPC
1. Create a private net itself
2. Add an Internet Gateway to provide the net with an Internet access
3. Add public subnets (keep in mind correct CIDR distribution across the net and  explicit routing)
4. Add private subnets
5. Add NAT Gateways for each AZs


## Solution
In case you face any issues while doing the task please peek into the [AWS solution](solution/vpc/vpc_solution.md) or [LocalStack solution](solution/vpc/vpc_solution_localstack.md)