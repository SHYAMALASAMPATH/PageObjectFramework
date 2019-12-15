package com.rameshsoft.auto.listeners;

import java.io.IOException;
import org.testng.ITestContext;
import org.testng.ITestResult;
import com.rameshsoft.auto.utilities.TakeScreenshot;

public class TcTrackingListener extends ScreenshotListener {

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("CURRENT TC EXECUTION IS : " +result.getName());
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("TC IS PASSED : " +result.getName());
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println(" TC is FAIL :"+result.getName());

		try {
			TakeScreenshot.screenShot();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println(" TC is SKIPPED :"+result.getName());

		try {
			TakeScreenshot.screenShot();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void onStart(ITestContext context) {
		System.out.println("SUITE EXECUTION IS STARTED");
   }

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("SUITE EXECUTION IS ENDED");
		
	}
	
}
