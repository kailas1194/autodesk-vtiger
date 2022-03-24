package com.vtiger.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OragnizationlinkTextPage {
  public OragnizationlinkTextPage(WebDriver driver) {
	  PageFactory.initElements(driver, this);
  }
  
  //achieve encapsulation
@FindBy(linkText="Organizations")
  private WebElement organizationlinkText;
  
  @FindBy(xpath="//img[@title='Create Organization...']")
  private WebElement createNewOrgIcon;
  
  @FindBy(xpath="//input[@name='accountname']")
  private WebElement neworgName;
  
  @FindBy(xpath="//input[@title='Save [Alt+S]']")
  private WebElement saveNewOrg;
  
  //provide getter method
  public WebElement getOrganizationlinkText() {
		return organizationlinkText;
	}

	public WebElement getCreateNewOrgIcon() {
		return createNewOrgIcon;
	}

	public WebElement getNeworgName() {
		return neworgName;
	}

	public WebElement getSaveNewOrg() {
		return saveNewOrg;
	}
	
	public void createNewOrg(String newName) {
		neworgName.sendKeys(newName);
		saveNewOrg.click();
	}
	
	public void createNewOrgIcon (){
		createNewOrgIcon.click();
	}
	
  
}
