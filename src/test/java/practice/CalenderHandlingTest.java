package practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CalenderHandlingTest {
	@Test
	public void calenderhandling(){
	WebDriverManager.chromedriver().setup();
	ChromeDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	String monthAndYear="March 2022";
	String date="25";
	driver.get("https://www.makemytrip.com");
	
	Actions action = new Actions(driver);
	action.moveByOffset(20,20).click().perform();
	driver.findElement(By.xpath("//span[@class='langCardClose']")).click();
	driver.findElement(By.xpath("//span[text()='DEPARTURE']")).click();
String calender = "//div[text()='"+monthAndYear+"']/ancestor::div[@class='DayPicker-Month']/descendant::p[text()='"+date+"']";
	
	for(;;)
	{
		try {
			driver.findElement(By.xpath(calender)).click();
			break;
		} catch (Exception e) {
			driver.findElement(By.xpath("//span[@aria-label='Next Month']")).click();
		}
		
	}
	
	System.out.println("Thank you for visiting MakeMyTrip");
	driver.quit();
}
	
}

