package com.vtiger.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.autodeskSeleniumFramework.javaUtility.JavaUtility;

public class CreateNewOrganization_FillUpPage {

	public CreateNewOrganization_FillUpPage(WebDriver driver) {
		  PageFactory.initElements(driver, this);
	  }
	 public WebElement getCreateNewOrgIcon() {
		return createNewOrgIcon;
	}

	@FindBy(xpath="//img[@title='Create Organization...']")
	  private WebElement createNewOrgIcon;
	 
	@FindBy(name="accountname")
	private WebElement organizationNameTextField;
	
	public WebElement getOrganizationNameTextField() {
		return organizationNameTextField;
	}

	public WebElement getIndustryType() {
		return industryType;
	}

	public WebElement getNewOrgSaveButton() {
		return newOrgSaveButton;
	}

	@FindBy(xpath="//option[@value='Healthcare']")
	private WebElement industryType;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement newOrgSaveButton;
	
	/*
	 * public void organizationNameTextFieldAndIndustry(String newName,String
	 * industryTypename) { organizationNameTextField.sendKeys(newName);
	 * industryType.sendKeys(industryTypename); }
	 */
	
	
	  public void organizationNameTextFieldAndIndustry(String newName) 
	  {
		  createNewOrgIcon.click();
		  organizationNameTextField.sendKeys(newName);
		  industryType.click();
	      newOrgSaveButton.click();
	  }
	 }

