package com.rameshsoft.auto.scripts;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.rameshsoft.auto.base.ActionEngin;
import com.rameshsoft.auto.base.BaseEngin;
import com.rameshsoft.auto.listeners.ReRunFailedTestCases;
import com.rameshsoft.auto.pageobjectmodel.FlipKart_Mobile_Page;
import com.rameshsoft.auto.supporters.PropertiesUtilities;
import com.rameshsoft.auto.utilities.PojoSupporters;
import com.relevantcodes.extentreports.ExtentTest;

public class GmailTest extends ActionEngin{
	
	@Test
	public void FbTest() {
		getDriver().get(getConfigData().getPropertyValue("Home_url"));
        getDriver().findElement(By.xpath("//button[@class='_2AkmmA _29YdH8']")).click();
		FlipKart_Mobile_Page.getMoveMI();
		FlipKart_Mobile_Page.getMiMobile();
	}
	
	

	public  void gmailLoginTest() throws IOException {
		
		getDriver().get(getConfigData().getPropertyValue("url"));
	    enterData("id", getObjRep().getPropertyValue
	    		      ("un_name"), getExcelData().getSingleData("PRUDVI2", 3, 2));
	    click("xpath", getObjRep().getPropertyValue("next_button"));
	    
	    enterData("name", getObjRep().getPropertyValue
	    		           ("gm_pwdN"), getExcelData().getSingleData("PRUDVI2", 3, 3));
	 
	    click("xpath", getObjRep().getPropertyValue("pwd_next"));
	}
	
}
