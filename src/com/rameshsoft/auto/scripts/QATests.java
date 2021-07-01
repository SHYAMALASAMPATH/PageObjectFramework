package com.rameshsoft.auto.scripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class QATests {

	static RemoteWebDriver driver;
	
	public static void main(String[] args) {
		
		
		 driver = new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		 driver.get("https://test.salesforce.com/");
		 driver.findElement(By.id("username")).sendKeys("caynan.braydin@iillii.org");
		 driver.findElement(By.id("password")).sendKeys("Password2!");
		 driver.findElement(By.id("Login")).click();
		 driver.findElement(By.xpath("//button[@title='Navigation']")).click(); 
		 
		 try{
			 driver.findElement(By.xpath("//div[16]//a[1]//div[2]")).click();
		 }
		 catch(StaleElementReferenceException e){
			 driver.findElement(By.xpath("//div[16]//a[1]//div[2]")).click();   
		 }
		 
		 //driver.findElement(By.xpath("//*[contains(@class,'slds-button__icon ee-button__icon action-c')]")).click();
		 try{
			 //WebElement ele = driver.findElement(By.xpath("//*[contains(@class,'slds-button__icon ee-button__icon action-c')]"));
			 //driver.executeScript("arguments[0]).click();",ele);
			driver.findElement(By.xpath("//button[contains(@class,'slds-button "
					+ "slds-button--icon-border-filled action-control__button action-control--square')]")).click();
		}
		 catch(StaleElementReferenceException e){
			 //WebElement ele = driver.findElement(By.xpath("//*[contains(@class,'slds-button__icon ee-button__icon action-c')]"));
			 //driver.executeScript("arguments[0]).click();",ele);
			 driver.findElement(By.xpath("//button[contains(@class,'slds-button slds-button--icon-border"
			 		+ "       -filled action-control__button action-control--square')]")).click();
			 }
		 
		
		 //driver.findElement(By.linkText("Divisions")).click();
		                                                            //WebElement ele=driver.findElement(By.xpath("//a[contains(text(),'Divisions')]"));
		   //driver.executeScript("arguments[0]).click();",ele);
		   //driver.findElement(By.xpath("//div[text()='Appliance']")).click();
	}
		
		
	}
	
