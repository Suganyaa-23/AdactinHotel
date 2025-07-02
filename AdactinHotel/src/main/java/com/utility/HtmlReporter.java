package com.utility;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.MediaEntityModelProvider;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.base.DriverFactory;

public abstract class HtmlReporter extends DriverFactory {

	private static ExtentReports extent;
	private static final ThreadLocal<ExtentTest> parentTest = new ThreadLocal<>();
	private static final ThreadLocal<ExtentTest> test = new ThreadLocal<>();
	private static final ThreadLocal<String> testName = new ThreadLocal<>();

	private String fileName = "result.html";
	private static final String pattern = "dd-MMM-yyyy HH-mm-ss";

	public String testcaseName, testDescription, authors, category, dataFileName, dataFileType;
	public static String folderName = "";

	// Create time stamped report folder

	public static String createFolder(String baseFolderName) {
		String date = new SimpleDateFormat(pattern).format(new Date());
		folderName = baseFolderName + "/" + date;
		File folder = new File("./" + folderName);
		if (!folder.exists()) {
			folder.mkdirs();
		}
		return folderName;
	}

	// Initialize Extent Report

	public synchronized void startReport() {
		folderName = createFolder("reports");
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("./" + folderName + "/" + fileName);
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
	}

	// Start a parent test case in the report
	public synchronized void startTestCase() {
		ExtentTest parent = extent.createTest(testcaseName, testDescription);
		// parent.assignCategory(category);
		// parent.assignAuthor(authors);
		parentTest.set(parent);
		testName.set(testcaseName);
	}

	public synchronized void setNode() {
		ExtentTest child = parentTest.get().createNode(getTestName());
		test.set(child);
	}

	// Subclasses implement screenshot capture
	public abstract String takeSnap();

	// Logs a step with description, status, and optional screenshot
	public void reportStep(String desc, String status, boolean bSnap) {
		synchronized (test) {

			MediaEntityModelProvider img = null;
			try {
				if (bSnap && !(status.equalsIgnoreCase("INFO") || status.equalsIgnoreCase("skipped"))) {
					String snapPath = takeSnap();
					img = MediaEntityBuilder.createScreenCaptureFromBase64String(snapPath).build();
				}

				if (status.equalsIgnoreCase("pass")) {
					test.get().pass(desc, img);
				} else if (status.equalsIgnoreCase("fail")) {
					test.get().fail(desc, img);
					throw new RuntimeException("See the reporter for details.");
				} else if (status.equalsIgnoreCase("warning")) {
					test.get().warning(desc, img);
				} else if (status.equalsIgnoreCase("skipped")) {
					test.get().skip("The test is skipped due to dependency failure");
				} else if (status.equalsIgnoreCase("INFO")) {
					test.get().info(desc);
				}

			} catch (Exception e) {
				System.err.println("Error while logging report step: " + e.getMessage());
			}
		}
	}

	// Overloaded method with screenshot capture by default
	public void reportStep(String desc, String status) {
		reportStep(desc, status, true);
	}

	// Finalizes and flushes the Extent report
	public synchronized void endResult() {
		extent.flush();
	}

	public String getTestName() {
		return testName.get();
	}

	public Status getTestStatus() {
		return parentTest.get().getModel().getStatus();
	}
}
