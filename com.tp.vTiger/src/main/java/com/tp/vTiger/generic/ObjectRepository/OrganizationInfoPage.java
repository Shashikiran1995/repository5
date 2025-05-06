package com.tp.vTiger.generic.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInfoPage {
	WebDriver driver;
	public OrganizationInfoPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement OrgInfoHeader_Txt;
	
	@FindBy(id="mouseArea_Organization Name")
	private WebElement Orgname_edt;
	
	@FindBy(id="mouseArea_Phone")
	private WebElement phone_Edt;

	@FindBy(id="mouseArea_Industry")
	private WebElement industry_edt;
	
	@FindBy(id="mouseArea_Type")
	private WebElement type_Edt;
	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getOrgInfoHeader_Txt() {
		return OrgInfoHeader_Txt;
	}

	public WebElement getOrgname_edt() {
		return Orgname_edt;
	}

	public WebElement getPhone_Edt() {
		return phone_Edt;
	}

	public WebElement getIndustry_edt() {
		return industry_edt;
	}

	public WebElement getType_Edt() {
		return type_Edt;
	}
	
	
}
