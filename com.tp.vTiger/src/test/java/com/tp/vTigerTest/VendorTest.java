package com.tp.vTigerTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.tp.vTiger.generic.BaseClassTest.BaseClass;
import com.tp.vTiger.generic.ObjectRepository.CreatingNewVendorPage;
import com.tp.vTiger.generic.ObjectRepository.VendorInfoPage;


//@Listeners(com.tp.vTiger.generic.ListenerUtility.ListenerImplementation.class)
public class VendorTest extends BaseClass {
	String vendor_name = null;
	@Test
	//(retryAnalyzer = com.tp.vTiger.generic.ListenerUtility.RetryAnalyserImp.class)
	public void createVendorTest() throws Throwable {
		Actions actions = new Actions(driver);
		actions.moveToElement(driver.findElement(By.linkText("More"))).perform();

		wLib.navigateToPage(driver, "Vendors", "Create Vendor...");
		
		//Assert.fail("failing...");

		//Generate Random Number using Java Utility
		//Read Test Script data from Excel file using ExcelUtility
		vendor_name = eu.getDataFromExcelFile("Vendor", 1, 2) + jLib.getRandomNumber();

		CreatingNewVendorPage newVendorPage = new CreatingNewVendorPage(driver);
		newVendorPage.getVendorname_Edt().sendKeys(vendor_name);
		newVendorPage.getSave_Btn().click();


		Thread.sleep(3000);

		VendorInfoPage vendorInfoPage = new VendorInfoPage(driver);
		WebElement elmt = vendorInfoPage.getVendorInfoHeader_Txt();
		
		validate(elmt, vendor_name);

		//verifying vendor info page
	/*	String header_info =vendorInfoPage.getVendorInfoHeader_Txt().getText();
		if(header_info.contains(vendor_name)) {
			System.out.println(vendor_name+" is created==pass");
		}
		else {
			System.out.println(vendor_name+" is not created==fail");
		}

		//verifying vendor name
		String actname = vendorInfoPage.getVendorName_Edt().getText();
		if(actname.trim().equals(vendor_name)) {
			System.out.println(vendor_name+" information is verified==pass");
		}
		else{
			System.out.println(vendor_name+" information is not verified==fail");	
		}
		*/

	}

}
