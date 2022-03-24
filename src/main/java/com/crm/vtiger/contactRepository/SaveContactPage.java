package com.crm.vtiger.contactRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SaveContactPage {

	public SaveContactPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveButton;

	public WebElement getSaveButton() {
		return saveButton;
	}
	
	public void clicksaveButton() {
		saveButton.click();
	}
}
