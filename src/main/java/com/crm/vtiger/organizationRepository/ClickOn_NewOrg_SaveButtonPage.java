package com.crm.vtiger.organizationRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ClickOn_NewOrg_SaveButtonPage {
      public ClickOn_NewOrg_SaveButtonPage(WebDriver driver) {
    	  PageFactory.initElements(driver,this);
      }


@FindBy(xpath="//input[@title='Save [Alt+S]']")
private WebElement clickOnSave;

public WebElement getClickOnSave() {
	return clickOnSave;
}

public void clickOnNewSaveButton() {
	clickOnSave.click();	
}
}
