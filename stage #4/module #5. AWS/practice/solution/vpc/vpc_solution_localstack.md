# AWS VPC

## Solution

Please reference these docs<br/>
[Create VPC Command Overview](https://docs.aws.amazon.com/cli/latest/reference/ec2/create-vpc.html)<br/>
[Create Internet Gateway Command Overview](https://docs.aws.amazon.com/cli/latest/reference/ec2/create-internet-gateway.html)<br/>
[Create NAT Gateway Command Overview](https://docs.aws.amazon.com/cli/latest/reference/ec2/create-nat-gateway.html)<br/>
[Create Subnets Command Examples](https://docs.aws.amazon.com/vpc/latest/userguide/vpc-subnets-commands-example.html)<br/>
[Create Subnets Command Overview](https://docs.aws.amazon.com/cli/latest/reference/ec2/create-subnet.html)<br/>
[Create Route Tables Command Overview](https://docs.aws.amazon.com/cli/latest/reference/ec2/create-route-table.html)<br/>

### First step

![First step](../../resources/vpc/media/img_2.png)
Here you can see the default step that requires no additional configuration<br/>
You have some AZs and the Internet access in any region by default

### Second step

![Second step](../../resources/vpc/media/img_3.png)
Next, you're going to create a vpc itself with specified CIDR block (10.0.0.0/16)<br/>

Use *create-vpc* command 

### Third step

![Third step](../../resources/vpc/media/img_4.png)
Next, introduce an Internet gateway in order to enable the net access the Internet

Use *create-internet-gateway* command to create an Internet Gateway<br/>
Use *attach-internet-gateway* command to attach it to the net

### Fourth step

![Fourth step](../../resources/vpc/media/img_5.png)
Add some subnets to the net. First create public ones

Use *create-subnet* to add subnets

### Fifth step

![Fifth step](../../resources/vpc/media/img_6.png)
Configure routes so that all the packages routed to the Internet will go to the Internet because as for now it's not like that<br/>

Use *create-route-table* command to create route tables<br/>
Use *describe-route-tables* command to ensure you did everything correctly

### Sixth step

![Sixth step](../../resources/vpc/media/img_7.png)
Add private subnets

Use *create-subnet* to add subnets

### Seventh step

![Seventh step](../../resources/vpc/media/img_1.png)
End in adding NAT gateways<br/>

Use *create-nat-gateway*