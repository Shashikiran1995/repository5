package com.tp.vTiger.generic.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	@FindBy(name ="user_name")
	private WebElement usernameEle;
	
	@FindBy(name ="user_password")
	private WebElement passwordEle;
	
	@FindBy(id ="submitButton")
	private WebElement LoginBtn;

	public WebElement getUsernameEle() {
		return usernameEle;
	}

	public WebElement getPasswordEle() {
		return passwordEle;
	}

	public WebElement getLoginBtn() {
		return LoginBtn;
	}
	
	public void login(String un,String pswd) {
		usernameEle.sendKeys(un);
		passwordEle.sendKeys(pswd);
		LoginBtn.click();
	}
	
	

}
