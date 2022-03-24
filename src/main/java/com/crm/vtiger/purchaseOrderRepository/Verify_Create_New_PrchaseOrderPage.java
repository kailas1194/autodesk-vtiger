package com.crm.vtiger.purchaseOrderRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Verify_Create_New_PrchaseOrderPage {

	public Verify_Create_New_PrchaseOrderPage(WebDriver driver){
		PageFactory.initElements(driver,this);
	}
	
	public String  createPurchaseOrder(WebDriver driver) {
		String createPurchaseOrderTitle=driver.getTitle();
		return createPurchaseOrderTitle;
		
	}
}
