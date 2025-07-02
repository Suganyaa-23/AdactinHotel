package com.base;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.utility.HtmlReporter;

public abstract class SeleniumWrapper extends HtmlReporter {
	int retry = 0;

	private WebDriverWait wait;

	public SeleniumWrapper() {
		this.wait = new WebDriverWait(getDriver(), Duration.ofSeconds(15));
	}

	// Maximize the browser based on screen size
	public void maximize() {
		try {
			getDriver().manage().window().maximize();
		} catch (Exception e) {
			reportStep("Exception while maximizing window: \n" + e.getMessage(), "Fail");
		}
	}

	// Click on element
	public boolean click(By locator, String field) {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
			reportStep("Clicked on element: " + field, "Pass");
			return true;
		} catch (Exception e) {
			reportStep("Click failed on: " + field + "\n" + e.getMessage(), "Fail");
			return false;
		}
	}

	// Type into input box
	public boolean type(By locator, String value, String field) {
		try {
			WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
			element.clear();
			element.sendKeys(value);
			reportStep("Typed '" + value + "' in element: " + field, "Pass");
			return true;
		} catch (Exception e) {
			reportStep("Typing failed on: " + field + "\n" + e.getMessage(), "Fail");
			return false;
		}
	}

	// Get attribute of element
	public String getAttribute(By locator, String attribute, String field) {
		String getText = null;
		try {
			WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
			getText = element.getAttribute(attribute);
			reportStep("Get attribte '" + getText + "' from '" + field, "Pass");

		} catch (Exception e) {
			reportStep("Unable to get attribute '" + attribute + "' from: " + field + "\n" + e.getMessage(), "Fail");

		}
		return getText;
	}

	// Select dropdown using Visible Text
	public boolean selectDropdownByVisibleText(By locator, String visibleText, int timeoutInSeconds, String field) {
		try {
			WebElement dropdown = new WebDriverWait(getDriver(), Duration.ofSeconds(timeoutInSeconds))
					.until(ExpectedConditions.visibilityOfElementLocated(locator));

			Select select = new Select(dropdown);
			select.selectByVisibleText(visibleText);
			reportStep("Dropdown " + field + " selected with value: " + visibleText, "Pass");
			return true;
		} catch (Exception e) {
			reportStep("Exception while selecting " + field + "  dropdown: " + e.getMessage(), "Fail");
		}
		return false;
	}

	// Select dropdown using Value
	public boolean selectDropdownByValue(By locator, String value, int timeoutInSeconds, String field) {
		try {
			WebElement dropdown = new WebDriverWait(getDriver(), Duration.ofSeconds(timeoutInSeconds))
					.until(ExpectedConditions.visibilityOfElementLocated(locator));

			Select select = new Select(dropdown);
			select.selectByValue(value);
			reportStep("Dropdown " + field + " selected with value: " + value, "Pass");
			return true;
		} catch (Exception e) {
			reportStep("Exception while selecting " + field + "  dropdown: " + e.getMessage(), "Fail");
		}
		return false;
	}

	// Select dropdown using Index
	public boolean selectDropdownByIndex(By locator, int index, int timeoutInSeconds, String field) {
		try {
			WebElement dropdown = new WebDriverWait(getDriver(), Duration.ofSeconds(timeoutInSeconds))
					.until(ExpectedConditions.visibilityOfElementLocated(locator));

			Select select = new Select(dropdown);
			select.selectByIndex(index);
			reportStep("Dropdown " + field + " selected with value: " + index, "Pass");
			return true;
		} catch (Exception e) {
			reportStep("Exception while selecting " + field + "  dropdown: " + e.getMessage(), "Fail");
		}
		return false;
	}
}
