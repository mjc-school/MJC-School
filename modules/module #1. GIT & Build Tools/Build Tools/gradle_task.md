###Materials (Videos & Links)
* [Gradle Getting Started](https://docs.gradle.org/current/userguide/getting_started.html)

###Tasks
1. Install Gradle

1. Assemble custom jar `utils-1.3.5.jar`.
    It should be compatible with java 8. 
    The manifest file should contain the name and version of your jar.
    The jar should contain class `StringUtils` with method `boolean isPositiveNumber(String str)`.
    Use `Apache Commons Lang 3.10` library to implement this method.
    Write one any unit test for your `StringUtils.isPositiveNumber(String str)` using `JUnit 4.12`.

1. Create a project `multi-project` with two subprojects `core` and `api`.
    The `core` subproject should contain class `Utils` with method `boolean isAllPositiveNumbers(String... str)`.
    Use `utils-1.3.5.jar` from the previous task to implement this method.
    The `api` subproject should contain class `App` with the `main` method.
    Call `Utils.isAllPositiveNumbers("12", "79")` from the `main` method of `api` subproject.

###Questions
1. What are build tools? Why are they used?
1. Explain gradle build life cycle.
1. How can you run build?
1. How can you run tests?
1. How can you generate javadoc?
1. What are a gradle project and task?
    1. How can you display the available projects?
    1. How can you display the available tasks? 
1. What is dependency management? Why is it needed?
    1. What is dependency?
    1. What is repository?
    1. What is scope of a dependency (configuration)?
    1. What is dependency cache? Why is it needed?
    1. What is transitive dependencies?
    1. Which kind of dependencies you know? Tell about module and file dependencies.
    1. What is the difference between api and implementation scopes?
    1. How can you display project dependencies?
1. What is the use of multi-project builds?
    1. What do allprojects and subprojects sections mean?
1. What is the use of plugins?
1. What is gradle wrapper?