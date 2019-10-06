package com.visiomit.freecrm2.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginExcel
{
@FindBy(name="username")
WebElement uname;

@FindBy(name="password")
WebElement upass;

@FindBy(xpath="//input[@type='submit' or @value='Login']")
WebElement loginBtn;

/*@FindBy(xpath="//a[text()='Sign Up']")
WebElement signUpLink;*/


WebDriver driver;

public loginExcel(WebDriver driver)
{
	this.driver=driver;
	PageFactory.initElements(driver, this);
}
public String verifyFreeCrmProLoginPageTitle() 
{
	return driver.getTitle();
}


public boolean verifyCRMPROLogo()
{
	return driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/a/img")).isDisplayed();
}




public void verifyloginToFreeCrmPro(String userName,String userPass) throws Exception
{
	Thread.sleep(5000);
	uname.sendKeys(userName);
	upass.sendKeys(userPass);
	loginBtn.click();
	
}
public void verifyLogoutCrmPro()
{
	driver.switchTo().frame("mainpanel");

	driver.findElement(By.xpath("/html/body/table[1]/tbody/tr[2]/td[1]/div/table/tbody/tr/td[4]/a")).click();

	driver.switchTo().defaultContent();
}
}


