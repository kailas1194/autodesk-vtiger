package com.crm.vtiger.organizationRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Verify_CreateNewOrganization_Page {

	public Verify_CreateNewOrganization_Page(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//span[@class='lvtHeaderText']")
	private WebElement createorganizationText;


		
		public WebElement getCreateorganizationText() {
		return createorganizationText;
	}



		public String createorganizationTextt(WebDriver driver) {
			String verifyText=createorganizationText.getText();
			return verifyText;
}
}
