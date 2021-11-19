package com.arbysstg.Testcases;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.CopyUtils;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.arbysstg.utilities.Readconfig;


public class BaseClass {
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
		
		
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		
		 driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		
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
	
	
}
