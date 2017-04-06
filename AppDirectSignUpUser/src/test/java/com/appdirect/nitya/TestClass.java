package com.appdirect.nitya;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.appdirect.nitya.utils.WaitClass;
import com.HomePage.HomePage;
import com.LoginPage.LoginPage;
import com.SignUpPage.SignupPage;
import com.appdirect.nitya.utils.BrowserFactory;


public class TestClass {
WaitClass wc;
WebDriver driver;


     //@BeforeClass(alwaysRun = true)
        @Test
		public void openBrowser() throws Exception{
			driver=BrowserFactory.startBrowser();
			wc = new WaitClass(driver);
		    wc.implicitWait(driver);
		    BrowserFactory.browserStatus();
		}
		
		 @Test(dependsOnMethods = { "openBrowser" })
		public void openHomePage(){
            //home_page.loginButtonStatus(driver);
			HomePage home_page=PageFactory.initElements(driver, HomePage.class);
			home_page
		   .clickLogin(driver)
		   .loginPageStatus(driver);	    
		}

		@Test(dependsOnMethods = { "openHomePage" })
		public void openLoginPage(){
		    LoginPage login_page=PageFactory.initElements(driver, LoginPage.class);
		    login_page
		   .clicksignup(driver)
		   .signupPageStatus(driver);
		}
		
		 @Test(dependsOnMethods = { "openLoginPage" })
		public void openSignUpPage(){
			wc.implicitWait(driver);
		    SignupPage signup_Page=PageFactory.initElements(driver, SignupPage.class);
		    signup_Page
		   .signupID(driver)
		   .submitSignupId(driver)
		   .WarningMessage(driver);
		    
		   
		}
		 


}
