package com.rameshsoft.auto.utilities;

import java.io.IOException;

import com.rameshsoft.auto.supporters.PropertiesUtilities;
import com.rameshsoft.auto.supporters.TextUtilities;
import com.rameshsoft.auto.testdata.ExcelReader;

public class PojoSupporters{
	
	private static PropertiesUtilities poConfiData,objRep;
	private static ExcelReader excelReaderPath;
	private static TextUtilities txtData;
	
	
	public static PropertiesUtilities getConfigData() throws IOException {
		 poConfiData = new PropertiesUtilities(FilePaths.confPath);
	return 	poConfiData;
	}

	public static ExcelReader getExcelData() throws IOException {
		 excelReaderPath = new ExcelReader(FilePaths.excelPath);
	return 	excelReaderPath;
	}

	public static PropertiesUtilities getObjRepo() throws IOException {
		 objRep = new PropertiesUtilities(FilePaths.orPath);
	return 	objRep;
	}
	
	public static TextUtilities getTxtData() throws IOException{
		txtData = new TextUtilities(FilePaths.txtPath);
		return txtData;
		
	}
	
}
