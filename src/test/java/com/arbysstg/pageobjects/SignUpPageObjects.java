package com.arbysstg.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignUpPageObjects {
	
	WebDriver ldriver;
	
	public SignUpPageObjects(WebDriver driver) {
		
		ldriver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//h3[contains(@class,'signup')]") WebElement header;
	
	@FindBy(css = "input#firstName") WebElement firstName;
	@FindBy(css="input#lastName") WebElement lastName;
	@FindBy(css = "input#email[name='email']") WebElement email;
	@FindBy(css = "input[type='tel']") WebElement phone;
	@FindBy(css = "input[placeholder='MM-DD']") WebElement dob;
	@FindBy(xpath = "//input[@name=\"password\"]") WebElement pwd;
	@FindBy(xpath = "//label[contains(@class,'termsLabel')][@for='terms']") WebElement Termscond;
	
	@FindBy(css = "button[type='submit']") WebElement signup;
	
	
		public String getsignupheader() {
			String headers=header.getText();
			return headers;
		}
		
		public void getFisrtName(String fName) {
			firstName.sendKeys(fName);
		}
		
		public void getLastName(String lName) {
				lastName.sendKeys(lName);
			}
			
		public void getEmail(String Email) {
			email.sendKeys(Email);
		}
		
		
		public void getPhoneNum(String phoneN) {
			phone.sendKeys(phoneN);
		}
		
		public void getDob(String dateOB) {
			dob.sendKeys(dateOB);
		}
		
		public void getpassword(String password) {
			pwd.sendKeys(password);
		}
		
		
		public void SelTermsCond() {
			Termscond.click();
		}
		
		
		public void signupbtn() {
			signup.click();
		}


}
