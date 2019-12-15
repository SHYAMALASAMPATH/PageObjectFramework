package com.rameshsoft.auto.listeners;

import java.io.IOException;

import org.testng.ITestResult;

import com.rameshsoft.auto.utilities.TakeScreenshot;

public class ScreenshotListener extends CoustomListenerAdator{
	
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
	public void onTestStart(ITestResult result) {
		System.out.println("CURRENT TC EXECUTION IS : " +result.getName());
	}
	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("TC IS PASSED : " +result.getName());
	}
	
	
	
	
}
