package com.tp.vTiger.generic.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeadInfoPage {
	WebDriver driver;
	public LeadInfoPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement LeadInfoHeader_Txt;
	
	@FindBy(id="mouseArea_Last Name")
	private WebElement leadLastName_Edt;
	
	@FindBy(id="mouseArea_Company")
	private WebElement companyName_Edt;
	
	
	@FindBy(id="mouseArea_Lead Source")
	private WebElement leadsource_Edt;
	
	@FindBy(id="mouseArea_Industry")
	private WebElement industry_Edt;
	
	public WebElement getLeadsource_Edt() {
		return leadsource_Edt;
	}

	public WebElement getIndustry_Edt() {
		return industry_Edt;
	}

	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getLeadInfoHeader_Txt() {
		return LeadInfoHeader_Txt;
	}

	public WebElement getLeadLastName_Edt() {
		return leadLastName_Edt;
	}

	public WebElement getCompanyName_Edt() {
		return companyName_Edt;
	}
	
}
