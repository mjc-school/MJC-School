# Infrastructure, AutoCode

## Must have to read

- [JVM vs. JRE vs. JDK: What is the Difference?](https://www.ibm.com/cloud/blog/jvm-vs-jre-vs-jdk "JVM vs. JRE vs. JDK: What's the Difference?")
- [Differences between JDK, JRE and JVM](https://www.geeksforgeeks.org/differences-jdk-jre-jvm/ "Differences between JDK, JRE and JVM")

## Setting up an environment. JDK/JRE/JVM

### JDK

An essential toolkit for Java development. The JDK includes:
an environment for executing Java programs called JRE (if you only need to run Java programs, without writing Java code,
you can install the JRE separately),
a set of necessary utilities (javac, java debuggers, java docs, etc.). For example, the javac utility converts written
code into intermediate byte code.

### JRE

Runtime environment for Java programs. Included in JDK by default. JRE contains core libraries, class loader and JVM.

### JVM

A virtual machine that runs Java programs. It is part of the JRE. For each separate running Java program, its own JVM
instance is created.

![structure](https://github.com/mjc-school/MJC-School/blob/main/stage%20%230/module%20%232.%20Infrastructure,%20AutoCode/img/jdk-structure.png?raw=true)

## Start Developing

To consolidate the material covered in this course, we will ask to write some task under the Autocode platform.
To confidently use these tools, we will need to learn the following:

- How to compile and run Java application
- Git basics
- Maven basic installation
- How to use Autocode for doing practical tasks
- **Advance:** What is Unit tests

## How to compile and run Java application

Currently, on large projects, programmers manually compile and assemble the project only in exceptional situations. To
simplify the work, integrated development environments (IDE) are used to develop and run applications, as well as build
tools and dependency management.

In this chapter, however, we will consider how to run Java code ourselves so that an understanding of how this process
works is formed. But in the future, for convenience, we recommend using specialized tools, which we will analyze a
little later.

#### To start building application, we will need:

1. Install JDK.
2. Write first application.
3. Compile .java file to .class.
4. Run .class file.

### Installing JDK

JDK is required for Java developers. It contains a Java compiler that allows you to compile your code written in Java in
the byte code that JVM can understand. It also contains everything that you need to run Java applications.

### To install JDK, follow the next steps:

1. Go to [Oracle download page](https://www.oracle.com/java/technologies/downloads/). On the page, you can see there are
   several options. You
   can install the latest JDK version (currently it is JDK 18) or choose the earlier ones. I would recommend installing
   the latest one. You will have a new feature introduced in the latest version, and you will be able to run code from
   the previous versions, like Java 8.
2. Choose a system you are working on. On the page, you will see `Linux/macOS/Windows sections`. Choose an appropriate
   one.
3. Find an option to download. You can download Java as an archive or as an installer.
4. Install or archive the downloaded file.
5. After installing, whether it is an archive or not, check the PATH environment variable. It should contain a path to
   the JDK bin directory. An example in window systems `C:\java\jdk1.8.0_202\bin`. The details may be found by the link
6. Set `JAVA_HOME` environment variable. Some third-party programs (for example IntelliJ IDEA) expect this environment
   variable to be set to the installation directory of the JDK. JAVA_HOME should not include a bin directory in the
   path. An example in window systems `C:\java\jdk1.8.0_202`
7. Open Command Prompt and do the following commands (both the commands should run successfully and return the current
   version of the java installed in a system):
    - javac -version
    - java -version

### Writing first application

To write the first program, we need any text editor. While it won't be smart enough to tell errors or run our program,
it's enough to write and work with Java.

In the old tradition, programmers start learning a new programming language by writing the "Hello, World!" program. This
program will simply print "Hello, World!" to the console. We will simply provide code that you can copy, the meaning of
which will be disassembled later.

    class HelloWorld {
      public static void main(String[] args) {
        System.out.println("Hello, World!"); 
      }
    }

Please copy these lines to a new file named HelloWorld.java.

- As you can see, the file name is exactly the same as the class name inside the file `class HelloWorld`.
- To make it easier, let's create a separate folder for that file, as an example, we would take `C:\mjc-school`.

### Compiling .java file

1. Open Command Prompt(CMD) as for Windows or similar for other Operating Systems.
    - Navigate to a new folder with HelloWorld.java file. We will use `cd C:\mjc-school`.
2. Compile Java file by doing command: `javac HelloWorld.java`.
    - In case you will have any issues, be sure that you correctly installed JDK in previous chapter, and you exactly
      copied lines above with same name of file.

As an outcome, a new `HelloWorld.class` file will be generated.

### Running .class file

1. Open Command Prompt(CMD) as for Windows or similar for other Operating Systems.
    - Navigate to a new folder with HelloWorld.java file. We will use `cd C:\mjc-school`.
2. Run Java file by doing command: `java HelloWorld`

### Installing IDE

As we have already discussed, as part of daily development, we do not always need to repeat these manual commands. For
this, we will use the IDE.

IntelliJ IDEA is the most popular IDE in the modern Java world, so in this section, we will consider installing this
IDE. The IDE can be downloaded as Community or paid Ultimate version. All the most important features, that may need in
development, exist in the Community version.

So, it is enough to install the Community version for now by the following steps:

1. Go to [JetBrains](https://www.jetbrains.com/idea/download/)
2. Choose your system Windows/macOS/Linux and a file type .exe or .zip and press the Download button for the Community
   version.
3. After it is downloaded, run the installer or archive in the appropriate folder.
4. After it finishes installing, you can run IntelliJ IDEA and create your first project.

At the end of this chapter, we will provide advance topic related to usage of IntelliJ IDEA.

## Git. Version of control

The next topic we'll look at isn't just about Java development. The modern world of development is impossible without
the use of a set of tools that directly affect the speed of writing and the quality of the product.

One such tool is the various Version Control Systems (VCS). We need to analyze the basic principles, since with the help
of this technology we will solve practical problems. In the future, we will study VCS in detail, to the level necessary
for a junior developer.

Version control system is a necessary tool for maintaining the history of changes in your files. After editing and
saving the files, we want to see who made the changes and when, as well as be able to revert to any of the previous
versions. For this, we need a version control system that allows us to navigate through the history of changes.

### What is Git

Git is a free and open source distributed version control system designed to handle everything from small to very large
projects with speed and efficiency.
**Source:** [Git](https://git-scm.com/)

## GitLab and GitHub

**GitLab**: GitLab is a repository hosting manager tool that is developed by GitLab Inc. and is used for the software
development process. It provides a variety of management by which we can streamline our collaborative workflow for
completing the software development lifecycle. It also allows us to import the repository from Google Code, Bitbucket,
etc.

**GitHub**: GitHub is a repository hosting service tool that features collaboration and access control. It is a platform
for programmers to fix bugs together and host open-source projects. GitHub is designed for the developers and to help
them track their changes into a project through the repository.

You can see a detailed difference using
this [Link](https://www.geeksforgeeks.org/difference-between-gitlab-and-github/ "link").

### Installing Git

The next important tool that should be installed is Git. Git is a distributed version control system. Such web services
like GitHub, GitLab and others, where you can search committed code, are based on Git. Thus, installing Git is a
required step if you want to push/pull any changes from a remote repository. It also might be useful when you are just
working locally and would like to store the history of the changes.

To install Git on Windows, follow the next steps:

1. Go to [Git](https://git-scm.com/download/win) and the download will start automatically.
2. Run the installer. Leave checkboxes and other settings as they are by default.
3. After the installing is done, run Command Prompt and perform the following command to make sure that Git was
   installed successfully:
    - git --version

For other systems like Linux or macOS, the instructions may be found by
the [link](https://git-scm.com/book/en/v2/Getting-Started-Installing-Git "link").

You can find details tips at the end of the chapter.

## Installing Maven

Another tool we are going to use in this course is Maven.
Maven is a framework for project build automation. In short, it allows you to specify dependencies of your code in one
place (pom.xml) and then compile your code with those dependencies by running tasks. With Maven, you can simply run a
compile task that will compile your project’s code. If you did it manually, you would have to run the javac command with
all the dependencies listed in the classpath.

For our usage, you can install Maven using IntelliJ IDEA or manually and then configure to use your installation in
IntelliJ IDEA.

### To install manually:

1. Go to [link](https://maven.apache.org/download.cgi).
2. In the Files sections, find and download Binary zip archive (currently it is `apache-maven-3.8.6-bin.zip`).
3. After it is downloaded, unzip the archive into any folder.
4. Create `MAVEN_HOME` and `M2_HOME` environment variables which will point out to maven directory (an example: `C:
   \tools\maven`).
5. Add a path to maven bin directory to a Path environment variable (an example: C:\tools\maven\bin).
6. Open Command Prompt and perform the next command:
    - mvn -v

### To install using IntelliJ IDEA:

1. Open IntelliJ IDEA.
2. Use `CTRL + ALT + S` in order to open preferences.
3. Type `Maven` in search bar. Or it should be under `Build, Execution, Deployment -> Build Tools -> Maven`.
4. You can specify to use bundled Maven version (IDEA can download it for you) or specify manual installation folder.

## How to use Autocode for doing practical tasks

While reading materials from that course, you will be able to solve related practical tasks which will be prepared using
Autocode platform.
Autocode has a well-formed documentation ([link](https://autocode-next.lab.epam.com/help/starting-work)), but we will
discuss most needed steps:

1. Create your GitHub account.
2. Connect new account to Autocode.
3. Start doing task.
4. Using IntelliJ IDEA with git.
5. Submitting task.
6. How to understand results.

### Create your GitHub account

In order to submit solutions, you will need to have an account on GitHub, it will be used to automatically fork task
repository and then get final solution.
You can simply visit SignUp page: [GitHub](https://github.com/signup).

Follow instructions, most probably you will need to verify your email - please do it.

### Connect GitHub account to Autocode

After you will have activated account, you can start linking your account to Autocode.
In order to link:

1. Log in to Autocode.
2. Click on your profile name, as e.g. `Ivan Ivanov`.
3. Click `profile`.
4. Click authorize for GitHub.
5. Confirm authorization in GitHub if needed.

### Start doing task

When you access the course in Autocode, you will be able to see modules and tasks.
Select the task you want to start (Let's start doing `autocode-greetings` task) and use `Start` button. You will see
some additional details here, such as minimum pass score, number of attempts and deadline.

The most important point is a newly forked repository with small GitHub icon.
This repository (you can click on it and see it on GitHub) will be used to check your solution. Every repository already
contains a small piece of code, you will need to extend it accordingly to the task.

Let's start implementing your first task!

## Using IntelliJ IDEA with git

Let's start from opening IDE and getting the repository already created.
**In order to get repository:**

1. Open IntelliJ IDEA.
2. Select `Get from VCS`.
3. You will need to provide a URL from GitHub.
    - Open Autocode task.
    - Click on repository, you will be redirected to GitHub.
    - Click on button `Code`.
    - Copy URL.
4. Authorize to GitHub. As if most probably your first time accessing git from IntelliJ IDEA you will need to provide
   credentials or create a key. Follow the steps you will be prompted.

Finally, you should be able to see project structure:

- src
    - main
        - java
            - talks
                - mjc
                    - FirstApplication.java
    - test
        - ...
- readme. md
- pom.xml

It is a typical structure for a Java project using Maven. Let's discuss key points here:

- `readme.md `- This file usually contains task description, where you can find some details of what should be done and
  how.
- `FirstApplication.java` - This file (or similar, but with different naming) contains some basic logic to help you
  start implementing the task. In this task you will need to make this file printing `Hello, World!` into the console.

After carefully reading all the files and doing needed changes - you will need to publish your solution to GitHub.
This can be done using IntelliJ IDEA or via Command Prompt.

### Using IntelliJ IDEA

1. Press `CTRL + K`.
2. Select updated files, in our case it should be `FirstApplication.java`.
3. Add a small commit message, usually it reflects changes done.
4. Press `Commit and Push`.
5. Confirm by clicking `Push`.

### Using CMD

1. Open Command Prompt (CMD) as for Windows or similar for other Operating System.
2. Navigate to project folder.
3. Use `git status` in order to see which files already included in commit.
4. In order to add a file into commit, you need to run `git add %FILE_NAME%` and specify a file name, or you can simply
   do `git add .` - which means to add all files.
5. To commit use: `git commit -m "My first commit!"`. Where you need to replace "My first commit!" with commit message.
6. Then use `git push` in order to update GitHub repository with your local changes.

## Result

You should be able to see your changes on GitHub repository via browser. If you think this is a final solution, or you
want to check an intermediate result, you can submit task.

### Submit task using Autocode platform

In order to check your solution and get score, you will need to do the following:

1. Open Autocode platform and sign in.
2. Go to course structure page.
3. Find the task you want to submit, for e.g. `Task #1. Autocode greetings`
    - You should be able to see your last commit, this is a good sign. If not - use `refresh`.
4. Click `Submit solution`.
5. You will see result soon.

### How to understand results

Usually, all tasks should contain the following stages:

1. Checkout - Autocode prepares your source code to be checked.

- You will not get a score for successfully passing this stage.
- If this stage is failing - it should be most probably environmental or GitHub issue.

2. Compile - Autocode using Javac to check compile error and prepare tests to be executed.

- In specific tasks, which require solving compile errors, you will get score points.
- If this stage is failing - check your core for different issue, open code in IntelliJ IDEA. Detailed logs will be
  available on Autocode. Maybe you forget to commit your changes or push them to a remote repository.

3. Test - **_(Main part)_** Autocode starts running prepared tests to verify your solution. Test can check the result of
   your solution, check how you solve it and are you following requirements. You can find more about Unit tests in the
   next section.

- You will receive score points for every successful test. Up to maximum points.
- If you do not receive maximum points - it means that some tests are failing, You will be able to see detailed message.
  But in some cases, it is fine to get only minimum points to finish the task.

4. Quality - (**_Optional_**) Autocode in specific tasks will check your code smells.

- You will get penalties for issue that can lead to issues or bugs.
- You will be able to see detailed description what is not ok.

### Note: Do not forget to check how many times you can submit a solution!

## Unit testing. JUnit

A unit test is a way of testing a unit - the smallest piece of code that can be logically isolated in a system. In most
programming languages, that is a function, a subroutine, a method or property.

JUnit is a unit testing framework for Java programming language. It plays a crucial role in test-driven development and
is a family of unit testing frameworks collectively known as xUnit. JUnit promotes the idea of "first testing then
coding", which emphasizes on setting up the test data for a piece of code that can be tested first and then implemented.
This approach is like "test a little, code a little, test a little, code a little." It increases the productivity of the
programmer and the stability of program code, which in turn reduces the stress on the programmer and the time spent on
debugging.

Reference links:
--------

- [What is Unit testing](https://www.techtarget.com/searchsoftwarequality/definition/unit-testing)
- [JUnit - Overview](https://www.tutorialspoint.com/junit/junit_overview.htm)
- [Create your first Java application in Intellij IDEA](https://www.jetbrains.com/help/idea/creating-and-running-your-first-java-application.html)
- [Java development with Intellij IDEA](https://www.softwaretestinghelp.com/java/intellij-idea-tutorial-java-development-with-intellij-ide/)
- [How to create first Git repository](https://www.git-tower.com/learn/git/faq/git-create-repository)
