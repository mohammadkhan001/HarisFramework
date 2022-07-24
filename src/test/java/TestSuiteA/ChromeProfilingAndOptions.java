package TestSuiteA;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeTest;

public class ChromeProfilingAndOptions {
	
	@BeforeTest
	public void chrome() {
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
		
		ops.addArguments("user-data-dir=C:\\Users\\nayan\\AppData\\Local\\Google\\Chrome\\User Data\\Profile6");
		
		
		
		ChromeDriver cd = new ChromeDriver(ops);
		cd.get("https://untrusted-root.badssl.com/");
		// 100 lines
		
	}
	

}
