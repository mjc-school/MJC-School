# CI/CD Введение 

О модуле:  Данный модуль расскажет вам о непрерывной интеграции и её преимуществах, предоставит вам практический опыт построения конвейера CI / CD с использованием Jenkins.  А так же познакомит с метриками для оценки кода и научит мониторингу качества кода с использованием SonarQube. 

Структура модуля: 
   - CI/CD Introduction 
   - Jenkins 
   - SonarQube 

## Для успешного прохождения модуля необходимо изучить следующие ссылки: 

   - [Continuous Integration with Jenkins](https://courses.epam.com/courses/course-v1:EPAM+CIJ+0819/about)  
   - [SonarQube](https://learn.epam.com/detailsPage?id=1ba43583-1c71-4545-8233-a4620807dce6)
   
## Также необходимо выполнить следующее задание: 
   **Главные требования:**
    
   - Ваш проект должен билдиться в соответсвии с Maven build script. 
   - Проект (ваше приложение разработанное в Rest API модуле) должен быть деплоиться на локальный Tomcat Server использую Jeknins. 
   - Jenkins должен интегрироваться с SonarQube. 

   **Технологический стек:**
   
   - Инструмент для сборки: **Maven/Gradle**.
   - **Tomcat Server** - должен быть установлен as Service и стартовать автоматически.
   - Фреймворк юнит тестированя: **JUnit** (версия 4.x предпочтительнее, но можно использовать версию 5.x).
   - База данныз: **PostgreSQL** (версия 9.x предпочтительне, но можно использовать версию 10.x). 
   - Сервер непрерывной интеграции: **Jenkins* LTS 
   - Инструмент анализа кода: **SonarQube**
   
   **Дополнительная требования:**
   
   - Сконфигурировать Jenkins security (установить Role strategy плагин). Анонимный доступ должен быть удалён. Создать administrator пользователя (включить все права доступа) и developer пользователь (build job, cancel builds). Добавить Jenkins учётные данные в Readme файл в ваш GIT репозиторий. 
   - Сконфигурировать Jenkins build job (pool, run test, build) для работы с вашим репозиторием использую pooling interval. 
   - Установить SonarQube. Сконфигурировать Jenkins для использования локально установленного SonarQube. Использовать JaCoCo для определния покрытия кода. 
   - Jenkins должен загружать ваше приложение (SonarQube quality gate должен быть Зелёным) в локальный Tomcat Server. Использовать Jenkins Tomcat Deploy плагин. 
   

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
