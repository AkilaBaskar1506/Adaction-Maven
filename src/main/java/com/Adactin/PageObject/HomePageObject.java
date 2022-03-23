package com.Adactin.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePageObject {
public static WebDriver driver;
	@FindBy(id = "username")
	private WebElement username;
	@FindBy(id = "password")
	private WebElement password;
	@FindBy(id = "login")
	private WebElement loginButton;
	@FindBy(xpath = "//td[@class='login_register']")
	private WebElement newRegister;
	@FindBy(xpath = "//div[@class='login_forgot']")
	private WebElement forgotPassword;
	
	public HomePageObject(WebDriver driver2) {
    this.driver= driver2;
PageFactory.initElements(driver, this);
	
	}
	public WebDriver getDriver() {
		return driver;
	}
	public WebElement getUsername() {
		return username;
	}
	public WebElement getPassword() {
		return password;
	}
	public WebElement getLoginButton() {
		return loginButton;
	}
	public WebElement getNewRegister() {
		return newRegister;
	}
	public WebElement getForgotPassword() {
		return forgotPassword;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
