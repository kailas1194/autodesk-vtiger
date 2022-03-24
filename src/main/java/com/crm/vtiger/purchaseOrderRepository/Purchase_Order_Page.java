package com.crm.vtiger.purchaseOrderRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Purchase_Order_Page {
   public Purchase_Order_Page(WebDriver driver) {
	   PageFactory.initElements(driver, this);
   }
   
   @FindBy(xpath="//img[@title='Create Purchase Order...']")
   private WebElement createPurchaseOrderIcon;

    public WebElement getCreatePurchaseOrder() {
	return createPurchaseOrderIcon;
    }
	public void createPurchaseOrderIcon(WebDriver driver) {
		createPurchaseOrderIcon.click();
	
	}

   
}
