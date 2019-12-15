package com.rameshsoft.auto.utilities;

import java.io.File;
import java.io.IOException;
import java.util.Base64;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;

import com.rameshsoft.auto.base.BaseEngin;

public interface TakeScreenshot {
	
	public static void screenShot() throws IOException {
		 File file =BaseEngin.getDriver().getScreenshotAs(OutputType.FILE);
		 FileUtils.copyFile(file, new File
				 (BaseEngin.getCurDir()+"\\Screenshots\\"+BaseEngin.getTcName()+
						                   System.currentTimeMillis()+".jpeg"));
		 System.out.println("The Current Test case is failled : "+BaseEngin.getTcName());
	
	}
	
}
