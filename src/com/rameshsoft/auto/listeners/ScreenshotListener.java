package com.rameshsoft.auto.listeners;

import java.io.IOException;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import com.rameshsoft.auto.base.BaseEngin;
import com.rameshsoft.auto.utilities.TakeScreenshot;
import com.relevantcodes.extentreports.LogStatus;

public class ScreenshotListener extends TestListenerAdapter{
	
	@Override
	public void onTestFailure(ITestResult result) {
		
		System.out.println(" TC is FAIL :"+result.getName());
		try { 
			BaseEngin.getExtentTest().log(LogStatus.FAIL, "The test case is::"+BaseEngin.getTcName());
			BaseEngin.getExtentTest().log(LogStatus.FAIL, result.getThrowable());
			String imageSh = TakeScreenshot.screenShot();
			BaseEngin.getExtentTest().addScreenCapture(imageSh);
		} catch (IOException e) {
			e.printStackTrace();
	  }
  }

	@Override
	public void onTestSkipped(ITestResult result) {
	
     	System.out.println(" TC is SKIPPED :"+result.getName());
		try {
			BaseEngin.getExtentTest().log(LogStatus.SKIP, "The test case is::"+result.getName());
			BaseEngin.getExtentTest().log(LogStatus.SKIP, result.getThrowable());
			String imageSh = TakeScreenshot.screenShot();
			BaseEngin.getExtentTest().addScreenCapture(imageSh);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("CURRENT TC EXECUTION IS : " +result.getName());
		BaseEngin.getExtentTest().log(LogStatus.INFO, "The test case onTestStart::"+result.getName());
	}
	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("TC IS PASSED : " +result.getName());
		BaseEngin.getExtentTest().log(LogStatus.INFO, "The test case onTestSuccess::"+result.getName());
	}
	
	
	
	
}
