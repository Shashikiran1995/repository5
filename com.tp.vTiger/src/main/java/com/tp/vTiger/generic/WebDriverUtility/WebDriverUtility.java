package com.tp.vTiger.generic.WebDriverUtility;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;

public class WebDriverUtility {

	public void waitForPageToLoad(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	public void maximizeWindow(WebDriver driver) {
		driver.manage().window().maximize();
	}

	public void switchToWindow(WebDriver driver,String partialURL) {

		Set<String> windows1 = driver.getWindowHandles();
		Iterator<String> iterator1 = windows1.iterator();
		while(iterator1.hasNext()) {
			String windowID1 = iterator1.next();
			driver.switchTo().window(windowID1);

			String actURL = driver.getCurrentUrl();
			if(actURL.contains(partialURL)) {

				break;
			}
		}
	}
	public void mouseHoverAction(WebDriver driver,WebElement element) {
		Actions actions = new Actions(driver);
		actions.moveToElement(element).perform();
		
	}
	public void toTakeScreenShotEntirePage(WebDriver driver) throws IOException{
		TakesScreenshot tks = (TakesScreenshot)driver;
		File temp = tks.getScreenshotAs(OutputType.FILE);
		File src = new File("./screenShot/entirePage.png");
		FileHandler.copy(temp, src);
		}
	
	public void toTakeScreenShotofWebElement(WebDriver driver,WebElement element) throws Throwable {
		File temp = element.getScreenshotAs(OutputType.FILE);
		File src = new File("./screenShot/element.png");
		FileHandler.copy(temp, src);
			
	}
	public void toHandleAlertPopup(WebDriver driver) {
		Alert alert = driver.switchTo().alert();
		alert.accept();
}
	
	public void toScrollIntoView(WebDriver driver,WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
	
		js.executeScript("arguments[0].scrollIntoView(false)",element); 	
		
	}
	public void toClickElementUsingJSE(WebDriver driver,WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();",element);
		
	}
	
	public void selectByVisibleTextDropDown(WebElement element,String text) {
		Select sel1 = new Select(element);
		sel1.selectByVisibleText(text);

	}
	
	public void navigateToPage(WebDriver driver,String text1,String text2) {
		driver.findElement(By.linkText(text1)).click();
		driver.findElement(By.xpath("//img[@title='"+text2+"']")).click();
	}
	
	public void assertion(String expData,String actData) {
		boolean b = actData.contains(expData);
		System.out.println(actData+" "+expData);
		SoftAssert sa = new SoftAssert();
		sa.assertTrue(b);
		sa.assertAll();
		
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
