package com.crm.vtiger.purchaseOrderRepository;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.autodeskSeleniumFramework.javaUtility.WebDriverUtility;

public class CreateNew_PurchaseOrder_Page {
/**
 * initialization of Webelement
 */
	public CreateNew_PurchaseOrder_Page(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	
	
	/**
	 * declaration of webelement
	 */
	@FindBy(name="subject")
	private WebElement subject;
	@FindBy(xpath="//input[@name='vendor_id']/following-sibling::img[@title='Select']")
	private WebElement selectVendorIcon;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement savePurchaseOrderButton;
	
	public WebElement getSubject() {
		return subject;
	}

	public WebElement getSelectVendorIcon() {
		return selectVendorIcon;
	}

	public WebElement getSavePurchaseOrderButton() {
		return savePurchaseOrderButton;
	}

	@FindBy(id="search_txt")
	private WebElement searchvendor;
	
	@FindBy(xpath="//textarea[@name='bill_street']")
	private WebElement billingAdress;
	
	@FindBy(xpath="//textarea[@name='ship_street']")
	private WebElement shippingAdress;
	
	
			
	@FindBy(name="qty1")
	private WebElement qty;
	
	public WebElement getQty() {
		return qty;
	}


	@FindBy(xpath="//img[@title='Products']")
	private WebElement lineIcon;
	
	public WebElement getLineIcon() {
		return lineIcon;
	}

	public WebElement getShippingAdress() {
		return shippingAdress;
	}

	public WebElement getBillingAdress() {
		return billingAdress;
	}


	@FindBy(name="search")
	private WebElement searchButton;
	
	
			
    public WebElement getSearchlineButton() {
		return searchlineButton;
	}


	@FindBy(name="search_text")
	private WebElement searchlineTextField;
  
    @FindBy(name="search")
	private WebElement searchlineButton;
  
  
	public WebElement getSearchlineTextField() {
	return searchlineTextField;
}

	public WebElement getSearchvendor() {
		return searchvendor;
	}

	public WebElement getSearchButton() {
		return searchButton;
	}

	public void CreatePurchaseOrder(WebDriver driver,String purchaseSubject,String vendorname) {

		
		subject.sendKeys(purchaseSubject);
		String parent=driver.getWindowHandle();
		selectVendorIcon.click();
		
		
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it = windows.iterator();
		while (it.hasNext()) {
			String windId = it.next();
			String title=driver.switchTo().window(windId).getTitle();
			if (title.contains(vendorname)) {
				break;
			}
			
		}
			
			searchvendor.sendKeys(vendorname);
			searchButton.click();
			driver.switchTo().window(parent);}
	
			
			public void selectLine(WebDriver driver,String actualVendor,String address,String qnty,String line) {
			billingAdress.sendKeys(address);
			shippingAdress.sendKeys(address);
			qty.sendKeys(qnty);
			String parent=driver.getWindowHandle();
			lineIcon.click();
			
			Set<String> allwindow = driver.getWindowHandles();
		    for (String ele : allwindow) {
		    	
		    	if (driver.getCurrentUrl().contains(actualVendor)) {
		    		break;
					
				}
				
			}
				searchlineTextField.sendKeys(line);
				searchlineButton.click();
				driver.findElement(By.partialLinkText(line)).click();
				//driver.switchTo().alert().dismiss();
				driver.switchTo().window(parent);
			}
		}
		
	
	



