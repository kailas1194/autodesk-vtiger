package com.crm.vTigerScenarios28;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.crm.autodeskSeleniumFramework.javaUtility.ExcelUtility;
import com.crm.autodeskSeleniumFramework.javaUtility.JavaUtility;
import com.crm.autodeskSeleniumFramework.javaUtility.PropertyUtility;
import com.crm.autodeskSeleniumFramework.javaUtility.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateOrg_UsingUtility {
	public static void main(String[] args) throws Exception {
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
		 * step 2:navigate to organization
		 */
		int num=ju.getRandomNumber();
		String org=eu.getDataFromExcel("Sheet1",1,0);
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.xpath("//img[@src=\"themes/softed/images/btnL3Add.gif\"]")).click();
		driver.findElement(By.xpath("//input[@name=\"accountname\"]")).sendKeys(org+num);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		
		/*
		 * verify organization is created
		 */
		  String HeaderText =driver.findElement(By.className("dvHeaderText")).getText();;
		//wd.waitForElementVisibility(driver, HeaderText);
		//HeaderText.getText();
		
		
		
		  if (HeaderText.contains(org+num)) {
		  System.out.println(org+num+" is verified == PASS"); } 
		  else
		  { System.out.println(org+num+" is NOT verified == FAIL"); }
		 
		/*
		 * close the browser and stop the server
		 */
		
		driver.quit();
		
	}
}
