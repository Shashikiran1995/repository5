package com.tp.vTiger.generic.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tp.vTiger.generic.WebDriverUtility.WebDriverUtility;


public class HomePage {
	WebDriver driver;
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	WebDriverUtility wLib = new WebDriverUtility();

	@FindBy(linkText = "Calendar")
	private WebElement Calendar_link;
	@FindBy(linkText = "Leads")
	private WebElement Leads_link;
	@FindBy(linkText = "Organizations")
	private WebElement Organizations_link;
	@FindBy(linkText = "Contacts")
	private WebElement Contacts_link;
	@FindBy(linkText = "Products")
	private WebElement Products_link;
	@FindBy(linkText = "More")
	private WebElement More_link;
	@FindBy(linkText = "Vendors")
	private WebElement Vendors_link;
	
	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement user_image;
	public WebElement getUser_image() {
		return user_image;
	}

	@FindBy(linkText = "Sign Out")
	private WebElement SignOut_Btn;
	public WebDriver getDriver() {
		return driver;
	}
	public WebElement getCalendar_link() {
		return Calendar_link;
	}
	public WebElement getLeads_link() {
		return Leads_link;
	}
	public WebElement getOrganizations_link() {
		return Organizations_link;
	}
	public WebElement getContacts_link() {
		return Contacts_link;
	}
	public WebElement getProducts_link() {
		return Products_link;
	}
	public WebElement getMore_link() {
		return More_link;
	}
	public WebElement getVendors_link() {
		return Vendors_link;
	}
	public WebElement getSignOut_Btn() {
		return SignOut_Btn;
	}

	public void signOut() {
		wLib.mouseHoverAction(driver, getUser_image());
		//driver.findElement(By.linkText("Sign Out")).click();
		getSignOut_Btn().click();

		driver.quit();

	}
}
