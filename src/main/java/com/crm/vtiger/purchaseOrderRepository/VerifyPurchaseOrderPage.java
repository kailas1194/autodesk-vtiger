package com.crm.vtiger.purchaseOrderRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VerifyPurchaseOrderPage {
   public VerifyPurchaseOrderPage(WebDriver driver) {
	   PageFactory.initElements(driver, this);
   }
   
   @FindBy(xpath="//img[@title='Create Purchase Order...']")
   private WebElement createPurchaseOrderIcon;

    public WebElement getCreatePurchaseOrder() {
	return createPurchaseOrderIcon;
    }
	public String getTitleAndVerifyPurchaseOrderPage(WebDriver driver) {
		String purchaseOrderTitle=driver.getTitle();
		createPurchaseOrderIcon.click();
		return purchaseOrderTitle;
		
	}

   
}
