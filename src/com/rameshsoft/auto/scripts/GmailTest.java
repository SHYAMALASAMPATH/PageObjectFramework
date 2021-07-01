package com.rameshsoft.auto.scripts;

import org.testng.annotations.Test;
import com.rameshsoft.auto.base.ActionEngin;

public class GmailTest extends ActionEngin {
	
	@Test//(retryAnalyzer=ReRunFailedTestCases.class)
	public static void Testcase1() {
		//System.out.println("Testcase is passed:");
		//enterURL("http://testsite.com/","navigate");
		getDriver().get(getConfigData().getPropertyValue("url"));
	
	}
}
