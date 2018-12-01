package com.test.utitlis;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ExcelDataProvider {
	private static WebDriver driver;
	@BeforeTest
	public  void setUpTest() {
		String projectPath = System.getProperty("user.dir");
	//	System.out.println("projectpath"+projectPath);
		  System.setProperty("webdriver.chrome.driver","D:/Selanium/chromedriver_win32_3/chromedriver.exe ");
		  driver = new ChromeDriver();
		  
		    
		    
		  //  driver.quit();	   
		
	}
	
	@Test(dataProvider="test1data")
	public void test1(String username,String password) throws Exception  {
		System.out.println(username+""+password);
		
		driver.get("https://www.facebook.com/");
		driver.findElement(By.id("email")).sendKeys(username);
		driver.findElement(By.id("pass")).sendKeys(password);
		Thread.sleep(2000);
		driver.findElement(By.id("u_0_2")).click();
	}
	@DataProvider(name = "test1data")
	public Object[][] getData() {
		String excelPath = "excel/data.xlsx";
		Object data[][]=testData(excelPath, "Sheet1");
		return data;
	}
	public static Object[][] testData(String excelPath, String SheeName) {
		ExcelUtitlis excel = new ExcelUtitlis(excelPath,SheeName);
		int rowCount = excel.getRowCount();
		int colCount = excel.getColCount();
		Object data[][] = new Object[rowCount-1][colCount];
		for(int i=1;i<rowCount;i++ ) {
			for(int j=0; j<colCount;j++) {
			String cellData =excel.getCellDataString(i,j);
			System.out.println(cellData);
			data[i-1][j]=cellData;
			}
		}
		return data;
	}

}
