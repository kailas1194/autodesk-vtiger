package com.crm.autodeskSeleniumFramework.javaUtility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import com.crm.vtiger.leadRepository.HomePage;
import com.crm.vtiger.leadRepository.LoginPage;
/**
 * 
 * @Listeners(com.crm.autodeskSeleniumFramework.javaUtility.ListenerImplementationClass.class)
 * @author CHAVAN
 *
 */
public class BaseClass {
	public WebDriver driver=null;
	public WebDriverUtility wd=new WebDriverUtility();
	public ExcelUtility eu=new ExcelUtility();
	public JavaUtility ju=new JavaUtility();
	public PropertyUtility pro=new PropertyUtility();
	public HomePage hp=new HomePage(driver);
	public JDBCUtility database=new JDBCUtility();
	public static WebDriver sDriver;
	
	@BeforeSuite
	public void bs() {
		database.connectToDatabase();
	}
	@BeforeTest
	public void bt() {
		System.out.println("Execute script in parallel mode");
	}
	

	@BeforeClass
	public void bc() throws Throwable{
		String browser=pro.getPropertiesKeyValue("browser");
		String url=pro.getPropertiesKeyValue("url");
		
		if (browser.equals("chrome")) {
			 driver=new ChromeDriver();	
		}
		else if (browser.equals("firefox")) {
			driver=new FirefoxDriver();
		}else {
			System.out.println("please choose proper web browser");
		}
		driver.manage().window().maximize();
		driver.get(url);
		
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		sDriver=driver;
	}
  
	@BeforeMethod
	public void beforem() throws Throwable {
		String userName=pro.getPropertiesKeyValue("username");
		String passWord=pro.getPropertiesKeyValue("password");
		LoginPage lp=new LoginPage(driver);
		lp.login(userName, passWord);
	}

	@AfterMethod
	public void afterM() {
		
		hp.getSignOutLink();
	}
	
	@AfterClass
	public void afterC() {
		driver.quit();
	}
	
	@AfterTest
	public void afterT() {
		System.out.println("close parallel mode of execution");
	}
	
	@AfterSuite
	public void afterS() {
		database.closeConnection();
	}
}
