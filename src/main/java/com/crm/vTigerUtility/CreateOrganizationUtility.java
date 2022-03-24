package com.crm.vTigerUtility;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.crm.autodeskSeleniumFramework.javaUtility.ExcelUtility;
import com.crm.autodeskSeleniumFramework.javaUtility.JavaUtility;
import com.crm.autodeskSeleniumFramework.javaUtility.WebDriverUtility;

public class CreateOrganizationUtility {

	public void createOrganization(WebDriver driver) throws EncryptedDocumentException, IOException, InterruptedException {
		//step1:navigate to organization
				driver.findElement(By.linkText("Organizations")).click();
				driver.findElement(By.xpath("//img[@title=\"Create Organization...\"]")).click();
				ExcelUtility eu=new ExcelUtility();
				JavaUtility ju=new JavaUtility();
				String org=eu.getDataFromExcel("Sheet1", 2, 0);
				int num=ju.getRandomNumber();
				driver.findElement(By.xpath("//input[@name=\"accountname\"]")).sendKeys(org+num);
				
				
		//step2:select industry type
				WebElement dropdown =driver.findElement(By.name("industry"));
				WebDriverUtility waitforlogout=new WebDriverUtility();
				  Select select=new Select(dropdown);
				  waitforlogout.waitForElementVisibility(driver, dropdown);
				  String industry=eu.getDataFromExcel("Sheet1",4,5);
				 select.selectByValue(industry);
				 
				 
		//step:3: select account type
				 WebElement accounttype=driver.findElement(By.xpath("//option[@value=\"Partner\"]"));
				 accounttype.click();
			
		//step4:click on assign to radio:: group radio button
				 driver.findElement(By.xpath("//input[@value=\"T\"]")).click();
				 
		//step5:save org
				 driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
				
				 
		//step6:verify created organization
		/*
		 * String orgname=driver.findElement(By.id("dtlview_Organization Name")).getText();
		 * if (name.contains(org+num)) {
		 * System.out.println("Pass:organization is created"+": : "+org+num); } else {
		 * System.out.println("Fail:organization is not created"+" : :"+org); }
		 * 
		 */
	}
}
