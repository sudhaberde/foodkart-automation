package com.sudha.ecom.foodkart.automation.setup;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.sudha.ecom.foodkart.automation.pageobjects.LandingPage;
import com.sudha.ecom.foodkart.automation.reports.ExtentReportManager;

import com.sudha.ecom.foodkart.automation.setup.OpenBrowser;
import com.sudha.ecom.foodkart.automation.utils.TestUtils;

public class NavigateToRegistration {
	private ExtentReports extent = ExtentReportManager.getInstance();
	private ExtentTest test;
	String firstWinHandle;
	//Launches the browser
	@Test(priority = 3)
	@Parameters({ "browser" })
	public void navigateToTheRegistration(String browser) {
		
		test = extent.startTest("New User Registration");
		test.log(LogStatus.INFO, "Navigate to Registration page");
		
		firstWinHandle=OpenBrowser.webDriver.getWindowHandle();
		OpenBrowser.webDriver.switchTo().window(firstWinHandle);
		
		
		
		LandingPage landingPage = new LandingPage(OpenBrowser.webDriver);
		//wait for landing page to load completely.Also the login button should be fully loaded.
		TestUtils.addDelay(30);
		TestUtils.waitForElement(landingPage.LoginButton);
		test.log(LogStatus.INFO, " Successful loading of Landing page");
	       
		if(!landingPage.LoginButton.isEnabled()){
			//Accepting the holiday alerts
			if(landingPage.holidayAlert.isDisplayed()){
				
				landingPage.holidayAlert.click();
			}
			//System.out.println("holiday alert complete");
	       //accepting the Cookie Alert
			else if (landingPage.cookieAlert.isDisplayed()){
				landingPage.cookieAlert.click();
			 	
			}
		}
		//Click on the login button
		landingPage.LoginButton.click();
		
		//wait for  page to load completely.Also the Registration button should be fully loaded.
		TestUtils.addDelay(30);
		TestUtils.waitForElement(landingPage.RegistrationLink);
		
		test.log(LogStatus.INFO, " Successful loading of the page");
				
		//Click on the Registration link
		landingPage.RegistrationLink.click();
		
		//Wait for Registration page to load
		TestUtils.addDelay(30);

		test.log(LogStatus.INFO, " Successful navigation to Registration page");
		extent.endTest(test);
		extent.flush();
		
		
	}
}
