package com.arbysstg.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomepageObjects {
	
	WebDriver ldriver;

	public HomepageObjects(WebDriver driver) {
		ldriver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[starts-with(@class,'signIn_signIn')]") WebElement signin;
	
	@FindBy(xpath = "//a[@href=\"/account/\"]") WebElement profilelink;
	
	public void ClickSignin() {
		signin.click();
	}
	
	public void profileClick() {
		profilelink.click();
	}
	
}
