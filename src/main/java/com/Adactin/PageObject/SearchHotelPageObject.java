package com.Adactin.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchHotelPageObject {
	public static WebDriver driver;
@FindBy(id = "location")
private WebElement location;
@FindBy(id = "hotels")
private WebElement hotels;
@FindBy(id = "room_type")
private WebElement room_type;
@FindBy(id = "room_nos")
private WebElement room_no;
@FindBy(id = "datepick_in")
private WebElement pickIn_date;
@FindBy(id = "datepick_out")
private WebElement pickOut_date;
@FindBy(id = "adult_room")
private WebElement adult_room;
@FindBy(id = "child_room")
private WebElement child_room;
public SearchHotelPageObject(WebDriver driver2) {
	this.driver= driver2;
	PageFactory.initElements(driver, this);
	// TODO Auto-generated constructor stub
}
public WebDriver getDriver() {
	return driver;
}
public WebElement getLocation() {
	return location;
}
public WebElement getHotels() {
	return hotels;
}
public WebElement getRoom_type() {
	return room_type;
}
public WebElement getRoom_no() {
	return room_no;
}
public WebElement getPickIn_date() {
	return pickIn_date;
}
public WebElement getPickOut_date() {
	return pickOut_date;
}
public WebElement getAdult_room() {
	return adult_room;
}
public WebElement getChild_room() {
	return child_room;
}
public WebElement getSearch_Button() {
	return search_Button;
}
public WebElement getReset_Button() {
	return reset_Button;
}
@FindBy(id = "Submit")
private WebElement search_Button;
@FindBy(id = "Reset")
private WebElement reset_Button;














}
