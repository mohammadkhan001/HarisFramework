package Utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.ProfilesIni;
import org.testng.ITestContext;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class BaseClass {
	public WebDriver wd;
	public Properties prp;
	public static ExtentReports reports;
	public static ExtentTest test;
	public SoftAssert  softassert;
	
	@BeforeTest(alwaysRun=true)
	public void init(ITestContext context) throws IOException {
		String propertyFileName="Project.properties";
	    prp=getProperties(propertyFileName);
	    String browser=prp.getProperty("browser");
	    wd =launchBrowser(browser);
		softassert = new SoftAssert();
		context.setAttribute("WebDriver", wd);
		}

	@AfterTest(alwaysRun=true)
	public void teardown() {
		//reports.flush();
		//wd.quit();

	}
	
	public WebDriver launchBrowser( String browser) {
		
		
		
		switch(browser) {
		  case "chrome":{
			 
			  System.setProperty("webdriver.chrome.driver", "C:\\Apps\\chromedriver.exe");
				System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY, "test-output\\chrome.log");
				//System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
				
				ChromeOptions ops = new ChromeOptions();
				//ops.setBinary("");
				//ops.setPageLoadStrategy(strategy)
				ops.addArguments("--disable-notifications");
				ops.addArguments("--start-maximized");
				ops.addArguments("ignore-certificate-errors");
				//  do not run this : ops.addArguments("--proxy-server=http://89.2872.292.2:9090");
				
				//ops.addArguments("user-data-dir=C:\\Users\\nayan\\AppData\\Local\\Google\\Chrome\\User Data\\Profile6");
					
			   wd = new ChromeDriver(ops);
			   
			  
		  }
		  break;
		  case "firefox":{
			  
			  System.setProperty("webdriver.gecko.driver","C:\\Apps\\geckodriver.exe"); // Setting system properties of FirefoxDriver
				//  to generate firefox log
				System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "test-output\\firefox.log");
				
				
				
				
				ProfilesIni allProfile = new ProfilesIni();// to get all profiles
				FirefoxProfile firefoxProfile= allProfile.getProfile("Haris");  // get your own profile
				firefoxProfile.setPreference("dom.webnotifications.enabled", false);// set notifications disable 1
				
				firefoxProfile.setAcceptUntrustedCertificates(true);   //  Manage ssl certificate.               2
				firefoxProfile.setAssumeUntrustedCertificateIssuer(true);
				
//				// setting proxy  
				firefoxProfile.setPreference("network.proxy.type", 1);
//				firefoxProfile.setPreference("network.proxy.type", 1);
				firefoxProfile.setPreference("network.proxy.socks", "234.543.34.343");
				
				
				
				//set the profile into option
				FirefoxOptions options = new FirefoxOptions();
				// page load strategy
						//options.setPageLoadStrategy(strategy);
						//options.setBinary("C:\\Program Files\\Mozilla Firefox\\firefox.exe");
				options.setProfile(firefoxProfile);
				
				wd= new FirefoxDriver(options);
			  
		  }
		  break;
		  case "Edge":{
			  System.out.println("I am in edge");
		  }
		  default:
			  System.out.println("There is no browser mentioned");
			  
		  }
		wd.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		return wd;
	}


  

public  Properties getProperties(String fileName) throws IOException {
	   String currentDirectory= System.getProperty("user.dir");
		  System.out.println(currentDirectory);
			
			prp= new Properties();
			String path= currentDirectory+"\\"+fileName;
			//String path= "C:\\Users\\nayan\\eclipse-workspace\\Sample1\\FileHandling\\Project.properties";
			FileInputStream fs = new FileInputStream(path);
			prp.load(fs);
			return prp;
   }
   
   
   
   }
