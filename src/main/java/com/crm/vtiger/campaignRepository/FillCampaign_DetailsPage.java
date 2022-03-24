package com.crm.vtiger.campaignRepository;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.autodeskSeleniumFramework.javaUtility.WebDriverUtility;
/**
 * this class is used to fill details in campaign page
 * @author CHAVAN
 *
 */
public class FillCampaign_DetailsPage extends WebDriverUtility {
	
	/**
	 * initialization of webElements
	 * @param driver
	 */
	public FillCampaign_DetailsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);	
	}
	
	/**
	 * declaration of webElement of campaign page
	 */
	@FindBy(name="campaignname")
	private WebElement campaignname;
	
	@FindBy(xpath="//img[@title='Select']")
	private WebElement chooseProduct;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveCampaignIcon;
	
	@FindBy(id="1")
	private WebElement selectproduct;

	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveCampaign;
	
	
	public WebElement getSaveCampaign() {
		return saveCampaign;
	}


	public WebElement getSelectproduct() {
		return selectproduct;
	}


	public WebElement getCampaignname() {
		return campaignname;
	}

	
	public WebElement getChooseProduct() {
		return chooseProduct;
	}

	public WebElement getSaveCampaignIcon() {
		return saveCampaignIcon;
	}
	

	@FindBy(linkText="productname")
	private WebElement chooseProductname;
	
	
	public WebElement getChooseProductname() {
		return chooseProductname;
	}

	@FindBy(name="search_text")
	private WebElement searchTextField;
	
	@FindBy(name="search")
	private WebElement searchButton;
	
	public WebElement getSearchsearchButton() {
		return searchButton;
	}
	
	public WebElement getSearchTextField() {
		return searchTextField;
	}

	//business Logic
	
	/**
	 * This method is used to fill all details into the campaign page 
	 * and also choose product and select expected product.
	 * @param driver
	 * @param campaignName
	 * @param partialWindowTitle
	 */
	public void selectproductAndsaveCampaign(WebDriver driver,String campaignName,String partialWindowTitle) {
		campaignname.sendKeys(campaignName);
		chooseProduct.click();
		
		
		String parent1=driver.getWindowHandle();
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it = windows.iterator();
		while (it.hasNext()) {
			String windId = it.next();
			String title=driver.switchTo().window(windId).getTitle();
			if (title.contains(partialWindowTitle)) {
				break;
			}
			
		}
		searchTextField.sendKeys(campaignName);
		searchButton.click();
		selectproduct.click();
		
		driver.switchTo().window(parent1);
		saveCampaign.click();
	}

	
	
}
