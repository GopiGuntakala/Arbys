package com.arbysstg.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PDPPageObjects {

	
	
	
WebDriver ldriver;
	
	public PDPPageObjects(WebDriver driver) {
		
		ldriver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//span[@aria-label='Product Price and Calories']") WebElement pdppricecalor;
	
	@FindBy(xpath = "//div[contains(@class,'productBanner_buttonBlock')]/button[@type=\"button\"]") WebElement addtobag;
	
	@FindBy(xpath="//div/h1")
	WebElement ItemNamePDP;
	
	
	public String pdpPriceCalories() {
	return pdppricecalor.getText();
	}
	
	public void AddItemfromPDP() {
		addtobag.click();
	}
	
	public String pdpName() {
		
		return ItemNamePDP.getText();
	}
	
}
