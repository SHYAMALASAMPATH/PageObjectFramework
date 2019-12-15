package com.rameshsoft.auto.utilities;

public interface FilePaths {
	
	String excelPath = System.getProperty("user.dir")+"\\TestData\\Data.xlsx";
	String confPath  = System.getProperty("user.dir")+"\\Application.properties";
	
	String orPath    = System.getProperty("user.dir")+"\\src\\com\\rameshsoft\\auto\\objectrepository\\OR.properties";
	String txtPath   = System.getProperty("user.dir")+"";
	String csvPath   = System.getProperty("user.dir")+"";
	
	String reportPath = System.getProperty("user.dir")+"\\Reports\\report.html";
	
}
