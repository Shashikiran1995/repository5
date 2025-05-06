package com.tp.vTiger.generic.ListenerUtility;

import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.tp.vTiger.generic.BaseClassTest.BaseClass;
import com.tp.vTiger.generic.WebDriverUtility.UtilityClassObject;

public class ListenerImplementation implements ITestListener,ISuiteListener{
	ExtentReports report;
	ExtentTest test;

	public void onStart(ISuite suite) {

		String time = new Date().toString().replace(" ", "_").replace(":", "_");
		ExtentSparkReporter spark = new ExtentSparkReporter("./ExtentReport/Report" + "_"+time);
		spark.config().setTheme(Theme.DARK);
		spark.config().setDocumentTitle("VtigerReports");
		spark.config().setReportName("Gowsalya");

		// system configure
		report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("OS", "Windows");
		report.setSystemInfo("executedBy", "Gowsalya");
		report.setSystemInfo("Browser", "Chrome");


	}

	public void onFinish(ISuite suite) {
		report.flush();

	}

	public void onTestStart(ITestResult result) {
		test = report.createTest(result.getMethod().getMethodName());
		UtilityClassObject.setTest(test);
		test.log(Status.INFO, result.getMethod().getMethodName()+"====start====");


	}

	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, result.getMethod().getMethodName()+"====success====");

	}

	public void onTestFailure(ITestResult result) {
		test.log(Status.FAIL, result.getMethod().getMethodName()+"====fail====");

		String testName = result.getMethod().getMethodName();
		test.log(Status.INFO, testName);
		String time = new Date().toString().replace(" ", "_").replace(":", "_");
		TakesScreenshot tks =  (TakesScreenshot)(BaseClass.sdriver);
		String srcFile = tks.getScreenshotAs(OutputType.BASE64);
		test.addScreenCaptureFromBase64String(srcFile,testName+"_"+time);

	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onStart(ITestContext context) {
	}

	public void onFinish(ITestContext context) {

	}

}
