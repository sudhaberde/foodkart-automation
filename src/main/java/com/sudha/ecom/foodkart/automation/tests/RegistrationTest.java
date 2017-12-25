package com.sudha.ecom.foodkart.automation.tests;

import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.sudha.ecom.foodkart.automation.setup.OpenBrowser;
import com.sudha.ecom.foodkart.automation.utils.TestUtils;

import com.sudha.ecom.foodkart.automation.pageobjects.LandingPage;
import com.sudha.ecom.foodkart.automation.pageobjects.RegistrationPage;
import com.sudha.ecom.foodkart.automation.reports.ExtentReportManager;

public class RegistrationTest {
	private ExtentReports extent = ExtentReportManager.getInstance();
	private ExtentTest test;
	public String firstWinHandle, secondWindowHandle;
	
	@Test(priority = 12)
	@Parameters({ "browser" })
	public void userRegisterPositive(String browser) {
	test = extent.startTest("positive Registration Test");
	test.log(LogStatus.INFO, "Registering  in");

	firstWinHandle = OpenBrowser.webDriver.getWindowHandle();
	OpenBrowser.webDriver.switchTo().window(firstWinHandle);
	
	RegistrationPage registrationPage = new RegistrationPage(OpenBrowser.webDriver);
	//wait for  page to load completely.Also the userGender element on the registration page must be clickable.
	TestUtils.addDelay(30);
	TestUtils.waitForElement(registrationPage.userGender);
	
	test.log(LogStatus.INFO, " Successful loading of the page");
			
	//Select the gender
	registrationPage.setUserGender();
	test.log(LogStatus.INFO, "Gender is set");
	
	//Set the First name
	registrationPage.setFirstName();
	test.log(LogStatus.INFO, "Firstname is set");
	
	//Set Last Name
	registrationPage.setLastName();
	test.log(LogStatus.INFO, "Lastname is set");
	
	//Set Email address
	registrationPage.setEmailAddress();
	test.log(LogStatus.INFO, "Email is set");
	
	//Set Password
	registrationPage.setPassword();
	test.log(LogStatus.INFO, "password is set");
	
	//set Date of birth
	registrationPage.setMonth();
	
	registrationPage.setDate();
	
	registrationPage.setYear();
	
	test.log(LogStatus.INFO, "Date of birth is set");
	
	
	
	TestUtils.addDelay(3000);
	registrationPage.registerButton.click();
	
	TestUtils.addDelay(5000);
	//Wait for the user name displayed on the profile
	if(registrationPage.loggedInUserName.isDisplayed())
	{
		test.log(LogStatus.PASS, "Registration Successfull");
	}
	else
	{
		test.log(LogStatus.FAIL, "Registration UnSuccessfull");
	}
	  
	Actions action = new Actions(OpenBrowser.webDriver);
	action.moveToElement(registrationPage.myaccount).build().perform();
	
	registrationPage.logout.click();
	
	TestUtils.addDelay(1000);
	
	extent.endTest(test);
	extent.flush();
	
	}
	
	//@Test(priority = 12)
	@Parameters({ "browser" })
	public void userRegisterInvaildEmail(String browser){
		test = extent.startTest("Negative Registration Test with invalid Email address");
		test.log(LogStatus.INFO, "Registering  in with invalid information");

		firstWinHandle = OpenBrowser.webDriver.getWindowHandle();
		OpenBrowser.webDriver.switchTo().window(firstWinHandle);
		
		RegistrationPage registrationPage = new RegistrationPage(OpenBrowser.webDriver);
		//wait for  page to load completely.Also the userGender element on the registration page must be clickable.
		TestUtils.addDelay(30);
		TestUtils.waitForElement(registrationPage.userGender);
		
		test.log(LogStatus.INFO, " Successful loading of the page");
				
		//Select the gender
		registrationPage.setUserGender();
		test.log(LogStatus.INFO, "Gender is set");
		
		//Set the First name
		registrationPage.setFirstName();
		test.log(LogStatus.INFO, "Firstname is set");
		
		//Set Last Name
		registrationPage.setLastName();
		test.log(LogStatus.INFO, "Lastname is set");
		
		
		
		//set an invalid email
		registrationPage.emailAddress.sendKeys("testUser@@");
		
		
		//Verify for the error message corresponding to the invalid email address
		if (registrationPage.emailErrorMessage.isDisplayed())
		{
			test.log(LogStatus.PASS, "Negative test Successful: error message  displayed for invalid Email");
		}
		
		else
		{
			test.log(LogStatus.PASS, "Negative test UnSuccessful");
		}
		
		
		

	
		
		extent.endTest(test);
		extent.flush();
		
		
		
	}
	
}
