package com.crm.autodeskSeleniumFramework.javaUtility;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class IListenerImpClass implements ITestListener{
    ExtentTest test;
	ExtentReports report;
	
	@Override
	public void onTestStart(ITestResult result) {
		//step 3:create a test method during the test execution starts.
		test=report.createTest(result.getMethod().getMethodName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS,result.getMethod().getMethodName());
	}

	@Override
	public void onTestFailure(ITestResult result) {
		test.log(Status.FAIL,result.getMethod().getMethodName());
		test.log(Status.FAIL,result.getThrowable());
		String path=null;
		WebDriverUtility wUtil=new WebDriverUtility();
		try {
			path=wUtil.takeScreenshot(BaseClass.sDriver,result.getMethod().getMethodName());
		} catch (Throwable e) {
			
			e.printStackTrace();
			
		}
		test.addScreenCaptureFromPath(path);
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		test.log(Status.SKIP,result.getMethod().getMethodName());
		test.log(Status.SKIP,result.getThrowable());
	}

	@Override
	public void onStart(ITestContext context) {
		//step 1: extent report configuration.
		ExtentSparkReporter htmlextentreport = new ExtentSparkReporter("./extentreports"+new JavaUtility().getSystmeDate()+".html");
		htmlextentreport.config().setReportName("Smoke execution report");
		htmlextentreport.config().setDocumentTitle("autodesk selenium framework execution");
		htmlextentreport.config().setTheme(Theme.DARK);
		
		//step 2:attach physical report and do system configuration.
		
		report=new ExtentReports();
		report.attachReporter(htmlextentreport);
		report.setSystemInfo("os",System.getProperty("os.name"));
		report.setSystemInfo("environment","testing environment");
		report.setSystemInfo("url","http://localhost:8888");
		report.setSystemInfo("reporter name","kailas");	
	}

	@Override
	public void onFinish(ITestContext context) {
	report.flush();
	}

}
