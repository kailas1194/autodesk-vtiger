package com.crm.autodeskSeleniumFramework.leads;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.crm.autodeskSeleniumFramework.javaUtility.ExcelUtility;
import com.crm.autodeskSeleniumFramework.javaUtility.JavaUtility;
import com.crm.autodeskSeleniumFramework.javaUtility.PropertyUtility;
import com.crm.autodeskSeleniumFramework.javaUtility.WebDriverUtility;
import com.crm.vtiger.leadRepository.Capture_UniqueLeadNo_Page;
import com.crm.vtiger.leadRepository.CreateLead_FillAllDetailsPage;
import com.crm.vtiger.leadRepository.HomePage;
import com.crm.vtiger.leadRepository.LeadsPage;
import com.crm.vtiger.leadRepository.LoginPage;
import com.crm.vtiger.leadRepository.Verify_uniqueLead_isCreatedPage;
import com.crm.vtiger.leadRepository.Vtiger_LogOutPage;

public class Tl_03_Test {

public static void main(String[] args) throws Throwable {
		
		PropertyUtility pro=new PropertyUtility();
		WebDriverUtility wd=new WebDriverUtility();
		ExcelUtility eu=new ExcelUtility();
		WebDriver driver=new ChromeDriver();
		JavaUtility ju=new JavaUtility();
		wd.maximizeTheWindow(driver);
		wd.implicitWait(driver);
		String username=pro.getPropertiesKeyValue("username");
		String password=pro.getPropertiesKeyValue("password");
		String url=pro.getPropertiesKeyValue("url");
	  
		int num = ju.getRandomNumber();
		int num1 = ju.getRandomNumber();
		LoginPage lp=new LoginPage(driver);
		/**
		 * navigate to application
		 */
		driver.get(url);
		
		 /**
	     * this step is used to verify the login page of vtiger is displayed.
	     */
		 String title=lp.vtigerLoginTitle(driver);
		 String loginPageTitle=eu.getDataFromExcel("Sheet2", 1, 1);
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
		 String homePageTitle=eu.getDataFromExcel("Sheet2",2,1);
		
		 if (actualhomeTitle.contains(homePageTitle)) {
		    	System.out.println("PASS :: home page is displayed");	
			}
		    else
		    	{
			    	System.out.println("FAIL :: home page not is displayed");	
				}
		 
		 /**
		     * click on "Lead" and navigate to "Leads" page
		     */
			
			hp.leadslink();
			
			/**
			 * verify leads page is displayed.
			 */
			LeadsPage leads=new LeadsPage(driver);
			String actualLeadsTitle=leads.titleOfLeadsPage(driver);
			String leadsPageTitle=eu.getDataFromExcel("Sheet2", 3, 1);
			 if (actualLeadsTitle.contains(leadsPageTitle)) {
			    	System.out.println("PASS :: leads page is displayed");	
				}
			    else
			    	{
				    	System.out.println("FAIL :: leads page not is displayed");	
			
			    	}
			 
			 /**
			  * click on create new lead icon 
			  */
			 LeadsPage LeadsPage=new LeadsPage(driver);
			 LeadsPage.clickOnCreateLeadsIcon();
			
			 /**
			  * fill all required details in field
			  */
			 String lastname=eu.getDataFromExcel("Sheet2", 1, 2)+num;
			 String companyname=eu.getDataFromExcel("Sheet2", 2, 3)+num1;
			 CreateLead_FillAllDetailsPage newLeadDetails=new CreateLead_FillAllDetailsPage(driver);
			 newLeadDetails.createNewLeadFields(driver, lastname, companyname);
			
			 /**
			  * verify lead number is unique.
			  */
			 Capture_UniqueLeadNo_Page leadnum=new Capture_UniqueLeadNo_Page(driver);
			String uniqueLead=leadnum.actualUniqueLeadNumber(driver);
			hp.leadslink();
			
			Verify_uniqueLead_isCreatedPage leadlistpage=new Verify_uniqueLead_isCreatedPage(driver);
			List<WebElement> expectedlead=leadlistpage.verifyleadisPresentInList(driver);
			
			for ( WebElement  ele: expectedlead) {
				
				if (expectedlead.contains(uniqueLead)) 
				{
					System.out.println("unique lead is created ::"+uniqueLead);
				}
				else 
				{
					System.out.println("unique lead is not created ::"+ele.getText());	
				}
				
				
			}
			
		
		 /**
		  * logout from the Vtiger application.
		  */
			
			  Vtiger_LogOutPage logout=new Vtiger_LogOutPage(driver);
			  logout.mouseHoverAndClickOnSignOut(driver); 
			  driver.quit();
			 
}}

