package practice;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.xml.XmlTest;

public class DataDrivenTestFromXmlFile {
    
	@Test
	public void xmlData(XmlTest xml)
	{
		System.out.println(xml.getParameter("browser"));
		System.out.println(xml.getParameter("url"));
		System.out.println(xml.getParameter("username"));
		System.out.println(xml.getParameter("password"));
	}
}
