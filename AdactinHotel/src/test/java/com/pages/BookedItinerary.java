package com.pages;

import org.openqa.selenium.By;
import org.testng.Assert;

import com.base.ProjectHooks;

public class BookedItinerary extends ProjectHooks {

	String booking_id1 = BookingConfirmationPage.booking_confirmation_id;

	private By search_order = By.id("order_id_text");
	private By gobutton = By.id("search_hotel_id1");
	private By orderid = By.xpath("//input[contains(@id,'order_id') and @class='select_text']");

	public BookedItinerary enterSearchOrderID() {
		type(search_order, booking_id1, "Search Order ID");
		return this;
	}

	public BookedItinerary clickGoButton() {
		click(gobutton, "Go Button");
		return this;
	}

	public BookedItinerary getOrderNumber() {
		String booking_id2 = getAttribute(orderid, "value", "Order Number");
		Assert.assertEquals(booking_id2, booking_id1);
		return this;
	}
}
