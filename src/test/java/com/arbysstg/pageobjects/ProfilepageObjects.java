package com.arbysstg.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProfilepageObjects {
	
	WebDriver ldriver;

	public ProfilepageObjects(WebDriver driver) {
		ldriver=driver;
		PageFactory.initElements(driver, this);
	}
	 
	@FindBy(name="firstName") WebElement firstname;
	@FindBy(id="lastName")    WebElement lastname;
	@FindBy(name="phone")     WebElement phonenum;
	@FindBy(id="email")       WebElement Email;
	@FindBy(id="birthDate")   WebElement birthdate;
	 
	public String getFisrtName() {
		return firstname.getAttribute("value");
	}
	
	public String getLastName() {
			return lastname.getAttribute("value");
		}
		
	public String getEmail() {
		return Email.getAttribute("value");
	}
	
	
	public String getPhoneNum() {
		return phonenum.getAttribute("value");
	}
	
	public String getDob() {
		return birthdate.getAttribute("value");
	}
	
	
}
