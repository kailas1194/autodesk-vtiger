
package com.crm.vtiger.leadRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	//initialization of webElement
		public HomePage(WebDriver driver) {
			PageFactory.initElements(driver, this);	
		}

		//declaration of webelement
		@FindBy(linkText="Leads")
		private WebElement leadslink;
		
		@FindBy(linkText="Vendors")
		private WebElement vendorLink;
		
		@FindBy(linkText="Products")
		private WebElement ProductsLink;
		
		@FindBy(linkText="More")
		private WebElement MoreLink;
		
		@FindBy(name="Purchase Order")
		private WebElement purchaseOrder;

		public WebElement getPurchaseOrder() {
			return purchaseOrder;
		}
		
		@FindBy(linkText="Organizations")
		private WebElement OrganizationsLink;
		
		public WebElement getOrganizationsLink() {
			return OrganizationsLink;
		}

		@FindBy(linkText="Campaigns")
		private WebElement CampaignsLink;
		
		@FindBy(linkText="Contacts")
		private WebElement ContactsLink;
		
		
		public WebElement getContactsLink() {
			return ContactsLink;
		}


		public WebElement getCampaignsLink() {
			return CampaignsLink;
		}


		public WebElement getMoreLink() {
			return MoreLink;
		}


		public WebElement getProducts() {
			return ProductsLink;
		}


		public WebElement getLeadslink() {
			return leadslink;
		}


		public void leadslink() {
			leadslink.click();
		}
		
		public void ContactsLink() {
			ContactsLink.click();
		}
		
		
		
		public void OrganizationsLink() {
			OrganizationsLink.click();
		}
		
		public void MoreLink(WebDriver driver) {
			
			Actions actions=new Actions(driver);
			MoreLink.click();
			actions.moveToElement(CampaignsLink).perform();
			CampaignsLink.click();
			
		}
		
public void clickMoreLinkandClickVendor(WebDriver driver) {
			
			Actions actions=new Actions(driver);
			MoreLink.click();
			actions.moveToElement(vendorLink).perform();
			vendorLink.click();
			
		}
		
		public WebElement getVendorLink() {
	return vendorLink;
}


		public void ProductsLink() {
			ProductsLink.click();
		}
		
		public String homePagetitle(WebDriver driver) {
			return driver.getTitle();
		}
		
		// logout required element
		@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
		private WebElement adminIcon;  

	    @FindBy(linkText="Sign Out")
	    private WebElement signOutLink;
	    
	    public WebElement getAdminIcon() {
			return adminIcon;
		}
		public WebElement getSignOutLink() {
			return signOutLink;
		}
		
		public void mouseHoverAndClickpurchaseOrder(WebDriver driver) {
			Actions actions=new Actions(driver);
			MoreLink.click();
			actions.moveToElement(purchaseOrder).perform();
			purchaseOrder.click();
		
		
		}

}
