package com.arbysstg.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class BagObjects {

	
	WebDriver driver;
	public BagObjects(WebDriver driver) {
		
		this.driver=driver;
		
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="//div[@aria-label=\"Open bag\"]")
	WebElement openingBag;
	
	@FindBy(how=How.XPATH, using="//*[text()='Item added to bag']")
	WebElement Atooltip;
	
	
	@FindBy(how=How.XPATH, using="//span[contains(@class,'item_bagItemPrice')]")
	WebElement bagItemPrice;
	
	@FindBy(xpath="//div[contains(@class,'subtotalContainer')]/div[contains(@class,'ReviewOrderTotal_price')]")
	WebElement BagSubtotal;
	
	@FindBy(xpath="//div[text()=\"Total\"]/following-sibling::div")
	WebElement bagTotal;
	
	@FindBy(xpath="//span[@aria-label=\"bag total price\"]")
	WebElement BagOverallTotal;
	
	
	@FindBy(xpath="//div[contains(@class,'item_bagItemHeader')]//span[contains(@class,'item_bagItemLabel')]")
	WebElement itemNameBag;
	
	@FindBy(xpath="//button[text()='CHECKOUT NOW']") WebElement checkout;
	
	public void CheckoutNow() {
		
		checkout.click();
	}
	
	public void OpenBag() {
		openingBag.click();
	}
	
	public String ItemaddTooltip() {
		
		return Atooltip.getText();
	}
	
	public String ItemLevelPriceB() {
		
		return bagItemPrice.getText();
	}
	
	public String SubtoatlB() {
		
		return BagSubtotal.getText();
	}
	
	
	public String TotalB() {
		
		return bagTotal.getText();
	}
	
	public String OverallTotalB() {
		
		return BagOverallTotal.getText();
	}
	
	public String ItemNameBag() {
		
		return itemNameBag.getText();
	}
	
	
	
}
