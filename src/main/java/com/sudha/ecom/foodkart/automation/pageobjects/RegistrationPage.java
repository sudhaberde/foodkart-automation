package com.sudha.ecom.foodkart.automation.pageobjects;

import java.util.Base64;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sudha.ecom.foodkart.automation.utils.*;


public class RegistrationPage {

	
	public RegistrationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath=".//select[@ id='gender-input']")
	public WebElement userGender;
	
	
	@FindBy(xpath=".//input[@id='first-name-input']")
	public WebElement firstName;
	
	@FindBy(xpath=".//input[@id='last-name-input']")
	public WebElement lastName;
	
	@FindBy(xpath=".//input[@id='email-input']")
	public WebElement emailAddress;
	
	
	@FindBy(xpath=".//input[@id='password-input']")
	public WebElement password;
	
	
	@FindBy(xpath=".//input[@id='month-input']")
	public WebElement month;
	
	
	@FindBy(xpath=".//input[@id='day-input']")
	public WebElement date;
	
	@FindBy(xpath=".//input[@id='year-input']")
	public WebElement year;

	@FindBy(xpath=".//button[@id='register-button']")
	public WebElement registerButton;
	
	@FindBy(xpath=".//span[@id='navigation-customer-name']")
	public WebElement loggedInUserName;
	
	@FindBy(xpath=".//small[@id='email-input-required-error-message']")
	public WebElement emailErrorMessage;
	
	@FindBy(xpath=".//span[@id='navigation-customer-name']")
	public WebElement myaccount;
	
	@FindBy(xpath=".//a[contains(@href,'logout')]")
	public WebElement logout;

	public void setUserGender() {
		this.userGender.sendKeys(TestProperties.getProperty("gender"));
	}

	

	public void setFirstName() {
		this.firstName.sendKeys(TestProperties.getProperty("first.name"));
	}

	

	public void setLastName() {
		this.lastName.sendKeys(TestProperties.getProperty("last.name"));
	}

	
	public void setEmailAddress() {
		this.emailAddress.sendKeys(TestUtils.getEmail());
	}

	

	public void setPassword() {
		this.password.sendKeys(new String(Base64.getDecoder().decode(TestProperties.getProperty("pwd"))));
	} 
	

	

	public void setMonth() {
		this.month.sendKeys(TestProperties.getProperty("month"));
	}

	

	public void setDate() {
		this.date.sendKeys(TestProperties.getProperty("day"));
	}

	

	public void setYear() {
		this.year.sendKeys(TestProperties.getProperty("year"));
	}
	
	
	
}
