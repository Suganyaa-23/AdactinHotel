package com.pages;

import org.openqa.selenium.By;
import com.base.ProjectHooks;

public class SelectHotelPage extends ProjectHooks {

	private By radioButton = By.xpath("//input[contains(@id,'radiobutton') and @type='radio']");
	private By continueButton = By.id("continue");

	public SelectHotelPage selectHotel() {
		click(radioButton, "Select Hotel");
		return this;
	}

	public BookHotelPage clickContinue() {
		click(continueButton, "Continue Button");
		return new BookHotelPage();
	}

}
