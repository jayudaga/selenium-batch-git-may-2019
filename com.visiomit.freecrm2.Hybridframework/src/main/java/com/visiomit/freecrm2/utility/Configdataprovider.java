package com.visiomit.freecrm2.utility;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class Configdataprovider 
{

	public static Properties prop;
	
	public Configdataprovider() {
		
		try {

			File fs = new File(".//Config//prop.properties1");
			FileInputStream fis = new FileInputStream(fs);
			prop = new Properties();
			prop.load(fis);

		} catch (Exception e) {

			System.out.println("File not found :" + e.getMessage());
		}
	}

	public String getconfigproperties(String keyvalue) 
	{
		
		return prop.getProperty(keyvalue);
	}
	public String username()
	{
		return prop.getProperty("uname");
	}
	
	public String userpass()
	{
		return prop.getProperty("upwd");
	}
	
	public String getuserBrowserName()
	{
		return prop.getProperty("browser");
	}

	


	
}
