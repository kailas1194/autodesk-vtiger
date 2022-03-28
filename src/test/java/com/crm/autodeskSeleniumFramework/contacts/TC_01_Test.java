package com.crm.autodeskSeleniumFramework.contacts;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.crm.autodeskSeleniumFramework.javaUtility.BaseClass;
import com.crm.vtiger.contactRepository.ClickOnCreateNewConatctIconPage;
import com.crm.vtiger.contactRepository.CreateNewContact_FillUpPage;
import com.crm.vtiger.contactRepository.Verify_Contactspage_IsDisplayedPage;
import com.crm.vtiger.contactRepository.Verify_CreateContactFillupPage;
import com.vtiger.objectrepository.HomePage;

/**
 * this class is used to 
 * @author CHAVAN
 *
 */
public class TC_01_Test extends BaseClass {
	@Test
	public void test() throws InterruptedException, Throwable, IOException {
		
		/**
		 * this step is used to click on contact link.
		 */
		 HomePage hp=new HomePage(driver);
		  hp.ContactsLink();
		
		  /**
		   * verify  the contacts page is displayed.
		   */
		  Verify_Contactspage_IsDisplayedPage contacts=new Verify_Contactspage_IsDisplayedPage(driver);
		 String verifycontact = contacts.verifyContactsPage();
		  if (verifycontact.contains("Contacts")) 
		  {
			System.out.println("Pass:: contacts page is displayed");
		  }
		  else 
		  {
			  System.out.println("fail:: contacts page is not displayed");
		  }
		  
		 /**
		  * click on create new contact icon. 
		  */
		ClickOnCreateNewConatctIconPage contact=new ClickOnCreateNewConatctIconPage(driver);
		contact.clickOnCreateNewContactIcon();
		
		/**
		 * this is used to verify create new contact fillup page is displayed.
		 */
		Verify_CreateContactFillupPage verifyCreatecontactPage=new Verify_CreateContactFillupPage(driver);
		String newcontactfillup = verifyCreatecontactPage.verifyContactFillUpPage();
		
		if (newcontactfillup.contains("Creating")) 
		{
		System.out.println("Pass:create fillup page of new contact page is displayed");	
		}
		else
		{
			System.out.println("Fail:create fillup page of new contact page is not displayed");	
		}
		
		CreateNewContact_FillUpPage fillup=new CreateNewContact_FillUpPage(driver);
		String lastname=eu.getDataFromExcel("Sheet1", 1, 7);
		driver.quit();
		
	}

}
