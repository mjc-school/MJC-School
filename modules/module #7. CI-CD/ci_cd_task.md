# CI & CD

## Materials

1. [Continuous Integration with Jenkins](https://courses.epam.com/courses/course-v1:EPAM+CIJ+0819/about)  
2. [SonarQube](https://learn.epam.com/detailsPage?id=1ba43583-1c71-4545-8233-a4620807dce6)

## Practice

### Recommended Timeline
The recommended timeline for the whole module is 1 week.

### Task

1. Configure Jenkins security (install Role strategy plugin). Remove anonymous access. Create administrator user (all permissions) and developer user (build job, cancel builds). Add Jenkins credentials to Readme file in your git repository. 
2. Configure Jenkins build job (pool, run test, build) to checkout your repository, use pooling interval.
3. Install SonarQube. Configure Jenkins to use local SonarQube installation. Analyze your source code with SonarQube after Maven builds your project. Use JaCoCo for code coverage. 
4. Jenkins should deploy your application (after passing SonarQube quality gate) under your local tomcat server. Please use Jenkins Tomcat Deploy plugin.

#### General requirements

1. Jenkins have to build your project according to the Maven build script.
2. Project (application you have developed for Rest API module?) is deployed at your local Tomcat Server by Jenkins job. 
3. Jenkins should be integrated with SonarQube.

#### Application requirements

 - Build tool: **Maven/Gradle**.
 - **Tomcat Server** - should be installed as Service and start automatic.
 - Unit testing framework: **JUnit** (version 4.x is preferred, but you can use 5.x).
 - Database: **PostgreSQL** (version 9.x is preferred, but you can use 10.x). 
 - Continuous Integration server: **Jenkins* LTS 
 - Code analysis tool: **SonarQube**   

## Demo
### Practical part

[upd]

### Theoretical part

Mentee should be able to answer questions during demo session.

## Extra Materials
 
1. [Просто о CI/CD](https://www.youtube.com/watch?v=7S1ndRRht6M)
2. [Что такое непрерывная интеграция?](https://aws.amazon.com/ru/devops/continuous-integration/)
3. [Introduction to CI/CD with GitLab](https://docs.gitlab.com/ee/ci/introduction/#introduction-to-cicd-methodologies)
4. [A Brief Introduction to CI/CD](https://dzone.com/articles/the-complete-introduction-to-cicd-1)
5. [Jenkins Tutorial for Beginners: Learn in 3 Day](https://www.guru99.com/jenkins-tutorial.html)
6. [Jenkins - Quick Guide](https://www.tutorialspoint.com/jenkins/jenkins_quick_guide.htm)
7. [Jenkins Tips & Tricks](https://automationstepbystep.com/jenkins-tips-tricks/)
8. [Jenkins. Documentation.](https://www.jenkins.io/doc/tutorials/)
9. [JaCoCo](https://plugins.jenkins.io/jacoco/)
10. [Youtube: Jenkins На Русском Языке](https://www.youtube.com/watch?v=cyb10iplv7U&list=PLg5SS_4L6LYvQbMrSuOjTL1HOiDhUE_5a)
11. [SonarQube на "русском"](https://sonar-russian.silverbulleters.org/)
12. [Introduction to SonarQube](https://learn.epam.com/detailsPage?id=1ba43583-1c71-4545-8233-a4620807dce6)
13. [Agile Software Development: Code Quality](https://medium.com/backend-habit/generate-codecoverage-report-with-jacoco-and-sonarqube-ed15c4045885)
14. [Generate Codecoverage Report with Jacoco and Sonarqube](https://medium.com/backend-habit/generate-codecoverage-report-with-jacoco-and-sonarqube-ed15c4045885)
15. [SonarQube Integration with Jenkins for Code analysis](https://www.youtube.com/watch?v=jh7utASgKj4&list=PL6Q8rpu0AhEVFkU0JM6i935Q5LM8LSG-n)