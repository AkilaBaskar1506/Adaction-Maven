package com.Adactin.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SelectHotelPageObject {
public static WebDriver driver;
@FindBy(id = "radiobutton_0")
private WebElement radio_Button;
public SelectHotelPageObject(WebDriver driver2) {
	this.driver= driver2;
	PageFactory.initElements(driver, this);
}
public WebDriver getDriver() {
	return driver;
}
public WebElement getRadio_Button() {
	return radio_Button;
}
public WebElement getContinue_Button() {
	return continue_Button;
}
public WebElement getCancel_Button() {
	return cancel_Button;
}
@FindBy(id = "continue")
private WebElement continue_Button;
@FindBy(id = "cancel")
private WebElement cancel_Button;






}
