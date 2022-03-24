package practice;

import org.testng.annotations.Test;

public class MultiGruopsInTest {

	@Test(groups={"regressionTest","smokeTest"})
	public void regression() {
		System.out.println("this is regression test");
	}
	
	@Test(groups="smokeTest")
	public void smoke() {
		System.out.println("this is smoke test");
	}
	
	@Test(groups="integrassionTest")
	public void integresion() {
		System.out.println("this is integresion test");
	}
}
