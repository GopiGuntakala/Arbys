package com.arbysstg.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LocationPageObjects {
	WebDriver ldriver;
	
	
	public LocationPageObjects(WebDriver driver){
		ldriver=driver;
		PageFactory.initElements(driver, this);
		
	}

	@FindBy(how = How.XPATH, using="//input[@aria-label=\"Search Location Input\"]") WebElement searchbox;
	
	@FindBy(xpath = "(//button[@type='button'][normalize-space()='ORDER'])[1]") WebElement orderbtn;
	
	@FindBy(xpath="//button[@aria-label=\"Search Location\"]") WebElement search;
	
	public void SearchBox(String storeId) {
		searchbox.sendKeys(storeId);
	}
	

	public void SelectStore() {
		orderbtn.click();
	}
	
	public void searchstore() {
		
		search.click();
	}
	
	
	
	
	
}
