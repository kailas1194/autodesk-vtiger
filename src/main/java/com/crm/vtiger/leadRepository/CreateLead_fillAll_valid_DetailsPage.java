package com.crm.vtiger.leadRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * this class is used to Create Lead fillAll valid Details in Leads Page
 * @author CHAVAN
 *
 */
public class CreateLead_fillAll_valid_DetailsPage {
 /**
  * initialization of element
  * @param driver
  */
	public CreateLead_fillAll_valid_DetailsPage(WebDriver driver) {
	  PageFactory.initElements(driver, this);
  }

	
	/**
	 * declaration of WebElement
	 */

@FindBy(name="lastname")
  private WebElement lastName;

  @FindBy(name="company")
  private WebElement companyName;
  
  @FindBy(id="noofemployees")
  private WebElement noOfEmployee;
  
  @FindBy(xpath="//input[@title='Save [Alt+S]']")
  private WebElement saveLeadButton;

public WebElement getLastName() {
		return lastName;
	}

	public WebElement getCompanyName() {
		return companyName;
	}

  public WebElement getNoOfEmployee() {
	  return noOfEmployee;
	}
 
  
  /**
   * this method is used to fill details in Create New Lead Fields
   * @param driver
   * @param lastname
   * @param companyname
   * @param noOfEmployee2
   */
public void createNewLeadFields(WebDriver driver,String lastname,String companyname,int noOfEmployee2) {
	 
	lastName.sendKeys(lastname);
	  companyName.sendKeys(companyname);
	  noOfEmployee.sendKeys(noOfEmployee2+"");
	  saveLeadButton.click();

}
}
