package com.rameshsoft.auto.base;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

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
		actions.moveToElement(webelement);	
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
	
	private static Boolean checkElementVisibility(WebElement webelement) {
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

 }
