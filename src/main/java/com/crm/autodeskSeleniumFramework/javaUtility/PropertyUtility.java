package com.crm.autodeskSeleniumFramework.javaUtility;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * 
 * @param args
 * @throws IOException
 * @throws InterruptedException
 */
public class PropertyUtility {
	/**
	 * it is used to read the common data from properties file based on key.
	 * which you pass as an argument.
	 * @param key
	 * @return
	 * @throws IOException 
	 */
public String getPropertiesKeyValue(String key) throws IOException {
	
		String filepath="./src/main/resources/common_data/properties.properties";
		FileInputStream fin = new FileInputStream(filepath);
		Properties pro=new Properties();
		pro.load(fin);
		String value=pro.getProperty(key);
		return value;
		
		
}}
