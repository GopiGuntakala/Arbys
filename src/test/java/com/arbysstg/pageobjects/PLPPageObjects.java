package com.arbysstg.pageobjects;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PLPPageObjects {

	
WebDriver ldriver;
	
	
	public PLPPageObjects(WebDriver driver){
		ldriver=driver;
		PageFactory.initElements(driver, this);
		
	}
	public int  RandomNum() {
		Random random=new Random();
		int num=random.nextInt(10);
		return num;
	}
	
	@FindBy(xpath = "(//span[@data-gtm-id=\"productItem\"][contains(@class,'textWithTrademark')])[2]") 
	WebElement addtobag;
	
	@FindBy(xpath = "(//span[@aria-label='Product Price and Calories'])[1]") WebElement plpproduct;
	//@FindBy(xpath = "(//span[@aria-label='Product Price and Calories'])["+RandomNum()+"]") WebElement plpproduct;
	
	
	public void addProductPLP() {
		addtobag.click();
	}
	
	public String PPandCalories() {
		return plpproduct.getText();
	}
	
}
