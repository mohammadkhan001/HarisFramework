package SingleScript;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Utilities.BaseClass;

public class instantBrowser extends BaseClass{
	WebDriver wd;
	String currentDirectory;
	String path;
	Properties prp;
	
	@AfterTest
	public void teardown() {
		wd.close();

	}
	
	@BeforeTest
	public void init() throws IOException {
		currentDirectory= System.getProperty("user.dir");
		System.out.println(currentDirectory);
		
		prp= new Properties();
		path= currentDirectory+"\\Project.properties";
		//String path= "C:\\Users\\nayan\\eclipse-workspace\\Sample1\\FileHandling\\Project.properties";
		System.out.println("Path ----->"+path);
		FileInputStream fs = new FileInputStream(path);
		prp.load(fs);
		
		String browserName= prp.getProperty("browser");
		System.out.println("boewser is --->"+browserName);
		
		wd= launchBrowser(browserName);
			 
			    
		}

	@Test
	public void test() {
	  String url=prp.getProperty("url", "https://www.google.com");
	  System.out.println(url);
	  if(wd!=null) {
	  wd.get(url);
	  }
}
  }

