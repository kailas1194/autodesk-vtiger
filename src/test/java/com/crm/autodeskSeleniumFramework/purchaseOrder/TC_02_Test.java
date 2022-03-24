package com.crm.autodeskSeleniumFramework.purchaseOrder;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.crm.autodeskSeleniumFramework.javaUtility.ExcelUtility;
import com.crm.autodeskSeleniumFramework.javaUtility.PropertyUtility;
import com.crm.autodeskSeleniumFramework.javaUtility.WebDriverUtility;
import com.crm.vtiger.leadRepository.HomePage;
import com.crm.vtiger.leadRepository.LoginPage;
import com.crm.vtiger.purchaseOrderRepository.CreateNew_PurchaseOrder_Page;
import com.crm.vtiger.purchaseOrderRepository.Purchase_Order_Page;
import com.crm.vtiger.purchaseOrderRepository.VerifyPurchaseOrderPage;
import com.crm.vtiger.purchaseOrderRepository.Verify_Create_New_PrchaseOrderPage;
/**
 * this script is used to create a purchase order with the vendor name
 * @author CHAVAN
 *
 */
public class TC_02_Test {
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
		 
		 /**
		  * create new vendor
		  */
		 String vendorname=eu.getDataFromExcel("Sheet3",1,1);
		CreateVendor_Page newVendor = new CreateVendor_Page(driver);
		 newVendor.createVendor(driver, vendorname);
		 
		 /**
		  * navigate to more options and click on purchase order link 
		  */
		    hp.mouseHoverAndClickpurchaseOrder(driver);
		    
		    /**
		     * verify purchase order page is displayed
		     */
		    VerifyPurchaseOrderPage purchase=new VerifyPurchaseOrderPage(driver);
		    String actualPurchaseOrderTitle=purchase.getTitleAndVerifyPurchaseOrderPage(driver);
		    String expectedPurchaseOrderTitle=eu.getDataFromExcel("Sheet3", 3, 0);
		    if (actualPurchaseOrderTitle.contains(expectedPurchaseOrderTitle)) 
		    {
			System.out.println("PASS :: purchase order page displayed");	
			}
		    else {

				System.out.println("FAIL :: purchase order page is not displayed");	
				}
		    
		    /**
		     * this step is used to click on create new purchase order icon
		     */
		    Purchase_Order_Page purchaseOrderPage=new Purchase_Order_Page(driver);
		    purchaseOrderPage.createPurchaseOrderIcon(driver);
		    
		    /**
			 * verify the create new purchase order page is displayed
			 */

Verify_Create_New_PrchaseOrderPage create=new Verify_Create_New_PrchaseOrderPage(driver);
String actualTitle=create.createPurchaseOrder(driver);
String expectedCreatePurchaseTitle=eu.getDataFromExcel("Sheet3", 3, 0);
if (actualTitle.contains(expectedCreatePurchaseTitle)) 
{
System.out.println("PASS:: create new Purchase Order page displayed.");	
}
else 
{
		System.out.println("PASS:: create new Purchase Order page displayed.");	
}
create.createPurchaseOrder(driver);

/**
 * create purchase order and select vendor
 */
CreateNew_PurchaseOrder_Page createpurchase=new CreateNew_PurchaseOrder_Page(driver);
String purchasesubject=eu.getDataFromExcel("Sheet3", 1,2 );
String address=eu.getDataFromExcel("Sheet3", 1,3 );
String vendors=eu.getDataFromExcel("Sheet3", 1,4 );
String qty=eu.getDataFromExcel("Sheet3", 1,5 );
String line=eu.getDataFromExcel("Sheet3", 1,6 );

createpurchase.CreatePurchaseOrder(driver, purchasesubject, vendorname);


		    














/**
		     * logout from the Vtiger application
		     */
			/*
			 * Vtiger_LogOutPage logoutObj=new Vtiger_LogOutPage(driver);
			 * logoutObj.mouseHoverAndClickOnSignOut(driver);
			 */
 
		    /**
		     * close the browser 
		     */
		 //driver.quit();
}	 
}

