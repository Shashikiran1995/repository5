package com.tp.vTiger.generic.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatingNewLeadPage {
	WebDriver driver;
	public CreatingNewLeadPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name = "lastname")
	private WebElement lastname_Edt;
	
	@FindBy(name ="company")
	private WebElement company_Edt;
	

	@FindBy(name="leadsource")
	private WebElement leadsource_dropdown;
	
	@FindBy(name="industry")
	private WebElement industry_dropdown;
	public WebElement getLeadsource_dropdown() {
		return leadsource_dropdown;
	}

	public WebElement getIndustry_dropdown() {
		return industry_dropdown;
	}

	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement save_Btn;
	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getLastname_Edt() {
		return lastname_Edt;
	}

	public WebElement getCompany_Edt() {
		return company_Edt;
	}

	public WebElement getSave_Btn() {
		return save_Btn;
	}
	


}
