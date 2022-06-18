package domElement;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Xpath {
@Test
public void xpath() throws Throwable {
	WebDriverManager.chromedriver().setup();
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://www.amazon.in/");
	driver.findElement(By.xpath("//div[@id=\"nav-xshop\"]/a[text()='Mobiles']")).click();
	driver.get("https://www.amazon.in/mobile-phones/b/?ie=UTF8&node=1389401031&ref_=nav_cs_mobiles");
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	driver.findElement(By.xpath("//span[text()='Brands']/ancestor::div[@class=\"a-section a-spacing-small\"]/following-sibling::ul/descendant::span[text()='Redmi']/preceding-sibling::div")).click();
	Thread.sleep(5000);
}
}
