package com.tp.vTiger.generic.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VendorPopupPage {
	WebDriver driver;
	public VendorPopupPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="search_txt")
	private WebElement search_txt;
	
	@FindBy(name = "search")
	private WebElement searchNow_Btn;
	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getSearch_txt() {
		return search_txt;
	}

	public WebElement getSearchNow_Btn() {
		return searchNow_Btn;
	}

}
