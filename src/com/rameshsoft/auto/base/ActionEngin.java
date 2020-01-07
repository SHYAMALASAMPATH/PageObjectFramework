package com.rameshsoft.auto.base;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.time.Duration;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
 
abstract public class ActionEngin extends BaseEngin{

	private static WebElement webelement;
	private static List<WebElement> webelements;
	
	public String enterURL(String url, String how) {
		if(how.equals("driver")) {
			getDriver().get(url);
		}else if(how.equalsIgnoreCase("navigate")) {
			getDriver().navigate().to(url);
		}
		return how;
	}
		
	
	public static WebElement identifyElement(String locMech,String locValue) {
			
		switch (locMech) {
		case "id":
			webelement= getDriver().findElement(By.id(locValue));
			checkElementVisibility(webelement);
			break;
		case "name":
			webelement= getDriver().findElement(By.name(locValue));
			checkElementVisibility(webelement);
			break;
		case "classname":
			webelement= getDriver().findElement(By.className(locValue));
			checkElementVisibility(webelement);
			break;
		case "css":
			webelement= getDriver().findElement(By.cssSelector(locValue));
			checkElementVisibility(webelement);
			break;
		case "xpath":
			webelement= getDriver().findElement(By.xpath(locValue));
			checkElementVisibility(webelement);
			break;
		case "linktext":
			webelement= getDriver().findElement(By.linkText(locValue));
			checkElementVisibility(webelement);
			break;
		case "partiallinktext":
			webelement= getDriver().findElement(By.partialLinkText(locValue));
			checkElementVisibility(webelement);
			break;
		case "tagname":
			webelement= getDriver().findElement(By.tagName(locValue));
			checkElementVisibility(webelement);
			break;
			
		default:
			System.out.println("LOCATOR IS NOT FOUND IN THE WEBPAGE");
			break;
		}
		return webelement;
	}

	public static List<WebElement> identifyElements(String locMech,String locValue) {
			
		switch (locMech) {
		case "id":
			webelements= getDriver().findElements(By.id(locValue));
			checkElementVisibility(webelements);
			break;
		case "name":
			webelements= getDriver().findElements(By.name(locValue));
			checkElementVisibility(webelements);
			break;
		case "classname":
			webelements= getDriver().findElements(By.className(locValue));
			checkElementVisibility(webelements);
			break;
		case "css":
			webelements= getDriver().findElements(By.cssSelector(locValue));
			checkElementVisibility(webelements);
			break;
		case "xpath":
			webelements= getDriver().findElements(By.xpath(locValue));
			checkElementVisibility(webelements);
			break;
		case "linktext":
			webelements= getDriver().findElements(By.linkText(locValue));
			checkElementVisibility(webelements);
			break;
		case "partiallinktext":
			webelements= getDriver().findElements(By.partialLinkText(locValue));
			checkElementVisibility(webelements);
			break;
		case "tagname":
			webelements= getDriver().findElements(By.tagName(locValue));
			checkElementVisibility(webelements);
			break;
			
		default:
			System.out.println("LOCATOR IS NOT FOUND IN THE WEBPAGE");
			break;
		}
		return webelements;
	}
	
	
	public static void enterData(String locMech,String locValue,String testdata) {
		webelement = identifyElement(locMech, locValue);
		webelement.sendKeys(testdata);
	}
	
	public static void click(String locMech,String locValue,String clickType) {
		 Actions actions = new  Actions(getDriver());
	    webelement = identifyElement(locMech, locValue);
		if(clickType.equalsIgnoreCase("Webelement")) {
			webelement.click();
		}else if(clickType.equalsIgnoreCase("single")) {
		actions.click(webelement).build().perform();
		}else if(clickType.equalsIgnoreCase("double")) {
			actions.doubleClick(webelement).build().perform();
		}else if(clickType.equalsIgnoreCase("keyboard")) {
			actions.sendKeys(webelement,Keys.ENTER).build().perform();
		}
     }
	
	public static void mouseHoverActions(String locMech,String locValue ) {
		 Actions actions = new  Actions(getDriver());
		webelement = identifyElement(locMech, locValue);
		actions.moveToElement(webelement).perform();;	
	}
	
	public static void mouseHoverActions(WebElement element ) {
		 Actions actions = new  Actions(getDriver());
		actions.moveToElement(element).perform();;	
	}
	
	
	public static void click(String locMech,String locValue) {
		 webelement = identifyElement(locMech, locValue);
		 webelement.click();
	}
	
	public static void closeCurrentBrowser() {
		getDriver().close();
	}
	public static void closeAllBrowser() {
		getDriver().quit();
	}
	
	
	public static boolean checkElementVisibility(WebElement webelement) {
		Boolean status = (webelement.isDisplayed()&& webelement.isEnabled())?true:false;
		return status;
	}
	
	private static Boolean checkElementVisibility(List<WebElement>  webelements) {
		Boolean status = true;
		for(WebElement webelement : webelements) {
			 status = (webelement.isDisplayed()&& webelement.isEnabled())?true:false;
		}
		return status;
	}
	
	public void getSystemHost(){
		
		try {
			InetAddress ia = Inet4Address.getLocalHost();
		
			System.out.println(ia.getHostName());
			System.out.println(ia.getHostAddress());
			System.out.println(System.getProperty("os.name"));
			System.out.println(System.getProperty("os.arch"));
			
		} catch (UnknownHostException e) {
			
			e.printStackTrace();
		}
		
	}
	
	public static boolean checkInURL(String valueToCheck) {
		boolean isValFound = false;
		
		try{
			
			String curURL = getDriver().getCurrentUrl();
			
			isValFound = curURL.toLowerCase().contains(valueToCheck.toLowerCase());
			
		} catch (WebDriverException wde){
			System.out.println("Error while verifying the url. Exception message captured is :  " + wde.getMessage());
			Assert.assertTrue(false, "Unable to verify the url as webdriver exception found.");
		}
		
		return isValFound;
	}
	
	 public static WebElement waitForElement(By by,int timeToWait){
    	 WebElement element = null;
    	 try{
    		 WebDriverWait wait = new WebDriverWait(getDriver(), timeToWait);
    		 wait.pollingEvery(Duration.ofMillis(200));
    		 wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
    		 
    	 }catch(Exception e ){
    		 System.out.println("Element :"+by.toString()+" is not found even after waiting for" +timeToWait+ "secands:");
    		 
    	 }
    	 
    	 return element;
     }
	

	public static void  checkErrorMessage(By by, String errorMessage) {
		
		if(errorMessage.isEmpty()) {
			WebElement errorElement = waitForElement(by, 1);
			
			if(errorElement==null) {
				System.out.println("passed: error message is not populated.");
			}else {
				System.out.println("failed: error message is populated.");
			}
		}else {			
			WebElement errorElement = waitForElement(by, 1);			
			if(errorElement==null) {
				System.out.println("failed : is not populated");
			}else {
				String actualMessage = errorElement.getText();
				if(actualMessage.trim().equals(errorMessage)) {
					System.out.println("passed:error message is populated .");
				}else {
					System.out.println("failed: error message is populated.");
					Assert.assertEquals(actualMessage, errorMessage);
				}
			}
		}
		
		
	}	
 }
