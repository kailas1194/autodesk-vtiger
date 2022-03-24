package com.crm.vTigerUtility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.crm.autodeskSeleniumFramework.javaUtility.WebDriverUtility;

public class LoginPageUtility {
	
	public void login(WebDriver driver,String vTigerurl,String username,String password) {
		WebDriverUtility wd=new WebDriverUtility();
		wd.maximizeTheWindow(driver);
		driver.get(vTigerurl);
		WebElement user=driver.findElement(By.name("user_name"));
		user.sendKeys(username);
		WebElement pass = driver.findElement(By.name("user_password"));
		pass.sendKeys(password);
		driver.findElement(By.id("submitButton")).click();
	}
}