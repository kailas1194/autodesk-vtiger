package com.crm.vtiger.purchaseOrderRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.autodeskSeleniumFramework.javaUtility.WebDriverUtility;
/**
 * 
 * @author CHAVAN
 *
 */
public class Vtiger_LogOutPage extends WebDriverUtility {
	/**
	 * initialization of WebElement.
	 * @param driver
	 */
	public Vtiger_LogOutPage(WebDriver driver) {
		PageFactory.initElements(driver, this);	
	}
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement adminIcon;  

    @FindBy(linkText="Sign Out")
    private WebElement signOutLink;
    
    public WebElement getAdminIcon() {
		return adminIcon;
	}
	public WebElement getSignOutLink() {
		return signOutLink;
	}
	
	/**
	 * this method is used to mouse hover to admin and click on logout link 
	 * @param driver
	 */
		public void mouseHoverAndClickOnSignOut(WebDriver driver) {
			Actions actions=new Actions(driver);
			adminIcon.click();
			actions.moveToElement(signOutLink).perform();
			signOutLink.click();
			System.out.println("pass:successfully logout");
		}
		
	}

	


