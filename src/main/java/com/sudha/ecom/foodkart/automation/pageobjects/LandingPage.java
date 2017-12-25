package com.sudha.ecom.foodkart.automation.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {
	
	

	public LandingPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath=".//span[@data-translation-id='senf-navigation.login']")
	public WebElement LoginButton;
	
	@FindBy(xpath=".//button[@id='register-user-link']")
	public WebElement RegistrationLink;
	
	@FindBy(xpath=".//div[@class='fela-1c1id1v']//*[name()='svg']")
	public WebElement holidayAlert;
	

	@FindBy(xpath=".//div[@id='cookiesDisclaimer']//button[contains(@class,'js-cookie-disclaimer-close')]")
	public WebElement cookieAlert;
}
