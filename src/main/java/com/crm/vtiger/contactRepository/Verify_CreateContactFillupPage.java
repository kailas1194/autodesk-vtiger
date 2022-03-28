package com.crm.vtiger.contactRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Verify_CreateContactFillupPage {

	public Verify_CreateContactFillupPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(className="lvtHeaderText")
	private WebElement contactpage;

	public WebElement getContactpage() {
		return contactpage;
	}
	
	public String verifyContactFillUpPage() {
		return contactpage.getText();
	}
}
