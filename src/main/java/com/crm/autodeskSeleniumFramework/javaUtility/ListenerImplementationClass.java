package com.crm.autodeskSeleniumFramework.javaUtility;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
/**
 * this class is used to the implementation of listeners class
 * @author CHAVAN
 *
 */
public class ListenerImplementationClass  implements ITestListener {

	/**
	 * this method is used to start the test
	 */
	public void onTestStart(ITestResult result) {
		String methodname = result.getMethod().getMethodName();
		System.out.println(methodname+"--------> test start");
	}

	/**
	 * this method is used to displayed result.
	 */
	public void onTestSuccess(ITestResult result) {
		String methodname = result.getMethod().getMethodName();
		System.out.println(methodname+"--------> execution successfull");
	}

	/**
	 * this method is used to take screen shot of failed test script.
	 */
	public void onTestFailure(ITestResult result) {
		String methodname = result.getMethod().getMethodName();
		System.out.println(methodname+"-------->execution failed");
		System.out.println(result.getThrowable());
		
		try {
			new WebDriverUtility().takeScreenshot(BaseClass.sDriver, methodname);
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * this method is used to displayed skipped test cases.
	 */
	public void onTestSkipped(ITestResult result) {
		String methodname = result.getMethod().getMethodName();
		System.out.println(methodname+"-----------> execution skipped");
		System.out.println(result.getThrowable());
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		String methodname = result.getMethod().getMethodName();
		System.out.println(methodname+"----> Test Failed But Within Success Percentage");
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	public void onStart(ITestContext context) {
		System.out.println("execution started");
	}

	public void onFinish(ITestContext context) {
		System.out.println("execution finished");
	}

}
