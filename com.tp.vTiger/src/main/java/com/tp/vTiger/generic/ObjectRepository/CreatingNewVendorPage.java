package com.tp.vTiger.generic.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatingNewVendorPage {
	WebDriver driver;
	public CreatingNewVendorPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name = "vendorname")
	private WebElement vendorname_Edt;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement save_Btn;
	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getVendorname_Edt() {
		return vendorname_Edt;
	}

	public WebElement getSave_Btn() {
		return save_Btn;
	}
	
	
}
