package com.base;

import java.io.IOException;
import java.util.Base64;
import java.util.Iterator;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;

import com.config.ConfigurationManager;
import com.utility.CSVDataReader;

public class ProjectHooks extends SeleniumWrapper {

	@BeforeClass(alwaysRun = true)
	public void startTestcaseReporting() {
		startTestCase();
	}

	@BeforeSuite
	public void initSuite() {
		startReport();
	}

	@BeforeMethod
	public void init() {
		setNode();
		
		setDriver(ConfigurationManager.configuration().browser(), ConfigurationManager.configuration().headless());

		maximize();

		getDriver().get(ConfigurationManager.configuration().baseUrl());

	}

	@Override
	public String takeSnap() {
		TakesScreenshot ts = (TakesScreenshot) getDriver();
		byte[] screenshotBytes = ts.getScreenshotAs(OutputType.BYTES);
		return Base64.getEncoder().encodeToString(screenshotBytes);
	}

	@DataProvider(name = "loginData")
	public Iterator<Object[]> loginSearchData() throws IOException {
		return CSVDataReader.readData("data/logindata.csv");
	}

	@AfterMethod(alwaysRun = true)
	public void tearDown() {
		try {
			getDriver().close();
			endResult();
		} catch (Exception e) {
			System.out.println(e);;
		}
	}

}
