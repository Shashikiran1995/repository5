package com.tp.vTiger.generic.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatingNewOrganizationPage {
	WebDriver driver;
	public CreatingNewOrganizationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name = "accountname")
	private WebElement accountname_Edt;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement save_Btn;
	
	@FindBy(id="phone")
	private WebElement phone_edt;

	public WebElement getPhone_edt() {
		return phone_edt;
	}

	@FindBy(name="industry")
	private WebElement industry_dropdown;
	
	@FindBy(name="accounttype")
	private WebElement accounttype_dropdown;
	
	public WebElement getIndustry_dropdown() {
		return industry_dropdown;
	}

	public WebElement getAccounttype_dropdown() {
		return accounttype_dropdown;
	}

	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getAccountname_Edt() {
		return accountname_Edt;
	}

	public WebElement getSave_Btn() {
		return save_Btn;
	}
	


}
