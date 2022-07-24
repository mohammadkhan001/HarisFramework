package TestSuiteA;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.ProfilesIni;
import org.testng.annotations.Test;

public class FirefoxProfilingAndOptions  {
	
	WebDriver wd;
	

	@Test
	public void testFirefox() {
		
		System.setProperty("webdriver.gecko.driver","C:\\Apps\\geckodriver.exe"); // Setting system properties of FirefoxDriver
		//  to generate firefox log
		System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "test-output\\firefox.log");
		
		
		
		
		ProfilesIni allProfile = new ProfilesIni();// to get all profiles
		FirefoxProfile firefoxProfile= allProfile.getProfile("Haris");  // get your own profile
		firefoxProfile.setPreference("dom.webnotifications.enabled", false);// set notifications disable 1
		
		firefoxProfile.setAcceptUntrustedCertificates(true);   //  Manage ssl certificate.               2
		firefoxProfile.setAssumeUntrustedCertificateIssuer(true);
		
//		// setting proxy  
		firefoxProfile.setPreference("network.proxy.type", 1);
//		firefoxProfile.setPreference("network.proxy.type", 1);
		firefoxProfile.setPreference("network.proxy.socks", "234.543.34.343");
		
		
		
		//set the profile into option
		FirefoxOptions options = new FirefoxOptions();
		// page load strategy
				//options.setPageLoadStrategy(strategy);
				//options.setBinary("C:\\Program Files\\Mozilla Firefox\\firefox.exe");
		options.setProfile(firefoxProfile);
		
		wd= new FirefoxDriver(options);
		// selenium 4 is managing ssl certificate  error.
		//wd.get("https://www.google.com/");
		wd.get("https://untrusted-root.badssl.com/");
		
		
	}
	
	

}
