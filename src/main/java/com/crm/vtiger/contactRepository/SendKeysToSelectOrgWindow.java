package com.crm.vtiger.contactRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SendKeysToSelectOrgWindow {

	public SendKeysToSelectOrgWindow(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(id="search_txt")
	private WebElement searchTextField;
	
	@FindBy(name="search")
	private WebElement searchButton;
	

	public WebElement getSearchTextField() {
		return searchTextField;
	}

	public WebElement getSearchButton() {
		return searchButton;
	}
	
	public void selectOrgInContact(WebDriver driver,String orgName,String parentWindow) {
		searchTextField.sendKeys(orgName);
		searchButton.click();
		driver.findElement(By.linkText(orgName)).click();
		driver.switchTo().window(parentWindow);
		
	}
}
