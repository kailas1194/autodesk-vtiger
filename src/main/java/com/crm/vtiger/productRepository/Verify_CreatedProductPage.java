package com.crm.vtiger.productRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Verify_CreatedProductPage {

	public Verify_CreatedProductPage(WebDriver driver) {
		PageFactory.initElements(driver, this);		
}
	
	@FindBy(xpath="//span[@class='lvtHeaderText']")
	private WebElement verifyProduct;

	public WebElement getVerifyProduct() {
		return verifyProduct;
	}
	public String verifyProductName(WebDriver driver) {
		return verifyProduct.getText();
		
	}
}



