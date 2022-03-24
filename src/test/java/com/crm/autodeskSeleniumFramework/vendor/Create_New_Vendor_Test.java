package com.crm.autodeskSeleniumFramework.vendor;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.crm.autodeskSeleniumFramework.javaUtility.ExcelUtility;
import com.crm.autodeskSeleniumFramework.javaUtility.PropertyUtility;
import com.crm.autodeskSeleniumFramework.javaUtility.WebDriverUtility;
import com.crm.vtiger.leadRepository.HomePage;
import com.crm.vtiger.leadRepository.LoginPage;
import com.crm.vtiger.vendorRepository.CreateVendor_Page;
import com.crm.vtiger.vendorRepository.Verify_VendorPage_Dispayed_Page;

public class Create_New_Vendor_Test {

	public static void main(String[] args) throws Throwable {
		
		/**
		 * object of pre-required libraries.  
		 */
			PropertyUtility pro=new PropertyUtility();
			WebDriverUtility wd=new WebDriverUtility();
			ExcelUtility eu=new ExcelUtility();
			WebDriver driver=new ChromeDriver();
			wd.maximizeTheWindow(driver);
			wd.implicitWait(driver);
			String username=pro.getPropertiesKeyValue("username");
			String password=pro.getPropertiesKeyValue("password");
			String url=pro.getPropertiesKeyValue("url");
			
			
			/**
			 * navigate to application
			 */
			LoginPage lp=new LoginPage(driver);
			driver.get(url);
			
			 /**
		     * this step is used to verify the login page of vtiger is displayed.
		     */
			 String title=lp.vtigerLoginTitle(driver);
			 String loginPageTitle=eu.getDataFromExcel("Sheet3", 1, 0);
		    if (title.contains(loginPageTitle)) {
		    	System.out.println("PASS :: login page is displayed");	
			}
		    else
		    	{
			    	System.out.println("FAIL :: login page is not displayed");	
				}
		    
			/**
			 * login to vtiger application
			 */
			
			lp.login(username, password);
		   
			/**
			 * verify vtiger home page is displayed
			 */
		   	HomePage hp=new HomePage(driver);
			String actualhomeTitle=hp.homePagetitle(driver);
			 String homePageTitle=eu.getDataFromExcel("Sheet3",2,0);
			
			 if (actualhomeTitle.contains(homePageTitle)) {
			    	System.out.println("PASS :: home page is displayed");	
				}
			    else
			    	{
				    	System.out.println("FAIL :: home page not is displayed");	
			    	}
			 
			 /**
			  * navigate to more options and click on vendor link 
			  */
			 hp.clickMoreLinkandClickVendor(driver);
			 Verify_VendorPage_Dispayed_Page title1=new Verify_VendorPage_Dispayed_Page(driver);
					
			 /*verify vendors  page is displayed*/
			 String vtitle=title1.vendorPageTitle(driver);
					String expectedvendorsTitle=eu.getDataFromExcel("Sheet3",1,7);
					 if (vtitle.contains(expectedvendorsTitle))
							 {
						 System.out.println("PASS::vendors page is displayed");
							}
					 else
				    	{
					    	System.out.println("FAIL:: vendor page is not displayed");
				    	}
					 CreateVendor_Page newVendor=new CreateVendor_Page(driver);
					 newVendor.createVendor(driver, expectedvendorsTitle);
}}
