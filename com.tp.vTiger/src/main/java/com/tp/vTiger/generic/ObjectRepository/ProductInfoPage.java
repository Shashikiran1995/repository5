package com.tp.vTiger.generic.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductInfoPage {
	WebDriver driver;
	public ProductInfoPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//span[@class='lvtHeaderText']")
	private WebElement productInfoHeader_Txt;
	
	@FindBy(id="mouseArea_Product Name")
	private WebElement productName_Edt;
	
	@FindBy(id="mouseArea_Vendor Name")
	private WebElement vendorName_Edt;
	
	@FindBy(id="mouseArea_Support Start Date")
	private WebElement prod_supportStartDate_Edt;
	
	@FindBy(id="mouseArea_Support Expiry Date")
	private WebElement prod_supportExpiryDate_Edt;
	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getProductInfoHeader_Txt() {
		return productInfoHeader_Txt;
	}

	public WebElement getProductName_Edt() {
		return productName_Edt;
	}

	public WebElement getVendorName_Edt() {
		return vendorName_Edt;
	}

	public WebElement getProd_supportStartDate_Edt() {
		return prod_supportStartDate_Edt;
	}

	public WebElement getProd_supportExpiryDate_Edt() {
		return prod_supportExpiryDate_Edt;
	}
	
	
	
}
