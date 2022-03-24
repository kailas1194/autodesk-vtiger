package practice;

import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CalenderForFutureDate {
	@Test
	public void futuredate() {
		
		/*browser specific code*/
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
		/* used to take system date and time */
		LocalDateTime dateAndTime = LocalDateTime.now().plusDays(50);
		 String month=dateAndTime.getMonth().toString();
		 int date = dateAndTime.getDayOfMonth();
		 int year = dateAndTime.getYear();
		 String monthFormat=month.substring(0,1)+month.substring(1).toLowerCase();
		 String monthAndYear=monthFormat+" "+year;
		
		 /* navigate to url of the application*/
		driver.get("https://www.makemytrip.com");
		Actions action = new Actions(driver);
		action.moveByOffset(20,20).click().perform();

		driver.findElement(By.xpath("//span[@class='langCardClose']")).click();
		
		/*from city*/
		driver.findElement(By.id("fromCity")).click();
		driver.findElement(By.xpath("//input[@placeholder='From']")).sendKeys("mumbai");
		driver.findElement(By.xpath("//div[text()='BOM']")).click();
		
		/*destination city*/
		
		action.moveByOffset(20,20).click().perform();
		driver.findElement(By.xpath("//span[@data-cy='defaultToValue']")).click();
		WebElement destination = driver.findElement(By.xpath("//input[@placeholder='To']"));
		destination.sendKeys("Nagpur,India");
		driver.findElement(By.xpath("//div[text()='NAG']")).click();
		
		/*select departure date*/
		driver.findElement(By.xpath("//span[text()='DEPARTURE']")).click();
	    String calender = "//div[text()='"+monthAndYear+"']/ancestor::div[@class='DayPicker-Month']/descendant::p[text()='"+date+"']";
        driver.findElement(By.xpath(calender)).click();
        
        driver.findElement(By.xpath("//a[@class='primaryBtn font24 latoBold widgetSearchBtn ']")).click();
        
        driver.findElement(By.xpath("//span[@class='bgProperties icon20 overlayCrossIcon']")).click();
       
        /* capture all flight name*/
       List<WebElement> allFlight = driver.findElements(By.xpath("//span[@class='boldFont blackText airlineName']"));
       
       for (WebElement webElement : allFlight) {
    	   
    	   System.out.println("flight name ::  "+webElement.getText());	
	       }
    	
       driver.quit();
	}
}
