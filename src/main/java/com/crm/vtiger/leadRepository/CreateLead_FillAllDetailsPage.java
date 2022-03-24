package com.crm.vtiger.leadRepository;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * 
 * this class is used to fill details in campaign page
 * @author CHAVAN
 *
 */

public class CreateLead_FillAllDetailsPage {
 
	/**
	 * initialization of webElements
	 * @param driver
	 */
	public CreateLead_FillAllDetailsPage(WebDriver driver) {
	  PageFactory.initElements(driver, this);
  }
  
	
	/**
	 * declaration of webElement of campaign page
	 */
  @FindBy(name="lastname")
  private WebElement lastName;

  @FindBy(name="company")
  private WebElement companyName;
  
  @FindBy(name="annualrevenue")
  private WebElement annualRevenue;
  
  @FindBy(xpath="//input[@title='Save [Alt+S]']")
  private WebElement saveLeadButton;

public WebElement getLastName() {
		return lastName;
	}

	public WebElement getCompanyName() {
		return companyName;
	}

	public WebElement getAnnualrevenue() {
		return annualRevenue;
	}
	
	
  /**
   * this method is used to create a new lead with required field and save the lead
   *this method fulfill expected condition :: annual revenue is in alphabet
   * 
   * @param driver
   * @param lastname
   * @param companyname
   * @param annualrevenue
   * @throws AWTException
   */
  public void createNewLeadFields(WebDriver driver,String lastname,String companyname,String annualrevenue) throws AWTException {
	  lastName.sendKeys(lastname);
	  companyName.sendKeys(companyname);
	  annualRevenue.clear();
	  annualRevenue.sendKeys(annualrevenue);
	  saveLeadButton.click();
	  
	  String alertText=driver.switchTo().alert().getText();
  	  System.out.println(annualrevenue+" : : is "+alertText );
  	  System.out.println("New lead is not created");
	  Robot r=new Robot();
	  r.keyPress(KeyEvent.VK_ENTER);
	  r.keyRelease(KeyEvent.VK_ENTER);
  
}
  
  /**
   *  this method is used to create a new lead with required field and save the lead
   *  required field is :: company  
   * @param driver
   * @param lastname
   * @param companyname
   */
  public void createNewLeadFields(WebDriver driver,String lastname,String companyname) {
	  lastName.sendKeys(lastname);
	  companyName.sendKeys(companyname);
	  annualRevenue.clear();
	  saveLeadButton.click();}
}
