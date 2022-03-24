package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.crm.autodeskSeleniumFramework.javaUtility.JavaUtility;
import com.crm.autodeskSeleniumFramework.javaUtility.PropertyUtility;
import com.crm.autodeskSeleniumFramework.javaUtility.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Calender_JQueryTest {

	@Test
	public void calender() throws Throwable {
	WebDriverUtility wd=new WebDriverUtility();

	
    WebDriver driver=new ChromeDriver();
	wd.implicitWait(driver);
	WebDriverWait wait=new WebDriverWait(driver,20);
	driver.manage().window().maximize();
	driver.get("https://jqueryui.com/datepicker/");
	driver.switchTo().frame(0);
	driver.findElement(By.id("datepicker")).click();
	String month="March";
	String year="2022";
	String date="28";
	
	String date1="//div[@class='ui-datepicker-title']/child::span[.='"+month+"']/following-sibling::span[.='"+year+"']/following::table/child::tbody/child::tr/child::td/child::a[.='"+date+"']";
	
	
	//select date from
	driver.findElement(By.xpath(date1)).click();
	Thread.sleep(20000);
	driver.quit();
	
}
}
