package com.appdirect.nitya.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Reporter;

import com.HomePage.HomePage;

import junit.framework.Assert;

public class BrowserFactory {
	static WebDriver driver;
	public BrowserFactory(WebDriver driver){
		this.driver=driver;
	}
	public static WebDriver startBrowser(){
		Properties prop = new Properties();
		try
		{
		InputStream input = new FileInputStream(new File("utilities/resources/value.properties"));
		prop.load(input);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
//		try
//		{
//		InputStream input = new FileInputStream(new File("home.properties"));
//		prop.load(input);
//		}
//		catch(Exception e)
//		{
//			e.printStackTrace();
//		}String loginPath=prop.getProperty("loginPath");
		
		
		String browserName=prop.getProperty("browser");
		String webSiteUrl=prop.getProperty("webSiteUrl");
		
		if(browserName.equalsIgnoreCase("firefox"))
		{   
			System.setProperty(prop.getProperty("browserPath"),prop.getProperty("browserDriver"));
			driver = new FirefoxDriver();
		}
		else if(browserName.equalsIgnoreCase("chrome"))
		{   System.setProperty(prop.getProperty("browserPath"),prop.getProperty("browserDriver"));
			driver=new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("IE"))
		{   System.setProperty(prop.getProperty("browserPath"),prop.getProperty("browserDriver"));
			driver=new InternetExplorerDriver();
		}
	
        driver.get(webSiteUrl);
		return driver;
	}
	public static void browserStatus(){
		
		Reporter.log("Verify the appdirect home page",true);
        Assert.assertTrue(driver.getTitle().contains("AppDirect"));
    }
//	public HomePage loginButtonStatus(WebDriver driver) {
//		 Reporter.log("Verified the login button",true);
//		 Assert.assertTrue(driver.findElement(By.xpath(loginPath)).isDisplayed());
//		return new HomePage(driver);
//	}
 
	
}
