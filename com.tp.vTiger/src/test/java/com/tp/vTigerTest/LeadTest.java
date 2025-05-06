package com.tp.vTigerTest;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.tp.vTiger.generic.BaseClassTest.BaseClass;
import com.tp.vTiger.generic.ObjectRepository.CreatingNewLeadPage;
import com.tp.vTiger.generic.ObjectRepository.LeadInfoPage;

/**
 * 
 * @author Gowsalya
 *
 */
public class LeadTest extends BaseClass{
	
	String lead_lastname,company,leadsource,industry = null;
	
	@Test
	public void createLeadTest() throws Throwable {
		wLib.navigateToPage(driver, "Leads", "Create Lead...");
		//Generate Random Number using Java utility
		//Read Test Script data from Excel file using Excel Utility
		lead_lastname = eu.getDataFromExcelFile("Lead", 1, 2) + jLib.getRandomNumber();
		company = eu.getDataFromExcelFile("Lead", 1, 3);

		//creating lead with pom class
		CreatingNewLeadPage newLeadPage = new CreatingNewLeadPage(driver);
		newLeadPage.getLastname_Edt().sendKeys(lead_lastname);
		newLeadPage.getCompany_Edt().sendKeys(company);
		newLeadPage.getSave_Btn().click();
	
		LeadInfoPage leadInfoPage = new LeadInfoPage(driver);
		
		validate(leadInfoPage.getLeadInfoHeader_Txt(), lead_lastname);
		/*String header_info = leadInfoPage.getLeadInfoHeader_Txt().getText();
		if(header_info.contains(lead_lastname)) {
			System.out.println(lead_lastname+" is created==pass");
		}
		else {
			System.out.println(lead_lastname+" is not created==fail");
		}

		//verifying Lead name
		String actLastname = leadInfoPage.getLeadLastName_Edt().getText();
		if(actLastname.trim().equals(lead_lastname)) {
			System.out.println(lead_lastname+" information is verified==pass");
		}
		else{
			System.out.println(lead_lastname+" information is not verified==fail");	
		}*/
		
	}



	


	@Test
	public void createLeadWithLeadSourceAndIndustryTest() throws  Throwable {
		wLib.navigateToPage(driver, "Leads", "Create Lead...");

		//Generate Random Number using Java utility
		//Read Test Script data from Excel file using Excel Utility
		lead_lastname = eu.getDataFromExcelFile("Lead", 3, 2) + jLib.getRandomNumber();
		company = eu.getDataFromExcelFile("Lead", 3, 3);
		leadsource = eu.getDataFromExcelFile("Lead", 3, 4);
		industry = eu.getDataFromExcelFile("Lead", 3, 5);

		
		CreatingNewLeadPage newLeadPage = new CreatingNewLeadPage(driver);
		newLeadPage.getLastname_Edt().sendKeys(lead_lastname);
		newLeadPage.getCompany_Edt().sendKeys(company);
	
		//dropdown handling using webdriver utility
		WebElement LeadSource_element = newLeadPage.getLeadsource_dropdown();
		WebElement Industry_element = newLeadPage.getIndustry_dropdown();
		wLib.selectByVisibleTextDropDown(LeadSource_element, leadsource);
		wLib.selectByVisibleTextDropDown(Industry_element, industry);

	
		newLeadPage.getSave_Btn().click();
			LeadInfoPage leadInfoPage = new LeadInfoPage(driver);

		//verifying vendor info page
		String header_info = leadInfoPage.getLeadInfoHeader_Txt().getText();
		if(header_info.contains(lead_lastname)) {
			System.out.println(lead_lastname+" is created==pass");
		}
		else {
			System.out.println(lead_lastname+" is not created==fail");
		}

		//verifying lead name
		String actLastname = leadInfoPage.getLeadLastName_Edt().getText();
		if(actLastname.trim().equals(lead_lastname)) {
			System.out.println(lead_lastname+" lastname is verified==pass");
		}
		else{
			System.out.println(lead_lastname+" lastname is not verified==fail");	
		}
		//verifying lead source
		String actLeadSource = leadInfoPage.getLeadsource_Edt().getText();
		if(actLeadSource.trim().equals(leadsource)) {
			System.out.println(leadsource+" leadsource is verified==pass");
		}
		else{
			System.out.println(leadsource+" leadsource is not verified==fail");	
		}

		//verifying industry
		String actIndustry = leadInfoPage.getIndustry_Edt().getText();
		if(actIndustry.trim().equals(industry)) {
			System.out.println(industry+" industry is verified==pass");
		}
		else{
			System.out.println(industry+" industry is not verified==fail");	
		}
	}
}
