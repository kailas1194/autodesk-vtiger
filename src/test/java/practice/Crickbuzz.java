package practice;

import java.util.List;

import org.apache.commons.collections4.Get;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Crickbuzz {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.cricbuzz.com/cricket-stats/icc-rankings/women/batting");
		List<WebElement> all = driver.findElements(By.xpath("//div[@class='cb-col cb-col-100 cb-padding-left0']/descendant::a[@class='text-hvr-underline text-bold cb-font-16']"));

		int i=1;
		for (WebElement webElement : all) {
			
			System.out.println(i+" :: "+webElement.getText());
			i++;
		}
		
		driver.quit();
	}}
