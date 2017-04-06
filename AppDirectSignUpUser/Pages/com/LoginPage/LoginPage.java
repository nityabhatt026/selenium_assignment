package com.LoginPage;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Reporter;

import com.SignUpPage.SignupPage;

import junit.framework.Assert;

public class LoginPage {
	WebDriver driver;
	String signupPath;
	public LoginPage(WebDriver driver){
		this.driver=driver;
		Properties prop = new Properties();
		try
		{
		InputStream input = new FileInputStream(new File("Pages/com/LoginPage/Login.properties"));
		prop.load(input);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	signupPath=prop.getProperty("signupPath");
	}
	@FindBy(how=How.XPATH,using="//*[@id='id5']/div[3]/p/a") 
	WebElement signup;//should be signupPath 
	 
	public SignupPage clicksignup(WebDriver driver){
		signup.click();
		return new SignupPage(driver);
	}

	public LoginPage loginPageStatus(WebDriver driver){
		
		Reporter.log("Verified the login page",true);
	    Assert.assertTrue(driver.getTitle().contains("Log In | AppDirect"));
	    return new LoginPage(driver);
	    
	}

}
