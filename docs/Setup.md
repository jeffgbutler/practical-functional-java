## Setup

### Maven Notes
If you experience difficulties in building the project, it might be that your workstation is configured to communicate with an internal Maven repository that cannot be reached when you are off-site. If this is true in your case, you can temporarily disable your connection to the internal Maven repository by renaming your Maven `settings.xml` file:

1. (Windows) Navigate to `\Users\<your id>\.m2`
2. (Linux/Mac) Navigate to `~\.m2`
3. Rename `settings.xml` to `settings.xml.save`

**Important** Remember to rename the file back to `settings.xml` once you are finished with this workshop. 

### Setup for Eclipse
1. Install JDK 8 or higher from [http://www.oracle.com/technetwork/java/javase/downloads/index.html](http://www.oracle.com/technetwork/java/javase/downloads/index.html)
2. Install Eclipse from [http://www.eclipse.org/downloads/](http://www.eclipse.org/downloads/)
3. Clone the repository from [https://github.com/jeffgbutler/practical-functional-java.git](https://github.com/jeffgbutler/practical-functional-java.git), or download the zip from [https://github.com/jeffgbutler/practical-functional-java/archive/master.zip](https://github.com/jeffgbutler/practical-functional-java/archive/master.zip)
4. Open Eclipse, make a new workspace
5. (Optional) Install the Infinitest plugin from the Eclipse marketplace if you want the tests to run automatically
   - Help->Eclipse Marketplace...
   - Search for Infinitest
   - Install the plugin, restart, etc.
6. Import the project from the cloned code repo (File->Import...->Existing Maven Project)
7. If you installed Infinitest, the tests will run automatically and you can follow the red marks to know where to make changes.  If you did not install Infinitest, the you can run all the tests by right clicking on the project and selecting "Run As->JUnit Test"
 
### Setup for IntelliJ
1. Install JDK 8 or higher from [http://www.oracle.com/technetwork/java/javase/downloads/index.html](http://www.oracle.com/technetwork/java/javase/downloads/index.html)
2. Install IntelliJ Community Edition from [https://www.jetbrains.com/idea/download](https://www.jetbrains.com/idea/download)
3. Clone the repository from [https://github.com/jeffgbutler/practical-functional-java.git](https://github.com/jeffgbutler/practical-functional-java.git), or download the zip from [https://github.com/jeffgbutler/practical-functional-java/archive/master.zip](https://github.com/jeffgbutler/practical-functional-java/archive/master.zip)
4. Open IntelliJ, import Maven project from the cloned repo (File->New->Project From Existing Sources...)
5. Run tests with ctrl-shift-F10

### Setup for Visual Studio Code
1. Install JDK 8 or higher from [http://www.oracle.com/technetwork/java/javase/downloads/index.html](http://www.oracle.com/technetwork/java/javase/downloads/index.html)
2. Install VS code from [https://code.visualstudio.com/](https://code.visualstudio.com/)
3. Clone the repository from [https://github.com/jeffgbutler/practical-functional-java.git](https://github.com/jeffgbutler/practical-functional-java.git), or download the zip from [https://github.com/jeffgbutler/practical-functional-java/archive/master.zip](https://github.com/jeffgbutler/practical-functional-java/archive/master.zip)
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
7. You can run the tests by opening any Java file, then navigating through the "Test Explorer" to find a test, and then taking the "Run Test" option within the code.
