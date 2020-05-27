# CI/CD Introduction 

О модуле:  Данный модуль расскажет вам о непрерывной интеграции и её преимуществах, предоставит вам практический опыт построения конвейера CI / CD с использованием Jenkins.  А так же познакомит с метриками для оценки кода и научит мониторингу качества кода с использованием SonarQube 

Структура модуля: 
   - CI/CD Introduction 
   - Jenkins 
   - SonarQube 

## Для успешного прохождения модуля необходимо изучить следующие ссылки: 

   - [Continuous Integration with Jenkins](https://courses.epam.com/courses/course-v1:EPAM+CIJ+0819/about)  
   - [SonarQube] (https://learn.epam.com/detailsPage?id=1ba43583-1c71-4545-8233-a4620807dce6)
   
## Также необходимо выполнить следующее задание: 
   **Main requirements:**
    
   - Jenkins have to build your project according to the Maven build script. 
   - Project (application you have developed for Rest API module?) is deployed at your local Tomcat Server by Jenkins job. 
   - Jenkins should be integrated with SonarQube. 

   **Technology stack: **
   
   - Build tool: **Maven/Gradle**.
   - **Tomcat Server** - should be installed as Service and start automatic.
   - Unit testing framework: **JUnit** (version 4.x is preferred, but you can use 5.x).
   - Database: **PostgreSQL** (version 9.x is preferred, but you can use 10.x). 
   - Continuous Integration server: **Jenkins* LTS 
   - Code analysis tool: **SonarQube**
   
   **Continuous Integration:**
   
   - Configure Jenkins security (install Role strategy plugin). Remove anonymous access. Create administrator user (all permissions) and     developer user (build job, cancel builds). Add Jenkins credentials to Readme file in your git repository. 
   - Configure Jenkins build job (pool, run test, build) to checkout your repository, use pooling interval. 
   - Install SonarQube. Configure Jenkins to use local SonarQube installation. Analyze your source code with SonarQube after Maven builds your project. Use JaCoCo for code coverage. 
   - Jenkins should deploy your application (after passing SonarQube quality gate) under your local tomcat server. Please use Jenkins Tomcat Deploy plugin. 
   

## Дополнительные рекомендованные источники: 
### 1. CI/CD
  - [Просто о CI/CD](https://www.youtube.com/watch?v=7S1ndRRht6M)
  - [Что такое непрерывная интеграция?](https://aws.amazon.com/ru/devops/continuous-integration/)
  - [Introduction to CI/CD with GitLab](https://docs.gitlab.com/ee/ci/introduction/#introduction-to-cicd-methodologies)
  - [A Brief Introduction to CI/CD](https://dzone.com/articles/the-complete-introduction-to-cicd-1)
### 2. Jenkins (https://www.jenkins.io/)
  - [Jenkins Tutorial for Beginners: Learn in 3 Day](https://www.guru99.com/jenkins-tutorial.html)
  - [Jenkins - Quick Guide](https://www.tutorialspoint.com/jenkins/jenkins_quick_guide.htm)
  - [Jenkins Tips & Tricks](https://automationstepbystep.com/jenkins-tips-tricks/)
  - [Jenkins. Documentation.](https://www.jenkins.io/doc/tutorials/)
  - [JaCoCo](https://plugins.jenkins.io/jacoco/)
  - [Youtube: Jenkins На Русском Языке](https://www.youtube.com/watch?v=cyb10iplv7U&list=PLg5SS_4L6LYvQbMrSuOjTL1HOiDhUE_5a)
### 3. SonarQube (https://www.sonarqube.org/)
  - [SonarQube на "русском"](https://sonar-russian.silverbulleters.org/)
  - [Introduction to SonarQube](https://learn.epam.com/detailsPage?id=1ba43583-1c71-4545-8233-a4620807dce6)
  - [Agile Software Development: Code Quality](https://medium.com/backend-habit/generate-codecoverage-report-with-jacoco-and-sonarqube-ed15c4045885)
  - [Generate Codecoverage Report with Jacoco and Sonarqube](https://medium.com/backend-habit/generate-codecoverage-report-with-jacoco-and-sonarqube-ed15c4045885)
  - [SonarQube Integration with Jenkins for Code analysis](https://www.youtube.com/watch?v=jh7utASgKj4&list=PL6Q8rpu0AhEVFkU0JM6i935Q5LM8LSG-n)
