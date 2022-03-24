package com.crm.vtiger.contactRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ClickOnCreateNewConatctIconPage {

	public ClickOnCreateNewConatctIconPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//img[@title='Create Contact...']")
	private WebElement createContactIcon;

	public WebElement getCreateContactIcon() {
		return createContactIcon;
	}
	
	public void clickOnCreateNewContactIcon() {
		createContactIcon.click();
	}
}
