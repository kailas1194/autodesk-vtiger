package com.crm.vtiger.vendorRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * this class is used to click on create new vendor icon and navigate to create new vendor
 * @author CHAVAN
 *
 */
public class CreateVendor_Page {
	/**
	 * 
	 * @param driver
	 */
	
public CreateVendor_Page(WebDriver driver) {
	PageFactory.initElements(driver, this);
}
/**
 * 
 */
@FindBy(xpath="//img[@title='Create Vendor...']")
private WebElement clickOnNewVendorIcon;

@FindBy(name="vendorname")
private WebElement vendorName;

public WebElement getVendorName() {
	return vendorName;
}
public WebElement getClickOnNewVendorIcon() {
	return clickOnNewVendorIcon;
}

@FindBy(xpath="//input[@title='Save [Alt+S]']")
private WebElement clickonSaveVendor;

public WebElement getClickonSaveVendor() {
	return clickonSaveVendor;
}
public void createVendor(WebDriver driver,String vendorname) {
	clickOnNewVendorIcon.click();
	vendorName.sendKeys(vendorname);
	clickonSaveVendor.click();
	
}


}
