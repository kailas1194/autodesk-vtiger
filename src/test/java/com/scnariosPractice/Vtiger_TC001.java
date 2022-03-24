package com.scnariosPractice;


import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
@Test(timeOut=1000)
public class Vtiger_TC001 {
	
public static void main(String[] args) throws IOException, InterruptedException {
	
		String filepath="./src/main/resources/common_data/properties.properties";
		FileInputStream fin = new FileInputStream(filepath);
		Properties pro=new Properties();
		pro.load(fin);
		String url=pro.getProperty("url");
		String username=pro.getProperty("username");
		String password=pro.getProperty("password");
		String browser=pro.getProperty("browser");
		WebDriver driver=null;
	
		  if (browser.equalsIgnoreCase("chrome")) {
		  WebDriverManager.chromedriver().setup(); driver =new ChromeDriver();
		   } 
		  else if
		  (browser.equalsIgnoreCase("firefox")) 
		  {
		  WebDriverManager.firefoxdriver().setup(); driver =new FirefoxDriver();
		  }
		  else 
		  {
		  System.out.println("=========correcr browser is launch================"); }
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		  WebDriverWait wait=new WebDriverWait(driver,20);
		  driver.get(url);
		  driver.findElement(By.name("user_name")).sendKeys(username);
		  driver.findElement(By.name("user_password")).sendKeys(password);
		  driver.findElement(By.id("submitButton")).click();
		  String homepagetitle=" Administrator - Home - vtiger CRM 5 - Commercial Open Source CRM";
		  String actualtitle=driver.getPageSource();
		  if (actualtitle.contains(homepagetitle)) 
		  {
			System.out.println("Pass :: Vtiger homepage is displayed.");
		  }
		  else 
		  {
			System.out.println("Fail :: Vtiger homepage is not displayed.");
		  }
		  
		  
}
}
