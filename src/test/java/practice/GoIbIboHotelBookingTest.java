package practice;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.crm.autodeskSeleniumFramework.javaUtility.ExcelUtility;
import com.crm.autodeskSeleniumFramework.javaUtility.WebDriverUtility;
import com.mysql.cj.x.protobuf.MysqlxExpect.Open.Condition.Key;

public class GoIbIboHotelBookingTest {
	@Test
	public void goibgo() throws Throwable{
		WebDriverUtility wd=new WebDriverUtility();
		ExcelUtility eu=new ExcelUtility();
		WebDriver driver=new ChromeDriver();
		wd.maximizeTheWindow(driver);
		wd.implicitWait(driver);
		
		driver.get("https://www.goibibo.com/");
		driver.findElement(By.linkText("Hotels")).click();
		driver.findElement(By.xpath("//h4[text()='India']/preceding-sibling::input")).click();
		
		/**
		 * used to click on search icon and send keys in search text field
		 */
		driver.findElement(By.xpath("//input[@data-testid='home-autosuggest-input']")).click();
	    driver.findElement(By.xpath("//input[@data-testid='home-autosuggest-input']")).sendKeys("Bengaluru");
		
	    //wait for element fully load.
	    Thread.sleep(10000);
	    
	    /**
	     * used to handle autosugestion drop down using sendkeys keys.without action class.
	     */
	    driver.findElement(By.xpath("//input[@data-testid='home-autosuggest-input']")).sendKeys(Keys.ARROW_DOWN);
	    driver.findElement(By.xpath("//input[@data-testid='home-autosuggest-input']")).sendKeys(Keys.ENTER);

	    driver.findElement(By.xpath("//div[text()='Check-in']/following-sibling::h4[@class='dwebCommonstyles__SmallSectionHeader-sc-112ty3f-9 SearchBlockUIstyles__CheckInDateWrapDiv-sc-fity7j-14 bjZxoj kSflmU']")).click();
	    driver.findElement(By.xpath("//span[@data-testid='date_12_3_2022']")).click();
	    
	    Thread.sleep(3000);
	    driver.findElement(By.xpath("//div[text()='Check-out']/following-sibling::h4[@class='dwebCommonstyles__SmallSectionHeader-sc-112ty3f-9 SearchBlockUIstyles__CheckInDateWrapDiv-sc-fity7j-14 bjZxoj kSflmU']")).click();
	    driver.findElement(By.xpath("//span[@data-testid='date_19_3_2022'")).click();
	    
	    
	    
	    /**
	     * used to click on child icon and add child.
	     */
	    driver.findElement(By.xpath("//input[@class='SearchBlockUIstyles__CitySearchInput-sc-fity7j-12 uGGSH']")).click();
	    driver.findElement(By.xpath("//span[text()='Children']/following::span[text()='+']")).click();
	    driver.findElement(By.xpath("//span[text()='Children']/following::span[text()='+']")).click();
	    driver.findElement(By.xpath("//span[text()='Children']/following::span[text()='+']")).click();
	    
	    
	    /**
	     * find child age select dropdown and select age using foreach loop
	     */
	    String select="//p[@class='PaxWidgetstyles__SelectedChildAgeErrorText-sc-gv3w6r-12 cvwGUW']/ancestor::div[@class='dwebCommonstyles__CenteredDivWrap-sc-112ty3f-1 PaxWidgetstyles__ContentItemWrapperDiv-sc-gv3w6r-2 ibYPGm fAmNIr']/div";
	   List<WebElement> selectAge= driver.findElements(By.xpath(select));
	 
	    for (WebElement ele : selectAge) {
		  ele.click();
		   driver.findElement(By.xpath("//ul[@class='PaxWidgetstyles__ChildDropdownWrap-sc-gv3w6r-9 cuOfFa']/li[text()='1']")).click();
}
	    driver.findElement(By.xpath("//button[text()='Done']")).click();
	    
	    //used to click on search hotel button
	    driver.findElement(By.xpath("//button[text()='Search Hotels']")).click();
	   
	    
	    
	    
	    /**
	     * to store all hotels and print all hotels name using foreach loop
	     */
	    List<WebElement> allHotels = driver.findElements(By.xpath("//h4[@itemprop='name']"));
	    int number=1;
	    for (WebElement webElement : allHotels) {
	    	System.out.println("Hotel No. ::"+number+":: "+"hotel name :: "+webElement.getText());
			number++;
		}
	    
	    
	    
	    
	    driver.quit();
}
}
