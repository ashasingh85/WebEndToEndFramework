package com.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	WebDriver driver;
	
	private By loginEmail = By.xpath("//input[@name='email']");
	
	private By loginPassword = By.cssSelector("input[type='password']");
	
	private By loginButton = By.xpath("//button[@type='submit']");
	
	private By forgotPassword = By.cssSelector("[href*='controller=password']");
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement email() {
		return driver.findElement(loginEmail);
	}
	
	public WebElement password() {
		return driver.findElement(loginPassword);
	}
	
	public WebElement buttonLogin() {
		return driver.findElement(loginButton);
		
	}
	
	public ForgotPasswordPage forgotPassword() {
		 driver.findElement(forgotPassword).click();
		 return new ForgotPasswordPage(driver);
	}

}
