package com.rameshsoft.auto.scripts;

import java.io.IOException;
import java.util.List;

import org.testng.annotations.Test;

import com.rameshsoft.auto.base.ActionEngin;
import com.rameshsoft.auto.base.BaseEngin;
import com.rameshsoft.auto.supporters.PropertiesUtilities;
import com.rameshsoft.auto.utilities.ExteendTest1;
import com.relevantcodes.extentreports.ExtentTest;

public class GmailTest extends ActionEngin{
	
	@Test
	public static void gmailLoginTest() throws IOException {
		
		getDriver().get(getConfigData().getPropertyValue("url"));
		
	    enterData("id", getObjRep().getPropertyValue
	    		      ("un_name"), getExcelData().getSingleData("PRUDVI2", 3, 2));
	    
	    click("xpath", getObjRep().getPropertyValue("next_button"));
	    
	    enterData("name", getObjRep().getPropertyValue
	    		           ("gm_pwdN"), getExcelData().getSingleData("PRUDVI2", 3, 3));
	
	    click("xpath", getObjRep().getPropertyValue("pwd_next"));
	
	
	}
}
