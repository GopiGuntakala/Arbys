package com.arbysstg.Testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.arbysstg.pageobjects.HomepageObjects;
import com.arbysstg.pageobjects.SignInPageObjects;


public class TC_Signin_002 extends BaseClass{
	
	HomepageObjects hp;
	SignInPageObjects signinp;
	
	

	@Test
	public void signin() throws InterruptedException, IOException {
		hp=new HomepageObjects(driver);
		signinp=new SignInPageObjects(driver);
		log.info("Navigated to Home page");
		hp.ClickSignin();
		log.info("clicked on signin button");
		signinp.setEmail(emailid);
		log.info("entered email");
		signinp.setpassword(signinpwd);
		log.info("entered password");
		signinp.signinClick();
		log.info("clicked on signin button");
		Thread.sleep(3000);
		if(driver.getPageSource().contains("Hi")) {
			Assert.assertTrue(true);
			System.out.println("successfully signed in");
			log.info("Signed in ");
		}else {
			CaptureScreenshot(driver, "signin");
			Assert.assertTrue(false);
			System.out.println("signin failed");
			log.info("Sign in failed ");
		}
		
		Thread.sleep(3000);
	}
	
	
	
}
