package com.rameshsoft.auto.base;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.rameshsoft.auto.supporters.PropertiesUtilities;
import com.rameshsoft.auto.testdata.ExcelReader;
import com.rameshsoft.auto.utilities.PojoSupporters;
import com.rameshsoft.auto.utilities.TakeScreenshot;

public class BaseEngin  {
	
	static private RemoteWebDriver driver;
	static private String tcName ;
	static private String curDir = System.getProperty("user.dir");
	static private ExcelReader excelData ;
	static private PropertiesUtilities configData,objRep;;
	
	
	@Parameters("browser")
	@BeforeSuite
	static public void openBrowser(@Optional("chrome")String browser) throws IOException {
		
		excelData  = PojoSupporters.getExcelData();
		configData = PojoSupporters.getConfigData();
		   objRep  = PojoSupporters.getObjRepo();
		
		
		if(browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
			DriverIniti();
		}
		else if(browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
			
			DriverIniti();
		}
		else if(browser.equalsIgnoreCase("IE")) {
			driver = new InternetExplorerDriver();
			DriverIniti();
		}
	}
	
	public static ExcelReader getExcelData() {
		return excelData;
	}

	public static PropertiesUtilities getConfigData() {
		return configData;
	}

	public static PropertiesUtilities getObjRep() {
		return objRep;
	}

	/**
	 * The  Method will do driver initializations 
	 */
	static private void DriverIniti() {
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	/**Author : 
	 * The annotated method will be run After all tests in this suite
	 */
	/*@AfterSuite
	public void closeBrowser() {
		java.util.Optional<RemoteWebDriver> op = java.util.Optional.ofNullable(driver);
		if(op.isPresent()) {
			driver.close();
			System.out.println("Driver is Close:: "+op);
		}else {
			System.out.println("Driver is Empty ::"+op);
		}
	}
*/
	public static RemoteWebDriver getDriver() {
		return driver;
	}
	
	public static String getTcName() {
		return tcName;
	}

	public static String getCurDir() {
		return curDir;
	}
	
	@BeforeMethod
	public void beforeMethod(Method method) {
		tcName = method.getName();
		System.out.println("Current method is :"+getTcName());
	}

	/*@AfterMethod
	public void aftermethod(ITestResult result) throws IOException {
	if(result.getStatus()==ITestResult.SUCCESS) {
		System.out.println("The Current test case is :"+getTcName());
		
	}else if(result.getStatus()==ITestResult.FAILURE) {
		TakeScreenshot.screenShot();
		System.out.println("Current test case is:: "+result.getThrowable());
	}else if(result.getStatus()==ITestResult.SKIP) {
		TakeScreenshot.screenShot();
		System.out.println("Current test case is:: "+result.getThrowable());
	}
  }*/
	
	
	
}
