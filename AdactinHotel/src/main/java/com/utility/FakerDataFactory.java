package com.utility;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import net.datafaker.Faker;

public class FakerDataFactory {
	private static final Faker faker = new Faker();
	private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	private FakerDataFactory() {
	}

	public static String getLocation() {
		return faker.options().option("Sydney", "Melbourne", "Brisbane", "Adelaide", "London", "New York",
				"Los Angeles", "Paris");
	}

	public static String getHotels() {
		return faker.options().option("Hotel Creek", "Hotel Sunshine", "Hotel Hervey", "Hotel Cornice");
	}

	public static String getRoomType() {
		return faker.options().option("Standard", "Double", "Deluxe", "Super Deluxe");
	}

	public static String getNoOfRoom() {
		return faker.options().option("1 - One", "2 - Two", "3 - Three", "4 - Four", "5 - Five", "6 - Six", "7 - Seven",
				"8 - Eight", "9 - Nine", "10 - Ten");
	}

	public static String getCheckInDate() {
        int randomDays = faker.number().numberBetween(1, 11); // 1 to 10 days from today
        LocalDate checkInDate = LocalDate.now().plusDays(randomDays);
        return checkInDate.format(formatter);
    }

	public static String getCheckOutDate(String checkInDateStr) {
        LocalDate checkInDate = LocalDate.parse(checkInDateStr, formatter);
        int stayDuration = faker.number().numberBetween(1, 6); // 1 to 5 nights
        LocalDate checkOutDate = checkInDate.plusDays(stayDuration);
        return checkOutDate.format(formatter);
    }
    
    public static String getAdultPerRoom() {
		return faker.options().option("1 - One","2 - Two","3 - Three","4 - Four");
	}
    
    public static String getChildPerRoom() {
		return faker.options().option("0 - None","1 - One","2 - Two","3 - Three","4 - Four");
	}
    
	public static String getAddress() {
		return faker.address().streetAddress();
	}

	public static String getFirstName() {
		return faker.name().firstName();
	}

	public static String getLastName() {
		return faker.name().lastName();
	}

	public static String getEmailAddress() {
		return faker.internet().emailAddress();
	}

	public static String getContactNumber() {
		return faker.phoneNumber().cellPhone();
	}

	public static String getSalutation() {
		return faker.options().option("Mr.", "Ms.", "Mrs.", "Dr.", "Prof.");
	}

	public static String getCreditCardNumber() {
		return faker.number().digits(16);
	}

	public static String getCVV() {
		return faker.number().digits(3);
	}

	public static String getCardType() {
		return faker.options().option("American Express", "VISA", "Master Card", "Other");
	}

	public static String getMonth() {
		String[] months = { "January", "February", "March", "April", "May", "June", "July", "August", "September",
				"October", "November", "December" };

		int index = faker.number().numberBetween(0, 12);
		return months[index];
	}

	public static String getYear() {
		return String.valueOf(faker.number().numberBetween(2026, 2030));
	}
}
