package SingleScript;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Utilities.BaseClass;

public class DynamicBrowser extends BaseClass{
	  WebDriver wd;
	  Properties prp;
	  
	  @BeforeTest
	  public void setup() throws IOException {
		  
		  //String browser= "chrome"; // firefox , IE, Edge, Safari
		  //String url ="https://www.bmo.com/main/personal/credit-cards/bmo-rewards-mastercard/";
		    String propertyFileName="Project.properties";
		    prp=getProperties(propertyFileName);
		    String browser=prp.getProperty("browser");
		    wd =launchBrowser(browser);
		    
		  
		  
	  }
	  
	  @Test
	  public void test1() throws IOException, InterruptedException {
		  String currentDirectory= System.getProperty("user.dir");
		  System.out.println(currentDirectory);
			String url=prp.getProperty("url1");
		    wd.get(url);
		    //WebElement userId= wd.findElement(By.xpath("//input[@name='q']"));
		    WebElement icon = wd.findElement(By.xpath("//*[contains(text(),'Brands')[2]"));
		    icon.click();
		    
//		    WebElement userId= wd.findElement(By.name("email"));
//			userId.sendKeys("Haris.khan@abc.com");
//			
//			//Thread.sleep(5000);
//			//wd.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//			WebElement forgotpwdlink = wd.findElement(By.partialLinkText("password123"));
//			forgotpwdlink.click();
	  }
	  
	  
	  @Test
	  public void inputCrederntialsAndVerify() {
		 
	  }
	  
	  @AfterTest
	  public void tearDown() {
		 // wd.quit();
	  }
	  
	}