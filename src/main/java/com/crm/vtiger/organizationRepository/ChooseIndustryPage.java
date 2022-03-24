package com.crm.vtiger.organizationRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.autodeskSeleniumFramework.javaUtility.WebDriverUtility;

public class ChooseIndustryPage {
	public ChooseIndustryPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(name="industry")
	private WebElement industryType;

	public WebElement getIndustryType() {
		return industryType;
	}
	public void industrytype(String industrytype) {
		WebDriverUtility wd=new WebDriverUtility();
		wd.selectByvalue(industryType, industrytype);;
	}

}
