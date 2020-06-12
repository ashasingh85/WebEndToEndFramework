package com.testcases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.configuration.Browser;
import com.configuration.Config;
import com.pageObject.ForgotPasswordPage;
import com.pageObject.HomePage;
import com.pageObject.LoginPage;

public class HomePageTest extends Browser{
	public WebDriver driver;
	public static Logger log= LogManager.getLogger(HomePageTest.class.getName());
	HomePage hp;
	
	@BeforeMethod
	public void launchURL() {
		driver = browserInformation();
		log.info("Driver is initialized");
		driver.get(Config.getStringValue("url"));
		}
		
	@Test(priority=1)
	public void correctPasswordTest() {
		hp= new HomePage(driver);
		LoginPage lp=hp.getLogin();
		lp.email().sendKeys(Config.getStringValue("email"));
		lp.password().sendKeys(Config.getStringValue("password"));
		lp.buttonLogin().click();
		log.info("User credentails have been verified");

	}
	
	@Test(priority=2)
	public void forgotPasswordTest() {
	hp= new HomePage(driver);
	LoginPage lp=hp.getLogin();
	ForgotPasswordPage fp = lp.forgotPassword();
	fp.forgotEmail().sendKeys(Config.getStringValue("email"));
	fp.retrieveButton().click();
	log.info("Forgot password features have been verified");
	
	}
	
	@AfterMethod
	public void closeBrowser() {
		driver.close();
	}

}
