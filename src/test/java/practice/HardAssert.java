package practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HardAssert {

	@Test
	public void haAssert() {
		// verify String value using hard Assert
		String name="kailas";
		String name1="kailas";
		
		Assert.assertEquals(name, name1);
		
		// verify integer value using hard Assert
		int a=10;
		int b=15;
		int d=25;
		int c=a+b;
		Assert.assertEquals(d, c);
		
		// verify boolean value using hard Assert
		boolean e=true;
		boolean f=true;
		Assert.assertEquals(e,f);
		
		//verify double value using hard Assert
		double num=15.5;
		double num2=15.5;
		Assert.assertEquals(num, num2);
		
		//verify float value using hard Assert
		
		float decimal=15f;
		float decimal1=15f;
		Assert.assertEquals(decimal, decimal1);
		
		
		
		
		
		
		
		
	}
}
