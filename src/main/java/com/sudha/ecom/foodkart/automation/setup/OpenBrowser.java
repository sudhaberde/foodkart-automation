package com.sudha.ecom.foodkart.automation.setup;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.sudha.ecom.foodkart.automation.reports.*;
import com.sudha.ecom.foodkart.automation.utils.*;

public class OpenBrowser {
	
	public static WebDriver webDriver = null;
	//private static final String HELLO_FRESH_URL= "https://www.hellofresh.com";
	private static final String HELLO_FRESH_URL= TestProperties.getProperty("landing.page."+System.getProperty("country.code").toUpperCase());
	
	private ExtentReports extent = ExtentReportManager.getInstance();
	private ExtentTest test;

	//Launches the browser
	@Test(priority = 1)
	@Parameters({ "browser" })
	public void startBrowser(String browser) {
		//set the driver based on browser
		System.out.println("Country "+ HELLO_FRESH_URL );
		if (browser.equalsIgnoreCase("Chrome")){
			test = extent.startTest("OpenBrowser");
			test.log(LogStatus.INFO, "Opening Chrome Browser");
			System.setProperty("webdriver.chrome.driver", "webdriver/bin/chromedriver");
			webDriver = new ChromeDriver();
			webDriver.manage().window().maximize();
			webDriver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		}else {
			System.setProperty("webdriver.firefox.marionette", "webdriver/bin/geckodriver");
			test = extent.startTest("OpenBrowser");
			test.log(LogStatus.INFO, "Opening the Mozilla Firefox Browser");
			FirefoxProfile profile = new FirefoxProfile();
			profile.setPreference(FirefoxProfile.PORT_PREFERENCE, "localhost.localdomain");
			webDriver = new FirefoxDriver(profile);
			webDriver.manage().timeouts().implicitlyWait(180, TimeUnit.SECONDS);
		}
		test.log(LogStatus.INFO, "Opening website : " + HELLO_FRESH_URL);
		//open the website
		webDriver.get(HELLO_FRESH_URL);
		webDriver.manage().timeouts().implicitlyWait(180, TimeUnit.SECONDS);
		test.log(LogStatus.INFO, "Opened website : " + HELLO_FRESH_URL);
		
		TestUtils.addDelay(30);
		extent.endTest(test);
		extent.flush();
	}
}
