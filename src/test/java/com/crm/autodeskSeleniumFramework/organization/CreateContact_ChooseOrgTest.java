package com.crm.autodeskSeleniumFramework.organization;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.crm.autodeskSeleniumFramework.javaUtility.ExcelUtility;
import com.crm.autodeskSeleniumFramework.javaUtility.JavaUtility;
import com.crm.autodeskSeleniumFramework.javaUtility.PropertyUtility;
import com.crm.autodeskSeleniumFramework.javaUtility.WebDriverUtility;
import com.crm.vTigerTest.CreateContact_FillupPage;
import com.vtiger.objectrepository.ContactLinkPage;
import com.vtiger.objectrepository.CreateNewOrganization_FillUpPage;
import com.vtiger.objectrepository.HomePage;
import com.vtiger.objectrepository.LoginPage;
import com.vtiger.objectrepository.OragnizationlinkTextPage;
import com.vtiger.objectrepository.VerifyNewCreatedOrganizationPage;

public class CreateContact_ChooseOrgTest {
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
		driver.get(url);
		String industryType=eu.getDataFromExcel("Sheet1", 3, 5);
		String ExpectedOrg=eu.getDataFromExcel("Sheet1", 3, 0)+ju.getRandomNumber();
		String lastname=eu.getDataFromExcel("Sheet1", 1, 7);
		/**
		 * login to vtiger application
		 */
		LoginPage lp=new LoginPage(driver);
		lp.login(username, password);
		
		

		/**
		 * navigate to home page and click on organization
		 */
		HomePage hp=new HomePage(driver);
		hp.OrganizationsLink();
		
		/**
		 * navigate to organizations page 
		 */
		OragnizationlinkTextPage org=new OragnizationlinkTextPage(driver);
		org.getCreateNewOrgIcon();
		
		/**
		 * navigate to Neworganization Fillup page and create new organization
		 */
		
		CreateNewOrganization_FillUpPage newOrg=new CreateNewOrganization_FillUpPage(driver);
		newOrg.organizationNameTextFieldAndIndustry(ExpectedOrg);
		
		
		VerifyNewCreatedOrganizationPage verifyOrg=new VerifyNewCreatedOrganizationPage(driver);
		String actualorg=verifyOrg.createNewOrgIcon();
		
		//verify newly created orgnization
		if (actualorg.contains(ExpectedOrg)) {
			System.out.println("PASS:: organization created successsfully");	
		}
		else {
			System.out.println("FAIL:: organization NOT created successsfully");
		}
		
		hp.ContactsLink();
		ContactLinkPage contact=new ContactLinkPage(driver);
		contact.CreateContactIcon();
		
		CreateContact_FillupPage contactFillup=new CreateContact_FillupPage(driver);
				contactFillup.chooseorgnizationClick(lastname);
				
				
				
		driver.quit();
	}
	
	
}
