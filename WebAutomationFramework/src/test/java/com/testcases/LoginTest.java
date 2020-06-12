package com.testcases;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.configuration.Browser;
import com.configuration.Config;
import com.pageObject.HomePage;
import com.pageObject.LoginPage;
import com.resources.TestData;

public class LoginTest extends Browser {
	public WebDriver driver;
	public static Logger log= LogManager.getLogger(LoginTest.class.getName());
	@BeforeMethod
	public void setUp() {
		driver = browserInformation();
		log.info("Driver is initialized");
		driver.get(Config.getStringValue("url"));
				
	}
	
	@Test(dataProvider="multipleUsers",dataProviderClass=TestData.class)
	public void loginDetails(String userName,String password) {
				
		HomePage h= new HomePage(driver);
		LoginPage l=h.getLogin();
		
		l.email().sendKeys(userName);
		l.password().sendKeys(password);
		l.buttonLogin().click();
		log.info("Test run with multiple sets of data");
		
		
	}

	@AfterMethod
	public void tearDown() {
		driver.close();
	}

}
