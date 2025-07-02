package com.pages;

import org.openqa.selenium.By;

import com.base.ProjectHooks;

public class BookingConfirmationPage extends ProjectHooks {

	private By order_no = By.id("order_no");
	private By myitinerary = By.id("my_itinerary");
	public static String booking_confirmation_id;

	public BookingConfirmationPage getOrderNumber() {
		booking_confirmation_id = getAttribute(order_no, "value", "Order Number");
		return this;
	}

	public BookedItinerary clickMyItinerary() {
		click(myitinerary, "My Itinerary Button");
		return new BookedItinerary();
	}

}
