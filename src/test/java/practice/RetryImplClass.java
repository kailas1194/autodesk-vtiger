package practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RetryImplClass {

	@Test(retryAnalyzer=practice.IRetryAnalyzerimplementatation.class)
	public void create() {
		System.out.println("retry");
		Assert.assertEquals(true, false);
	}
}
