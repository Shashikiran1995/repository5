package com.tp.vTiger.generic.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatingNewProductPage {

	WebDriver driver;
	public CreatingNewProductPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name = "productname")
	private WebElement productname_Edt;
	
	//@FindBy(xpath="//input[@name='vendor_name']/following-sibling::img")
	@FindBy(xpath="//img[@alt='Select']")
	private WebElement vendor_loopup;
	
	@FindBy(id="jscal_field_start_date")
	private WebElement supportStartDate_Edt;
	
	@FindBy(id="jscal_field_expiry_date")
	private WebElement supportExpiryDate_Edt;
	
	@FindBy(name="button")
	private WebElement save_Btn;
	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getProductname_Edt() {
		return productname_Edt;
	}

	public WebElement getVendor_loopup() {
		return vendor_loopup;
	}

	public WebElement getSupportStartDate_Edt() {
		return supportStartDate_Edt;
	}

	public WebElement getSupportExpiryDate_Edt() {
		return supportExpiryDate_Edt;
	}

	public WebElement getSave_Btn() {
		return save_Btn;
	}
}

