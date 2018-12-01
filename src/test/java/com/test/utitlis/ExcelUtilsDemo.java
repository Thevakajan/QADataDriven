package com.test.utitlis;

public class ExcelUtilsDemo {
	public static void main(String[] args) {
		String projectPath =	System.getProperty("user.dir");
		ExcelUtitlis excel = new ExcelUtitlis(projectPath+"/excel/data.xlsx","Sheet1");
		excel.getRowCount();
		excel.getCellDataString(0, 0);
		excel.getCellDataNumber(1, 1);
	}

}
