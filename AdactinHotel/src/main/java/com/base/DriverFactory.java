package com.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class DriverFactory {
	private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

	/**
	 * Launches the preferred browser in the head(less) mode.
	 * 
	 * @param browser  The accepted browsers are chrome, edge, firefox
	 * @param headless Send true if you like to run in headless mode else false
	 */

	public static void setDriver(String browser, boolean headless) {
		switch (browser.toLowerCase()) {
		case "chrome":
			ChromeOptions chromeOptions = new ChromeOptions();
			if (headless) {
				chromeOptions.addArguments("--headless=new");
			}
			chromeOptions.addArguments("--start-maximized");
			driver.set(new ChromeDriver(chromeOptions));
			break;

		case "edge":
			EdgeOptions edgeOptions = new EdgeOptions();
			if (headless) {
				edgeOptions.addArguments("--headless=new");
			}
			edgeOptions.addArguments("--start-maximized");
			driver.set(new EdgeDriver(edgeOptions));
			break;

		case "firefox":
			FirefoxOptions firefoxOptions = new FirefoxOptions();
			if (headless) {
				firefoxOptions.addArguments("--headless");
			}
			driver.set(new FirefoxDriver(firefoxOptions));
			break;

		default:
			System.out.println("Browser not supported: " + browser);
			break;
		}
	}

	public static WebDriver getDriver() {
		return driver.get();
	}
}
