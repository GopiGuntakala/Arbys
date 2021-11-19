package com.arbysstg.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;


public class Readconfig {


Properties pro;

	public Readconfig() {
		File src=new File("./Configurations/config.properties");
		try {
		
		FileInputStream file = new FileInputStream(src);
			pro=new Properties();
			 pro.load(file);
		}catch (Exception e) {
			System.out.println("Exception is "+e.getMessage());
			
		}
		 
		 
	}
	
	
	public String getURL() {
		String url=pro.getProperty("ApplicationURL");
		return url;
	}
	
	public String getMainpassword() {
		String password=pro.getProperty("password");
		return password;
	}
	
	public String getchromepath() {
		String chrome=pro.getProperty("chromepath");
		return chrome;
	}
	
	public String getfirefoxpath() {
		String firefoxpath=pro.getProperty("firefoxpath");
		return firefoxpath;
	}
	
	public String getxlpath() {
		String xlpath=pro.getProperty("xlpath");
		return xlpath;
	}
	
	public String getemail() {
		String email=pro.getProperty("email");
		return email;
	}
	
	public String getpassword() {
		String password=pro.getProperty("password");
		return password;
	}
	
	
}
