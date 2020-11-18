package com.gridexchange.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	
	Properties pro;

	public ReadConfig() {
		{
		
		File src = new File("./ConfigurationFiles/config.properties");
		
		try {
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);
			
		}
		catch(Exception e){
			System.out.println(" Exception is " + e.getMessage());
		}

	}

	}
	
	public String getApplicationURL()
	{
		String url = pro.getProperty("baseURL");
		return url;
	}
	
	public String getEmailAddress()
	{
		String email = pro.getProperty("emailAddress");
		return email;
	}
	
	public String getPassword()
	{
		String passw = pro.getProperty("password");
		return passw;
	}
	
	public String getChromePath()
	{
		String chrPath = pro.getProperty("chromepath");
		return chrPath;
	}
	
	public String getFirefoxPath()
	{
		String ffPath = pro.getProperty("firefoxpath");
		return ffPath;
	}
	
	public String getIEPath()
	{
		String iePath = pro.getProperty("iepath");
		return iePath;
	}
	
	public String getCCManEVChName()
	{
		String ccMaEVName = pro.getProperty("ccMgEVCrName");
		return ccMaEVName;
	}
	
}
