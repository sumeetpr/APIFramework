package utils;

import java.io.File;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;



public class ExtentReportListner implements ITestListener{
	
	
	public static ExtentReports report;
	public static ExtentTest test;

	public static String resultPath= getResultPath();
	
	public static void deleteDirectory(File directory) 
	{
		
		File[] files = directory.listFiles();
		
		if (null!=files) 
		{
			
			for (int i = 0; i < files.length; i++) 
			{
			System.out.println(files[i].getName());
				
			if(files[i].isDirectory()) 
					deleteDirectory(files[i]);
			else 
					files[i].delete();
				
			}
		}	
	}
	
	private static String getResultPath() {
		
		resultPath = "test";
		
		if(!new File(resultPath).isDirectory()) {
			new File(resultPath);
		}
		return resultPath;
		
	}
	
	String resultLocation = System.getProperty("user.dir")+"\\test-output\\";
	
	public void onTestStart(ITestResult result) {

		
	}

	public void onTestSuccess(ITestResult result) {
		
		test.log(LogStatus.PASS, "Test is Passed");
		
	}

	public void onTestFailure(ITestResult result) {
		test.log(LogStatus.FAIL, "Test is Failed");
		
	}

	public void onTestSkipped(ITestResult result) {
		test.log(LogStatus.SKIP, "Test is Skipped");
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		System.out.println("Report Location" + resultLocation);
		report = new ExtentReports( resultLocation+ "ExtentReport.html");
		test = report.startTest("");
		
	}

	public void onFinish(ITestContext context) {
		report.endTest(test);
		report.flush();
		
	}
	
	
	

}
