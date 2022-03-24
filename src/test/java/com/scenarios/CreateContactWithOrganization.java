package com.scenarios;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;
import practice.ExcelLib;

public class CreateContactWithOrganization {
	public static void main(String[] args) throws IOException, InterruptedException {
		//create a random number
		Random rm=new Random();
		int num=rm.nextInt(100);
		
		//read the data from properties file.
		String filepath="./src/main/resources/common_data/properties.properties";
		FileInputStream fin=new FileInputStream(filepath);
		Properties pro=new Properties();
		pro.load(fin);
		String url=pro.getProperty("url");
		String username=pro.getProperty("username");
		String password=pro.getProperty("password");
		String browser=pro.getProperty("browser");
		WebDriver driver=null;
		
		//verify the launching browser
		  if (browser.equalsIgnoreCase("chrome")) {
		  WebDriverManager.chromedriver().setup(); driver =new ChromeDriver();
		  System.out.println("=========chrome is launch================"); } else if
		  (browser.equalsIgnoreCase("firefox")) {
		  WebDriverManager.firefoxdriver().setup(); driver =new FirefoxDriver();
		  System.out.println("=========FirefoxDriver is launch================"); }
		  else {
		  System.out.println("=========correcr browser is launch================"); }
		  
		  //login to Vtiger application
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		  driver.get(url); driver.findElement(By.name("user_name")).sendKeys(username);
		  driver.findElement(By.name("user_password")).sendKeys(password);
		  driver.findElement(By.id("submitButton")).click();
		  
		  System.out.println("======================================================");
		 
		  //navigate to organization
		  driver.findElement(By.linkText("Organizations")).click();
		  
		  //navigate to create organizations page
		  driver.findElement(By.xpath("//img[@title='Create Organization...']")).click(); 
		  
		  //
		//step3:create new org
		    ExcelLib lib=new ExcelLib();
			String org=lib.getOrgname("Sheet1",1,0);
			String industry=lib.getOrgname("Sheet1",1,0);
			driver.findElement(By.xpath("//input[@name=\"accountname\"]")).sendKeys(org+num);
			
			WebElement dropdown = driver.findElement(By.name("industry"));
			
			
			 driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
				
			 
			 WebDriverWait wait=new WebDriverWait(driver,20);
			 wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.linkText("Contacts"))));
			 
			 //navigate to organization
		String lastname=lib.getLast("Sheet2",1,1);
		  driver.findElement(By.linkText("Contacts")).click();
		  
		  //navigate to create contact page
		  driver.findElement(By.xpath("//img[@title=\"Create Contact...\"]")).click();
		  
		  //create new contact
		  driver.findElement(By.name("lastname")).sendKeys(lastname+num);
		driver.findElement(By.xpath("//input[@name='account_name']/following-sibling::img")).click();
		
		 Set<String> set = driver.getWindowHandles();
		 
		 
		 Iterator<String>it=set.iterator();
		 while (it.hasNext()) {
			String windowid=it.next();
			driver.switchTo().window(windowid);
			if (driver.getTitle().contains("Accounts")) {
				break;
			}	
		}
		 driver.findElement(By.id("Search_txt")).sendKeys(org+num);
		 driver.findElement(By.xpath("//input[@name=\"search\"]")).click();
		 driver.findElement(By.xpath("//a[text()='"+org+num+"']")).click();
		 
		 Set<String> set1 = driver.getWindowHandles();
		 Iterator<String>it1=set1.iterator();
		 while (it1.hasNext()) {
			String windowid = it1.next();
			driver.switchTo().window(windowid);
			if (driver.getTitle().contains("Contacts")) {
				break;
			}
		}
		 driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();	 

		 WebElement admin=driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]"));
		admin.click();
		 Actions actions=new Actions(driver);
		WebElement signout = driver.findElement(By.linkText("Sign Out"));
			actions.moveToElement(signout).perform();
			driver.findElement(By.linkText("Sign Out")).click();
			
			driver.quit();
	}

}
