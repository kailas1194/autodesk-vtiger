package com.crm.autodeskSeleniumFramework.campaigns;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.crm.autodeskSeleniumFramework.javaUtility.ExcelUtility;
import com.crm.autodeskSeleniumFramework.javaUtility.JavaUtility;
import com.crm.autodeskSeleniumFramework.javaUtility.PropertyUtility;
import com.crm.autodeskSeleniumFramework.javaUtility.WebDriverUtility;
import com.crm.vtiger.campaignRepository.ClickOnCreateCampaignIcon;
import com.crm.vtiger.campaignRepository.FillCampaign_DetailsPage;
import com.crm.vtiger.contactRepository.Vtiger_LogOutPage;
import com.crm.vtiger.leadRepository.HomePage;
import com.crm.vtiger.leadRepository.LoginPage;
import com.crm.vtiger.productRepository.ClickOnProductsPageIcon_Page;
import com.crm.vtiger.productRepository.Fill_ProductDetails_Page;
import com.crm.vtiger.productRepository.Verify_CreatedProductPage;

public class CreateCampaign_ChooseProduct_Test {

	public static void main(String[] args) throws Throwable {
		PropertyUtility pro = new PropertyUtility();
		WebDriverUtility wd = new WebDriverUtility();
		ExcelUtility eu = new ExcelUtility();
		WebDriver driver = new ChromeDriver();
		JavaUtility ju = new JavaUtility();
		wd.maximizeTheWindow(driver);
		wd.implicitWait(driver);
		String username = pro.getPropertiesKeyValue("username");
		String password = pro.getPropertiesKeyValue("password");
		String url = pro.getPropertiesKeyValue("url");
        
		int num=ju.getRandomNumber();
		LoginPage lp = new LoginPage(driver);
		/**
		 * navigate to application
		 */
		driver.get(url);

		/**
		 * this step is used to verify the login page of vtiger is displayed.
		 */
		String title = lp.vtigerLoginTitle(driver);
		String loginPageTitle = eu.getDataFromExcel("Sheet2", 1, 1);
		if (title.contains(loginPageTitle)) {
			System.out.println("PASS :: login page is displayed");
		} else {
			System.out.println("FAIL :: login page is not displayed");
		}

		/**
		 * login to vtiger application
		 */

		lp.login(username, password);

		/**
		 * verify vtiger home page is displayed
		 */
		HomePage hp = new HomePage(driver);
		String actualhomeTitle = hp.homePagetitle(driver);
		String homePageTitle = eu.getDataFromExcel("Sheet2", 2, 1);

		if (actualhomeTitle.contains(homePageTitle)) {
			System.out.println("PASS :: home page is displayed");
		} else {
			System.out.println("FAIL :: home page not is displayed");
		}

		/**
		 * click on product link.it navigate to products page
		 */
		hp.ProductsLink();

		/**
		 * click on create new product icon .it navigate to create new product fillup
		 * page
		 */

		ClickOnProductsPageIcon_Page createProduct = new ClickOnProductsPageIcon_Page(driver);
		createProduct.clickOnCreateProductIcon(driver);
		
		/**
		 * fill all required details
		 */
		
		String product = eu.getDataFromExcel("Sheet2",1,6)+num;
		Fill_ProductDetails_Page productDetails=new Fill_ProductDetails_Page(driver);
		productDetails.fillProductDetails(driver, product);

		/**
		 * verify product is created.
		 */
		
		Verify_CreatedProductPage productVerify=new Verify_CreatedProductPage(driver);
		String actualProduct=productVerify.verifyProductName(driver);
		
		if (actualProduct.contains(product)) {
			System.out.println("PASS::product is created successfully");	
		}
		else {
			System.out.println("FAIL::product is not created successfully");
		}
		
		/**
		 * click on More link.
		 * then click on Campaignlink.
		 * it navigate to campaigns page
		 */
	
		hp.MoreLink(driver);
		
		/**
		 * click on create campaign icon
		 */
		ClickOnCreateCampaignIcon campaignIcon=new ClickOnCreateCampaignIcon(driver);
		campaignIcon.clickOnCreateCampaignIcon(driver);
		
		/**
		 * fill all details in create campaign page and select product and save campaign.
		 */
		FillCampaign_DetailsPage selectCampaign=new  FillCampaign_DetailsPage(driver);
		selectCampaign.selectproductAndsaveCampaign(driver, product, "Products");
		
		Thread.sleep(10000);
		  Vtiger_LogOutPage logOut=new Vtiger_LogOutPage(driver);
		  logOut.mouseHoverAndClickOnSignOut(driver);
		 
	}
}
