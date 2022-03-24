package com.crm.autodeskSeleniumFramework.testNgAnnotation;


import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.crm.autodeskSeleniumFramework.javaUtility.BaseClass;
import com.crm.vtiger.contactRepository.Vtiger_LogOutPage;
import com.crm.vtiger.leadRepository.HomePage;
import com.crm.vtiger.organizationRepository.ChooseIndustryPage;
import com.crm.vtiger.organizationRepository.ClickOn_CreateOrganizationIcon_Page;
import com.crm.vtiger.organizationRepository.ClickOn_NewOrg_SaveButtonPage;
import com.crm.vtiger.organizationRepository.Create_NewOrganization_Fillup_Page;

public class CreateOrganizationWithIndustryTest extends BaseClass{
	
	@Test
	public void createOrganization() throws Throwable {
		HomePage hp=new HomePage(driver);
		hp.OrganizationsLink();
        int num = ju.getRandomNumber();
		SoftAssert soft=new SoftAssert();
		
		ClickOn_CreateOrganizationIcon_Page newOrgIcon=new ClickOn_CreateOrganizationIcon_Page(driver);
		newOrgIcon.ClickOn_CreateOrganizationIcn(driver);
		

		  String orgName=eu.getDataFromExcel("Sheet1",3, 0)+num;
		  Create_NewOrganization_Fillup_Page newOrg=new Create_NewOrganization_Fillup_Page(driver);
		  newOrg.fillDetails(driver,orgName);
		  
		  ChooseIndustryPage chooseOrg=new ChooseIndustryPage(driver);
		  String industry=eu.getDataFromExcel("Sheet1",3, 5);
		  chooseOrg.industrytype(industry);
		 
		  ClickOn_NewOrg_SaveButtonPage save=new ClickOn_NewOrg_SaveButtonPage(driver);
		  save.clickOnNewSaveButton();
		  Thread.sleep(5000);
		  Vtiger_LogOutPage logOut=new Vtiger_LogOutPage(driver);
		  logOut.mouseHoverAndClickOnSignOut(driver);
	}
}
