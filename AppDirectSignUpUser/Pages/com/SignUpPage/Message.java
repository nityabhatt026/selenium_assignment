package com.SignUpPage;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Reporter;

import junit.framework.Assert;

public class Message {

	WebDriver driver;
	Properties prop = new Properties();
	String errorMessage;
	String successMessage;
	public Message(WebDriver driver){
		this.driver=driver;
		
		try
		{
		InputStream input = new FileInputStream(new File("Pages/com/SignUpPage/SignUp.properties"));
		prop.load(input);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		errorMessage=prop.getProperty("errorMessage");
		successMessage=prop.getProperty("successMessage");
		
	}
	
	public void WarningMessage(WebDriver driver){
		
		
		if(driver.findElement(By.cssSelector(errorMessage)).isDisplayed()){
         Reporter.log("Error Message Displayed",false);
         Assert.assertFalse(false);
		}
   
		
		else{
			 Reporter.log("Success Message Displayed.... Thanks for registering.We have sent a verification email to abc.xyz@yopmail.com.Please check your inbox and click the link to activate your account.",true);
	         Assert.assertFalse(true);
		}
   }
  	
}
