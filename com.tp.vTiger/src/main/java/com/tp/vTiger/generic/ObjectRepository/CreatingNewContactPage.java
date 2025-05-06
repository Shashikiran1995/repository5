package com.tp.vTiger.generic.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatingNewContactPage {
	WebDriver driver;
	public CreatingNewContactPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="firstname")
	private WebElement firstname_Edt;
	@FindBy(name="lastname")
	private WebElement lastname_Edt;
	
	@FindBy(xpath = "//input[@name='account_name']/following-sibling::img")
	private WebElement org_lookup;

	@FindBy(id="jscal_field_support_start_date")
	private WebElement supportStartDate_Edt;
	
	@FindBy(id="jscal_field_support_end_date")
	private WebElement supportEndDate_Edt;
	
	@FindBy(name = "button")
	private WebElement save_Btn;
	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getFirstname_Edt() {
		return firstname_Edt;
	}

	public WebElement getLastname_Edt() {
		return lastname_Edt;
	}

	public WebElement getOrg_lookup() {
		return org_lookup;
	}

	public WebElement getSupportStartDate_Edt() {
		return supportStartDate_Edt;
	}

	public WebElement getSupportEndDate_Edt() {
		return supportEndDate_Edt;
	}

	public WebElement getSave_Btn() {
		return save_Btn;
	}
	
	public void createNewContact(String name) {
		lastname_Edt.sendKeys(name);
		save_Btn.click();
	}
	
	
}
