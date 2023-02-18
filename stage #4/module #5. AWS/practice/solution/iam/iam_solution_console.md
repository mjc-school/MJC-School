# AWS IAM

## Solution

### Subtask 1

* Go to the IAM service
* Click on "Policies"
* Click on "Create policy"
* Choose a service(you can search for it by its name - "EC2", "S3", etc.)
* Choose the actions to be allowed
* Click on "Resources" and then on "All resources"(P.S. - this is done only for demo purposes, avoid doing it in production)
* Click "Next: Tags" and optionally add some tags for your new policy
* Click "Next: Review", specify a name for your new policy and then review its summary
* If the summary is as expected, click on "Create policy"

### Subtask 2

* Go to the IAM service
* Click on "Roles"
* Click on "Create role"
* Choose "AWS service" and EC2 use-case
* Click on "Next" and then choose one of the policies that you've previously created
* Click on "Next", specify a name for your new role and then review its trusted entities and permissions
* If everything is as expected, click on "Create role"

### Subtask 3

* Go to the IAM service
* Click on "User groups"
* Click on "Create user group"
* Specify a name for your new user group
* Add users to your new user group if you've already created them(or you can do it later on)
* Attach one of the policies to the new user group from the ones that you've previously created
* Click on "Create group"