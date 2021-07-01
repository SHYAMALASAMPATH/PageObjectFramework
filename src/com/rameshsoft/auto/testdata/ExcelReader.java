package com.rameshsoft.auto.testdata;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.hssf.record.CellValueRecordInterface;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelReader {
	
	private static FileInputStream fip;
	private static Workbook wb;
	private static Sheet sheet;
	private static Row row;
	private static Cell cell;
	private static String cellValue;
	private static String data;
	
	public ExcelReader(String filePath) throws EncryptedDocumentException, IOException {
		
		fip = new FileInputStream(filePath);
		wb= WorkbookFactory.create(fip);
	}
	
	public Sheet getSheetFromWorkbook(String sheetName) {
		 sheet = wb.getSheet(sheetName);
		return sheet;
	}
	
	public Sheet getSheetFromWorkbook(int sheetIndex) {
		 sheet = wb.getSheetAt(sheetIndex);
		return sheet;
	}
	
	public String getSingleData(String sheetName,int rowNum,int colNum) {
		
		sheet = getSheetFromWorkbook(sheetName);
	    row = sheet.getRow(rowNum);
	    if(row!=null) {
	    	cell = row.getCell(colNum);
	    	if(cell!=null) {
	    		data = "";
			    if(cell.getCellType()==CellType.STRING) {
			    	cellValue = cell.getStringCellValue();
			    	data=cellValue;
			    }else if(cell.getCellType()== CellType.NUMERIC) {
			    	cellValue = cell.getNumericCellValue()+"";
			    	 data=cellValue;
			    }else if(cell.getCellType()== CellType.BOOLEAN) {
			    	cellValue= cell.getBooleanCellValue()+"";
			    	 data=cellValue;
			    }
			   Optional<String> op = Optional.ofNullable(cellValue);
			   if(op.isPresent()) {
				   data=cellValue;
			   }
	    	}
	    }
	    return data;
   }
	public List<String> getSheetTotalData(String sheetName){
		
		List<String> dataCell = new ArrayList<String>();
		sheet = getSheetFromWorkbook(sheetName);
		for(int rNum = 0;rNum<sheet.getLastRowNum();rNum++) {
			row = sheet.getRow(rNum);
			if(row!=null) {
				for(int colNum=0;colNum<row.getLastCellNum();colNum++) {
					cell = row.getCell(colNum);
					if(cell!=null) {
						if (cell.getCellType()==CellType.STRING) {
							cellValue = cell.getStringCellValue();
						}else if(cell.getCellType()==CellType.NUMERIC) {
							cellValue = cell.getNumericCellValue()+"";
						}else if(cell.getCellType()==CellType.BOOLEAN) {
							cellValue = cell.getBooleanCellValue()+"";
						}
					}
				}	
			}
		}	
		dataCell.add(cellValue);
		return dataCell;
	 }
	
	public List<String> getTcNames(String sheetName) {
		
		List<String> cellData = new ArrayList<String>();
		sheet = getSheetFromWorkbook(sheetName);
		 for(int rNum=1;rNum<sheet.getLastRowNum()+1;rNum++) {
			row = sheet.getRow(rNum);
			if(row!=null){
				for(int colNum=0;colNum<=0;colNum++) {
					cell = row.getCell(colNum);
					if(cell!=null) {
						if(cell.getCellType()==CellType.STRING) {
							cellValue = cell.getStringCellValue();
							cellData.add(cellValue);
						}else if(cell.getCellType()==CellType.NUMERIC) {
							cellValue = cell.getNumericCellValue()+"";
							cellData.add(cellValue);
						}else if(cell.getCellType()==CellType.BOOLEAN) {
							cellValue = cell.getBooleanCellValue()+"";
							cellData.add(cellValue);
						}
					}
				}	
			  }
			}

		return cellData;
	}
	
	public List<String>  getHeaders(String sheetName) {	
		List<String> headerData = new ArrayList<String>();
		sheet = getSheetFromWorkbook(sheetName);
		for(int rNum=0;rNum<=0;rNum++) {
		   row = sheet.getRow(rNum);
		   if(row!=null) {
			   for(int colNum=0;colNum<row.getLastCellNum();colNum++) {
					cell = row.getCell(colNum);
					if(cell!= null) {
						if(cell.getCellType()==CellType.STRING) {
							cellValue =	cell.getStringCellValue();
							   headerData.add(cellValue);
							}else if(cell.getCellType()==CellType.NUMERIC) {
								cellValue =cell.getNumericCellValue()+"";
								 headerData.add(cellValue);
							}else if(cell.getCellType()==CellType.BOOLEAN) {
								cellValue = cell.getBooleanCellValue()+"";
								 headerData.add(cellValue);
							}
						 }
					}
		         }
		 
	          }
		        return headerData;
          }
	
	public Set<String> getTotalUniqueSheetData(String sheetName) {
		List<String> data = getSheetTotalData(sheetName);
		Set<String> uniqueData = new LinkedHashSet<String>();
		return uniqueData;
	}
	
	public List<String> getSingleRowData(String sheetName,int rowNum) {
		List<String> rowData = new ArrayList<String>();
		sheet = getSheetFromWorkbook(sheetName);
		row = sheet.getRow(rowNum);
		if(row!=null) {
			for(int rNum=0;rNum<row.getLastCellNum();rNum++){
				cell = row.getCell(rNum);
				if(cell!=null) {
					if (cell.getCellType() == CellType.NUMERIC) {
						cellValue = cell.getNumericCellValue()+"";
						rowData.add(cellValue);
					}
					else if (cell.getCellType() == CellType.STRING) {
						cellValue = cell.getStringCellValue();
						rowData.add(cellValue);
				   }
				}
			}		
		}
		return rowData;
	 }
	
     public Map<String, String> getTcData(String sheetName,String tcName) {
		Map<String, String> tcData = new LinkedHashMap<String,String>();
	     List<String> headers = getHeaders(sheetName);
	     List<String> tcNames = getTcNames(sheetName);
	     List<String> matchTcData = null;
	     int rowMatch=1 ;
	     for(String str : tcNames) {
	    	if(str.equalsIgnoreCase(tcName)) {
	    		matchTcData = getSingleRowData(sheetName, rowMatch);
	    		for(int tcMatch = 1;tcMatch<headers.size();tcMatch++) {
		    		tcData.put(headers.get(tcMatch),matchTcData.get(tcMatch));	
		    	}
	    		break;
	    	}
	    	rowMatch++;
	   }
		return tcData;
   }
	/*public static void main(String[] args) throws EncryptedDocumentException, IOException {
		ExcelReader ex = new ExcelReader
				 ("G:\\SELENIUM\\new selenium\\Framework7AMP\\TestData\\Data.xlsx");
		
		List<String> list  = ex.getTcNames("Book");
		System.out.println(list);
		
		//System.out.println(ex.getTcData("PRUDVI2", "gmailTest"));
		List headers = ex.getHeaders("PRUDVI2");
		System.out.println(headers);
	}
	*/
	

}
