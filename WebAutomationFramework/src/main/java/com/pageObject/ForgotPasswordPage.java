package com.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ForgotPasswordPage {
	public WebDriver driver;
	
	private By forgotEmail =  By.id("email");
	private By retrieveButton = By.cssSelector("button[type='submit']");
	
	public  ForgotPasswordPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement forgotEmail() {
		return driver.findElement(forgotEmail);
	}
	
	public WebElement retrieveButton() {
		return driver.findElement(retrieveButton);
	}

}
