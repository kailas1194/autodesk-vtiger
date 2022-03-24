package com.crm.vTigerTest;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.crm.autodeskSeleniumFramework.javaUtility.PropertyUtility;
import com.crm.autodeskSeleniumFramework.javaUtility.WebDriverUtility;
import com.crm.vTigerUtility.ContactPageUtility;
import com.crm.vTigerUtility.LoginPageUtility;
import com.crm.vTigerUtility.VtigerLogOutUtility;

public class VtigerLogin_CreateContact_ChooseOrg {
	public static void main(String[] args) throws IOException, InterruptedException  {
		
		WebDriver driver=new ChromeDriver();
		LoginPageUtility login=new LoginPageUtility();
		PropertyUtility pro=new PropertyUtility();
		WebDriverUtility wd=new WebDriverUtility();
		String url=pro.getPropertiesKeyValue("url");
		String username=pro.getPropertiesKeyValue("username");
		String password=pro.getPropertiesKeyValue("password");
		
		//step1:login to Vtiger Application
		login.login(driver, url,username,password);
		
		//step:navigate to the contact 
		ContactPageUtility con=new ContactPageUtility();
		con.createContact(driver);
		
		
		//step:logout from Vtiger Application and close Browser
		VtigerLogOutUtility logout=new VtigerLogOutUtility();
		logout.vtiger_logOut(driver);
		driver.quit();
	}

}
