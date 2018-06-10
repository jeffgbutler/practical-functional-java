## Setup

Note: If you experience difficulties building the projects after following these instructions, see the Maven Notes section at the bottom of this page.

### For all Environments
Install and configure Java, Maven, and Git. Some of these steps are optional depending on the IDE you choose and your preferred workflow. If you have experience with these tools then you may feel free to alter the instructions to fit your preferences. If you plan to use Visual Studio Code, then your life will be easier if you use a setup similar to what's shown here.

#### Download/Install 
1. Install JDK 8 or higher from [http://www.oracle.com/technetwork/java/javase/downloads/index.html](http://www.oracle.com/technetwork/java/javase/downloads/index.html)
2. Download Maven from [http://maven.apache.org/](http://maven.apache.org/) and unzip/untar the file somewhere convenient (for example \JavaTools\apache-maven-3.5.3)
3. Install Git from [https://git-scm.com/](https://git-scm.com/)

#### Configure
You will need to configure some environment variables for the tools to work properly. There are a variety of ways to do this.

| Environment Variable | Setting |
|----------------------|---------|
| M2_HOME | Set to the home directory of your Maven download (for example, \JavaTools\apache-maven-3.5.3) |
| JAVA_HOME| Set to the home directory of your JDK installation (for example, \Program Files\Java\jdk-10.0.1) |
| PATH | Add %M2_HOME%\bin to the PATH |

## Setup for Eclipse
1. Install Eclipse from [http://www.eclipse.org/downloads/](http://www.eclipse.org/downloads/)
2. Clone the repository from [https://github.com/jeffgbutler/practical-functional-java.git](https://github.com/jeffgbutler/practical-functional-java.git), or download the zip from [https://github.com/jeffgbutler/practical-functional-java/archive/master.zip](https://github.com/jeffgbutler/practical-functional-java/archive/master.zip)
3. Open Eclipse, make a new workspace
4. (Optional) Install the Infinitest plugin from the Eclipse marketplace if you want the tests to run automatically
   - Help->Eclipse Marketplace...
   - Search for Infinitest
   - Install the plugin, restart, etc.
5. (Optional) Install the Code Coverage plugin from the Eclipse marketplace if you want to measure code coverage
   - Help->Eclipse Marketplace...
   - Search for EclEmma
   - Install the plugin, restart, etc.
6. Import the project from the cloned code repo (File->Import...->Existing Maven Project)
7. If you installed Infinitest, the tests will run automatically and you can follow the red marks to know where to make changes.  If you did not install Infinitest, the you can run all the tests by right clicking on the project and selecting "Run As->JUnit Test"
 
### Setup for IntelliJ
1. Install IntelliJ Community Edition from [https://www.jetbrains.com/idea/download](https://www.jetbrains.com/idea/download)
2. Clone the repository from [https://github.com/jeffgbutler/practical-functional-java.git](https://github.com/jeffgbutler/practical-functional-java.git), or download the zip from [https://github.com/jeffgbutler/practical-functional-java/archive/master.zip](https://github.com/jeffgbutler/practical-functional-java/archive/master.zip)
3. Open IntelliJ, import Maven project from the cloned repo (File->New->Project From Existing Sources...)
4. Run tests with ctrl-shift-F10

### Setup for Visual Studio Code
1. Install VS code from [https://code.visualstudio.com/](https://code.visualstudio.com/)
2. Clone the repository from [https://github.com/jeffgbutler/practical-functional-java.git](https://github.com/jeffgbutler/practical-functional-java.git), or download the zip from [https://github.com/jeffgbutler/practical-functional-java/archive/master.zip](https://github.com/jeffgbutler/practical-functional-java/archive/master.zip)
3. Open VS code in the cloned code repo:
   - cd ...\practical-functional-java
   - code .
4. Open the extensions page (ctrl-shift-X), install the Java Extension Pack (from Microsoft)
5. If you get the message from VS Code that it can't find the Java Runtime...
   - ctrl-shift-P (show all commands)
   - Open Workplace settings
   - Add setting "java.home": "\<your JDK location\>" (for example "C:\\\\Program Files\\\\Java\\\\jdk-10.0.1")
   - Reload the window (ctrl-shift-P, then "Reload Window")
6. You can run the tests by opening any Java file, then navigating through the "Test Explorer" to find a test, and then taking the "Run Test" option within the code.

### Maven Notes
If you experience difficulties in building the project, it might be that your workstation is configured to communicate with an internal Maven repository that cannot be reached when you are off-site. If this is true in your case, you can temporarily disable your connection to the internal Maven repository by renaming your Maven `settings.xml` file:

1. (Windows) Navigate to `\Users\<your id>\.m2`
2. (Linux/Mac) Navigate to `~\.m2`
3. Rename `settings.xml` to `settings.xml.save`

**Important** Remember to rename the file back to `settings.xml` once you are finished with this workshop. 
