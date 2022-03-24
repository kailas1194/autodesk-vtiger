package com.crm.vTigerScenarios28;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.crm.autodeskSeleniumFramework.javaUtility.ExcelUtility;
import com.crm.autodeskSeleniumFramework.javaUtility.JavaUtility;
import com.crm.autodeskSeleniumFramework.javaUtility.PropertyUtility;
import com.crm.autodeskSeleniumFramework.javaUtility.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Create_Contact_Choose_Organization {
	public static void main(String[] args) throws Exception {
		WebDriverUtility wd = new WebDriverUtility();
		ExcelUtility eu = new ExcelUtility();
		JavaUtility ju = new JavaUtility();
		PropertyUtility pro = new PropertyUtility();
		String browser = pro.getPropertiesKeyValue("browser");
		String url = pro.getPropertiesKeyValue("url");
		String username = pro.getPropertiesKeyValue("username");
		String password = pro.getPropertiesKeyValue("password");

		/*
		 * To launch browser with help of properties file.
		 */
		WebDriver driver = null;
		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			System.out.println("=========chrome is launch================");
		} else if (browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			System.out.println("=========FirefoxDriver is launch================");
		} else {
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
		int num = ju.getRandomNumber();
		String org = eu.getDataFromExcel("Sheet1", 1, 0);
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.xpath("//img[@src=\"themes/softed/images/btnL3Add.gif\"]")).click();
		driver.findElement(By.xpath("//input[@name=\"accountname\"]")).sendKeys(org + num);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

		
		/*
		 * verify organization is created
		 */
		  String HeaderText =driver.findElement(By.className("dvHeaderText")).getText();
		  if (HeaderText.contains(org+num)) {
		  System.out.println(org+num+" is verified == PASS"); } 
		  else
		  { System.out.println(org+num+" is NOT verified == FAIL"); }
		  
		  
		/*
		 * create contact
		 */
		String lastname=eu.getDataFromExcel("Sheet1",1,7);
		
		WebElement contact = driver.findElement(By.linkText("Contacts"));
				wd.waitForElementVisibility(driver, contact);
				contact.click();
		  driver.findElement(By.xpath("//img[@title=\"Create Contact...\"]")).click();
		  driver.findElement(By.name("lastname")).sendKeys(lastname+num);
		  driver.findElement(By.xpath("//input[@name=\"account_id\"]/following-sibling::img[@src=\"themes/softed/images/select.gif\"]")).click();
		Set<String> set = driver.getWindowHandles();

		Iterator<String> it = set.iterator();
		while (it.hasNext()) {
			String windowid = it.next();
			driver.switchTo().window(windowid);
			if (driver.getTitle().contains("Accounts")) {
				break;
			}
		}
		driver.findElement(By.id("Search_txt")).sendKeys(org);
		driver.findElement(By.xpath("//input[@name=\"search\"]")).click();
		driver.findElement(By.xpath("//a[text()='" + org + "']")).click();

		Set<String> set1 = driver.getWindowHandles();
		Iterator<String> it1 = set1.iterator();
		while (it1.hasNext()) {
			String windowid = it1.next();
			driver.switchTo().window(windowid);
			if (driver.getTitle().contains("Contacts")) {
				break;
			}
		}

		
		  driver.findElement(By.xpath("//input[@title=\"Save [Alt+S]\"]")).click();
		 
	
		  
		  /*
		   * 
		   */
		  
		  
		  
		  
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
}
