package com.Helper_File;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Configuration_Reader {

	public static Properties prop;

	public Configuration_Reader() throws IOException {
		// G:\Automation
		File file = new File(System.getProperty("user.dir") + "\\Configuration\\data.properties");
		FileInputStream fis = new FileInputStream(file);
		prop = new Properties();
		prop.load(fis);
	}
//	url=https://adactinhotelapp.com/
//		username=adactinakila
//		password=adactinakila
//		location=london
//		hotel=hotel sunshine
//		roomtype = deluxe
//		roomnumber=2
//		checkin = 20/3/2022
//		checkout= 22/3/2022
//		adult=1
//		childrenroom=1
//	
	public String getBrowsername() {
		String browser = prop.getProperty("browsername");
		return browser;
	}

	public String geturl() {
		String browser = prop.getProperty("url");
		return browser;
	}

	public String getusername() {
		String username = prop.getProperty("username");
		return username;
	}

	public String getpassword() {
		String password = prop.getProperty("password");
		return password;
	}

	public String getlocation() {
		String location = prop.getProperty("location");
		return location;
	}

	public String gethotel() {
		String hotel = prop.getProperty("hotel");
		return hotel;
	}

	public String getroomtype() {
		String roomtype = prop.getProperty("roomtype");
		return roomtype;
	}

	public String getroomnumber() {
		String roomnumber = prop.getProperty("roomnumber");
		return roomnumber;
	}

	public String getcheckin() {
		String checkin = prop.getProperty("checkin");
		return checkin;
	}

	public String getcheckout() {
		String checkout = prop.getProperty("checkout");
		return checkout;
	}
	public String getadultroom() {
		String adultroom = prop.getProperty("adultroom");
		return adultroom;
	}
	public String getchildrenroom() {
		String childroom = prop.getProperty("childrenroom");
		return childroom;
	}
//	firstname=akila
//			lastname=anandh
//			billingaddress=porur chennai
//			creditcardnumber=1234567894561234
//			creditcardtype=Master Card
//			expirymonth=June
//			expiryyear=2022
//			ccvnumber=123
	public String getfirstname() {
		String firstname = prop.getProperty("firstname");
		return firstname;
	}
	public String getdesignation() {
		String designation = prop.getProperty("designation");
		return designation;
	}
	public String getdesignationName() {
		String designationName = prop.getProperty("designationName");
		return designationName;
	}
	public String getlastname() {
		String lastname = prop.getProperty("lastname");
		return lastname;
	}
	public String getbillingaddress() {
		String billingaddress = prop.getProperty("billingaddress");
		return billingaddress;
	}
	public String getcreditcardnumber() {
		String creditcardnumber = prop.getProperty("creditcardnumber");
		return creditcardnumber;
	}
	public String getcreditcardtype() {
		String creditcardtype = prop.getProperty("creditcardtype");
		return creditcardtype;
	}
	public String getexpirymonth() {
		String expirymonth = prop.getProperty("expirymonth");
		return expirymonth;
	}
	public String getexpiryyear() {
		String expiryyear = prop.getProperty("expiryyear");
		return expiryyear;
	}
	public String getccvnumber() {
		String ccvnumber = prop.getProperty("ccvnumber");
		return ccvnumber;
	}
}
