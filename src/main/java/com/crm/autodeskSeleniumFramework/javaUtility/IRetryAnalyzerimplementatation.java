package com.crm.autodeskSeleniumFramework.javaUtility;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
/**
 * this class is used to retry the failed test scripts
 * @author CHAVAN
 *
 */
public class IRetryAnalyzerimplementatation implements IRetryAnalyzer {
	int count=0;
	int retryCount=6;
	/**
	 * this method is used to retry the test script till result.
	 */
	public boolean retry(ITestResult result) {
		if (count<retryCount) {
			count++;
			return true;
			
		}
		return false;
	}

}
