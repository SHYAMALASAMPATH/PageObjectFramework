package com.rameshsoft.auto.utilities;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;

import com.rameshsoft.auto.base.BaseEngin;

public interface ScreenShotUtility {
	
	public static String screenShot() throws IOException {
		File file =BaseEngin.getDriver().getScreenshotAs(OutputType.FILE);
		 String imagePath = BaseEngin.getCurDir()+"\\ScreenShots\\"+BaseEngin.getTcName()+
	                                        System.currentTimeMillis()+".jpeg";
		 FileUtils.copyFile(file, new File(imagePath));
		 System.out.println("The Current Test case is failed : "+BaseEngin.getTcName());
		return imagePath;
	}

}
