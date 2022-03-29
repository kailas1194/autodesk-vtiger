package practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.autodeskSeleniumFramework.javaUtility.ExcelUtility;
import com.crm.autodeskSeleniumFramework.javaUtility.WebDriverUtility;
import com.crm.vtiger.leadRepository.HomePage;
import com.crm.vtiger.leadRepository.LoginPage;
import com.crm.vtiger.leadRepository.Vtiger_LogOutPage;
import com.crm.vtiger.organizationRepository.ClickOn_CreateOrganizationIcon_Page;
import com.crm.vtiger.organizationRepository.Create_NewOrganization_Fillup_Page;
import com.crm.vtiger.organizationRepository.Verify_CreateNewOrganization_Page;
import com.crm.vtiger.organizationRepository.Verify_Organizations_Page;
@Listeners (com.crm.autodeskSeleniumFramework.javaUtility.IListenerImpClass.class)
public class CreateOrg_Verify_DeleteTest {
	@Test
	public void deleteOrg() throws Throwable {
		WebDriverUtility wd=new WebDriverUtility();
		ExcelUtility eu=new ExcelUtility();
		WebDriver driver=new ChromeDriver();
		wd.maximizeTheWindow(driver);
		wd.implicitWait(driver);
		Random rm=new Random();
		int num=rm.nextInt(100000);
		
		String filepath="./src/main/resources/common_data/properties.properties";
		FileInputStream fin=new FileInputStream(filepath);
		Properties pro=new Properties();
		pro.load(fin);
		String url=pro.getProperty("url");
		String username=pro.getProperty("username");
		String password=pro.getProperty("password");
		
		driver.manage().window().maximize();
		LoginPage login=new LoginPage(driver);
	
		login.login(driver, url, username, password);
		
		HomePage hp=new HomePage(driver);
	    hp.OrganizationsLink();
	    
	    Verify_Organizations_Page orgTitle=new Verify_Organizations_Page(driver);
	    String actualTitle=orgTitle.organizationsListTitle(driver);
	    if (actualTitle.contains("Organizations")) 
	    {
			System.out.println("PASS::organizations page is displayed");
		}
	    else 
	    {
			System.out.println("FAIL::organizations page is not displayed");
		}
	    
	    ClickOn_CreateOrganizationIcon_Page orgIcon=new ClickOn_CreateOrganizationIcon_Page(driver);
	    orgIcon.ClickOn_CreateOrganizationIcn(driver);
	    
	    Verify_CreateNewOrganization_Page createpage=new Verify_CreateNewOrganization_Page(driver);
	   String actualpageTitle= createpage.createorganizationTextt(driver);
	   if (actualpageTitle.contains("New"))  {
			System.out.println("PASS::create new organizations fillup page is displayed");
		}
	    else 
	    {
			System.out.println("FAIL::create new organizations fillup page is not displayed");
		}
	   
	   String organizationName=eu.getDataFromExcel("Sheet1", 3, 0)+num;
	   Create_NewOrganization_Fillup_Page fullFill=new Create_NewOrganization_Fillup_Page(driver);
	   fullFill.fillDetails(driver, organizationName);
	   
	   Actions action = new Actions(driver);
		action.moveByOffset(20,20).click().perform();
	   /*return organization */
	  WebDriverWait wait=new WebDriverWait(driver,5);
	 Thread.sleep(5000);
	  wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//a[@href='index.php?module=Accounts&action=index']"))));
	  driver.findElement(By.xpath("//a[@href='index.php?module=Accounts&action=index']")).click();
	   if (actualTitle.contains("Organizations")) 
	    {
			System.out.println("PASS::You are return back to list organizations page is displayed");
		}
	    else 
	    {
			System.out.println("FAIL::You are return back to list organizations page is not displayed");
		}
	   
	   for(;;)
		{
			try {
				driver.findElement(By.linkText(organizationName)).click();
				break;
			} catch (Exception e) {
				driver.findElement(By.xpath("//img[@src='themes/images/next.gif']")).click();
			}
			
		}

	   driver.findElement(By.xpath("//input[@title='Delete [Alt+D]']")).click();
	   driver.switchTo().alert().accept();
		 /**
		  * logout from the Vtiger application.
		  */
			
			  Vtiger_LogOutPage logout=new Vtiger_LogOutPage(driver);
			  logout.mouseHoverAndClickOnSignOut(driver); 
			  driver.quit();
			  
			 
	}

}
