package com.crm.vtiger.productRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Fill_ProductDetails_Page {
	public Fill_ProductDetails_Page(WebDriver driver) {
		PageFactory.initElements(driver, this);		
}
	
	@FindBy(name="productname")
	private WebElement productname;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	  private WebElement saveProductButton;

	public WebElement getProductname() {
		return productname;
	}

	public WebElement getProductButton() {
		return saveProductButton;
	}
    
	public void fillProductDetails(WebDriver driver,String productName) {
		productname.sendKeys(productName);
		saveProductButton.click();
		
	}

}
