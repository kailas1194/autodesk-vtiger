
package com.vtiger.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	/**
	 * initialization of webElement
	 * @param driver
	 */
		public HomePage(WebDriver driver) {
			PageFactory.initElements(driver, this);	
		}

		/**
		 * declaration of webelement
		 */
		@FindBy(linkText="Calendar")
		private WebElement Calendar;
		
		@FindBy(linkText="Leads")
		private WebElement Leads;
		
		@FindBy(linkText="Organizations")
		private WebElement Organizations;
		
		@FindBy(linkText="Contacts")
		private WebElement Contacts;
		
		@FindBy(linkText="Opportunities")
		private WebElement Opportunities;
		
		@FindBy(linkText="Products")
		private WebElement Products;
		
		@FindBy(linkText="Documents")
		private WebElement Documents;
		
		@FindBy(linkText="Email")
		private WebElement Email;
		
		@FindBy(linkText="Trouble Tickets")
		private WebElement Trouble_Tickets;
		
		public WebElement getTrouble_Tickets() {
			return Trouble_Tickets;
		}

		public void setTrouble_Tickets(WebElement trouble_Tickets) {
			Trouble_Tickets = trouble_Tickets;
		}

		public WebElement getCalendar() {
			return Calendar;
		}

		public WebElement getLeads() {
			return Leads;
		}

		public WebElement getOrganizations() {
			return Organizations;
		}

		public WebElement getContacts() {
			return Contacts;
		}

		public WebElement getOpportunities() {
			return Opportunities;
		}

		public WebElement getProducts() {
			return Products;
		}

		public WebElement getDocuments() {
			return Documents;
		}

		public WebElement getEmail() {
			return Email;
		}

		public WebElement getDashboard() {
			return Dashboard;
		}

		public WebElement getMore() {
			return More;
		}

		@FindBy(linkText="Dashboard")
		private WebElement Dashboard;
		
		@FindBy(linkText="More")
		private WebElement More;
		
		@FindBy(name="Purchase Order")
		private WebElement purchaseOrder;

		public WebElement getPurchaseOrder() {
			return purchaseOrder;
		}

		public void OrganizationsLink() {
			Organizations.click();
		}
		
		public void ContactsLink() {
			Contacts.click();
		}
		
		
		public void ProductsLink() {
			Products.click();
		}
		
		public void MoreLink() {
			More.click();
			
		}
		public void mouseHoverAndClickpurchaseOrder(WebDriver driver) {
			Actions actions=new Actions(driver);
			More.click();
			actions.moveToElement(purchaseOrder).perform();
			purchaseOrder.click();
		
		
		}

}
