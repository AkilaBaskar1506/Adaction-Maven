package com.Adactin.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PageObjectManager {
public static WebDriver driver;
private Book_A_Hotel_PageObject BookaHotel;
private HomePageObject homepage;
private Booking_Confirmation_PageObject booking_confirmation;
private SearchHotelPageObject search_Hotel;
private SelectHotelPageObject select_Hotel;

public PageObjectManager(WebDriver driver2) {
	this.driver= driver2;
	PageFactory.initElements(driver, this);
	// TODO Auto-generated constructor stub
}
//public WebDriver getDriver() {
//	
//	return driver;
//}
public Book_A_Hotel_PageObject getBookaHotel() {
	BookaHotel=new Book_A_Hotel_PageObject(driver);
	return BookaHotel;
}
public HomePageObject getHomepage() {
	homepage = new HomePageObject(driver);
	return homepage;
}
public Booking_Confirmation_PageObject getBooking_confirmation() {
	booking_confirmation= new Booking_Confirmation_PageObject(driver);
	return booking_confirmation;
}
public SearchHotelPageObject getSearch_Hotel() {
	search_Hotel = new SearchHotelPageObject(driver);
	return search_Hotel;
}
public SelectHotelPageObject getSelect_Hotel() {
	select_Hotel = new SelectHotelPageObject(driver);
	return select_Hotel;
}

}
