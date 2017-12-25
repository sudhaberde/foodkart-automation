# foodkart-automation

The project automate the following tasks using Selenium with  FirefoxDriver, ChromeWebDriver. The project supports Cross browser-execution on Firefox and Chrome. The Firefox browser execution happens first and then execution on Chrome follows.
   
If the execution one of the browsers is not required, then the tests grouped under respective names need to be commented in [testng.xml](testng.xml) which is located in base path.

Flow of the Scenario:
1. Go to the website https://www.hellofresh.co.uk and https://www.hellofresh.com( Based on the preference given by the tester at the time of execution in the command line)
2. Register new user
3. Login with existing user
4. Add classic box/plan to cart and validate that box and price are ok in checkout page

# Prerequisites 
### This automation project been designed to run on Mac OS ###
* Chrome 60 (and greater) and Firefox 55.0 (and greater) browsers installed
* Have [java](http://www.oracle.com/technetwork/java/javase/downloads/index.html) installed
* Have [maven](http://maven.apache.org/) installed

# Test Execution Steps:
1. Install foodkart-automation project
	1. Download the project zip from :(https://github.com/sudhaberde/foodkart-automation/archive/master.zip)
	2. Extract the zip file to the directory of choice (hereafter referred to as base-path)
	* You can also clone the codebase to base-path if you have GIT installed
2. Go to the base-path directory 
	`cd foodkart-automation`
3. a. Run the  below command for UK
   `mvn clean test -Dcountry.code=UK`
   b. Run the  below command for US
   `mvn clean test -Dcountry.code=US`
   c. By Default with no option the test will run for US. This can be done using the below command.
   `mvn clean test'
	
	* The first time execution of this command will take some time for downloading the required packages. Also, please manually clear the browser cache.

# Note:
1. The geckodriver required for execution on Firefox and chromedriver required for execution on Chrome browser are kept in [webdriver/bin](webdriver/bin)
2. Each step of the flow has been logically treated as a Test. The success and failure of each step will be logged in an html based report. This report test_report.html will be generated in the base path itself. This report gives information in the Pie chart form as well as tabular form. Details of the execution will also be available under each link.

# Scope for Improvement
1. Fix existing issues in Chrome execution. Provide support for windows execution
2. Extend the execution support for the other countries of operation (For DE, LU, CA etc)
3. Extend browser support to IE and Safari
4. Dockerize the project

# Troubleshooting
1. Make sure you are running this program on Mac OS. Currently the application supports only Mac OS.
2. If you get any error  while running the start script which says 'COMMAND NOT FOUND' make sure maven is installed properly and maven bin is added to the PATH.
3. If the browser doesn't open it could be because of permission issue for the driver.Run the below command from base path to make it executable.
`chmod 755 webdriver/bin/chromedriver`
`chmod 755 webdriver/bin/geckodriver`
4. Firefox browser version supported by application - 46.0
5. Chrome browser version supported by application - Version 61.0.3163.100 (Official Build) (64-bit)



