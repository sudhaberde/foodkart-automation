package com.sudha.ecom.foodkart.automation.pageobjects;

import java.util.Base64;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sudha.ecom.foodkart.automation.utils.TestProperties;
import com.sudha.ecom.foodkart.automation.utils.TestUtils;

public class LoginPage {

	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = ".//input[@id='email-input']")
	public WebElement emailAddress;

	@FindBy(xpath = ".//input[@id='password-input']")
	public WebElement password;

	@FindBy(xpath = ".//button[@id='submit-login-button']")
	public WebElement loginButton;

	@FindBy(xpath = ".//span[@data-translation-id='senf-navigation.login']")
	public WebElement LoginNavigation;

	public void setEmailAddress() {
		this.emailAddress.sendKeys(TestUtils.EMAIL_ADDRESS);
	}

	public void setPassword() {
		this.password.sendKeys(new String(Base64.getDecoder().decode(TestProperties.getProperty("pwd"))));
	}

}
