## Git & Build tools

### Git
To cover this topic please refer to the Git task of MJC-School first module (master branch)
```
MJC-School/modules/module #1. GIT & Build Tools/git_task/
```
Links: 
- [Understanding Git — Data Model](https://medium.com/hackernoon/https-medium-com-zspajich-understanding-git-data-model-95eb16cc99f5)
- [Understanding Git — Branching](https://medium.com/hackernoon/understanding-git-branching-2662f5882f9)
- [Understanding Git — Index](https://medium.com/hackernoon/understanding-git-index-4821a0765cf)
- [GitFlow, GitHubFlow and etc.](https://habr.com/ru/company/flant/blog/491320)
- [git -add flags difference](https://stackoverflow.com/a/26039014)
- [git -add flags difference (RU)](https://ru.stackoverflow.com/a/431840)

### Maven
Topics: 
- What are build tools? Why are they used?
- What can Maven manage?
- What is a Maven Repository? What types are there?
- What are Maven dependencies?
- Name Maven scopes and their definitions.
- Describe Maven lifecycles, phases, goals, tasks.
- What are Maven Plugins?
- What is pom.xml structure?
- Be familiar with parents/multimodule projects.

Links
- [Maven Getting Started Guide](https://maven.apache.org/guides/getting-started/index.html)
- [Maven Tutorial](https://www.tutorialspoint.com/maven/maven_overview.htm)


#### Task
1. Install Maven
2. Assemble custom jar `utils-1.3.5.jar`.
    It should be compatible with java 8. 
    The manifest file should contain the name and version of your jar.
    The jar should contain class `StringUtils` with method `boolean isPositiveNumber(String str)`.
    Use `Apache Commons Lang 3.10` library to implement this method.
    Write one any unit test for your `StringUtils.isPositiveNumber(String str)` using `JUnit 4.12`.
3. Create a project `multi-project` with two subprojects `core` and `api`.
    The `core` subproject should contain class `Utils` with method `boolean isAllPositiveNumbers(String... str)`.
    Use `utils-1.3.5.jar` from the previous task to implement this method.
    The `api` subproject should contain class `App` with the `main` method.
    Call `Utils.isAllPositiveNumbers("12", "79")` from the `main` method of `api` subproject.
