package com.crm.vtiger.organizationRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Create_NewOrganization_Fillup_Page {

	public Create_NewOrganization_Fillup_Page(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//input[@name='accountname']")
	private WebElement organizationName;
	
	
	

	public WebElement getOrganizationName() {
		return organizationName;
	}
	
	public void fillDetails(WebDriver driver,String organizationNam) {
		organizationName.sendKeys(organizationNam);
		
	}

}
