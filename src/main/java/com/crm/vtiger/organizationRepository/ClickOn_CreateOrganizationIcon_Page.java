package com.crm.vtiger.organizationRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ClickOn_CreateOrganizationIcon_Page {
   public ClickOn_CreateOrganizationIcon_Page(WebDriver driver) {
	   PageFactory.initElements(driver,this);
   }
	
   @FindBy(xpath="//img[@title='Create Organization...']")
   private WebElement createOrganizationIcon;
   
   public WebElement getCreateOrganizationIcon() {
		return createOrganizationIcon;
	}
   
   public void ClickOn_CreateOrganizationIcn(WebDriver driver) {
	   createOrganizationIcon.click();
   }


}
