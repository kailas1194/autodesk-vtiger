package com.crm.vtiger.leadRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * this class is used to capture newly created lead no 
 * @author CHAVAN
 *
 */
public class Capture_UniqueLeadNo_Page {
/**
 * initialization of WebElements
 * @param driver
 */
	public Capture_UniqueLeadNo_Page(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	/**
	 * this is used to declared the WebElements
	 */
	@FindBy(xpath="//td[@id='mouseArea_First Name']/following-sibling::td[@class='dvtCellInfo']")
	private WebElement actualuniqueLeadNo;
	
	public WebElement getActualuniqueLeadNo() {
		
		return actualuniqueLeadNo;
	}
	
	/**
	 * this method is used to capture newly created lead no.
	 * @param driver
	 * @return
	 */
	public String actualUniqueLeadNumber(WebDriver driver)
	{
		String actualLead=actualuniqueLeadNo.getText();
		return actualLead;
		
	}
}
