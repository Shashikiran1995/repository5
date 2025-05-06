package com.tp.vTiger.generic.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {
	WebDriver driver;
	public ProductPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//img[@alt='Create Product...']")
	private WebElement CreateProduct_lookup;
	
	@FindBy(name="search_text")
	private WebElement search_Edt;
	@FindBy(id="bas_searchfield")
	private WebElement searchfield_dropdown;
	
	@FindBy(name="submit")
	private WebElement searchNow_Btn;
	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getCreateProduct_lookup() {
		return CreateProduct_lookup;
	}

	public WebElement getSearch_Edt() {
		return search_Edt;
	}

	public WebElement getSearchfield_dropdown() {
		return searchfield_dropdown;
	}

	public WebElement getSearchNow_Btn() {
		return searchNow_Btn;
	}
	
	
}
