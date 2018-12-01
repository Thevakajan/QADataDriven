package com.test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtendReportBasicDemo {
	private static WebDriver driver;
	public static void main(String[] args) {
		
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("extentReports.html");
		
		// create ExtentReports and attach reporter(s)
        ExtentReports extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
     // creates a toggle for the given test, adds all log events under it    
        ExtentTest test1 = extent.createTest("Google Search MyFirstTest", "this is test to validate google search functionalitiy");
        
        String projectPath = System.getProperty("user.dir");
		System.out.println("projectpath"+projectPath);
		  System.setProperty("webdriver.chrome.driver","D:/Selanium/chromedriver_win32_3/chromedriver.exe ");
		  driver = new ChromeDriver();
		  
		  test1.log(Status.INFO, "String Test Cash");
		  driver.get("https://opensource-demo.orangehrmlive.com/");
		  test1.pass("Navigate to google.com");
		  driver.findElement(By.name("txtUsername")).sendKeys("Admin");
		  test1.pass("Enter The UestName");
		  driver.findElement(By.name("txtPassword")).sendKeys("admin123");
		  test1.pass("Enter The Passwword");
		  driver.findElement(By.id("btnLogin")).click();
     	  test1.pass("Perss Login Button ");
//     	  driver.findElement(By.id("welcome")).click();
//     	  driver.findElement(By.linkText("Logout")).click();
//     	 test1.pass("Logout Dashboard ");
		  driver.close();
		  driver.quit();
		  test1.pass("close google.com");
		  test1.info("Test Completed");
		  
		  
		// creates a toggle for the given test, adds all log events under it    
	        ExtentTest test2 = extent.createTest("Google Search MyFirstTest", "this is test to validate google search functionalitiy");
	        
	       
			System.out.println("projectpath"+projectPath);
			  System.setProperty("webdriver.chrome.driver","D:/Selanium/chromedriver_win32_3/chromedriver.exe ");
			  driver = new ChromeDriver();
			  
			  test2.log(Status.INFO, "String Test Cash");
			  driver.get("https://opensource-demo.orangehrmlive.com/");
			  test2.pass("Navigate to google.com");
			  driver.findElement(By.name("txtUsername")).sendKeys("Admin");
			  test2.pass("Enter The UestName");
			  driver.findElement(By.name("txtPassword")).sendKeys("admin123");
			  test2.pass("Enter The Passwword");
			  driver.findElement(By.id("btnLogin")).click();
	     	  test2.fail("Perss Login Button ");
//	     	  driver.findElement(By.id("welcome")).click();
//	     	  driver.findElement(By.linkText("Logout")).click();
//	     	 test1.pass("Logout Dashboard ");
			  driver.close();
			  driver.quit();
			  test2.pass("close google.com");
			  test2.info("Test Completed");
		  
		// calling flush writes everything to the log file
	        extent.flush();
	}

}
