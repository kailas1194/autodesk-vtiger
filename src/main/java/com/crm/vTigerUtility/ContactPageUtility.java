package com.crm.vTigerUtility;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crm.autodeskSeleniumFramework.javaUtility.ExcelUtility;

import com.crm.autodeskSeleniumFramework.javaUtility.JavaUtility;

/**
 * 
 * @author kailas
 *
 */
public class ContactPageUtility {
	
	public void createContact(WebDriver driver) throws EncryptedDocumentException, IOException {
		ExcelUtility eu=new ExcelUtility();
		JavaUtility ju=new JavaUtility();
		int num=ju.getRandomNumber();
		String org=eu.getDataFromExcel("Sheet1",1,0);
		String industry=eu.getDataFromExcel("Sheet1",1,0);
		
		driver.findElement(By.xpath("//input[@name=\"accountname\"]")).sendKeys(org+num);
		
		WebElement dropdown = driver.findElement(By.name("industry"));
		
		
		 driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
			
		 
		 WebDriverWait wait=new WebDriverWait(driver,20);
		 wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.linkText("Contacts"))));
		 
		 //navigate to organization
	String lastname=eu.getDataFromExcel("Sheet2",1,1);
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
	}
}
