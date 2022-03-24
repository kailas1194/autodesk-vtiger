package com.crm.vtiger.productRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ClickOnProductsPageIcon_Page {
	public ClickOnProductsPageIcon_Page(WebDriver driver) {
		PageFactory.initElements(driver, this);	
	}
	
	@FindBy(linkText="Products")
	private WebElement ProductsIconLink;
	
	@FindBy(xpath="//img[@title='Create Product...']")
	private WebElement CreateProductIcon;

	public WebElement getCreateProductIcon() {
		return CreateProductIcon;
	}

	public WebElement getProductsIconLink() {
		return ProductsIconLink;
	}
	
	public void clickOnCreateProductIcon(WebDriver driver) {
		CreateProductIcon.click();
	}
	
	
}
