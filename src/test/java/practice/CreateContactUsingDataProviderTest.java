package practice;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CreateContactUsingDataProviderTest {

	@Test(dataProvider="getData")
	public void multipleDataToCreateContact(String url,String username,String password,String lastname,String phoneno) {
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
   
	driver.get(url);
	driver.findElement(By.name("user_name")).sendKeys(username);
	driver.findElement(By.name("user_password")).sendKeys(password);
	driver.findElement(By.id("submitButton")).click();
	driver.findElement(By.linkText("Contacts")).click();
	driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
	driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(lastname);
	driver.findElement(By.id("phone")).sendKeys(phoneno);
	driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	 
	driver.quit();
	}
	
	@DataProvider
	public Object[][] getData() {
		
		Object[][] objectArray = new Object[5][5];
		
		  objectArray[0][0]="http://localhost:8888";
		   objectArray[0][1]="admin";
		  objectArray[0][2]="manager";
		   objectArray[0][3]="ade";
		  objectArray[0][4]="5064080462";
		 
		objectArray[1][0]="http://localhost:8888";
		objectArray[1][1]="admin";
		objectArray[1][2]="manager";
		objectArray[1][3]="pawar";
		objectArray[1][4]="9080405060";
		
		objectArray[2][0]="http://localhost:8888";
		objectArray[2][1]="admin";
		objectArray[2][2]="manager";
		objectArray[2][3]="jadhav";
		objectArray[2][4]="9080706050";
		
	
		objectArray[3][0]="http://localhost:8888";
		objectArray[3][1]="admin";
		objectArray[3][2]="manager";
		objectArray[3][3]="goyal";
		objectArray[3][4]="5060708090";
		
		objectArray[4][0]="http://localhost:8888";
		objectArray[4][1]="admin";
		objectArray[4][2]="manager";
		objectArray[4][3]="lall";
		objectArray[4][4]="2030405060";
		
		return objectArray;
	
	}
	
	
}
