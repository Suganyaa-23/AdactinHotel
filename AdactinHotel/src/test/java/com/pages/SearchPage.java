package com.pages;

import org.openqa.selenium.By;

import com.base.ProjectHooks;

public class SearchPage extends ProjectHooks {

	private By location = By.id("location");
	private By hotels = By.id("hotels");
	private By room_type = By.id("room_type");
	private By room_nos = By.id("room_nos");
	private By date_in = By.id("datepick_in");
	private By date_out = By.id("datepick_out");
	private By adult_per_room = By.id("adult_room");
	private By child_per_room = By.id("child_room");
	private By search = By.id("Submit");

	public SearchPage selectLocation(String locationvalue) {
		selectDropdownByVisibleText(location, locationvalue, 10, "Location");
		return this;
	}

	public SearchPage selectHotels(String hotelvalue) {
		selectDropdownByVisibleText(hotels, hotelvalue, 10, "Hotels");
		return this;
	}

	public SearchPage selectRoomType(String roomtypevalue) {
		selectDropdownByVisibleText(room_type, roomtypevalue, 10, "Room Type");
		return this;
	}

	public SearchPage selectNumberOfRooms(String roomnovalue) {
		selectDropdownByVisibleText(room_nos, roomnovalue, 10, "Number of Rooms");
		return this;
	}

	public SearchPage enterDateIn(String datein) {
		type(date_in, datein, "Check In Date");
		return this;
	}

	public SearchPage enterDateOut(String dateout) {
		type(date_out, dateout, "Check Out Date");
		return this;
	}

	public SearchPage selectAdultPerRooms(String adultvalue) {
		selectDropdownByVisibleText(adult_per_room, adultvalue, 10, "Adult Per Room");
		return this;
	}

	public SearchPage selectChildPerRooms(String childvalue) {
		selectDropdownByVisibleText(child_per_room, childvalue, 10, "Child Per Room");
		return this;
	}

	public SelectHotelPage clickSearch() {
		click(search, "Search Button");
		return new SelectHotelPage();
	}
}
