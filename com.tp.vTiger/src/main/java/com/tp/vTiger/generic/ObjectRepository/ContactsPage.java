package com.tp.vTiger.generic.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage {

	WebDriver driver;
	public ContactsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//img[@alt='Create Contact...']")
	private WebElement createContact_lookup;
	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getCreateContact_lookup() {
		return createContact_lookup;
	}
}
