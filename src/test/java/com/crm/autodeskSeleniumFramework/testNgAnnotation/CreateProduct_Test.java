package com.crm.autodeskSeleniumFramework.testNgAnnotation;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.crm.autodeskSeleniumFramework.javaUtility.BaseClass;
import com.crm.autodeskSeleniumFramework.javaUtility.JavaUtility;
import com.crm.vtiger.leadRepository.HomePage;
import com.crm.vtiger.leadRepository.Vtiger_LogOutPage;
import com.crm.vtiger.productRepository.ClickOnProductsPageIcon_Page;
import com.crm.vtiger.productRepository.Fill_ProductDetails_Page;
import com.crm.vtiger.productRepository.Verify_CreatedProductPage;

@Listeners (com.crm.autodeskSeleniumFramework.javaUtility.IListenerImpClass.class)
public class CreateProduct_Test extends BaseClass {

	@Test
	public void createOrganization() throws Throwable {
		HomePage hp=new HomePage(driver);
		JavaUtility ju=new JavaUtility();
		int num = ju.getRandomNumber();
		SoftAssert soft=new SoftAssert();
	
		String actualhomeTitle = hp.homePagetitle(driver);
		String homePageTitle = eu.getDataFromExcel("Sheet2", 2, 1);
		
		Assert.assertEquals(actualhomeTitle.contains(homePageTitle),true);
		soft.assertEquals(actualhomeTitle.contains(homePageTitle),true);
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
		
		String product = eu.getDataFromExcel("Sheet2",1,6);
		Fill_ProductDetails_Page productDetails=new Fill_ProductDetails_Page(driver);
		productDetails.fillProductDetails(driver, product);

		/**
		 * verify product is created.
		 */
		
		Verify_CreatedProductPage productVerify=new Verify_CreatedProductPage(driver);
		String actualProduct=productVerify.verifyProductName(driver);
		
		
		Assert.assertEquals(actualProduct.contains(actualProduct),true);
		soft.assertEquals(actualProduct.contains(actualProduct),true);
		
		
		/**
		 * logout from the Vtiger application.
		 */
		
			  Vtiger_LogOutPage logout=new Vtiger_LogOutPage(driver);
			  logout.mouseHoverAndClickOnSignOut(driver); driver.quit();
			 
	}
	}