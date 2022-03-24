package practice;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class IRetryAnalyzerimplementatation implements IRetryAnalyzer {
	int count=0;
	int retryCount=6;
	public boolean retry(ITestResult result) {
		if (count<retryCount) {
			count++;
			return true;
			
		}
		return false;
	}

}
