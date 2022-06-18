package dynamicWebTable;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SelectOnlyOddCheckBox {
@Test
	public void checkBox() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("http://localhost:8888");
		driver.findElement(By.xpath("//input[@name=\"user_name\"]")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@name=\"user_password\"]")).sendKeys("manager");
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.linkText("Organizations")).click();
		List<WebElement> allCheckBox = driver.findElements(By.xpath("//table[@class=\"lvt small\"]/tbody/tr/td/input[@name=\"selected_id\"]"));
		for (WebElement webElement : allCheckBox) {
			int i=1;
				if(i/2!=0) {
					webElement.click();
				}
		i++;
	
}}}
