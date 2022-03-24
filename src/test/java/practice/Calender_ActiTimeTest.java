package practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Calender_ActiTimeTest {

	@Test
	public void actitime() {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.get("https://www.goindigo.in/");
		driver.findElement(By.xpath("//button[@class='btn btn-primary btn-acc-cookie']")).click();
		driver.findElement(By.xpath("//i[@class='icon-close close-pass-tooltip']")).click();
	    driver.findElement(By.xpath("//i[@class='icon-close']")).click();
	    driver.findElement(By.name("or-depart")).click();
	    driver.quit();
	}
}
