package com.tp.vTiger.generic.ListenerUtility;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyserImp implements IRetryAnalyzer {

	int count=0, retryLimit=1;
	public boolean retry(ITestResult result) {
		if(count<retryLimit) {
			count++;
			return true;
		}
	return false;
	}
}
