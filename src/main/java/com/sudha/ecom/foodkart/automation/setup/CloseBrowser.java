package com.sudha.ecom.foodkart.automation.setup;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.sudha.ecom.foodkart.automation.reports.*;


public class CloseBrowser {

	private ExtentReports extent = ExtentReportManager.getInstance();
	private ExtentTest test;
	
	@Test(priority = 25)
	public void quitBrowser() {
		test = extent.startTest("closing Browser");
		test.log(LogStatus.INFO, "Closing the Browser");
		OpenBrowser.webDriver.close();
		OpenBrowser.webDriver.quit();
		extent.endTest(test);
		extent.flush();

	}
}
