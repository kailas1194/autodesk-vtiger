package com.scenarios;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;
import practice.ExcelLib;

public class Vtiger_CreateaProduct {
	
	
	
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
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get(url);
		driver.findElement(By.name("user_name")).sendKeys(username);
		driver.findElement(By.name("user_password")).sendKeys(password);
		driver.findElement(By.id("submitButton")).click();
		
		System.out.println("======================================================");
		
		
		ExcelLib lib=new ExcelLib();
		String org=lib.getOrgname("Sheet1",1,0);
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.xpath("//img[@src=\"themes/softed/images/btnL3Add.gif\"]")).click();
		driver.findElement(By.xpath("//input[@name=\"accountname\"]")).sendKeys(org+num);
		
		
		
		
		 
		   WebElement dropdown = driver.findElement(By.name("industry"));
		  Select select=new Select(dropdown);
		  Thread.sleep(1000);
		 select.selectByVisibleText("Healthcare");
		 System.out.println("======industry type is healthcare selected==========");
		 driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		 String name=driver.findElement(By.id("dtlview_Organization Name")).getText();
		 if (name.contains(org+num)) {
			  System.out.println("Pass:organization is created"+": : "+org+num); } 
			  else {
			  System.out.println("Fail:organization is not created"+" : :"+org); }
		System.out.println("==================org is created===================");
		Actions actions=new Actions(driver);
		actions.moveToElement(driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]"))).perform();
		driver.findElement(By.linkText("Sign Out")).click();
		
		driver.quit();
		
	}

}
