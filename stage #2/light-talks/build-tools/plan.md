## Build Tools comparison

1. Intro
2. Build tools in general
    1. Why do we need build tools? Why can't we compile programs with `javac` and use `jar`?
    2. What build tools help to do?
    3. What Java build tools exist?
    4. Anyone can create their own tool
3. Main Java tools
    1. Each new tool tries to fix the problems of the previous one
    2. Make - was used with the first versions of Java, nowadays it's mainly used for C and C++ projects
    3. Ant - works faster for Java builds
    4. Maven - introduced automatic dependency management
    5. Gradle - introduced DSL instead of XML
    6. Gradle becomes more and more popular, but still many projects use Maven
4. Ant
    1. Main info
    2. `build.xml` overview
    3. Demo
5. Maven
    1. Description
    2. `pom.xml` description
    3. What is Maven repo
    4. Demo
6. Gradle
    1. Description
    2. Demo. Jobs are called `tasks`, they can depend on one another
7. Gradle vs Maven comparison
8. When to choose which tool?