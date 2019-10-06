package com.visiomit.freecrm2.Testdata;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.visiomit.freecrm2.utility.Configdataprovider;
import com.visiomit.freecrm2.utility.Exceldataprovider1;

public class Baseclass1 
{
public static XSSFWorkbook wb;
public static XSSFSheet sheet;
public static Properties prop;
public static WebDriver driver;

public static Exceldataprovider1 excelDataProvider1;
public static Configdataprovider configDataProvider;

public void intitialize() 
{
	configDataProvider = new Configdataprovider();
	excelDataProvider1 = new Exceldataprovider1();
}
	
public static void browserstartup(String brName,String url)
{
	if(brName.equalsIgnoreCase("Firefox"))
	{
		System.setProperty("webdriver.gecko.driver",
				"D:\\eclipse\\geckodriver.exe");
		driver=new FirefoxDriver();
	}
	else if(brName.equalsIgnoreCase("Chrome"))
	{
		System.setProperty("webdriver.chrome.driver",
				"D:\\eclipse\\jayu selenium\\chromedriver.exe");
		driver=new ChromeDriver();
	}
	else
	{
		System.out.println("Driver exe not able to found and hence illegal state exception");
	}
	driver.manage().window().maximize();
	
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	driver.get(url);

}


/*@AfterMethod
public void tearDown()
{
	//driver.quit();
}*/
}

