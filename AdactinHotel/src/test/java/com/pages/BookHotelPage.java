package com.pages;

import org.openqa.selenium.By;

import com.base.ProjectHooks;

public class BookHotelPage extends ProjectHooks {

	private By firstName = By.id("first_name");
	private By lastName = By.id("last_name");
	private By billingAddress = By.id("address");
	private By creditCardNo = By.id("cc_num");
	private By creditCardType = By.id("cc_type");
	private By expiryDate_Month = By.id("cc_exp_month");
	private By expiryDate_Year = By.id("cc_exp_year");
	private By ccvNo = By.id("cc_cvv");
	private By bookNow = By.id("book_now");

	public BookHotelPage enterFirstName(String fname) {
		type(firstName, fname, "Firstname");
		return this;
	}

	public BookHotelPage enterLastName(String lname) {
		type(lastName, lname, "Lastname");
		return this;
	}

	public BookHotelPage enterBillingAddress(String address) {
		type(billingAddress, address, "Billing Address");
		return this;
	}

	public BookHotelPage enterCreditCardNo(String cc_no) {
		type(creditCardNo, cc_no, "Credit Card Number");
		return this;
	}

	public BookHotelPage selectCreditCardType(String cctypevalue) {
		selectDropdownByVisibleText(creditCardType, cctypevalue, 10, "Credit Card Type");
		return this;
	}

	public BookHotelPage selectExpiryDateMonth(String expmonthvalue) {
		selectDropdownByVisibleText(expiryDate_Month, expmonthvalue, 10, "Expiry Date Month");
		return this;
	}

	public BookHotelPage selectExpiryDateYear(String expyearvalue) {
		selectDropdownByVisibleText(expiryDate_Year, expyearvalue, 10, "ExpiryDateYear");
		return this;
	}

	public BookHotelPage enterCCVNo(String ccv_no) {
		type(ccvNo, ccv_no, "CCV Number");
		return this;
	}

	public BookingConfirmationPage clickBookNow() {
		click(bookNow, "Book Now Button");
		return new BookingConfirmationPage();
	}

}
