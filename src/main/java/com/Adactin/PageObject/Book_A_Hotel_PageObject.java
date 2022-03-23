package com.Adactin.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Book_A_Hotel_PageObject {
public static WebDriver driver;
@FindBy(id = "first_name")
private WebElement firstname;
@FindBy(id = "last_name")
private WebElement lastname;
@FindBy(id = "address")
private WebElement address;
@FindBy(id = "cc_num")
private WebElement creditCard_number;
@FindBy(id = "cc_type")
private WebElement creditCard_type;
@FindBy(id = "cc_exp_month")
private WebElement cc_expireDate;
@FindBy(id = "cc_exp_year")
private WebElement cc_expireYear;
@FindBy(id = "cc_cvv")
private WebElement ccv_number;
@FindBy(id = "book_now")
private WebElement book_now_Button;	
@FindBy(id = "cancel")
private WebElement cancel_Button;
public Book_A_Hotel_PageObject(WebDriver driver2) {
this.driver=driver2;
PageFactory.initElements(driver, this);
	
}
public WebDriver getDriver() {
	return driver;
}
public WebElement getFirstname() {
	return firstname;
}
public WebElement getLastname() {
	return lastname;
}
public WebElement getAddress() {
	return address;
}
public WebElement getCreditCard_number() {
	return creditCard_number;
}
public WebElement getCreditCard_type() {
	return creditCard_type;
}
public WebElement getCc_expireDate() {
	return cc_expireDate;
}
public WebElement getCc_expireYear() {
	return cc_expireYear;
}
public WebElement getCcv_number() {
	return ccv_number;
}
public WebElement getBook_now_Button() {
	return book_now_Button;
}
public WebElement getCancel_Button() {
	return cancel_Button;
}
		
	
	
	
	
	
	
	
	
	
	
	
	
	
}
