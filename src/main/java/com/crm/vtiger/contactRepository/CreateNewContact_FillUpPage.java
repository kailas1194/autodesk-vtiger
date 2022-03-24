package com.crm.vtiger.contactRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewContact_FillUpPage {

	public CreateNewContact_FillUpPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(name="lastname")
	private WebElement lstname;
	
	@FindBy(name="phone")
	private WebElement phoneno;

	public WebElement getLastname() {
		return lstname;
	}

	public WebElement getPhoneno() {
		return phoneno;
	}
	
	public void lastNameAndPhone(String lastname,String phoneNo) {
		lstname.sendKeys(lastname);
		phoneno.sendKeys(phoneNo);
	}
}
