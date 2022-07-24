package Utilities;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;
import com.google.common.io.Files;

import Utilities.BaseClass;
import Utilities.ExtentManager;

public class ExtentReportListener extends BaseClass implements ITestListener, ISuiteListener {

	@Override
	public void onStart(ISuite suite) {
		//Create an html report for the suite that is executed
		//report = new ExtentReports("./report/" + suite.getName() + "_Results.html");
		reports =ExtentManager.getReport();
	}

	@Override
	public void onFinish(ISuite suite) {
		reports.flush();
	}

	@Override
	public void onTestStart(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		test =reports.createTest(methodName);
		
		test.log(Status.INFO, "Executing test: " + result.getMethod().getMethodName());

	}

	@Override
	public void onTestSuccess(ITestResult result) {
		
		test.log(Status.INFO, "Finished executing test");
	}


	@Override
	public void onTestFailure(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		
		String fileName = String.format(methodName, Calendar.getInstance().getTimeInMillis());
		Date date = new Date() ;
		String udate= date.toString().replaceAll(":", ".").replaceAll(" ", "_");
		System.out.println(udate);
		fileName=fileName+udate+".jpg";
		WebDriver driver = (WebDriver)result.getTestContext().getAttribute("WebDriver"); //use string from setAttribute from BasePage
		File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File destFile = new File(ExtentManager.screenshotPath +"\\"+ fileName);
		try {
			Files.copy(srcFile, destFile);
			System.out.println("Screenshot taken, saved in screenshots folder");
		} catch(IOException e) {
			System.out.println("Failed to take screenshot");
		}
		test.log(Status.FAIL, "Test failed, attaching screenshot in screenshots folder");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		test.log(Status.SKIP, "Test skipped");
	}

}