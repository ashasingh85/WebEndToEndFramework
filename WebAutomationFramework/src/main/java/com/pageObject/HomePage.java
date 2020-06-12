package com.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
	
	public WebDriver driver;
	
	private By signIn= By.cssSelector("a[href*='my-account']");
	private By logo= By.xpath("//div[@class='shopping_cart']");
	private By items=By.id("block_top_menu");
	
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		
	}

	public LoginPage getLogin() {
		 driver.findElement(signIn).click();
		 LoginPage l = new LoginPage(driver);
		 return l;
	}
	
	public WebElement myLogo() {
		return driver.findElement(logo);
	}
	
	public WebElement itemsShown() {
		return driver.findElement(items);
	}
}
