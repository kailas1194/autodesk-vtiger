package com.crm.autodeskSeleniumFramework.javaUtility;

import java.io.File;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

/**
 * this class contains webDriver specific generic methods
 *  * @author Kailas
 */
public class WebDriverUtility {
/**
 * this method wait for 20 sec for page loading
 * @param driver
 */
	public void implicitWait(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	}
	
	/**
	 * this method is used to maximize the window
	 */
	
	public void maximizeTheWindow(WebDriver driver) {
		driver.manage().window().maximize();
	}
	
	
	
	/**
	 * this method wait for element to be visible
	 * @param driver
	 */
		public void waitForElementVisibility(WebDriver driver,WebElement element) {
			WebDriverWait wait=new WebDriverWait(driver,20);
			wait.until(ExpectedConditions.visibilityOf(element));
		}
		
		/**
		 * this method wait for element to be clicked,its custom wait created to avoid elementInterceptedException
		 * @param element
		 * @throws InterruptedException 
		 * @throws throwable
		 */
			public void waitAndClick(WebElement element)throws InterruptedException {
				int count=0;
				while(count<20) {
					try {
						element.click();
						break;
					}
					catch (Throwable e) {
						Thread.sleep(1000);
						count++;
						// TODO: handle exception
					}
				}
			}
				
			/**
			 * this method is enables user to handle dropdown using index
			 * @param element
			 */
				public void select(WebElement element,int index) {
					Select select=new Select(element);
					select.selectByIndex(index);
				}
				
				/**
				 * this method is enables user to handle dropdown using value
				 * @param element
				 */
					public void selectByvalue(WebElement element,String value) {
						Select select=new Select(element);
						select.selectByValue(value);
					}
					
					/**
					 * this method is enables user to handle dropdown using Visible text
					 * @param element
					 */
						public void selectByVisible(WebElement element,String text) {
							Select select=new Select(element);
							select.selectByVisibleText(text);
						}
						
						/**
						 * this method is enables user to handle dropdown using deselect All.
						 * @param element
						 */
							public void deselectAll(WebElement element) {
								Select select=new Select(element);
								select.deselectAll();
								
							}
							
							/**
							 * this method is enables user to handle dropdown using deselect By Index 
							 * @param element
							 */
								public void deselectByIndex(WebElement element,int index) {
									Select select=new Select(element);
									select.deselectByIndex(index);
								}
							
								/**
								 * this method is enables user to handle dropdown using deselect By value 
								 * @param element
								 */
									public void deselectByValue(WebElement element,String value) {
										Select select=new Select(element);
										select.deselectByValue(null);
									}
									
									/**
									 * this method is enables user to handle dropdown using deselect By text 
									 * @param element
									 */
										public void deselectByVisibleText(WebElement element,String text) {
											Select select=new Select(element);
											select.deselectByVisibleText(text);
										}
										
		
				
				/**
				 * this method is used to mouse over actions
				 * @param element
				 * @param driver
				 */
				   public void mouseHover(WebDriver driver,WebElement element) {
					Actions actions=new Actions(driver);
					actions.moveToElement(element).perform();
				}
				
				/**
				 * this method is used to clickAndHold actions
				 * @param element
				 * @param driver
				 */
				public void clickAndHold(WebDriver driver,WebElement element) {
					Actions actions=new Actions(driver);
					actions.clickAndHold(element).perform();
				}
				
				/**
				 * this method is used to doubleClick actions
				 * @param element
				 * @param driver
				 */
				public void doubleClick(WebDriver driver,WebElement element) {
					Actions actions=new Actions(driver);
					actions.doubleClick(element).perform();
				}
				
				/**
				 * this method is used to pause actions for seconds
				 * @param element
				 * @param driver
				 */
				public void pause(WebDriver driver,int seconds) {
					Actions actions=new Actions(driver);
					actions.pause(Duration.ofSeconds(seconds)).perform();
				}
				
				
				/**
				 * this method is helps to switch from one window to another
				 * @param driver
				 * @param partialWindowTitle
				 */
				public void switchToWindow(WebDriver driver,String partialWindowTitle) {
					String parent=driver.getWindowHandle();
					Set<String> windows = driver.getWindowHandles();
					Iterator<String> it = windows.iterator();
					while (it.hasNext()) {
						String windId = it.next();
						String title=driver.switchTo().window(windId).getTitle();
						if (title.contains(partialWindowTitle)) {
							break;
						}
					}
				}
				
				
				/**
				 * this method is used to accept the alert popup
				 * @param driver
				 */
				public void acceptAlert(WebDriver driver) {
					driver.switchTo().alert().accept();
				}
				
				/**
				 * this method is used to cancel the alert popup
				 * @param driver
				 */
				public void cancelAlert(WebDriver driver) {
					driver.switchTo().alert().dismiss();
				}
				
				/**
				 * this method is used to getTextOfAlert the alert popup
				 * @param driver
				 */
				public void getTextOfAlert(WebDriver driver) {
					driver.switchTo().alert().getText();
				}
				
				/**
				 * this method is used to sendKeys to the alert popup
				 * @param driver
				 */
				public void SendkeysToAlert(WebDriver driver,String charsequence) {
					driver.switchTo().alert().sendKeys(charsequence);
				}
				
				
				/**
				 * this method is used to scrolling the webpage.
				 * @param driver
				 * @param element
				 * 
				 */
				
				public void scrollToElement(WebDriver driver,WebElement element) {
					JavascriptExecutor jse=(JavascriptExecutor) driver;
					int y=element.getLocation().getY();
					jse.executeScript("window.scrollBy(0,"+y+")",element);
				}
				
				
				/**
				 * this method is used for take a screenshot
				 * @param driver
				 * @param screenshotName
				 * @throws Throwable
				 */
			    public String takeScreenshot(WebDriver driver, String screenshotName) throws Throwable {
			    	TakesScreenshot ts=(TakesScreenshot)driver;
			    	File src=ts.getScreenshotAs(OutputType.FILE);
			    	String timeStamp=LocalDateTime.now().toString().replace(":","-");
			    	File dest=new File("./screenshot/"+timeStamp+screenshotName+".PNG");
			    	FileUtils.copyFile(src, dest);
					return dest.getAbsolutePath();
			        }

				
				
				
				
				
				
				
}
			
