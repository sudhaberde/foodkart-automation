package com.sudha.ecom.foodkart.automation.tests;

import java.util.Base64;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.sudha.ecom.foodkart.automation.pageobjects.LoginPage;
import com.sudha.ecom.foodkart.automation.reports.*;
import com.sudha.ecom.foodkart.automation.setup.OpenBrowser;
import com.sudha.ecom.foodkart.automation.utils.TestUtils;

public class LoginTest {

	private ExtentReports extent = ExtentReportManager.getInstance();
	private ExtentTest test;
	public String firstWinHandle, secondWindowHandle;

	@Test(priority = 12)
	@Parameters({ "browser" })
	public void userLogin(String browser) {
		test = extent.startTest("LoginTest");
		test.log(LogStatus.INFO, "Logging in");

		firstWinHandle = OpenBrowser.webDriver.getWindowHandle();
		OpenBrowser.webDriver.switchTo().window(firstWinHandle);
		LoginPage login = new LoginPage(OpenBrowser.webDriver);
		// Wait for page to load
		TestUtils.addDelay(500);
		if (login.LoginNavigation.isDisplayed()) {
			System.out.println("inside login navigation");
			login.LoginNavigation.click();

		}
		TestUtils.addDelay(500);

		login.setEmailAddress();

		login.setPassword();

		login.loginButton.click();

		TestUtils.addDelay(50);

		extent.endTest(test);
		extent.flush();

	}
}