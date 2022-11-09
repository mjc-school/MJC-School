# CI & CD

## Materials

1. [Continuous Integration with Jenkins](https://learn.epam.com/detailsPage?id=59bdf234-6664-4f38-a9c5-6689edd6f8d4)
2. [SonarQube](https://videoportal.epam.com/video/LoBwb5R9)

## Practice

### Recommended Timeline

The recommended timeline for the whole module is 1 week.

### Task

1. Configure Jenkins security (install Role strategy plugin). Remove anonymous access. Create administrator user (all permissions) and developer user (build job, cancel builds). Add Jenkins credentials to Readme file in your git repository.
2. Configure Jenkins build job (pool, run test, build) to checkout your repository, use pooling interval.
3. Install SonarQube. Configure Jenkins to use local SonarQube installation. Analyze your source code with SonarQube after Maven builds your project. Use JaCoCo for code coverage.
4. Jenkins should deploy your application (after passing SonarQube quality gate) under your local tomcat server. Please use **Deploy to container Plugin**.
5. (Optional task) Create a Pipeline to complete the above tasks (build, run SonarQube, deploy to Tomcat). Jenkinsfile should be committed to the GitHub repository and pulled up from there. Try out Blue Ocean plugin for pipelines.

#### General requirements

1. Jenkins have to build your project according to the Maven/Gradle build script.
2. Project is deployed at your local Tomcat Server by Jenkins job.
3. Jenkins should be integrated with SonarQube.

#### Application requirements

- Build tool: **Maven/Gradle**.
- **Tomcat Server** - should be installed as Service and start automatic.
- Unit testing framework: **JUnit** (the latest version).
- Database: **PostgreSQL** (the latest version).
- Continuous Integration server: **Jenkins LTS**
- Code analysis tool: **SonarQube**

## Demo
### Practical part

Mentee should be able to demonstrate his test project.

### Theoretical part

Mentee should be able to answer questions during demo session.

## Extra Materials

1. [What is Jenkins? Why Use Continuous Integration (CI) Tool?](https://www.guru99.com/jenkin-continuous-integration.html)
2. [What is Continuous Integration](https://aws.amazon.com/en/devops/continuous-integration/)
3. [Introduction to CI/CD with GitLab](https://docs.gitlab.com/ee/ci/introduction/#introduction-to-cicd-methodologies)
4. [A Brief Introduction to CI/CD](https://dzone.com/articles/the-complete-introduction-to-cicd-1)
5. [Jenkins Tutorial for Beginners: Learn in 3 Day](https://www.guru99.com/jenkins-tutorial.html)
6. [Jenkins - Quick Guide](https://www.tutorialspoint.com/jenkins/jenkins_quick_guide.htm)
7. [Jenkins Tips & Tricks](https://automationstepbystep.com/jenkins-tips-tricks/)
8. [Jenkins. Documentation.](https://www.jenkins.io/doc/tutorials/)
9. [JaCoCo](https://plugins.jenkins.io/jacoco/)
10. [Code Analysis with SonarQube](https://www.baeldung.com/sonar-qube)
11. [Generate Codecoverage Report with Jacoco and Sonarqube](https://medium.com/backend-habit/generate-codecoverage-report-with-jacoco-and-sonarqube-ed15c4045885)
12. [SonarQube Integration with Jenkins for Code analysis](https://www.youtube.com/watch?v=jh7utASgKj4&list=PL6Q8rpu0AhEVFkU0JM6i935Q5LM8LSG-n)
13. [Pipeline](https://www.jenkins.io/doc/book/pipeline/)
14. [Blue Ocean Plugin](https://www.jenkins.io/doc/book/blueocean/)
