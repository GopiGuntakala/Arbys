package com.arbysstg.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.arbysstg.Testcases.BaseClass;

public class MenuPageObjects  {

WebDriver ldriver;
	
	
	public MenuPageObjects(WebDriver driver){
		ldriver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath = "//span[@data-gtm-id=\"Meals\" and text()=\"ORDER\"]") WebElement mealsCat;
	
	
	public void MealsCategory() {
		mealsCat.click();
	}
	
	
	
	
	
}
