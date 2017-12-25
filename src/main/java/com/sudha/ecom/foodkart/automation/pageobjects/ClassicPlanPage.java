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
	private WebElement verifyClassicMenu_us;
	
	@FindBy(xpath=".//strong[@ng-bind='vm.productHelper.getProductTitle(product)']")
	private WebElement verifyClassicMenu_uk;
	
	@FindBy(xpath=".//span[@ng-bind='vm.getProductPrice(product)']")
	private WebElement verifyPrice_us;
	
	@FindBy(xpath=".//strong[@ng-bind='product.price']")
	private WebElement verifyPrice_uk;
	
	@FindBy(xpath=".//span[@ng-bind='vm.getProductSize(product)']")
	private WebElement patronCount_us;
	
	
	@FindBy(xpath=".//span[@ng-bind='vm.getProductMeals(product)']")
	private WebElement mealCount_us;
	
	@FindBy(xpath=".//span[@ng-bind='product.specsLabel']")
	private WebElement mealCount_uk;
	
	public WebElement getMealCountElement(){
		if("US".equalsIgnoreCase(System.getProperty("country.code"))){
			return mealCount_us;
		}else if("UK".equalsIgnoreCase(System.getProperty("country.code"))){
			return mealCount_uk;
		}else{
			return mealCount_us;
		}
	}
	
	public String getPatronsCount(){
		if("US".equalsIgnoreCase(System.getProperty("country.code"))){
			return patronCount_us.getText().split(" ")[0];
		}else if("UK".equalsIgnoreCase(System.getProperty("country.code"))){
			return mealCount_uk.getText().split(" - ")[1].split(" ")[0];
		}else{
			return patronCount_us.getText().split(" ")[0];
		}
	}
	
	public WebElement getProductPriceElement(){
		if("US".equalsIgnoreCase(System.getProperty("country.code"))){
			return verifyPrice_us;
		}else if("UK".equalsIgnoreCase(System.getProperty("country.code"))){
			return verifyPrice_uk;
		}else{
			return verifyPrice_us;
		}
	}
	
	public WebElement getMenuSelectedElement(){
		if("US".equalsIgnoreCase(System.getProperty("country.code"))){
			return verifyClassicMenu_us;
		}else if("UK".equalsIgnoreCase(System.getProperty("country.code"))){
			return verifyClassicMenu_uk;
		}else{
			return verifyClassicMenu_us;
		}
	}

	
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
