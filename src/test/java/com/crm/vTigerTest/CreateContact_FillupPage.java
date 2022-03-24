package com.crm.vTigerTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.autodeskSeleniumFramework.javaUtility.WebDriverUtility;

public class CreateContact_FillupPage extends WebDriverUtility {
	
	public CreateContact_FillupPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(name="lastname")
	private WebElement lastName;

	@FindBy(xpath="//input[@name='account_id']/following-sibling::img[@title='Select']")
	private WebElement chooseorgnization;
	
	
	public WebElement getLastName() {
		return lastName;
	}

	public WebElement getChooseorgnization() {
		return chooseorgnization;
	}
	
	public void chooseorgnizationClick (String lastname) {
		lastName.sendKeys(lastname);
		
		chooseorgnization.click();
	}
}
