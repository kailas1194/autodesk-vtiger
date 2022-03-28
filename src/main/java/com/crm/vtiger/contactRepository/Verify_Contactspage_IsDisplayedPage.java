package com.crm.vtiger.contactRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Verify_Contactspage_IsDisplayedPage {

	public Verify_Contactspage_IsDisplayedPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(linkText="Contacts")
	private WebElement contacts;

	public WebElement getContact() {
		return contacts;
	}
	
	public String verifyContactsPage() {
		String contact = contacts.getText();
		return contact;
		
	}
}
