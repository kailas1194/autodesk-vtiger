package com.scenarios;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import practice.ExcelLib;

public class CreateProduct {
	public static void main(String[] args) throws IOException, InterruptedException {
		
		Random rm=new Random();
		int num=rm.nextInt(100);
		
		String filepath="./src/main/resources/common_data/properties.properties";
		FileInputStream fin=new FileInputStream(filepath);
		Properties pro=new Properties();
		pro.load(fin);
		String url=pro.getProperty("url");
		String username=pro.getProperty("username");
		String password=pro.getProperty("password");
		String browser=pro.getProperty("browser");
		WebDriver driver=null;
	
		
		
		
		  if (browser.equalsIgnoreCase("chrome")) {
		  WebDriverManager.chromedriver().setup(); driver =new ChromeDriver();
		  System.out.println("=========chrome is launch================"); } else if
		  (browser.equalsIgnoreCase("firefox")) {
		  WebDriverManager.firefoxdriver().setup(); driver =new FirefoxDriver();
		  System.out.println("=========FirefoxDriver is launch================"); }
		  else {
		  System.out.println("=========correcr browser is launch================"); }
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		  driver.get(url); driver.findElement(By.name("user_name")).sendKeys(username);
		  driver.findElement(By.name("user_password")).sendKeys(password);
		  driver.findElement(By.id("submitButton")).click();
		  
		  System.out.println("======================================================");
		 
		
		ExcelLib lib=new ExcelLib();
		String productname=lib.getProduct("Sheet2",1,1);
		driver.findElement(By.linkText("Products")).click();
	
		driver.findElement(By.xpath("//img[@title=\"Create Product...\"]")).click();
		driver.findElement(By.name("productname")).sendKeys(productname);
		
		driver.findElement(By.xpath("//input[@title=\"Save [Alt+S]\"]")).click();
		
	    driver.quit();
		 
		
	}

}
