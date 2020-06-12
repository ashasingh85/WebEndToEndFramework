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

public class SelectByItems extends Browser {
	public WebDriver driver;
	public static Logger log= LogManager.getLogger(SelectByItems.class.getName());
	@BeforeMethod
	public void setUp() {
		driver = browserInformation();
		log.info("Driver is initialized");
		driver.get(Config.getStringValue("url"));
	}
	
	@Test
	public void getItemNavigation() {
		
	HomePage h = new HomePage(driver);
	Assert.assertTrue(h.itemsShown().isDisplayed());
	log.error("Items shown is not displayed");
		}
	
	@AfterMethod
	public void tearDown() {
		driver.close();
	}
}
