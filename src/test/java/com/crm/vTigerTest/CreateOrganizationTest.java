package com.crm.vTigerTest;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.crm.autodeskSeleniumFramework.javaUtility.ExcelUtility;
import com.crm.autodeskSeleniumFramework.javaUtility.JavaUtility;
import com.crm.autodeskSeleniumFramework.javaUtility.PropertyUtility;
import com.crm.autodeskSeleniumFramework.javaUtility.WebDriverUtility;
import com.crm.vtiger.contactRepository.Vtiger_LogOutPage;
import com.vtiger.objectrepository.CreateNewOrganization_FillUpPage;
import com.vtiger.objectrepository.HomePage;
import com.vtiger.objectrepository.LoginPage;
import com.vtiger.objectrepository.OragnizationlinkTextPage;
import com.vtiger.objectrepository.VerifyNewCreatedOrganizationPage;
/**
 * this test script is used to Create Organization with mandatory field and verify.
 * @author CHAVAN
 *
 */
public class CreateOrganizationTest {
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
		
		/**
		 * verify newly created orgnization
		 */
	
		VerifyNewCreatedOrganizationPage verifyOrg=new VerifyNewCreatedOrganizationPage(driver);
		String actualorg=verifyOrg.createNewOrgIcon();
		
		if (actualorg.contains(ExpectedOrg)) {
			System.out.println("PASS:: organization created successsfully");	
		}
		else {
			System.out.println("FAIL:: organization NOT created successsfully");
		}
		
		Vtiger_LogOutPage logout=new Vtiger_LogOutPage(driver);
		logout.mouseHoverAndClickOnSignOut(driver);
		
		driver.quit();
	}
	
	
}
