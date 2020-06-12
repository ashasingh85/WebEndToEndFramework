package com.testcases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.configuration.Browser;
import com.configuration.Config;
import com.pageObject.HomePage;



public class validateTitle extends Browser{
	public WebDriver driver;
	public static Logger log= LogManager.getLogger(validateTitle.class.getName());
	
	@BeforeMethod
	public void setUp() {
		driver = browserInformation();
		driver.get(Config.getStringValue("url"));	
	}
	
	@Test
	public void assertTitle() {		
		HomePage h= new HomePage(driver);
		Assert.assertEquals(h.myLogo().getText(),"Cart (empty)");
		log.error("Assertion failed for text validation");
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.close();
	}

}
