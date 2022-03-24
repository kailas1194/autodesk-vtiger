package practice;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftassertTest {

	@Test
	public void softAssert() {
		SoftAssert soft=new SoftAssert();
		String name="kailas";
		String name1="kailas";
		
		soft.assertEquals(name, name1);
		
		// verify integer value using hard Assert
		int a=10;
		int b=15;
		int d=25;
		int c=a+b;
		soft.assertEquals(d, c);
		
		// verify boolean value using soft Assert
		boolean e=true;
		boolean f=false;
		soft.assertEquals(e,f);
		
		//verify double value using soft Assert
				double num=15.5;
				double num2=15.5;
				soft.assertEquals(num, num2);
				
				//verify float value using soft Assert
				
				float decimal=15f;
				float decimal1=15f;
				soft.assertEquals(decimal, decimal1);
		
		
		
		
	}
}
