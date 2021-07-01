package com.rameshsoft.auto.pageobjectmodel;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.rameshsoft.auto.base.ActionEngin;

public class FlipKart_Mobile_Page extends ActionEngin{
	
	@FindBy(xpath="//span[text()='Electronics']")
	private static WebElement MoveMI;
	
	public static void getMoveMI() {
		Actions actions = new  Actions(getDriver());
		waitForElement(MoveMI, 5);
		checkElementVisibility(MoveMI);
		actions.moveToElement(MoveMI).build().perform();
	}
	
	@FindBy(xpath="(//ul[@class='QPOmNK']/child::li/following-sibling::li/a[@title='Mi' and text()='Mi'])[1]")
	private static WebElement miMobile ;
	
	public static void getMiMobile() {
		waitForElement(miMobile, 5);
		checkElementVisibility(miMobile);
		miMobile.click();
	}

	
	static {
		PageFactory.initElements(getDriver(),FlipKart_Mobile_Page.class );
	 }
}
