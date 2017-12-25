package com.sudha.ecom.foodkart.automation.tests;

import org.openqa.selenium.Keys;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.sudha.ecom.foodkart.automation.pageobjects.HomePage;
import com.sudha.ecom.foodkart.automation.pageobjects.LoginPage;
import com.sudha.ecom.foodkart.automation.reports.ExtentReportManager;
import com.sudha.ecom.foodkart.automation.setup.OpenBrowser;
import com.sudha.ecom.foodkart.automation.utils.TestUtils;

public class HomePageTest {
	private ExtentReports extent = ExtentReportManager.getInstance();
	private ExtentTest test;
	public String firstWinHandle, secondWindowHandle;
    

	public static float price;
	
	@Test(priority = 16)
	@Parameters({ "browser" })
	public void viewPlan(String browser) {
		test = extent.startTest("View PlanTest");
		test.log(LogStatus.INFO, "See the meal  plans");
		
		firstWinHandle = OpenBrowser.webDriver.getWindowHandle();
		OpenBrowser.webDriver.switchTo().window(firstWinHandle);
		HomePage homepage = new HomePage(OpenBrowser.webDriver);
		
		//wait for page to load
		TestUtils.addDelay(10000);
		System.out.println("Wait complete at homepage after login");
		if(homepage.ourPlans.isDisplayed()){
			test.log(LogStatus.PASS,"Home page has been loaded");
		}
		else{
			TestUtils.waitForElement(homepage.ourPlans);
		}
		
		homepage.ourPlans.click();
		
		TestUtils.addDelay(10000);
		System.out.println("waited for 10s");
		
		//TestUtils.waitForElement(homepage.selectMenuList);
		
		String priceText=homepage.price.getText();
		
		price = Float.parseFloat(priceText.split(" ")[1]);
		
		homepage.selectMenuList.sendKeys(Keys.ENTER);
		
		extent.endTest(test);
		extent.flush();

      }
	
}	
