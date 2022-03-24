package com.crm.vtiger.organizationRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Verify_Organizations_Page {
     public Verify_Organizations_Page(WebDriver driver) {
    	 PageFactory.initElements(driver,this);
     }
     
     public String organizationsListTitle(WebDriver driver) {
    	 String organizationsListTitl=driver.getTitle();
		return organizationsListTitl;
    	 
     }
}
