package com.SignUpPage;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Reporter;

import junit.framework.Assert;

public class SignupPage {
	WebDriver driver;
	String signupTextboxPath;
	public SignupPage(WebDriver driver){
		this.driver=driver;
		Properties prop = new Properties();
		try
		{
		InputStream input = new FileInputStream(new File("Pages/com/SignUpPage/SignUp.properties"));
		prop.load(input);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		signupTextboxPath=prop.getProperty("signupTextboxPath");
		
	}
	@FindBy(how=How.CSS,using="#ida > fieldset > div.adb-container_content > div > input") 
	WebElement signupTextbox;//should be signupPath 
	@FindBy(how=How.CSS,using="#id13")
	WebElement submitId;
	
	public SignupPage signupID(WebDriver driver){
		String signupId = (RandomStringUtils.randomAlphabetic(5, 10)+"."+RandomStringUtils.randomAlphabetic(5,10)+"@yopmail.com").toLowerCase();
		System.out.println(signupId);
		signupTextbox.sendKeys(signupId);
		return new SignupPage(driver);
	}
//	public void submitSignupId(WebDriver driver){
//		 WebElement element4=obj.cssFinder(signupButton);
//		 element4.click();	
//	}
   public SignupPage signupPageStatus(WebDriver driver){
		
		Reporter.log("Verified the signup page",true);
	    Assert.assertTrue(driver.getTitle().contains("Sign Up for AppDirect"));
	    return new SignupPage(driver);
	}
	
   public Message submitSignupId(WebDriver driver){
	   
	   Reporter.log("Clicked on Signup",true);
	   submitId.click(); 
	   return new Message(driver);
   }
   
   
}
