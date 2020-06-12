package com.configuration;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Browser {
	public WebDriver driver;

	
	public WebDriver browserInformation() {
		// Control the test from properties file 
		String browserName = Config.getStringValue("browser");
		// Control the test from the jenkins pipeline
		//String browserName = System.getProperty("browser");
	if(browserName.contains("chrome")) {
		
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\main\\java\\com\\driver\\executables\\chromedriver.exe");
		System.setProperty("webdriver.chrome.silentOutput", "true");
		ChromeOptions options = new ChromeOptions();
		if (browserName.contains("headless"))
			options.addArguments("--headless");
		
		driver = new ChromeDriver(options);
	}
	
	else if(browserName.equalsIgnoreCase("Firefox")) {
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\src\\main\\java\\com\\driver\\executables\\geckodriver.exe");
		System.setProperty("webdriver.chrome.silentOutput", "true");
		driver = new FirefoxDriver();
		
	}
	
	driver.manage().timeouts().implicitlyWait(Config.getIntValue("time"), TimeUnit.SECONDS);
	driver.manage().window().maximize();
	return driver;
	
}
	
}