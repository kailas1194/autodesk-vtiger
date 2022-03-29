package com.crm.autodeskSeleniumFramework.testNgAnnotation;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.autodeskSeleniumFramework.javaUtility.BaseClass;
import com.crm.autodeskSeleniumFramework.javaUtility.JavaUtility;
import com.crm.vtiger.contactRepository.ChooseOrgIconPage;
import com.crm.vtiger.contactRepository.ClickOnCreateNewConatctIconPage;
import com.crm.vtiger.contactRepository.CreateNewContact_FillUpPage;
import com.crm.vtiger.contactRepository.SaveContactPage;
import com.crm.vtiger.contactRepository.SendKeysToSelectOrgWindow;
import com.crm.vtiger.contactRepository.Vtiger_LogOutPage;
import com.crm.vtiger.leadRepository.HomePage;
import com.crm.vtiger.organizationRepository.ChooseIndustryPage;
import com.crm.vtiger.organizationRepository.ClickOn_CreateOrganizationIcon_Page;
import com.crm.vtiger.organizationRepository.ClickOn_NewOrg_SaveButtonPage;
import com.crm.vtiger.organizationRepository.Create_NewOrganization_Fillup_Page;
/**
 * this class is used to create contact and choose the organization 
 * @author CHAVAN
 *
 */
@Listeners (com.crm.autodeskSeleniumFramework.javaUtility.IListenerImpClass.class)
public class CreateContact_ChooseOrgTest extends BaseClass {

	@Test
	public void createOrganization() throws Throwable {
		HomePage hp=new HomePage(driver);
		JavaUtility ju=new JavaUtility();
		
		/**
		 * used to generate the random number.
		 */
		int num = ju.getRandomNumber();
		hp.OrganizationsLink();
     
		/**
		 * this is used to click on create a organization icon. 
		 */
		ClickOn_CreateOrganizationIcon_Page newOrgIcon=new ClickOn_CreateOrganizationIcon_Page(driver);
		newOrgIcon.ClickOn_CreateOrganizationIcn(driver);
		
		
		/**
		 * this is used to fill all details into the fillup page
		 */
		  String orgName=eu.getDataFromExcel("Sheet1",3, 0)+num;
		  Create_NewOrganization_Fillup_Page newOrg=new Create_NewOrganization_Fillup_Page(driver);
		  newOrg.fillDetails(driver,orgName);
		  
		  /**
		   * this is used to choose industry type
		   */
		  ChooseIndustryPage chooseOrg=new ChooseIndustryPage(driver);
		  String industry=eu.getDataFromExcel("Sheet1",3, 5);
		  chooseOrg.industrytype(industry);
		  ClickOn_NewOrg_SaveButtonPage save=new ClickOn_NewOrg_SaveButtonPage(driver);
		  save.clickOnNewSaveButton();
		  
		  Thread.sleep(5000);
		  /**
		   * this is used to click on contact link.
		   */
		hp.ContactsLink();
		/**
		 * this is used to click on create a contact icon 
		 */
	ClickOnCreateNewConatctIconPage contactIcon=new ClickOnCreateNewConatctIconPage(driver);
	contactIcon.clickOnCreateNewContactIcon();
	
	/**
	 * this is used to fill all details into the contact page
	 */
	CreateNewContact_FillUpPage fillupContact=new CreateNewContact_FillUpPage(driver);
	 String lastname=eu.getDataFromExcel("Sheet1",3,7);
	 String phone=eu.getDataFromExcel("Sheet1",3,9);
	fillupContact.lastNameAndPhone(lastname, phone);
	
	/**
	 * this is used to choose the 
	 */
	String parentwindow=driver.getWindowHandle();
	ChooseOrgIconPage orgIcon=new ChooseOrgIconPage(driver);
	orgIcon.chooseOrg(driver, "Accounts");
	
	SendKeysToSelectOrgWindow newWindow=new SendKeysToSelectOrgWindow(driver);
	newWindow.selectOrgInContact(driver, orgName, parentwindow);
	
	SaveContactPage saveContact=new SaveContactPage(driver);
	saveContact.clicksaveButton();
	
	
	 
	  Vtiger_LogOutPage logOut=new Vtiger_LogOutPage(driver);
	  logOut.mouseHoverAndClickOnSignOut(driver);
	 
	  
	
	
		
}}
