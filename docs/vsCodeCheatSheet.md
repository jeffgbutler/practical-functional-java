# Using VS Code for Java Development

## Installing

1. Install VS Code from [https://code.visualstudio.com/](https://code.visualstudio.com/)
2. Install Git from [https://git-scm.com/](https://git-scm.com/)
3. Install a JDK from [http://www.oracle.com/technetwork/java/javase/downloads/index.html](http://www.oracle.com/technetwork/java/javase/downloads/index.html)
4. Download and unzip Maven from [http://maven.apache.org/](http://maven.apache.org/)

## Basic Configuration

Install Extension "Java Extension Pack" from Microsoft. This installs four extensions:

1. Language Support for Java by RedHat
   
   This extension, basically, installs Eclipse under the covers of VS Code and integrates it through a Java language server implementation. This provides the following basic functions:
   * Can read a Maven pom.xml and compute an Eclipse project setup
   * Provides basic intellisense support
   * Can flag errors and warnings

2. Debugger for Java by Microsoft

   This extension allows you to set break points in code and create debug launch configurations.

3. Java Test Runner by Microsoft

   This extension will show a "Test Explorer" window when any Java file is open. From the test explorer you can run any/all unit tests. This extension also adds "run test", "debug test", etc. links within the test Java files.

4. Maven for Java by Microsoft

   This extension will show a "Maven Projects" window where you can run various maven goals.

## Basic Java Support

If you don't hava JAVA_HOME set, and don't have Maven in your path, then add the following workspace settings:

   * "java.home": "C:\\\\Program Files\\\\Java\\\\jdk-9.0.4"
   * "maven.terminal.useJavaHome": true
   * "maven.executable.path": "C:\\\\JavaTools\\\\apache-maven-3.3.9\\\\bin\\\\mvn.cmd"

If you have unit tests, then they can be run from the test explorer window, or directly from within the code.

If you want to run a class with a main method, then you need to add a launch configuration:

1. F5 in the class with the main meathod - should open launch.json
2. Press "Add Configuration..." and select "Java: Launch Program"
3. Fill in fully qualified name of your main class
4. Remove any other launch configuration
5. F5 again will run program and you can set breakpoints, step, etc.

## Multi-Root Workspace

Projects with multiple Maven components can be setup as multi-root workspace projects.  This will allow you to create one set of consolidated settings to share among all the projects.

Add the different Maven root folders to the workspace with File -> Add Folder to Workspace

Once you do this, you can set properties like "java.home" for the entire workspace, rather then for each individual project.  This will create a *.code-workspace file that you will need to save somewhere convenient.

One limitation of this support is that VS Code Maven support will not understand the dependencies between the projects automatically.  For example, suppose you have WAR project A that depends on library B. If you make a change in B, you will need to rebuild B (with mvn clean install) and then rebuild A.

## Tomcat Debugging

1. Install Extension "Tomcat for Java"
2. Download and unzip Tomcat from [http://tomcat.apache.org/](http://tomcat.apache.org/)
3. Must have JAVA_HOME set to a JDK  (grrr)
4. Must have %JAVA_HOME%\bin in the path (grrr)
5. Open VS Code, add define the server in the "Tomcat Servers" window
6. Build your WAR project with Maven, then add the WAR to the server
7. Breakpoints, step into, etc.

## Spring Boot

1. Install Extension "Spring Initializr Java Support" from Microsoft
2. Use command "Spring Initializr: Generate a Maven Project"
3. Here's a simple rest controller you can use to test...

```java
@RestController
public class MyController {

    @RequestMapping("/hello")
    public String index() {
        return "hello world!";
    }
}
```
