package com.crm.autodeskSeleniumFramework.testNgAnnotation;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.crm.autodeskSeleniumFramework.javaUtility.BaseClass;
import com.crm.autodeskSeleniumFramework.javaUtility.JavaUtility;
import com.crm.vtiger.campaignRepository.ClickOnCreateCampaignIcon;
import com.crm.vtiger.campaignRepository.FillCampaign_DetailsPage;
import com.crm.vtiger.contactRepository.Vtiger_LogOutPage;
import com.crm.vtiger.leadRepository.HomePage;
import com.crm.vtiger.productRepository.ClickOnProductsPageIcon_Page;
import com.crm.vtiger.productRepository.Fill_ProductDetails_Page;
import com.crm.vtiger.productRepository.Verify_CreatedProductPage;
/**
 * this class is used to create a campaign and choose product
 * @author CHAVAN
 *
 */
public class CreateCampaign_ChooseProductTest extends BaseClass {

	@Test
	public void createOrganization() throws Throwable {
		HomePage hp=new HomePage(driver);
		JavaUtility ju=new JavaUtility();
		int num = ju.getRandomNumber();
		SoftAssert soft=new SoftAssert();
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
		
		
		Assert.assertEquals(actualProduct.contains(actualProduct),true);
		soft.assertEquals(actualProduct.contains(actualProduct),true);
	
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
		/**
		 * this is used to navigate to administrator and click on logout link
		 */
		  Vtiger_LogOutPage logOut=new Vtiger_LogOutPage(driver);
		  logOut.mouseHoverAndClickOnSignOut(driver);
		
	}}