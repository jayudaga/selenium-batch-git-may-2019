package com.visiomit.freecrm2.Testcase;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.visiomit.freecrm2.PageObject.loginExcel;
import com.visiomit.freecrm2.Testdata.Baseclass1;


public class LoginExcelTC extends Baseclass1
{
	public loginExcel login ;
	@BeforeMethod
	
	public void SetUp()
	{
	
		String brName=configDataProvider.getconfigproperties("browser");
		
		String url=configDataProvider.getconfigproperties("url");
		browserstartup(brName, url);
		
		login = new loginExcel(driver);
	}
	
	/*@Test(priority=1)
	public void verifyFreeCrmProLoginPageTitleTest()
	{
		String expectedTitle="CRMPRO - CRM software for customer relationship management, sales, and support.";
		String actualTitle=login.verifyFreeCrmProLoginPageTitle();
		Assert.assertEquals(actualTitle, expectedTitle);
		System.out.println("Title Matched");
	}
	@Test(priority=2)

	public void verifyCRMPROLogoTest()
	{

		Assert.assertTrue(login.verifyCRMPROLogo(), "CRMPRO logo on login page not displayed");
		System.out.println("Logo tested");
	}*/
	/*@Test(priority=3)

	public void verifyLoginToFreeCrmProTest() throws Exception
	{

		login.verifyloginToFreeCrmPro(prop.getProperty("userName"), prop.getProperty("userPass"));
	}*/
 
	@Test(priority = 4, dataProvider = "getExcelData")
	public void verifyloginToCrmProTest(String uname, String upass) throws Exception  {
		
		login.verifyloginToFreeCrmPro(uname, upass);

		if (driver.getTitle().contains("CRMPRO")) {

			Assert.assertTrue(true);

			login.verifyLogoutCrmPro();
		} else {

			System.out.println("Not able to login into an application");
		
			Assert.assertTrue(false);
		}

	}

	@DataProvider
	public Object[][] getExcelData() {
   
		Object [][] data=excelDataProvider1.getExcelData("Sheet1");

		return data;
	}

}
