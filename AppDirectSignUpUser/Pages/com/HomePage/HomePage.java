package com.HomePage;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

import javax.xml.xpath.XPath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Reporter;

import com.LoginPage.LoginPage;

import junit.framework.Assert;

public class HomePage {
	WebDriver driver;
	String loginPath;
	Properties prop= new Properties();
	
	public HomePage(WebDriver driver){
		this.driver=driver;
		try
		{
		InputStream input = new FileInputStream(new File("home.properties"));
		prop.load(input);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	loginPath=prop.getProperty("loginPath");
	}
	@FindBy(how=How.XPATH,using="//*[@id='newnav']/header/div/menu/ul/li[3]/a") 
	WebElement login;//should be loginPath 
	 
	public LoginPage clickLogin(WebDriver driver){
		
		login.click();
		
		return new LoginPage(driver);
	}

//public HomePage loginButtonStatus(WebDriver driver) {
//	 Reporter.log("Verified the login button",true);
//	 Assert.assertTrue(driver.findElement(By.xpath(loginPath)).isDisplayed());
//	return new HomePage(driver);
//}



public LoginPage loginPageStatus(WebDriver driver){
	
	Reporter.log("Verified the login page",true);
    Assert.assertTrue(driver.getTitle().contains("Log In | AppDirect"));
    return new LoginPage(driver);
    
}
	
}
