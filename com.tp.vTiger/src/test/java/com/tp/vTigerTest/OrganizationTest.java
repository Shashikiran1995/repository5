package com.tp.vTigerTest;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.tp.vTiger.generic.BaseClassTest.BaseClass;
import com.tp.vTiger.generic.FileUtility.ExcelUtility;
import com.tp.vTiger.generic.FileUtility.FileUtility;
import com.tp.vTiger.generic.ObjectRepository.CreatingNewOrganizationPage;
import com.tp.vTiger.generic.ObjectRepository.OrganizationInfoPage;
import com.tp.vTiger.generic.WebDriverUtility.JavaUtility;
import com.tp.vTiger.generic.WebDriverUtility.WebDriverUtility;

public class OrganizationTest extends BaseClass {
	String contact_name = null;
	String Org_name,last_name,industry,type,phone_number = null;

	@Test(groups = "smokeTest")
	public void createOrganizationTest() throws IOException, Throwable {
		wLib.navigateToPage(driver, "Organizations", "Create Organization...");
		Org_name = eu.getDataFromExcelFile("Org", 1, 2)+ jLib.getRandomNumber();
		CreatingNewOrganizationPage newOrgPage = new CreatingNewOrganizationPage(driver);
		newOrgPage.getAccountname_Edt().sendKeys(Org_name);
		newOrgPage.getSave_Btn().click();

		OrganizationInfoPage orgInfoPage = new OrganizationInfoPage(driver);
		
		/*String header_info =orgInfoPage.getOrgInfoHeader_Txt().getText();
		if(header_info.contains(Org_name)) {
			System.out.println(Org_name+" is created==pass");
		}
		else {
			System.out.println(Org_name+" is not created==fail");
		}

		String actOrgname = orgInfoPage.getOrgname_edt().getText();
		if(actOrgname.trim().equals(Org_name)) {
			System.out.println(Org_name+" information is verified==pass");
		}
		else{
			System.out.println(Org_name+" information is not verified==fail");	
		}*/
	}

	@Test
	public void createOrganizationWithIndustryAndTypeTest() throws IOException, Throwable {
		wLib.navigateToPage(driver, "Organizations", "Create Organization...");

		Org_name = eu.getDataFromExcelFile("Org", 4, 2)+ jLib.getRandomNumber();
		industry = eu.getDataFromExcelFile("Org", 4, 3);
		type = eu.getDataFromExcelFile("Org", 4, 4);

		CreatingNewOrganizationPage newOrgPage = new CreatingNewOrganizationPage(driver);
		newOrgPage.getAccountname_Edt().sendKeys(Org_name);


		WebElement Industry_element = newOrgPage.getIndustry_dropdown();
		WebElement Accounttype_element = newOrgPage.getAccounttype_dropdown();
		wLib.selectByVisibleTextDropDown(Industry_element, industry);
		wLib.selectByVisibleTextDropDown(Accounttype_element, type);

		newOrgPage.getSave_Btn().click();

		//verify the header info
		OrganizationInfoPage orgInfoPage = new OrganizationInfoPage(driver);
		String header_info =orgInfoPage.getOrgInfoHeader_Txt().getText();
		if(header_info.contains(Org_name)) {
			System.out.println(Org_name+" is created==pass");
		}
		else {
			System.out.println(Org_name+" is not created==fail");
		}

		//verify the industry		
		String actIndustry = orgInfoPage.getIndustry_edt().getText();
		if(actIndustry.trim().equals(industry)) {
			System.out.println(industry+" industry is verified==pass");
		}
		else {
			System.out.println(industry+" industry is not verified==fail");
		}

		//verify type 
		String actType = orgInfoPage.getType_Edt().getText();
		if(actType.trim().equals(type)) {
			System.out.println(type+" type is verified==pass");
		}
		else {
			System.out.println(type+" type is not verified==fail");
		}

	}

	@Test
	public void createOrganizationWithPhoneNumberTest() throws Throwable {
		wLib.navigateToPage(driver, "Organizations", "Create Organization...");
		Org_name = eu.getDataFromExcelFile("Org", 7, 2)+jLib.getRandomNumber();
		phone_number = eu.getDataFromExcelFile("Org", 7, 3);

		CreatingNewOrganizationPage newOrgPage = new CreatingNewOrganizationPage(driver);
		newOrgPage.getAccountname_Edt().sendKeys(Org_name);
		newOrgPage.getPhone_edt().sendKeys(phone_number);
		newOrgPage.getSave_Btn().click();
		OrganizationInfoPage orgInfoPage = new OrganizationInfoPage(driver);

		//verify the header info
		String header_info = orgInfoPage.getOrgInfoHeader_Txt().getText();
		if(header_info.contains(Org_name)) {
			System.out.println(Org_name+" is verified==pass");
		}
		else {
			System.out.println(Org_name+" is not verified==fail");
		}


		//verify the phone number		
		String actPhnumber = orgInfoPage.getPhone_Edt().getText();
		if(actPhnumber.trim().equals(phone_number)) {
			System.out.println(phone_number+" is verified==pass");
		}
		else {
			System.out.println(phone_number+" is not verified==fail");
		}

	}
}
