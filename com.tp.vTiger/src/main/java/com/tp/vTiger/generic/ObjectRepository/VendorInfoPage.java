package com.tp.vTiger.generic.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VendorInfoPage {
	WebDriver driver;
	public VendorInfoPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//span[@class='lvtHeaderText']")
	private WebElement VendorInfoHeader_Txt;
	
	
	@FindBy(id="mouseArea_Vendor Name")
	private WebElement vendorName_Edt;
	public WebDriver getDriver() {
		return driver;
	}


	public WebElement getVendorInfoHeader_Txt() {
		return VendorInfoHeader_Txt;
	}


	public WebElement getVendorName_Edt() {
		return vendorName_Edt;
	}
	
}
