package com.crm.vtiger.contactRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.autodeskSeleniumFramework.javaUtility.WebDriverUtility;

public class ChooseOrgIconPage {

	public ChooseOrgIconPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//input[@name='account_id']/following-sibling::img")
	private WebElement orgIcon;

	public WebElement getOrgIcon() {
		return orgIcon;
	}
	
	public void chooseOrg(WebDriver driver,String partialUrl) {
		orgIcon.click();
		WebDriverUtility wd=new WebDriverUtility();
		wd.switchToWindow(driver, partialUrl);
	}
}
