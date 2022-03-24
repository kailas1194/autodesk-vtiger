package com.crm.vTigerUtility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.crm.autodeskSeleniumFramework.javaUtility.WebDriverUtility;

public class VtigerLogOutUtility {
public void vtiger_logOut(WebDriver driver) throws InterruptedException {
	Actions actions=new Actions(driver);
	WebDriverUtility waitforlogout=new WebDriverUtility();
	WebElement logout = driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]"));
   waitforlogout.waitAndClick(logout);
	actions.moveToElement(driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]"))).perform();
	driver.findElement(By.linkText("Sign Out")).click();

}

}