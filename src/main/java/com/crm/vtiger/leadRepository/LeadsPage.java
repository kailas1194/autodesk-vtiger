package com.crm.vtiger.leadRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * this class is used to navigate control leads list page to create new lead page
 * @author CHAVAN
 *
 */
public class LeadsPage {

	/**
	 * initialization of WebElements
	 * @param driver
	 */
	public LeadsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	/**
	 * Declaration of WebElements
	 */
	@FindBy(xpath="//img[@title='Create Lea...']")
	private WebElement createNewLeadIcon;
	
	public WebElement getCreateNewLeadIcon() {
		return createNewLeadIcon;
	}

	/**
	 * this method is used to capture the current WebPage title.
	 * @param driver
	 * @return
	 */
	public String titleOfLeadsPage(WebDriver driver) {
		String leadsTitle=driver.getTitle();
		return leadsTitle;
	}
	
	/**
	 * this method is used to click on create new lead icon in Leads list page
	 */
	public void clickOnCreateLeadsIcon() {
		createNewLeadIcon.click();
	}
}
