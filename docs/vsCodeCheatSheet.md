# Using VS Code for Java Development

## Installing

1. Install VS Code from https://code.visualstudio.com/
2. Install Git from https://git-scm.com/
3. Install a JDK from http://www.oracle.com/technetwork/java/javase/downloads/index.html
4. Download and unzip Maven from http://maven.apache.org/

## Basic Configuration

Install Extension "Java Extension Pack" from Microsoft. This installs for extensions:

1. Language Support for Java by RedHat
   
   This extension, basically, installs Eclipse under the covers of VS Code and integrates it through a Java language server implementation. This provides the following basic functions:
   * Can read a Maven pom.xml and compute an Eclipse project setup
   * Provides basic intellisense support
   * Can flag errors and warnings

2. Debugger for Java by Microsoft

   This extension allows you to set break points in code and 

3. Java Test Runner by Microsoft

   This extension will show a "Test Explorer" window when any Java file is open.

4. Maven for Java by Microsoft

   THis extension will show a "Maven Projects" window where you can run various maven goals

## Basic Java Support

If you don't hava JAVA_HOME set, and don't have Maven in your path, then add the following workspace settings:

   * "java.home": "C:\\Program Files\\Java\\jdk-9.0.4"
   * "maven.terminal.useJavaHome": true
   * "maven.executable.path": "C:\\JavaTools\\apache-maven-3.3.9\\bin\\mvn.cmd"

If you have unit tests, then they can be run from the test explorer window, or directly from within the code.

If you want to run a class with a main method, then you need to add a launch configuration:

1. F5 in the class with the main meathod - should open launch.json
2. Press "Add COnfiguration..." and select "Java: Launch Program"
3. Fill in fully qualified name of your main class
4. Remove any other launch configuration
5. F5 again will run program and you can set breakpoints, step, etc.

## Multi-Root Workspace

Project with multiple Maven components can be setup as multi-root workspace projects.  This will allow you to create one set of
consolidated settings to share among all the projects.

## Tomcat Debugging

1. Install Extension "Tomcat for Java"
2. Download and unzip Tomcat from http://tomcat.apache.org/
3. Must have JAVA_HOME set to a JDK  (grrr)
4. Must have %JAVA_HOME%\bin in the path (grrr)
5. Open VS Code, add define the server in the "Tomcat Servers" window
6. Build your WAR project with Maven, then add the WAR to the server
7. Breakpoints, step into, etc.

