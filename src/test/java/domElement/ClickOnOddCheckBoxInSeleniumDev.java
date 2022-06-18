package domElement;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ClickOnOddCheckBoxInSeleniumDev {
@Test
public void domObject() throws Throwable {
	WebDriverManager.chromedriver().setup();
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("http://localhost:8888");
	driver.findElement(By.name("user_name")).sendKeys("admin");
	driver.findElement(By.name("user_password")).sendKeys("manager");
	driver.findElement(By.id("submitButton")).click();
	Thread.sleep(5000);
	driver.findElement(By.linkText("Organizations")).click();
	
	List<WebElement> checkboxlist = driver.findElements(By.xpath("//input[@name=\"selected_id\"]"));
	
	for(int i=0;i<checkboxlist.size();i++) {
		if(i%2==1) {
			driver.findElement(By.xpath("(//input[@name='selected_id'])[position()mod 2=1]")).click();
		}
		}
	}
	
}

