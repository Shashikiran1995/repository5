package com.tp.vTiger.generic.BaseClassTest;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import com.tp.vTiger.generic.FileUtility.ExcelUtility;
import com.tp.vTiger.generic.FileUtility.FileUtility;
import com.tp.vTiger.generic.ObjectRepository.HomePage;
import com.tp.vTiger.generic.ObjectRepository.LoginPage;
import com.tp.vTiger.generic.WebDriverUtility.JavaUtility;
import com.tp.vTiger.generic.WebDriverUtility.UtilityClassObject;
import com.tp.vTiger.generic.WebDriverUtility.WebDriverUtility;

public class BaseClass {
	public WebDriver driver;
	public static WebDriver sdriver;
	public FileUtility fu = new FileUtility();
	public ExcelUtility eu = new ExcelUtility();
	public JavaUtility jLib = new JavaUtility();
	public WebDriverUtility wLib = new WebDriverUtility();
	
	@Parameters("browser")
	@BeforeClass(groups = "smokeTest")
	public void toLaunch(@Optional("edge")String bname) {
		if(bname.equalsIgnoreCase("chrome")) {
		 driver = new ChromeDriver();
		}
		else if(bname.equalsIgnoreCase("Edge")) {
			 driver = new EdgeDriver();
			}
		else if(bname.equalsIgnoreCase("FireFox")) {
			 driver = new FirefoxDriver();
			}
		sdriver =driver;
		UtilityClassObject.setWebdriver(driver);
		Reporter.log("Browser got launched",true);
		driver.manage().window().maximize();
		Reporter.log("Browser got Maximized",true);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	}
	@BeforeMethod(groups = "smokeTest")
	public void toLogin() throws Throwable {
		FileUtility fu = new FileUtility();
		String URL = fu.getDataFromPropertyFile("url");
		String UN = fu.getDataFromPropertyFile("username");
		String PSWD = fu.getDataFromPropertyFile("password");
		driver.get(URL);
		LoginPage lp = new LoginPage(driver);
		lp.login(UN, PSWD);
		
		Reporter.log("Logged In Successfully",true);
	
	}
	
	@AfterMethod(groups = "smokeTest")
	public void toLogout() {
		
		WebDriverUtility wLib = new WebDriverUtility();
		HomePage hp = new HomePage(driver);
		wLib.mouseHoverAction(driver, hp.getUser_image());
		hp.getSignOut_Btn().click();

			Reporter.log("Logged out Successfully",true);
	}
	
	@AfterClass(groups = "smokeTest")
	public void toClose() {

		driver.quit();
		Reporter.log("Browser got Closed Successfully",true);
	}
	
	public void validate(WebElement element,String Data) {
		String actualText = element.getText();
		boolean b = actualText.contains(Data);
		Assert.assertTrue(b);
		Reporter.log(actualText+" verified",true);
	
	}
	
	
}
