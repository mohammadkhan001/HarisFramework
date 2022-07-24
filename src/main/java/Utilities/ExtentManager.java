package Utilities;

import java.io.File;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {

	static ExtentReports reports;
	static String screenshotPath;
	//static ExtentReports test;
	
	public static  ExtentReports getReport() {
		
		//  initializing path of report
		Date date = new Date() ;
		String udate= date.toString().replaceAll(":", ".").replaceAll(" ", "_");
		System.out.println(udate);
		String reportFolder= System.getProperty("user.dir")+"\\testReport\\"+udate;
		screenshotPath= reportFolder+"\\screenshots";
		System.out.println(screenshotPath);
		File file = new File(screenshotPath);
		file.mkdirs();
//		
		
		if (reports==null) {
			//String currenDir= System.getProperty("user.dir");
			// Initializing Report and Spark Reporter object
			reports = new ExtentReports();
			ExtentSparkReporter sparkrep = new ExtentSparkReporter(reportFolder);
			
			
			// Finalizing report configurations by specifing report name, theme and encoding
			sparkrep.config().setReportName("My First Extent Report");
			sparkrep.config().setDocumentTitle("Automation Testing");
			sparkrep.config().setTheme(Theme.STANDARD);
			sparkrep.config().setEncoding("utf-8");
			
			// integrate report with sparkReporter
			reports.attachReporter(sparkrep);
		}
		return reports;
	}
}

