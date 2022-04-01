package practice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Olympic_athelet {
	public static void main(String[] args) throws Throwable {
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		String athleteName="ren";
		driver.get("https://olympics.com/en/athletes/"+athleteName);
		
		String AthleteMedals="//h1[text()='"+athleteName+"']/ancestor::div[@class='b2p-grid__inner athlete-wrap -no-gap']/descendant::div[@class='col-right d-flex']";
		
		Thread.sleep(5000);
		driver.switchTo().frame("amp_iframe0");
		
		driver.findElement(By.id("onetrust-accept-btn-handler")).click();
	
		List<WebElement> medal = driver.findElements(By.xpath(AthleteMedals));
		
		for (WebElement webElement : medal) {
			
			System.out.println(webElement.getText());
			
		}
		
		driver.quit();
	}
	

}
