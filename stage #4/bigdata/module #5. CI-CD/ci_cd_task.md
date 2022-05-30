## CI/CD. Jenkins

Topics: 
- CI/CD
    - Continuous Integration, Continuous Delivery, Continuous Deployment. Difference. Pros and Cons.
    - CI/CD tools
- Jenkins
    - What is Jenkins?
    - What are the benefits of using Jenkins?
    - Define the process of Jenkins
    - What is the use of Pipelines in Jenkins?
    - Types of jobs or projects in Jenkins
    - Explain the terms Agent, post-section, Jenkinsfile
    - Environment variables in Jenkins job
- SonarQube
    - What is it and why?
    - Quality Profiles, Quality Gates
    - Sonar Scanner, Sonar Analyzer
    
    
Links
- [CI vs CD vs CD](https://www.atlassian.com/continuous-delivery/principles/continuous-integration-vs-delivery-vs-deployment)
- [Просто о CI/CD](https://www.youtube.com/watch?v=7S1ndRRht6M)
- [Что такое непрерывная интеграция?](https://aws.amazon.com/ru/devops/continuous-integration/)
- [Introduction to CI/CD with GitLab](https://docs.gitlab.com/ee/ci/introduction/#introduction-to-cicd-methodologies)
- [A Brief Introduction to CI/CD](https://dzone.com/articles/the-complete-introduction-to-cicd-1)
- [Jenkins Tutorial for Beginners: Learn in 3 Day](https://www.guru99.com/jenkins-tutorial.html)
- [Jenkins - Quick Guide](https://www.tutorialspoint.com/jenkins/jenkins_quick_guide.htm)
- [Jenkins Tips & Tricks](https://automationstepbystep.com/jenkins-tips-tricks/)
- [Jenkins. Documentation.](https://www.jenkins.io/doc/tutorials/)
- [Youtube: Jenkins На Русском Языке](https://www.youtube.com/watch?v=cyb10iplv7U&list=PLg5SS_4L6LYvQbMrSuOjTL1HOiDhUE_5a)
- [SonarQube на русском](https://sonar-russian.silverbulleters.org/)


### Task

__Deadline:__ 4 working days.  

1. Configure Jenkins security (install Role strategy plugin). Remove anonymous access. Create administrator user (all permissions) and developer user (build job, cancel builds). Add Jenkins credentials to Readme file in your git repository. 
2. Create Jenkins build job. Configure it to checkout your repository, build your application using maven. Save artifact to subfolder of builds' location folder. The parent folder location is a constant configured inside the job. Name of the subfolder defines build version, it should be generated incrementally (example: 1, 2, ..., n) or taken from the Jenkins build number.   
   *Sample structure: ~/builds/1/\*.jar*
3. Install SonarQube. Configure Jenkins to use local SonarQube installation. In the build job analyze your source code with SonarQube before saving the jar. If the source code does not pass SonarQube quality gate the artifact should not be stored, build job should fail. Use JaCoCo for code coverage. 
4. Create Jenkins deploy job. Application build version (generated during build job) should be passed as a parameter to the deployment job. Job copies content of the provided build version's folder into the launch folder specified in the job's configuration. Launch folder should be cleaned before deployment.
5. Create Jenkins run job. The job runs application, located in the launch folder, with specified parameters. 

#### Application requirements

 - Build tool: **Maven**.
 - There is no need to do the task on the previously installed virtual machine, any OS can be used.
 - **Tomcat Server** - should be installed as Service and start automatically.
 - Continuous Integration server: *Jenkins LTS*
 - Code analysis tool: **SonarQube**   