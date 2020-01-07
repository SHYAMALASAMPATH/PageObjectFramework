package com.rameshsoft.auto.listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import com.rameshsoft.auto.base.BaseEngin;
import com.relevantcodes.extentreports.LogStatus;

public class ReRunFailedTestCases implements IRetryAnalyzer {

	int retryCount = 0;
	int maxRetryCount=3;
	
	@Override
	public boolean retry(ITestResult result) {
		
		if(ITestResult.FAILURE==result.getStatus()&&retryCount<=maxRetryCount) {
			try {
				Thread.sleep(5000);
				BaseEngin.getExtentTest().log(LogStatus.INFO, "Count is :"+retryCount+ "Executing TC is :"+result.getName());
				retryCount++;
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		return true;
	}
}
