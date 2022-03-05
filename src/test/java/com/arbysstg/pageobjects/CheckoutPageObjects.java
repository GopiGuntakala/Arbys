package com.arbysstg.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPageObjects {
	
	
	
	WebDriver driver;
	public CheckoutPageObjects(WebDriver driver) {
		
		this.driver=driver;
		
		PageFactory.initElements(driver, this);
		
	}

	@FindBy(id="firstName") WebElement FirstName;
	
	@FindBy(id="lastName") WebElement LastName;
	
	@FindBy(name="phone") WebElement phonenu;
	
	@FindBy(id="email") WebElement Email;
	
	
	@FindBy(name="chFirstName") WebElement cardFN;
	
	@FindBy(name="chLastName") WebElement cardLN;
	
	@FindBy(id="CardNumber") WebElement cardnum;
	
	@FindBy(id="ExpirationDate") WebElement expdate;
	
	@FindBy(id="SecurityCode") WebElement securitycode;
	
	@FindBy(id="PostalCode") WebElement postal;
	
	
	@FindBy(xpath="//*[contains(@class,'paymentInfo_checkIcon')]") WebElement checkboxx;
	
	
	public void firstname(String fname) {
		
		FirstName.sendKeys(fname);
		
		
	}
	
	public void LastName(String lname) {
		
		LastName.sendKeys(lname);
	}
	
	public void phonenum(String phonenumber) {
		
		phonenu.sendKeys(phonenumber);
	}
	
	public void email(String emails) {
		
		Email.sendKeys(emails);
	}
	
	
	public void CardHFName(String fname) {
		
		cardFN.sendKeys(fname);
		
	}
	
	public void CardHLName(String lname) {
		
		cardLN.sendKeys(lname);
	}
	
	public void cardNumber(String number) {
		
		cardnum.sendKeys(number);
	}
	
	public void CExpirydate(String expDate) {
		
		expdate.sendKeys(expDate);
	}
	
	public void CsecurityCode(String code) {
		
		securitycode.sendKeys(code);
	}
	
	public void PostalCode(String pcode) {
		postal.sendKeys(pcode);
	}
	
	
	public void TermsConditions() {
		
		checkboxx.click();
	}
}
