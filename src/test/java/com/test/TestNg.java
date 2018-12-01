package com.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class TestNg {
	private static WebDriver driver;
	@BeforeTest
	public  void setUpTest() {
		String projectPath = System.getProperty("user.dir");
		System.out.println("projectpath"+projectPath);
		  System.setProperty("webdriver.chrome.driver","D:/Selanium/chromedriver_win32_3/chromedriver.exe ");
		  driver = new ChromeDriver();
		  
		    
		    
		  //  driver.quit();	   
		
	}
	@Test
	 public void Search() {
		 driver.get("https://www.google.lk/");
		 driver.findElement(By.xpath("//*[@id=\"tsf\"]/div[2]/div/div[1]/div/div[1]/input")).sendKeys("theva");
		 driver.findElement(By.name("btnK")).click();
		  //  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); 
	    }
     @AfterTest 
	public void tearDownTest() {
		driver.close();
		driver.quit();
		System.out.println("Test Completed Successfully");
	}
}
