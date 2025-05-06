package com.tp.vTiger.generic.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;

public class ContactInformationPage {
	WebDriver driver;
	public ContactInformationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement contactInfoHeader_Txt;

	@FindBy(id="mouseArea_Last Name")
	private WebElement lastname_Edt;

	@FindBy(id="mouseArea_Organization Name")
	private WebElement Orgname_edt;

	@FindBy(id="dtlview_Support Start Date")
	private WebElement supportStartDate_Edt;

	public WebElement getSupportStartDate_Edt() {
		return supportStartDate_Edt;
	}

	public WebElement getSupportEndDate_Edt() {
		return supportEndDate_Edt;
	}

	@FindBy(id="dtlview_Support End Date")
	private WebElement supportEndDate_Edt;
	public WebElement getOrgname_edt() {
		return Orgname_edt;
	}

	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getContactInfoHeader_Txt() {
		return contactInfoHeader_Txt;
	}

	public WebElement getLastname_Edt() {
		return lastname_Edt;
	}

	public void verifyingContactInfo(String text) {
		String header_info= getContactInfoHeader_Txt().getText();
		boolean b = header_info.contains(text);
		Assert.assertTrue(b);
		Reporter.log("Date verified",true);

		/*if(header_info.contains(text)) {
			System.out.println(text+" is created==pass");
		}
		else {
			System.out.println(text+" is not created==fail");
		}*/

	}
	/*public void verifyContactName(String text) {
		String actLastname =getLastname_Edt().getText();
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(actLastname.trim(), text);
		sa.assertAll();
		Reporter.log("contactName verified",true);
	}*/
		/*	if(actLastname.trim().equals(text)) {
			System.out.println(text+" information is vernoified==pass");
		}
		else{
			System.out.println(text+" information is not verified==fail");	
		}*/

	

	/*public void verifyingOrgName(String text) {
		String actOrg_name = getOrgname_edt().getText();
		//String actOrg_name = driver.findElement(By.id("mouseArea_Organization Name")).getText();

		if(actOrg_name.trim().equals(text)) {
			System.out.println(text+" information is verified==pass");
		}
		else{
			System.out.println(text+" information is not verified==fail");	
		}
	}*/
	
	public void verifyingHeader(WebElement elmt,String text) {
		String actualText = elmt.getText();
		boolean b = actualText.contains(text);
		Assert.assertTrue(b);
		Reporter.log(actualText+" verified",true);
	}
	public void verifyingTextfield(WebElement elmt,String text) {
		String actualText = elmt.getText();
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(actualText.trim(), text);
		sa.assertAll();
		Reporter.log(actualText+" verified",true);
		}
}
