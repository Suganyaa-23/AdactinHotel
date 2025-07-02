package com.testcase;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.base.ProjectHooks;
import com.pages.LoginPage;
import com.utility.FakerDataFactory;

public class LoginTest extends ProjectHooks {

	String checkIn = FakerDataFactory.getCheckInDate();

	@BeforeTest
	public void setReportValues() {
		testcaseName = "Booking Confirmation";
		testDescription = "Login with multiple user credentials and hotel search with various location, date, and room combinations";
	}

	@Test(dataProvider = "loginData")
	public void runLogin(String user, String pass) {
		
		new LoginPage()
		.enterUsername(user)
		.enterPassword(pass)
		.clickLogin()
		.selectLocation(FakerDataFactory.getLocation())
		.selectHotels(FakerDataFactory.getHotels())
		.selectRoomType(FakerDataFactory.getRoomType())
		.selectNumberOfRooms(FakerDataFactory.getNoOfRoom())
		.enterDateIn(checkIn)
		.enterDateOut(FakerDataFactory
		.getCheckOutDate(checkIn))
		.selectAdultPerRooms(FakerDataFactory.getAdultPerRoom())
		.selectChildPerRooms(FakerDataFactory.getChildPerRoom())
		.clickSearch()
		.selectHotel()
		.clickContinue()
		.enterFirstName(FakerDataFactory.getFirstName())
		.enterLastName(FakerDataFactory.getLastName())
		.enterBillingAddress(FakerDataFactory.getAddress())
		.enterCreditCardNo(FakerDataFactory.getCreditCardNumber())
		.selectCreditCardType(FakerDataFactory.getCardType())
		.selectExpiryDateMonth(FakerDataFactory.getMonth())
		.selectExpiryDateYear(FakerDataFactory.getYear())
		.enterCCVNo(FakerDataFactory.getCVV())
		.clickBookNow()
		.getOrderNumber()
		.clickMyItinerary()
		.enterSearchOrderID()
		.clickGoButton()
		.getOrderNumber();
	}
}
