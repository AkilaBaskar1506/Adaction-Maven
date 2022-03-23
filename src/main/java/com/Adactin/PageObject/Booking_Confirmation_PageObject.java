package com.Adactin.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Booking_Confirmation_PageObject {
public static WebDriver driver;
@FindBy(id = "search_hotel")
private WebElement search_hotel;
@FindBy(id = "my_itinerary")
private WebElement My_itinerary;
@FindBy(id = "logout")
private WebElement logout_Button;
@FindBy(id = "order_no")
private WebElement order_no;
public Booking_Confirmation_PageObject(WebDriver driver2) {
this.driver=driver2;
PageFactory.initElements(driver, this);
}
public WebDriver getDriver() {
	return driver;
}
public WebElement getSearch_hotel() {
	return search_hotel;
}
public WebElement getMy_itinerary() {
	return My_itinerary;
}
public WebElement getLogout_Button() {
	return logout_Button;
}
public WebElement getOrder_no() {
	return order_no;
}	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
