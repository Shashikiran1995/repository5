package com.tp.vTiger.generic.WebDriverUtility;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

public class UtilityClassObject {

	public static ThreadLocal<ExtentTest> test = new ThreadLocal<ExtentTest>();
	public static ThreadLocal<WebDriver> webdriver = new ThreadLocal<WebDriver>();


	public static ExtentTest getTest() {
		return test.get();
	}
	public static void setTest(ExtentTest acttest) {
		test.set(acttest);
	}
	public static WebDriver getWebdriver() {
		return webdriver.get();
	}
	public static void setWebdriver(WebDriver actdriver) {
		webdriver.set(actdriver);		}





}
