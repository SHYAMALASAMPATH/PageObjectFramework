package com.rameshsoft.auto.base;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import org.apache.poi.xssf.model.Themes;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.markuputils.ExtentColor;
import com.rameshsoft.auto.supporters.PropertiesUtilities;
import com.rameshsoft.auto.testdata.ExcelReader;
import com.rameshsoft.auto.utilities.FilePaths;
import com.rameshsoft.auto.utilities.PojoSupporters;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
public class BaseEngin  {
	
	private static RemoteWebDriver driver;
	private static String tcName ;
	private static String curDir = System.getProperty("user.dir");
	private static ExcelReader excelData ;
	private static PropertiesUtilities configData,objRep;
	private static ExtentReports extent;
	private static ExtentTest extentTest;
	
	@Parameters("browser")
	@BeforeSuite
	static public void openBrowser(@Optional("chrome")String browser) throws IOException {
		
		excelData  = PojoSupporters.getExcelData();
		configData = PojoSupporters.getConfigData();
		   objRep  = PojoSupporters.getObjRepo();
		   
		if(browser.equalsIgnoreCase("chrome")){
			ChromeOptions co = new ChromeOptions();
			co.addArguments("disable-infobars");
			co.addArguments("--start-maximized");
            co.addArguments("--disable-web-security","--new-window","--ignore-certificate-errors","--disable-extensions");
			HashMap<String, Object> prefs = new HashMap<String, Object>();
			prefs.put("credentials_enable_service", false);
			prefs.put("profile.password_manager_enabled", false);
			co.setExperimentalOption("prefs", prefs);
			co.setCapability(CapabilityType.ForSeleniumServer.ENSURING_CLEAN_SESSION, true);
			driver = new ChromeDriver(co);
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
	public static ExtentTest getExtentTest() {
		return extentTest;
	}
	public static ExtentReports getExtent() {
		return extent;
	}
	
	@BeforeTest
	public void initextnt() {
		extent = new ExtentReports(FilePaths.reportPath);
		extent.addSystemInfo("Release Name", "Release 21");
		extent.addSystemInfo("Cycle Name", "Cycle 1");
		extent.addSystemInfo("IP Address", "192.168.137.1");
		//extentTest.log(LogStatus.INFO, "FilePaths.reportPath: "+FilePaths.reportPath);
		//System.out.println("FilePaths.reportPath: "+FilePaths.reportPath);
		
	}
	
	@BeforeMethod
	public void startRepo(Method method) {
		tcName = method.getName();
		System.out.println("Current method is :"+tcName);
		extentTest = extent.startTest(tcName);
		extentTest.log(LogStatus.PASS, "test case pass");
		extentTest.log(LogStatus.INFO, "information");
		//extentTest.log(LogStatus.FAIL, "test case fail");
	}

	@AfterTest
	public void endReport() {
		extent.flush();
		extent.endTest(extentTest);
		extent.close();
		
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
	}*/

	public static RemoteWebDriver getDriver() {
		return driver;
	}
	
	public static String getTcName() {
		return tcName;
	}

	public static String getCurDir() {
		return curDir;
	}
	/*
	@AfterMethod
	public void aftermethod(ITestResult result) throws IOException {
	if(result.getStatus()==ITestResult.SUCCESS) {
		//System.out.println("The Current test case is :"+getTcName()+ExtentColor.GREEN);
		extentTest.log(LogStatus.PASS, "The Current test case is "+tcName+ExtentColor.GREEN);
		
	}else if(result.getStatus()==ITestResult.FAILURE) {
		System.out.println("The test case is:: "+result.getThrowable()+ExtentColor.RED);
		extentTest.log(LogStatus.FAIL, "The test case is::"+tcName+ExtentColor.RED);
		extentTest.log(LogStatus.FAIL, result.getThrowable());
		String imageSh = TakeScreenshot.screenShot();
		extentTest.addScreenCapture(imageSh);
		
	}else if(result.getStatus()==ITestResult.SKIP) {
		System.out.println("Current test case is:: "+result.getThrowable()+ExtentColor.YELLOW);
		extentTest.log(LogStatus.SKIP, "The test case is::"+tcName+ExtentColor.YELLOW);
		extentTest.log(LogStatus.SKIP, result.getThrowable());
		String imageSh = TakeScreenshot.screenShot();
		extentTest.addScreenCapture(imageSh);
	}
   }*/
}
