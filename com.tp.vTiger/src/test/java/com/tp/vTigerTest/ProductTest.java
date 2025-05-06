package com.tp.vTigerTest;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.tp.vTiger.generic.BaseClassTest.BaseClass;
import com.tp.vTiger.generic.ObjectRepository.CreatingNewProductPage;
import com.tp.vTiger.generic.ObjectRepository.CreatingNewVendorPage;
import com.tp.vTiger.generic.ObjectRepository.HomePage;
import com.tp.vTiger.generic.ObjectRepository.ProductInfoPage;
import com.tp.vTiger.generic.ObjectRepository.VendorPopupPage;

public class ProductTest extends BaseClass {

	String product_name,vendor_name = null;
	@Test(groups = "smokeTest")
	public void createProductTest() throws IOException, Throwable {
		wLib.navigateToPage(driver, "Products", "Create Product...");
		product_name = eu.getDataFromExcelFile("Product", 1, 2) + jLib.getRandomNumber();
		CreatingNewProductPage newProPage = new CreatingNewProductPage(driver);
		newProPage.getProductname_Edt().sendKeys(product_name);
		newProPage.getSave_Btn().click();
		Thread.sleep(3000);

		ProductInfoPage proInfoPage = new ProductInfoPage(driver);
		//verifying product info page
		String header_info = proInfoPage.getProductInfoHeader_Txt().getText();
		if(header_info.contains(product_name)) {
			System.out.println(product_name+" is created==pass");
		}
		else {
			System.out.println(product_name+" is not created==fail");
		}

		//verifying product name
		String actProname = proInfoPage.getProductName_Edt().getText();
		if(actProname.trim().equals(product_name)) {
			System.out.println(product_name+" information is verified==pass");
		}
		else{
			System.out.println(product_name+" information is not verified==fail");	
		}
	}

	@Test
	public void createProductWithSupportDateTest() throws Throwable {

		Reporter.log("createProductWithSupportDateTest");
		wLib.navigateToPage(driver, "Products", "Create Product...");
		product_name = eu.getDataFromExcelFile("Product", 1, 2) + jLib.getRandomNumber();
		CreatingNewProductPage newProPage = new CreatingNewProductPage(driver);
		newProPage.getProductname_Edt().sendKeys(product_name);
		String actDate= jLib.getSystemDate();
		String date_req = jLib.getRequiredDate();

		WebElement startDate_WE = newProPage.getSupportStartDate_Edt();
		startDate_WE.sendKeys(actDate);
		WebElement ExpiryDate_WE =newProPage.getSupportExpiryDate_Edt();
		ExpiryDate_WE.sendKeys(date_req);
		newProPage.getSave_Btn().click();
		Thread.sleep(3000);

		ProductInfoPage proInfoPage = new ProductInfoPage(driver);
		//verifying product info page
		String header_info = proInfoPage.getProductInfoHeader_Txt().getText();
		if(header_info.contains(product_name)) {
			System.out.println(product_name+" is created==pass");
		}
		else {
			System.out.println(product_name+" is not created==fail");
		}

		//verifying product name
		String actProname = proInfoPage.getProductName_Edt().getText();
		if(actProname.trim().equals(product_name)) {
			System.out.println(product_name+" information is verified==pass");
		}
		else{
			System.out.println(product_name+" information is not verified==fail");	
		}

		//verifying the start date and expiry date
		String actStartDate =proInfoPage.getProd_supportStartDate_Edt().getText();
		if(actStartDate.trim().equals(actDate)) {
			System.out.println(actDate+" information is verified==pass");
		}
		else{
			System.out.println(actDate+" information is not verified==fail");	
		}

		String actExpDate =proInfoPage.getProd_supportExpiryDate_Edt().getText();
		if(actExpDate.trim().equals(date_req)) {
			System.out.println(date_req+" information is verified==pass");
		}
		else{
			System.out.println(date_req+" information is not verified==fail");	
		}
	}

	@Test
	public void createProductWithVendorTest() throws Throwable {
		HomePage hp = new HomePage(driver);
		Actions actions = new Actions(driver);
		actions.moveToElement(hp.getMore_link()).perform();
		wLib.navigateToPage(driver, "Vendors", "Create Vendor...");
		vendor_name = eu.getDataFromExcelFile("Vendor", 1, 2) + jLib.getRandomNumber();

		CreatingNewVendorPage newVendorPage = new CreatingNewVendorPage(driver);
		newVendorPage.getVendorname_Edt().sendKeys(vendor_name);
		newVendorPage.getSave_Btn().click();

		wLib.navigateToPage(driver, "Products", "Create Product...");
		product_name = eu.getDataFromExcelFile("Product", 1, 2) + jLib.getRandomNumber();

		CreatingNewProductPage newProPage = new CreatingNewProductPage(driver);
		newProPage.getProductname_Edt().sendKeys(product_name);
		newProPage.getVendor_loopup().click();

		//switch to window using WebDriver utility
		wLib.switchToWindow(driver, "Vendors&action");

		VendorPopupPage vendorPopupPage = new VendorPopupPage(driver);
		vendorPopupPage.getSearch_txt().sendKeys(vendor_name);
		vendorPopupPage.getSearchNow_Btn().click();
		driver.findElement(By.xpath("//a[text()='"+vendor_name+"']")).click();
		//switch to window using WebDriver utility
		wLib.switchToWindow(driver, "Products&action");

		newProPage.getSave_Btn().click();
		Thread.sleep(3000);

		ProductInfoPage prodInfoPage = new ProductInfoPage(driver);
		//verifying product info page
		String header_info = prodInfoPage.getProductInfoHeader_Txt().getText();

		if(header_info.contains(product_name)) {
			System.out.println(product_name+" is created==pass");
		}
		else {
			System.out.println(product_name+" is not created==fail");
		}

		//verifying product name
		String actProname = prodInfoPage.getProductName_Edt().getText();
		if(actProname.trim().equals(product_name)) {
			System.out.println(product_name+" information is verified==pass");
		}
		else{
			System.out.println(product_name+" information is not verified==fail");	
		}

		//verifying vendor name in product page
		String actVendor_name = prodInfoPage.getVendorName_Edt().getText();
		if(actVendor_name.trim().equals(vendor_name)) {
			System.out.println(vendor_name+" information is verified==pass");
		}
		else{
			System.out.println(vendor_name+" information is not verified==fail");	
		}

	}
}