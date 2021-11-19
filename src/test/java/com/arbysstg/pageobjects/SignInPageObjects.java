package com.arbysstg.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class SignInPageObjects {
	
	WebDriver ldriver;
	public SignInPageObjects(WebDriver driver) {
		ldriver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "button[data-gtm-id=\"createAnAccount\"]") WebElement createanAccount;
	@FindBy(how = How.ID, using = "email")  WebElement email;
	@FindBy(how=How.XPATH, using = "//input[@name=\"password\"]") WebElement Spassword;
	@FindBy(how=How.CSS, using = "button[type='submit']") WebElement signin;
	
	public void CreateAccountBtn() {
		createanAccount.click();
	}
	
	public void setEmail(String Email) {
		email.sendKeys(Email);
	}
	
	public void setpassword(String pwd) {
		Spassword.sendKeys(pwd);
	}
	
	public void signinClick() {
		signin.click();
	}
	
	
	
}
