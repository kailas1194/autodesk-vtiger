package com.crm.autodeskSeleniumFramework.testNgAnnotation;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.crm.autodeskSeleniumFramework.javaUtility.BaseClass;
import com.crm.autodeskSeleniumFramework.javaUtility.JavaUtility;
import com.crm.vtiger.leadRepository.CreateLead_FillAllDetailsPage;
import com.crm.vtiger.leadRepository.HomePage;
import com.crm.vtiger.leadRepository.LeadsPage;
import com.crm.vtiger.leadRepository.Vtiger_LogOutPage;

public class Tl_12 extends BaseClass {

	@Test
	public void createOrganization() throws Throwable {
		HomePage hp=new HomePage(driver);
		JavaUtility ju=new JavaUtility();
		int num = ju.getRandomNumber();
		SoftAssert soft=new SoftAssert();
		
		String actualhomeTitle=hp.homePagetitle(driver);
	    String homePageTitle=eu.getDataFromExcel("Sheet2",2,1);
		 
	    
		 Assert.assertEquals(actualhomeTitle.contains(homePageTitle),true);
		 soft.assertEquals(actualhomeTitle.contains(homePageTitle),true);
		
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
		 
		 Assert.assertEquals(actualLeadsTitle.contains(leadsPageTitle),true);
		 soft.assertEquals(actualLeadsTitle.contains(leadsPageTitle),true);
		 
		 /**
		  * click on create new leads icon
		  */
		 leads.clickOnCreateLeadsIcon();
		 
		 /**
		  * fill all required details in field
		  */
		 String lastname=eu.getDataFromExcel("Sheet2", 1, 2)+num;
		 String companyname=eu.getDataFromExcel("Sheet2", 1, 3)+num;
		 String annualrevenue=eu.getDataFromExcel("Sheet2", 1, 4);
		 
		 CreateLead_FillAllDetailsPage newLeadDetails=new CreateLead_FillAllDetailsPage(driver);
		 newLeadDetails.createNewLeadFields(driver, lastname, companyname, annualrevenue);
		
		 /**
		  * logout from the Vtiger application.
		  */
			
			/*
			 * Vtiger_LogOutPage logout=new Vtiger_LogOutPage(driver);
			 * logout.mouseHoverAndClickOnSignOut(driver); driver.quit();
			 */
	}}