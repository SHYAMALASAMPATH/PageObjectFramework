package com.rameshsoft.auto.utilities;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


public class ExteendTest1 {
	static WebDriver driver;
	static String reportPath = "G:\\SELENIUM\\new selenium\\Framework7AMP\\Reports\\ttt.html";
	
	
	
	public static void main(String[] args) {

		
		ExtentReports extentReports = new ExtentReports(reportPath);
		
		ExtentTest extentTest = extentReports.startTest("Hello");
		
		
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https:\\www.gmail.com/");
		String str = driver.getTitle();
		System.out.println(str);
		Assert.assertEquals(str, "Gmail");
		extentTest.log(LogStatus.INFO, "login successfull");
		extentReports.endTest(extentTest);
		extentReports.flush();
		extentReports.close();
		
		//driver.quit();
		
   }
	
}
