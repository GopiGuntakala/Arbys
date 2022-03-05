package com.arbysstg.Testcases;

import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.CopyUtils;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.arbysstg.pageobjects.CheckoutPageObjects;
import com.arbysstg.utilities.Readconfig;
import com.arbysstg.utilities.excelutilities;

import io.github.bonigarcia.wdm.WebDriverManager;


public class BaseClass {
	
	excelutilities Xlutilss;
	CheckoutPageObjects checkp;
	
	Readconfig config=new Readconfig();

	String url=config.getURL();
	String password=config.getMainpassword();
	String chromepath=config.getchromepath();
	String firefoxpath=config.getfirefoxpath();
	String xlpath=config.getxlpath();
	String emailid=config.getemail();
	String signinpwd=config.getpassword();
	
	WebDriver driver;
	
	Logger log;
	
	@BeforeClass
	public void setup() {
		
		log=Logger.getLogger("Arbys");
		PropertyConfigurator.configure("log4j.properties");
		
		
		//System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		
		WebDriverManager.chromedriver().setup();
		
		 driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);
		
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
		
		
	}
	
	
	
	
	@AfterClass
public void teardown() {
	driver.quit();
}
	
	
	public void CaptureScreenshot(WebDriver driver, String name) throws IOException {
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		
		File dest=new File("./Screenshots/"+name+".png");
		FileUtils.copyFile(src, dest);
	}
	
	
	public void CustomerInfoFill() throws IOException {
		Xlutilss=new excelutilities();
		checkp=new CheckoutPageObjects(driver);
		
		
		for(int i=1; i<=Xlutilss.getRowCount(xlpath, "Sheet2"); i++) {
			
			XSSFRow row=Xlutilss.ws.getRow(i);
			
			String firstname=row.getCell(0).getStringCellValue();
			String lastname=row.getCell(1).getStringCellValue();
			String phoneNumber=row.getCell(2).getStringCellValue();
			
			log.info("Entering customer first name");
			checkp.firstname(firstname);
			log.info("Entering customer last name");
			checkp.LastName(lastname);
			log.info("Entering customer phone number");
			checkp.phonenum(phoneNumber);
			log.info("Entering customer email id");
			checkp.email(RandomEmail());
			
		}
		
	}
	
	public void CardHolderDetails() throws IOException, InterruptedException {
		
		Xlutilss=new excelutilities();
		checkp=new CheckoutPageObjects(driver);
		
		
		for(int i=1; i<=Xlutilss.getRowCount(xlpath, "Sheet3"); i++) {
			
			XSSFRow row=Xlutilss.ws.getRow(i);
			
			String firstname=row.getCell(0).getStringCellValue();
			String lastname=row.getCell(1).getStringCellValue();
			String cardnumber=row.getCell(2).getStringCellValue();
			String Expirydate=row.getCell(3).getStringCellValue();
			String Securitycode=row.getCell(4).getStringCellValue();
			String postalcode=row.getCell(5).getStringCellValue();
			
			log.info("entering card holders first name");
			checkp.CardHFName(firstname);
			log.info("Entering card holders last name");
			checkp.CardHLName(lastname);
			
			Thread.sleep(3000);
			log.info("Switching to iframe");
			driver.switchTo().frame(0);
			log.info("Entering card holders card number");
			checkp.cardNumber(cardnumber);
			log.info("Entering expiry date");
			checkp.CExpirydate(Expirydate);
			log.info("Entering security code");
			checkp.CsecurityCode(Securitycode);
			log.info("Entering postal code");
			checkp.PostalCode(postalcode);
			log.info("Coming out of iframe");
			driver.switchTo().defaultContent();
			log.info("check the Terms&Conditions check box");
			checkp.TermsConditions();
			
		
		}
		
	}
	
	
	
	
	public String  RandomEmail() {
		Random random=new Random();
		int num=random.nextInt(10);
		String email="prod"+num+"@gmail.com";
		return email;
	}
	
	
}
