package com.scenarios;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateCampaignAndChooseProduct {
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
		  System.out.println("=========chrome is launch================"); }
		  else if
		  (browser.equalsIgnoreCase("firefox")) {
		  WebDriverManager.firefoxdriver().setup(); driver =new FirefoxDriver();
		  System.out.println("=========FirefoxDriver is launch================"); }
		  else {
		  System.out.println("=========correcr browser is launch================"); }
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		  WebDriverWait wai=new WebDriverWait(driver,10);
		  driver.get(url); 
		  driver.findElement(By.name("user_name")).sendKeys(username);
		  driver.findElement(By.name("user_password")).sendKeys(password);
		  driver.findElement(By.id("submitButton")).click();
		 
		
		    String filepath1="E:\\Client\\Book1.xlsx";
			FileInputStream fin1=new FileInputStream(filepath1);
			Workbook wb=WorkbookFactory.create(fin1);
			Sheet sheet=wb.getSheet("Sheet1");
			Row row=sheet.getRow(1);
		       //getting the cell value from rowNumber and cell Number
		    String org = row.getCell(0).getStringCellValue();
		    String campaign=row.getCell(0).getStringCellValue();
		Thread.sleep(10000);
		Actions action=new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//img[@src=\"themes/softed/images/menuDnArrow.gif\"]"))).perform();
		driver.findElement(By.xpath("//a[@name='Campaigns']")).click();
		driver.findElement(By.xpath("//img[@title='Create Campaign...']")).click();
		driver.findElement(By.name("campaignname")).sendKeys(campaign);
		
		String parent = driver.getWindowHandle();
		driver.findElement(By.xpath("//img[@title=\"Select\"]")).click();
		Set<String> allwindows = driver.getWindowHandles();
		
		Iterator<String>it=allwindows.iterator();
		while(it.hasNext()) {
			String win_id=it.next();
			driver.switchTo().window(win_id);
			if (driver.getTitle().contains("Accounts")) {
			break;	
			}
		}
		driver.findElement(By.name("search_text")).sendKeys(org);
		driver.findElement(By.name("search")).click();
		driver.findElement(By.xpath("//a[text()='tyss47']")).click();
		
		driver.switchTo().window(parent);
		  driver.findElement(By.xpath("//input[@title=\"Save [Alt+S]\"]")).click();
		
		  action.moveToElement(driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]"))).perform();
		  driver.findElement(By.linkText("Sign Out")).click();
		  driver.quit();
		// WebDriverUtility wu=new WebDriverUtility();
		  //wu
	}

}
