package com.vtiger.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	//initialization of webElement
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
	}
	
	WebDriver driver=null;
	//declaration of loginpage webelement
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
	
	public void login(String username,String password) {
		usernameTextfield.sendKeys(username);
		passwordTextfield.sendKeys(password);
		loginButton.click();
	}
	public String vtigerLoginTitle() {
		String title=driver.getTitle();
		return title;
	}
	

}
