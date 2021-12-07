# qaf-blank-project-maven

XXX Framework (XXX) is a powerful and versatile platform to author Test Cases in Behavior Driven, Keyword Driven or Code Driven approach. It is built on top of QMetry Automation Framework and can be used to build test cases covering API, Web and Mobile platforms. The framework is built on Java using TestNG, Selenium, Appium and Perfecto with out of the box integration to QMetry reports.

Some of the key features include:
- Test Authoring based on Behavior Driven Development (BDD), Keyword Driven and Code Driven Development or using regular TestNG test cases
- Perform Data Driven Testing with test data supplied from **external** files such as CSV, JSON, XML or custom source
- Write less code with more focus on data setup and configuration
- Code is more resusable and easy to maintain with lot of utility classes
- Supports parallel execution as the framework is based on TestNG
- Multiple locales and environment support for application properties
- Easy out of the box QMetry reporting with execution dashboard, detailed analysis and screenshot capturing
- CI/CD integration with Jenkins, Bamboo
- Integration with test management platforms like QMetry, Rally
- Integration with Perfecto Mobile cloud, Sauce labs

Please refer to [QAF documentation](https://qmetry.github.io/qaf/) for more information.

Project Structure: 

XXX automation project makes use of XXX Framework and is based on Maven directory structure:
 
The 'config' directory contains testng.xml file, and is a place holder for configuration files.

The 'resources' directory contains all required resources including properties files and data files, and is a place holder for other resources.

The 'src' directory contains all java files and is a place holder for other java files.

The 'test-results' directory contains result files.

The 'scenarios' directory is the default place holder for all the scenario files. 


To change/modify dependencies check pom.xml
To run the project, from command prompt go to project home and run mvn. Open dashboard.htm to view results.

Note: This sample project uses chrome driver and it requires chrome driver binary.
You need to download and set webdriver.chrome.driver property in application.properties file with driver binary path.

