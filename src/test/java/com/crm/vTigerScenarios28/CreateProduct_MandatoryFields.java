package com.crm.vTigerScenarios28;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import com.crm.autodeskSeleniumFramework.javaUtility.ExcelUtility;
import com.crm.autodeskSeleniumFramework.javaUtility.JavaUtility;
import com.crm.autodeskSeleniumFramework.javaUtility.PropertyUtility;
import com.crm.autodeskSeleniumFramework.javaUtility.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateProduct_MandatoryFields {
	
	public static void main(String[] args) throws EncryptedDocumentException, IOException, InterruptedException {
		WebDriverUtility wd=new WebDriverUtility();
		ExcelUtility eu=new ExcelUtility();
		JavaUtility ju=new JavaUtility();
		PropertyUtility pro=new PropertyUtility();
		String browser = pro.getPropertiesKeyValue("browser");
		String url = pro.getPropertiesKeyValue("url");
		String username = pro.getPropertiesKeyValue("username");
		String password = pro.getPropertiesKeyValue("password");
		
		/*
		 * To launch browser with help of properties file. 
		 */
		WebDriver driver=null;{
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
		/*
		 * step 1:login to Vtiger Application
		 */
		wd.implicitWait(driver);
		driver.get(url);
		driver.manage().window().maximize();
		driver.get(url);
		driver.findElement(By.name("user_name")).sendKeys(username);
		driver.findElement(By.name("user_password")).sendKeys(password);
		driver.findElement(By.id("submitButton")).click();
		
		/*
		 * navigate to product 
		 */
		String productname=eu.getDataFromExcel("Sheet1",1,2);
		driver.findElement(By.linkText("Products")).click();
		driver.findElement(By.xpath("//img[@title=\"Create Product...\"]")).click();
		driver.findElement(By.name("productname")).sendKeys(productname);
		
		driver.findElement(By.xpath("//input[@title=\"Save [Alt+S]\"]")).click();
		
		 /*
		  *  logout from vtiger application
		  */
		  
		  
		  Actions actions=new Actions(driver);
		  WebElement logout =
		  driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]"));
		  wd.waitAndClick(logout); 
		  actions.moveToElement(driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]"))).perform();
		  driver.findElement(By.linkText("Sign Out")).click();
		 

		/*
		 * close the browser and stop the server
		 */

		driver.quit();

	}
	}}
