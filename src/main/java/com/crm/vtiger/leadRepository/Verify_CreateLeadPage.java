package com.crm.vtiger.leadRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * this class is used to verify the create leads page
 * @author CHAVAN
 *
 */
public class Verify_CreateLeadPage {

	/**
	 * initialization of WebElements
	 * 
	 * @param driver
	 */
	public Verify_CreateLeadPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	/**
	 * this is used to declared the WebElements
	 */
	
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement verifyCreatedLead;

	public WebElement getVerifyCreatedLead() {
		return verifyCreatedLead;
	}
	
	public String verifyCreatedLead(WebDriver driver)
        {
		return verifyCreatedLead.getText();
		}
}

