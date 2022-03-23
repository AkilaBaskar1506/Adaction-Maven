package com.Adactin.Testcase;

import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.Adactin.PageObject.PageObjectManager;
import com.Adactin.Utitlites.BaseClass;
import com.Helper_File.FileReadManager;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class adactinmodelTest extends BaseClass {
	public static WebDriver driver;
	public static PageObjectManager pom;
	public static Logger log = LogManager.getLogger(BaseClass.class.getName());
	public static ExtentReports extent= getExtendReport();
	public static ExtentTest test;

	@BeforeTest
	public void url_launch() throws IOException {
		try {
			loadConfig();
//			test = extent.createTest("url_launch");
			log.debug("launching browser");
			driver = browserLaunch(prop.getProperty("browsername"));
			pom = new PageObjectManager(driver);
			getUrl(FileReadManager.manager().getReader().geturl());
			log.info("adactin url launched");
			test.pass("url_launch passed");
		} catch (Exception e) {
//			test.fail("url_launch failed");
		}
	}

	@Test
	public void login() throws IOException {
		try {
			test = extent.createTest("login");
			log.debug("logging into adactin using credentials");
			toSendKeys(pom.getHomepage().getUsername(), FileReadManager.manager().getReader().getusername());
			toSendKeys(pom.getHomepage().getPassword(), FileReadManager.manager().getReader().getpassword());
			toclick(pom.getHomepage().getLoginButton());
			log.info("logged into adactin");
			test.pass("login passed");
		} catch (Exception e) {
			test.fail("login failed");
		}

	}

	@Test(dependsOnMethods = { "login" })
	public void searchHotel() throws IOException {
		try {
			test = extent.createTest("searchHotel");
			log.debug("searching for Hotels");
			dropDown(pom.getSearch_Hotel().getLocation(), "text", FileReadManager.manager().getReader().getlocation());
			dropDown(pom.getSearch_Hotel().getHotels(), "text", FileReadManager.manager().getReader().gethotel());
			dropDown(pom.getSearch_Hotel().getRoom_type(), "text", FileReadManager.manager().getReader().getroomtype());
			dropDown(pom.getSearch_Hotel().getRoom_no(), "value",
					FileReadManager.manager().getReader().getroomnumber());
			toSendKeys(pom.getSearch_Hotel().getPickIn_date(), FileReadManager.manager().getReader().getcheckin());
			toSendKeys(pom.getSearch_Hotel().getPickOut_date(), FileReadManager.manager().getReader().getcheckout());
			dropDown(pom.getSearch_Hotel().getAdult_room(), "value",
					FileReadManager.manager().getReader().getadultroom());
			dropDown(pom.getSearch_Hotel().getChild_room(), "value",
					FileReadManager.manager().getReader().getchildrenroom());
			log.info("specifications for booking has been entered");
			toclick(pom.getSearch_Hotel().getSearch_Button());
			log.debug("searching for hotels");
			test.pass("searchHotel passed");
		} catch (Exception e) {
			test.fail("searchHotel failed");
		}

//		
//		
	}

	@Test(dependsOnMethods = { "searchHotel" })
	public static void Select_Hotel() {
		try {
			test = extent.createTest("Select_Hotel");
			log.debug("Selecting the desired Hotel");
			toclick(pom.getSelect_Hotel().getRadio_Button());
			toclick(pom.getSelect_Hotel().getContinue_Button());
			log.info("Selected Hotel");
			test.pass("Select_Hotel passed");
		} catch (Exception e) {
			test.fail("Select_Hotel failed");
		}
	}

	@Test(dependsOnMethods = { "Select_Hotel" })
	public static void Booking_Hotel() throws IOException {
		try {
			test = extent.createTest("Booking_Hotel");
			log.debug("booking the Hotel");
			log.debug("Adding Payment Details");
			toSendKeys(pom.getBookaHotel().getFirstname(), FileReadManager.manager().getReader().getfirstname());
			toSendKeys(pom.getBookaHotel().getLastname(), FileReadManager.manager().getReader().getlastname());
			toSendKeys(pom.getBookaHotel().getAddress(), FileReadManager.manager().getReader().getbillingaddress());
			toSendKeys(pom.getBookaHotel().getCreditCard_number(),
					FileReadManager.manager().getReader().getcreditcardnumber());
			dropDown(pom.getBookaHotel().getCreditCard_type(), "text",
					FileReadManager.manager().getReader().getcreditcardtype());
			dropDown(pom.getBookaHotel().getCc_expireDate(), "text",
					FileReadManager.manager().getReader().getexpirymonth());
			dropDown(pom.getBookaHotel().getCc_expireYear(), "text",
					FileReadManager.manager().getReader().getexpiryyear());
			toSendKeys(pom.getBookaHotel().getCcv_number(), FileReadManager.manager().getReader().getccvnumber());
			toclick(pom.getBookaHotel().getBook_now_Button());
			log.info("Booked Hotel");
//			test.pass(toGetAttribute(null));

		} catch (Exception e) {
			test.fail("Booking_Hotel failed");
		}
	}

	@Test(dependsOnMethods = { "Booking_Hotel" })
	public void Booking_Confirmation() {
		try {
			test = extent.createTest("Booking_Confirmation");
			log.debug("confirming Hotel Booking");
			toGetAttribute(pom.getBooking_confirmation().getOrder_no());
			log.info("Booking Confirmed");
			test.pass("Booking_Confirmation passed");
		} catch (Exception e) {
			test.fail("Booking_Confirmation failed");
		}
	}

	@AfterTest
	public void tearDown() {
		extent.flush();
		driver.close();
	}

}
