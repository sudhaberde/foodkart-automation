package com.sudha.ecom.foodkart.automation.utils;

import java.util.Random;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.sudha.ecom.foodkart.automation.setup.OpenBrowser;

public class TestUtils {

	public static String EMAIL_ADDRESS;

	public static WebDriverWait wait;

	public static void addDelay(long time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static String getEmail() {
		Random rad = new Random();
		EMAIL_ADDRESS = "testuser" + rad.nextInt(1000) + "@foodemail.com";
		return EMAIL_ADDRESS;

	}

	public static void waitForElement(WebElement element) {
		wait = new WebDriverWait(OpenBrowser.webDriver, 40);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

}
