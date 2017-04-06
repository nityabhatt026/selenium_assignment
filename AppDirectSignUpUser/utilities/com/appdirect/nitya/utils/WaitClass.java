package com.appdirect.nitya.utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitClass{
	
	WebDriver driver;
	
	public WaitClass(WebDriver driver){
		this.driver = driver;
	}
public void explicitWit(String path,WebDriver driver){

	 WebDriverWait wait = new WebDriverWait(driver, 20);
	 WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(path)));
	
}
public WebDriver implicitWait(WebDriver driver){
	 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	 return driver;
}
}