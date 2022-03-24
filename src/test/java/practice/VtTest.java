package practice;
import java.io.IOException;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class VtTest {

	@Test
	public void createOrg(){
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		Random rm=new Random();
		int num=rm.nextInt(100);
		String org="tyss"+num;
		driver.get("http://localhost:8888/");
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("manager");
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		 
		
		driver.findElement(By.name("accountname")).sendKeys(org);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		String name=driver.findElement(By.className("dvHeaderText")).getText();
		if (name.contains(org)) 
		{
		System.out.println("Pass:organization is created"+": : "+org);	
		}
		else 
		{
			System.out.println("Fail:organization is not created"+" : :"+org);		
		}

		Actions actions=new Actions(driver);
		actions.moveToElement(driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]"))).perform();
		driver.findElement(By.linkText("Sign Out")).click();
		driver.quit();
		
	}

}
