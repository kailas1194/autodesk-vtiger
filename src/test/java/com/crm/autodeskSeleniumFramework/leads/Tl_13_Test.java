package com.crm.autodeskSeleniumFramework.leads;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.crm.autodeskSeleniumFramework.javaUtility.ExcelUtility;
import com.crm.autodeskSeleniumFramework.javaUtility.JavaUtility;
import com.crm.autodeskSeleniumFramework.javaUtility.PropertyUtility;
import com.crm.autodeskSeleniumFramework.javaUtility.WebDriverUtility;
import com.crm.vtiger.leadRepository.CreateLead_fillAll_valid_DetailsPage;
import com.crm.vtiger.leadRepository.HomePage;
import com.crm.vtiger.leadRepository.LeadsPage;
import com.crm.vtiger.leadRepository.LoginPage;
import com.crm.vtiger.leadRepository.Verify_CreateLeadPage;
import com.crm.vtiger.leadRepository.Vtiger_LogOutPage;

/**
 * this script is used to create a new lead by giving valid input to no.of Employee
 * @author CHAVAN
 *
 */
public class Tl_13_Test {
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
		  * click on create new leads icon
		  */
		 leads.clickOnCreateLeadsIcon();
		 
		 /**
		  * fill all required details in field
		  */
		 String lastname=eu.getDataFromExcel("Sheet2", 1, 2)+num;
		 String companyname=eu.getDataFromExcel("Sheet2", 1, 3);
		 int noOfEmployee = eu.getDataCharSequenceFromExcel("Sheet2", 1, 5);
		 CreateLead_fillAll_valid_DetailsPage newLeadDetails=new CreateLead_fillAll_valid_DetailsPage(driver);
	      newLeadDetails.createNewLeadFields(driver, lastname, companyname,noOfEmployee);
			
	      
	      /**
	       * verify the lead is created
	       */
	      Verify_CreateLeadPage verifyLead=new Verify_CreateLeadPage(driver) ;
	      String actualLead = verifyLead.verifyCreatedLead(driver);
	      if (actualLead.contains(lastname)) {
			    	System.out.println("PASS :: lead is created");	
				}
			    else
			    	{
			    	System.out.println("Fail :: lead is not created");	
					}
	     
	      /**
	       * logout from the Vtiger application
	       */
	      Vtiger_LogOutPage logout=new Vtiger_LogOutPage(driver);
	      logout.mouseHoverAndClickOnSignOut(driver);
		  driver.quit();
	}}
		