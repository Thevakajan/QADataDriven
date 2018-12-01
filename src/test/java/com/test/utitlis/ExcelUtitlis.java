package com.test.utitlis;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtitlis {
	
	static	String projectPath;
	static XSSFWorkbook workbook;
	static XSSFSheet sheet;
	
	public ExcelUtitlis(String excelPath,String sheeName) {
		try {
		
		 workbook = new XSSFWorkbook(excelPath);
		sheet = workbook.getSheet(sheeName);
		}
		catch(Exception e) {
			
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		getRowCount();
		 getCellDataString(0,0);
		 getCellDataNumber(1,1);
	}
	public static int getRowCount() {
		int rowCount=0;
		try {

			
			rowCount  =sheet.getPhysicalNumberOfRows();
			System.out.println("No of rows: "+rowCount);
		}
		
		catch(Exception exp) {
			System.out.println(exp.getMessage());
			System.out.println(exp.getCause());
			exp.printStackTrace();
		}
		return rowCount;
	}
	public static int getColCount() {
		int colCount=0;
		try {		
			 colCount  = sheet.getRow(0).getPhysicalNumberOfCells();
			System.out.println("No of Colms: "+colCount);
		}
		catch(Exception exp) {
			System.out.println(exp.getMessage());
			System.out.println(exp.getCause());
			exp.printStackTrace();
		}
		return colCount;
	}
	public static  String getCellDataString(int rowNum,int colNum) {
		String cellData=null;
		try {
			
			cellData= sheet.getRow(rowNum).getCell(colNum).getStringCellValue();
			System.out.println(cellData);
		}
		catch(Exception exp) {
			System.out.println(exp.getMessage());
			System.out.println(exp.getCause());
			exp.printStackTrace();
		}
		return cellData;
	}
	
	public static void getCellDataNumber(int rowNum ,int colNum) {
		try {
			 
			double cellData= sheet.getRow(1).getCell(1).getNumericCellValue();
			System.out.println(cellData);
		}
		catch(Exception exp) {
			System.out.println(exp.getMessage());
			System.out.println(exp.getCause());
			exp.printStackTrace();
		}
	}

}
