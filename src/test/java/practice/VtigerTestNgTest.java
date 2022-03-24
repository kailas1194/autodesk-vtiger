package practice;

import org.testng.annotations.Test;

public class VtigerTestNgTest {

	@Test(groups="regressionTest")
	public void regression() {
		System.out.println("this is regression test");
	}
	
	@Test(groups="smokeTest")
	public void smoke() {
		System.out.println("this is smokeTest test");
	}
	
	@Test(groups="integrassionTest")
	public void integresion() {
		System.out.println("this is integresion test");
	}
}
