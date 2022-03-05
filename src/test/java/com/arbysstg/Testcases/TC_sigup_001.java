package com.arbysstg.Testcases;

import java.io.IOException;
import java.util.Random;

import org.apache.poi.xssf.usermodel.XSSFRow;

import org.testng.annotations.Test;

import com.arbysstg.pageobjects.HomepageObjects;
import com.arbysstg.pageobjects.ProfilepageObjects;
import com.arbysstg.pageobjects.SignInPageObjects;
import com.arbysstg.pageobjects.SignUpPageObjects;
import com.arbysstg.utilities.excelutilities;

import junit.framework.Assert;

public class TC_sigup_001 extends BaseClass {
	
	
	
	HomepageObjects hp;
	SignInPageObjects signinP;
	SignUpPageObjects signUp;
	excelutilities Xlutils;
	ProfilepageObjects profile;

	
	@Test
	public void Signup() throws IOException, InterruptedException {
		
		hp=new HomepageObjects(driver);
		signinP=new SignInPageObjects(driver);
		signUp=new SignUpPageObjects(driver);
		Xlutils=new excelutilities();
		profile=new ProfilepageObjects(driver);
		
		hp.ClickSignin();
		signinP.CreateAccountBtn();
		
		String actualheader=signUp.getsignupheader();
		
		if(actualheader.equals("CREATE AN ACCOUNT")) {
			System.out.println("Header matches  "+actualheader);
		}else {
			System.out.println("Header not matches  "+actualheader);
		}
		
		for(int i=1; i<=Xlutils.getRowCount(xlpath, "Sheet1"); i++) {
			
			XSSFRow row=Xlutils.ws.getRow(i);
			String firstname=row.getCell(0).getStringCellValue();
			String lastname=row.getCell(1).getStringCellValue();
			String phoneNumber=row.getCell(2).getStringCellValue();
			String DOB=row.getCell(3).getStringCellValue();
			String password=row.getCell(4).getStringCellValue();
			
			signUp.getFisrtName(firstname);
			signUp.getLastName(lastname);
			String email=RandomEmail();
			signUp.getEmail(email);
			System.out.println("Random email is : "+email);
			signUp.getPhoneNum(phoneNumber);
			signUp.getDob(DOB);
			signUp.getpassword(password);
			Xlutils.setCellData(xlpath, "Sheet1", i, 5, email);
		
		signUp.SelTermsCond();
		signUp.signupbtn();
		Thread.sleep(5000);
		hp.ClickSignin();
		hp.profileClick();
		
		String pfName=profile.getFisrtName();
		
		
		Assert.assertEquals(pfName, firstname);
			/*
			 * if(pfName.equals(firstname)){
			 * System.out.println("First name matches with profile and signup "); }else {
			 * System.out.println("First name not matches with profile and signup "); }
			 */
		Assert.assertEquals(profile.getLastName(), lastname);
			/*
			 * if(profile.getLastName().equals(lastname)){
			 * System.out.println("last name matches with profile and signup "); }else {
			 * System.out.println("last name not matches with profile and signup "); }
			 */
		
		Assert.assertEquals(profile.getPhoneNum(), phoneNumber);
			/*
			 * if(profile.getPhoneNum().equals(phoneNumber)){
			 * System.out.println("phoneNumber matches with profile and signup "); }else {
			 * System.out.println("phoneNumber not matches with profile and signup "); }
			 */
		Assert.assertEquals(profile.getEmail(), email);
			/*
			 * if(profile.getEmail().equals(email)){
			 * System.out.println("Email matches with profile and signup "); }else {
			 * System.out.println("Email not matches with profile and signup  "); }
			 */
		Assert.assertEquals(profile.getDob(), DOB);
			/*
			 * if(profile.getDob().equals(DOB)){
			 * System.out.println("DOB matches with profile and signup "); }else {
			 * System.out.println("DOB not matches with profile and signup  "); }
			 */
		
		
		Thread.sleep(10000);
		}
		
		
	}
	

	
}
