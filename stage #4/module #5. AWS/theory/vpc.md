# AWS VPC

## Theory

The VPC - Virtual Private Cloud - is a service that lets you launch your own virtual network. This virtual network closely resembles a traditional network that you'd operate in your own data center,
with the benefits of using the scalable infrastructure of AWS.
Actually you've been dealing with this kind of entities from the very beginning since under the hood AWS launches the *default VPC* in each region within your account.
Your default VPCs are configured such that you can immediately start launching and connecting to EC2 instances. [Here you can read about it more](https://docs.aws.amazon.com/vpc/latest/userguide/vpc-getting-started.html)
<br/>It's pretty important to be aware of what the VPC is in view of the fact that it's the most efficient way to isolate your resources and the secure them most efficiently

In order to get familiar with the service some key concepts should be described
1. A *VPC* is a virtual network that closely resembles a traditional network that you'd operate in your own data center. After you create a VPC, you can add subnets <br/>[read more](https://docs.aws.amazon.com/vpc/latest/userguide/configure-your-vpc.html)
2. A *subnet* is a range of IP addresses in your VPC. A subnet must reside in a single Availability Zone. After you add subnets, you can deploy AWS resources in your VPC <br/>[read more](https://docs.aws.amazon.com/vpc/latest/userguide/configure-subnets.html)
3. You can assign IPv4 addresses and IPv6 addresses to your VPCs and subnets. You can also bring your public IPv4 and IPv6 GUA addresses to AWS and allocate them to resources in your VPC, such as EC2 instances, NAT gateways, and Network Load Balancers.
4. A *CIDR block* is a range of IP addresses available in your VPC. It's almost a synonym for a subnet term but more specific <br/>[read more](https://docs.aws.amazon.com/vpc/latest/userguide/configure-your-vpc.html#vpc-cidr-blocks)
5. *Route tables* are used to determine where network traffic from your subnet or gateway is directed  <br/>[read more](https://docs.aws.amazon.com/vpc/latest/userguide/VPC_Route_Tables.html)
6. A *gateway* connects your VPC to another network. For example, use an internet gateway to connect your VPC to the internet. Use a VPC endpoint to connect to AWS services privately, without the use of an internet gateway or NAT device  <br/>[read more](https://docs.aws.amazon.com/vpc/latest/userguide/extend-intro.html)
7. *VPC peering connection* enables routing traffic between the resources in two VPCs <br/>[read more](https://docs.aws.amazon.com/vpc/latest/peering/)
8. A *flow log* captures information about the IP traffic going to and from network interfaces in your VPC <br/>[read more](https://docs.aws.amazon.com/vpc/latest/userguide/flow-logs.html)


Keeping in mind that definition, note there are some features within the service which we'll briefly cover below

- There is a soft limit for maximum number of subnets in a single VPC - 200. In case you need more contact support <br/>[read more](https://aws.amazon.com/vpc/faqs/)
- You're able to launch 2 types of subnets within VPCs. They are public and private ones <br/>[read more](https://docs.aws.amazon.com/vpc/latest/userguide/VPC_Scenario2.html)
- In order to access a private a bastion host is going to be used through public subnet <br/>[read more](https://aws.amazon.com/quickstart/architecture/linux-bastion/)
- In case you want to connect to your private subnet from for instance from home computer a VPN connection should be used. It consists of two parts: customer gateway on your side and virtual private gateway on AWS's side. In fact, it emulates the situation when we access VPC not via Internet but via its public subnet <br/>[read more](https://docs.aws.amazon.com/vpc/latest/userguide/vpn-connections.html)
- There is an opportunity to access the Internet from a private subnet. Either NAT gateway or NAT instance should be used.
- It's a best practice to use NAT gateway instead of NAT instance since the second one is actually an instance with finite power just like any other EC2 instance <br/>[read more](https://docs.aws.amazon.com/vpc/latest/userguide/vpc-nat-comparison.html)
- When VPC peering is enabled then direct connections should be used from one to another. This means that in case you have for instance 3 VPCs then you have to connect 1 and 2, 1 and 3, 2 and 3 - have 3 connections due to the fact no opportunity to transfer data directly from 1 to 3 via 2 present. This feature of VPC is called *non-transient* <br/>[read more](https://docs.aws.amazon.com/vpc/latest/peering/what-is-vpc-peering.html)

As an example of a VPC net loot at the image below<br/>

![Example VPC](../practice/resources/vpc/media/img_1.png) 

This VPC is made of several parts:
1. A net itself
2. An Internet Gateway that provides the net with an Internet access
3. Public subnets
4. Private subnets
5. NAT Gateways for each AZs that provide private subnets with an Internet access

## General requirements
1. A mentee should be able to explain general purpose of the service
2. A mentee should be able to answer all the questions during a demo session.

## Extra Materials

1. [AWS VPC Official Documentation](https://aws.amazon.com/vpc/)
2. [AWS VPC Official FAQ](https://aws.amazon.com/vpc/faqs/)
3. [AWS Essentials](https://www.youtube.com/playlist?list=PLv2a_5pNAko0Mijc6mnv04xeOut443Wnk)
4. [AWS Concepts](https://www.youtube.com/playlist?list=PLv2a_5pNAko2Jl4Ks7V428ttvy-Fj4NKU)
5. [Cloud Computing Fundamentals](https://youtu.be/uroryFU78gM)
6. [AWS Tutorial for Begginers](https://youtu.be/IT1X42D1KeA)
7. [Getting started with Amazon VPC](https://docs.aws.amazon.com/vpc/latest/userguide/vpc-getting-started.html)

