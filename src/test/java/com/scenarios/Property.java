package com.scenarios;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;
import practice.ExcelLib;

public class Property {
	public static void main(String[] args) throws IOException {
		String filepath="./src/main/resources/common_data/properties.properties";
		FileInputStream fin=new FileInputStream(filepath);
		Properties pro=new Properties();
		pro.load(fin);
		String url=pro.getProperty("url");
		String username=pro.getProperty("username");
		String password=pro.getProperty("password");
		String browser=pro.getProperty("browser");
		WebDriver driver=null;
		Random rm=new Random();
		int num=rm.nextInt(100);
		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver =new ChromeDriver();
			System.out.println("=========chrome is launch================");
		}
		else if (browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver =new FirefoxDriver();
			System.out.println("=========FirefoxDriver is launch================");
		}
		else {
			System.out.println("=========correcr browser is launch================");
		}
		driver.manage().window().maximize();
		driver.get(url);
		driver.findElement(By.name("user_name")).sendKeys(username);
		driver.findElement(By.name("user_password")).sendKeys(password);
		driver.findElement(By.id("submitButton")).click();
		
		System.out.println("======================================================");
		
		
		ExcelLib lib=new ExcelLib();
		String org=lib.getOrgname("Sheet1",1,0);
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.xpath("//img[@src=\"themes/softed/images/btnL3Add.gif\"]")).click();
		driver.findElement(By.xpath("//input[@name=\"accountname\"]")).sendKeys(org+rm);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		//String name=driver.findElement(By.className("dvHeaderText")).getText();
		/*
		 * if (name.contains(org+rm)) {
		 * System.out.println("Pass:organization is created"+": : "+org); } else {
		 * System.out.println("Fail:organization is not created"+" : :"+org); }
		 * 
		 * System.out.println("=====================================");
		 */
		
		  String product=lib.getCellDataProduct("Sheet1",1,1);
		  driver.findElement(By.linkText("Products")).click();
		  
		  driver.findElement(By.xpath("//img[@title='Create Product...']")).click();
		  driver.findElement(By.name("productname")).sendKeys(product+rm);
		  driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		  String productname=driver.findElement(By.className("lvtHeaderText")).getText();
		if(productname.contains(product+rm)) {
		  System.out.println("Pass:productname is created"+": : "+product+rm); } else {
		  System.out.println("Fail:productname is not created"+" : :"+product+rm); }
		 
		Actions actions=new Actions(driver);
		actions.moveToElement(driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]"))).perform();
		driver.findElement(By.linkText("Sign Out")).click();
		
		driver.quit();
		
	}

}
