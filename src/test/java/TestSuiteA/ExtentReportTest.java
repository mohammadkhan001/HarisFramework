package TestSuiteA;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import Utilities.ExtentManager;

public class ExtentReportTest {
	
	ExtentReports reports;
	ExtentTest test;
	
	
	@BeforeTest
	public void init() {
		
		reports =ExtentManager.getReport();
			
		
	}
	
	@AfterTest
	public void teardown() {
		reports.flush();
	}
	
	@Test
	public void doLogin() {
		
		// Create Test
		String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
		test =reports.createTest(methodName);
		test.log(Status.INFO, "Start Login into application");
		test.log(Status.INFO, "Opening Chrome Browser");
		test.log(Status.INFO, "Login into Facebook");
		test.log(Status.INFO, "Testing");
		test.log(Status.FAIL, "Test Failed");
		test.addScreenCaptureFromPath("C:\\Apps\\screenshot.png","Error message 404");
		
		
		
		
	}
	
	
	
}
