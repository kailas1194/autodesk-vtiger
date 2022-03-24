package com.crm.vtiger.campaignRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ClickOnCreateCampaignIcon {

	public ClickOnCreateCampaignIcon(WebDriver driver) {
		PageFactory.initElements(driver, this);	
	}
	
	@FindBy(xpath="//img[@title='Create Campaign...']")
	private WebElement CreateCampaignIcon;

	public WebElement getCreateCampaignIcon() {
		return CreateCampaignIcon;
	}
	
	public void clickOnCreateCampaignIcon(WebDriver driver) {
		CreateCampaignIcon.click();
	}
}
