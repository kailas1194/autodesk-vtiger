package com.vtiger.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactLinkPage {
	public ContactLinkPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//img[@title='Create Contact...']")
	private WebElement CreateContactIcon;

	public WebElement getCreateContactIcon() {
		return CreateContactIcon;
	}

	public void CreateContactIcon() {
		CreateContactIcon.click();
	}
}
