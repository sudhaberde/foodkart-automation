package com.sudha.ecom.foodkart.automation.tests;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.sudha.ecom.foodkart.automation.pageobjects.ClassicPlanPage;
import com.sudha.ecom.foodkart.automation.reports.ExtentReportManager;
import com.sudha.ecom.foodkart.automation.setup.OpenBrowser;
import com.sudha.ecom.foodkart.automation.utils.TestUtils;

public class ClassicPlanPageTest {

	private ExtentReports extent = ExtentReportManager.getInstance();
	private ExtentTest test;
	public String firstWinHandle, secondWindowHandle;

	@Test(priority = 18)
	@Parameters({ "browser" })
	public void checkPrice(String browser) {
		test = extent.startTest(" Validate Amount");
		test.log(LogStatus.INFO, "Check the price");

		secondWindowHandle = OpenBrowser.webDriver.getWindowHandle();
		OpenBrowser.webDriver.switchTo().window(secondWindowHandle);

		ClassicPlanPage classicPlanPage = new ClassicPlanPage(OpenBrowser.webDriver);

		// Wait for page to load and check the cart

		TestUtils.addDelay(1000);

		if (classicPlanPage.getMenuSelectedElement().isDisplayed()) {
			test.log(LogStatus.PASS, "Classic menu has been added to the cart");
		} else {
			test.log(LogStatus.FAIL, "Classic menu has NOT been added to the cart");
		}

		if (classicPlanPage.getProductPriceElement().isDisplayed()) {
			test.log(LogStatus.PASS,
					"Classic menu has been added to the cart with the price:" + classicPlanPage.getProductPriceElement().getText());
		}
		else {
			test.log(LogStatus.FAIL, "Classic menu has NOT been added to the cart");
		}

		String patronsCount = classicPlanPage.getPatronsCount();
		//.getText().split(" ")[0];

		String recipesCount = classicPlanPage.getMealCountElement().getText().split(" ")[0];

		String productPrice = classicPlanPage.getProductPriceElement().getText().substring(1);

		Float expectedPrice = Float.parseFloat(patronsCount) * Float.parseFloat(recipesCount) * HomePageTest.price;

		if (expectedPrice == Float.parseFloat(productPrice)) {

			test.log(LogStatus.PASS, "Classic menu price displayed on the Summary page is as expected");
		}

		else {

			test.log(LogStatus.FAIL, "Classic menu price displayed on the Summary page is not as expected");
		}

		extent.endTest(test);
		extent.flush();

	}

	@Test(priority = 19)
	@Parameters({ "browser" })
	public void viewPlan(String browser) {
		test = extent.startTest(" Add plan to the cart");
		test.log(LogStatus.INFO, "add plan to cart, check the price for check out");

		firstWinHandle = OpenBrowser.webDriver.getWindowHandle();
		OpenBrowser.webDriver.switchTo().window(firstWinHandle);

		ClassicPlanPage classicPlanPage = new ClassicPlanPage(OpenBrowser.webDriver);
		// Wait for page to load

		TestUtils.addDelay(1000);

		// Fill in the address for delivery
		classicPlanPage.setAddressLine1();

		classicPlanPage.setCity();

		classicPlanPage.setPostcode();

		// classicPlanPage.setState();

		classicPlanPage.setPhone();

		// classicPlanPage.Continue.click();

		TestUtils.addDelay(1000);

		extent.endTest(test);
		extent.flush();
	}

}