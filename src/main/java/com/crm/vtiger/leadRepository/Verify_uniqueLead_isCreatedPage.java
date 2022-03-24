package com.crm.vtiger.leadRepository;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * this class is used to verify unique lead is present in lead list.
 * @author CHAVAN
 *
 */
public class Verify_uniqueLead_isCreatedPage {

	/**
	 * initialization of elements
	 * @param driver
	 */
	public Verify_uniqueLead_isCreatedPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	/**
	 * this is used to make element private
	 */
	
	@FindBy(xpath="//img[@src='themes/images/next.gif']")
	private WebElement nextButton;

	public WebElement getNextButton() {
		return nextButton;
	}
	/**
	 * this method is used to verify whether new lead number is present or not.
	 * @param driver
	 * @return 
	 */
	public List<WebElement> verifyleadisPresentInList(WebDriver driver)
	{
		
		List<WebElement> leadList = driver.findElements(By.xpath("//td[contains(text(),'LEA')]"));
		return leadList;
		
		
	}
	public void ifLeadisNotPresentInList()
	{
		nextButton.click();
	}
	
	
}
