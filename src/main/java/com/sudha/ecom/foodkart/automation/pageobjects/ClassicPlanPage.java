package com.sudha.ecom.foodkart.automation.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.sudha.ecom.foodkart.automation.utils.TestProperties;

public class ClassicPlanPage {
	
	public ClassicPlanPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath=".//input[@id='autocompleteAddress']")
			public WebElement addressLine1;
	
	
	@FindBy(xpath=".//input[@id='city']")
	public WebElement city;
	

	@FindBy(xpath=".//input[@id='postcode']")
	public WebElement postcode;
	
	@FindBy(xpath=".//select[@id='regionCode']")
	public Select state;
	
	
	@FindBy(xpath=".//input[@id='phone']")
	public WebElement phone;
	
	
	@FindBy(xpath=".//button[@applanga='next']")
	public WebElement Continue;
	
	@FindBy(xpath=".//button[@id='place-your-order-button']")
	public WebElement PlaceOrder;
	
	
	@FindBy(xpath=".//span[@applanga='classic-menu-title']")
	public WebElement verifyClassicMenu;
	
	@FindBy(xpath=".//span[@ng-bind='vm.getProductPrice(product)']")
	public WebElement verifyPrice;
	
	@FindBy(xpath=".//span[@ng-bind='vm.getProductSize(product)']")
	public WebElement patronCount;
	
	
	@FindBy(xpath=".//span[@ng-bind='vm.getProductMeals(product)']")
	public WebElement mealCount;
	
	

	
	/**
	 * @param addressLine1 the addressLine1 to set
	 */
	public void setAddressLine1() {
		this.addressLine1.sendKeys(TestProperties.getProperty("address.line1"));
	}



	/**
	 * @param city the city to set
	 */
	public void setCity() {
		this.city.sendKeys(TestProperties.getProperty("city")); 
	}

	

	/**
	 * @param postcode the postcode to set
	 */
	public void setPostcode() {
		this.postcode.sendKeys(TestProperties.getProperty("zip.code")); 
	}
	



	/**
	 * @param state the state to set
	 */
	public void setState() {
		this.state.selectByIndex(1);
	}

	

	/**
	 * @param phone the phone to set
	 */
	public void setPhone() {
		this.phone.sendKeys(TestProperties.getProperty("phone")); 
	}
	
	
}
