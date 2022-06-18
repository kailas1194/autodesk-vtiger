package practice2;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.xml.XmlTest;

public class TestngTest {

	@Parameters()
	@Test()
	public void sample(XmlTest xml) {
		xml.getParameter("browser");
	}
	
	@Test()
	public void sample1() {
		
	}
	@Test()
	public void sample2() {
		
	}
}
