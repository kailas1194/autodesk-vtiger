package com.crm.vtiger.leadRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * this class is used to store all login page webelements.
 * @author CHAVAN
 *
 */
public class LoginPage {
	
	/**
	 * initialization of webElement
	 * @param driver
	 */
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
	}
	/**
	 * declaration of loginpage webelement
	 */
	@FindBy(name="user_name")
	private WebElement usernameTextfield;
	
	@FindBy(name="user_password")
	private WebElement passwordTextfield;
	
	@FindBy(id="submitButton")
	private WebElement loginButton;

	public WebElement getUsername() {
		return usernameTextfield;
	}
	public WebElement getPassword() {
		return passwordTextfield;
	}
	public WebElement getLoginButton() {
		return loginButton;
	}
	
	public String vtigerLoginTitle(WebDriver driver) {
		String title=driver.getTitle();
		return title;
		
	}
	
	/**
	 * this method is used to fill all credentials (username and password) and click on login button
	 * @param username
	 * @param password
	 */
	public void login(String username,String password) {
		
		usernameTextfield.sendKeys(username);
		passwordTextfield.sendKeys(password);
		
		loginButton.click();
	}
	/**
	 * this method is used to fill all credentials (driver,url,username and password) and click on login button
	 * @param driver
	 * @param url
	 * @param username
	 * @param password
	 */
public void login(WebDriver driver,String url,String username,String password) {
		driver.get(url);
		usernameTextfield.sendKeys(username);
		passwordTextfield.sendKeys(password);
		
		loginButton.click();
	}
	

}
