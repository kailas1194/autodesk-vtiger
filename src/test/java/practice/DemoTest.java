package practice;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.autodeskSeleniumFramework.javaUtility.BaseClass;

@Listeners (com.crm.autodeskSeleniumFramework.javaUtility.IListenerImpClass.class)
public class DemoTest extends BaseClass {
	
	@Test
	public void demo() {
		
	}

	@Test
	public void demo1() {
		Assert.fail();
	}
	
	
	

}
