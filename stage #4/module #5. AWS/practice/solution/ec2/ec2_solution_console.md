# Amazon EC2

## Solution

### Creating an EC2 instance and its Security Group

* Go to the EC2 service
* Click on "Launch instance"
* Specify a name for your instance in the "Name" field
* Choose any free-tier AMI in the "Amazon Machine Image (AMI)" dropdown
* Choose any free-tier instance type in the "Instance type" dropdown
* Click on "Create new key pair" that will be used to connect to your EC2 instance securely
* Specify a key pair name
* Click on "Create key pair"
* In Network settings, click on "Allow HTTPS traffic from the internet" and "Allow HTTP traffic from the internet" checkboxes
* Click on "Launch instance"

### Installing an HTTP server

To install and configure an HTTP server, refer to [this tutorial](https://docs.aws.amazon.com/AmazonRDS/latest/UserGuide/CHAP_Tutorials.WebServerDB.CreateWebServer.html)

### Making the simple static website available to the Internet from the EC2 instance

* To download the simple static website, firstly, configure the AWS CLI by using the following command: aws configure
* After configuring AWS CLI, download the website by using the following command: aws s3 cp s3://name-surname-website ./my-simple-static-website-folder --recursive
* Place the files of your website in the /var/www/html folder
* Verify that your website is available by opening a web browser and browsing to http://Public-EC2-instance-IP/index.html