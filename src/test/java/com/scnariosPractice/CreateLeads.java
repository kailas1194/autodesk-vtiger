package com.scnariosPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateLeads {
	WebDriver driver=null;
public  String newLead(String name) {
	WebDriverManager.chromedriver().setup();
	driver=new ChromeDriver();
	driver.findElement(By.linkText("Leads")).click();
	driver.findElement(By.xpath("//img[@title=\"Create Lead...\"]")).click();
	
	return name;
	
	
}
}
