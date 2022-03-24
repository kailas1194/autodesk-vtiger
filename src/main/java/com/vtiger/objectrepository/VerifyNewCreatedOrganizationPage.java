package com.vtiger.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VerifyNewCreatedOrganizationPage {
	//span[@class="dvHeaderText"]
	
	public VerifyNewCreatedOrganizationPage(WebDriver driver) {
		  PageFactory.initElements(driver, this);
	  }
	  
	  //achieve encapsulation
	@FindBy(xpath="//span[@class='dvHeaderText']")
	  private WebElement actualOrgHead;

	public WebElement getActualOrgHead() {
		return actualOrgHead;
	}
	
	public String createNewOrgIcon (){
		return actualOrgHead.getText();
	
	}
}
