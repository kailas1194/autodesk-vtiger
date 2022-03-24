package com.crm.vtiger.vendorRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Verify_VendorPage_Dispayed_Page{
	
public Verify_VendorPage_Dispayed_Page(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}

public String vendorPageTitle(WebDriver driver)
{
	String title=driver.getTitle();
	return title;
	
}
}
