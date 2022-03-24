package practice;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
public class LastSelectUsingForLoopTest {
	@Test
	public void lastUsingloop() {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
		driver.get("http://localhost:8888/");
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("manager");
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.linkText("Organizations")).click();
		
		List<WebElement> allCheckbox = driver.findElements(By.xpath("//input[@name='selected_id']"));
		
		for(int i=0;i<=allCheckbox.size();i++)
		{
			allCheckbox.get(allCheckbox.size()-1).click();
			break;
		}
		driver.quit();
	}
}
