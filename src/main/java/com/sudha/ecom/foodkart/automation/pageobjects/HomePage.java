package com.sudha.ecom.foodkart.automation.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	
	@FindBy(xpath="//*[@id='main-navigation']/a[1]")
	public WebElement ourPlans;
	
	
	@FindBy(xpath="//div[contains(@class,'card-classic-menu')]/div[2]/div[2]/h3/span/span[1]")
	private WebElement price_us;
	
	@FindBy(xpath="//div[contains(@class,'card-classic-menu')]/div[2]/div[1]/h3/span/span[1]")
	private WebElement price_uk;
	
	@FindBy(xpath="//div[contains(@class,'card-classic-menu')]/div[2]/button")
	public WebElement selectMenuList;
	
	public WebElement getPriceElement(){
		if("US".equalsIgnoreCase(System.getProperty("country.code"))){
			return price_us;
		}else if("UK".equalsIgnoreCase(System.getProperty("country.code"))){
			return price_uk;
		}else{
			return price_us;
		}
	}
	
	
	
}
