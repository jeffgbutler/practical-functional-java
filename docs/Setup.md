## Setup
### Setup for Eclipse
1. Install JDK 8 or higher from http://www.oracle.com/technetwork/java/javase/downloads/index.html
2. Install Eclipse from http://www.eclipse.org/downloads/
3. Clone this repository
4. Open Eclipse, make a new workspace
5. (Optional) Install the Infinitest plugin from the Eclipse marketplace if you want the tests to run automatically
   - Help->Eclipse Marketplace...
   - Search for Infinitest
   - Install the plugin, restart, etc.
6. Import the project from the cloned code repo
7. If you installed Infinitest, the tests will run automatically and you can follow the red marks to know where to make changes.  If you did not install Infinitest, the you can run all the tests by right clicking on the project and selecting "Run As->JUnit Test"
 

### Setup for Visual Studio Code
1. Install JDK 8 or higher from http://www.oracle.com/technetwork/java/javase/downloads/index.html
2. Install VS code from https://code.visualstudio.com/
3. Clone this repository
4. Open VS code in the cloned code repo:
   - cd ...\practical-functional-java
   - code .
5. Open the extensions page (ctrl-shift-X), install the following extensions
   - Java Extension Pack (from Microsoft)
   - Java Test Runner (from Microsoft)
6. If you get the message from VS Code that it can't find the JDK...
   - ctrl-shift-P (show all commands)
   - Open Workplace settings
   - Add setting "java.home" = "\<your JDK location\>" (for example "C:\\\\Program Files\\\\Java\\\\jdk1.8.0_121")
7. You can run the tests by opening any test Java file and taking the "Run Test" option within the code.
