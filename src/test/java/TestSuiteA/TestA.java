package TestSuiteA;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import Utilities.BaseClass;

@Listeners(Utilities.ExtentReportListener.class)

public class TestA extends BaseClass {

	
	
	List<WebElement> we;
	WebElement element;
	
	

	@Test
	public void testA() throws InterruptedException {
		System.out.println("The thread ID for testA is "+ Thread.currentThread().getId());

		System.out.println("I am test A");
		Thread.sleep(2000);
		System.out.println("I am test ABCD");
		String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
		test =reports.createTest(methodName);
		
		test.log(Status.INFO, "Start Login into application");
		test.log(Status.INFO, "Opening Chrome Browser");
		test.log(Status.INFO, "Login into Facebook");
		test.log(Status.INFO, "Testing");


	}

	@Test( priority=1)
	public void testBMOLoginPage() {

		String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
		test =reports.createTest(methodName);
        
		wd.get("https://www.bmo.com/main/personal/credit-cards/bmo-rewards-mastercard/");
		test.log(Status.PASS, "Able to open web link");

	}

	//@Test(dependsOnMethods="testBMOLoginPage", priority=2)
	public void testMainNavLinks() {

		String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
		test =reports.createTest(methodName);
//		
		
		we= wd.findElements(By.xpath("//*[@id='personal-site-wrapper']//button[contains(@class, 'main-nav__link link lob-nav__tab')]"));
		
		
	
		//we= wd.findElements(By.cssSelector("*#personal-site-wrapper button.main-nav__link.link.lob-nav__tab"));
				
		
		String[] expectedButtonList = {"Bank Account","Credit Cards","Mortgages","Loans & Lines of Credit","Investments"
				,"Financial Planning","Insurance","Ways to Bank", "About BMO"};
		
		if(expectedButtonList.length==we.size()) {
			for ( int i=0 ;i<we.size();i++) {	
					softassert.assertEquals(we.get(i).getText().trim(),expectedButtonList[i],test.log(Status.INFO, "expected "+expectedButtonList[i]+" And  found "+we.get(i).getText().trim() ).toString());

				  
			}
			softassert.assertAll();

		}
		else {
			test.log(Status.FAIL, "Count mismatch");
			Assert.fail("count mismatch");
		}


	}
	
	
	@Test( priority=2)
	public void testPernalForm() {

		String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
		test =reports.createTest(methodName);
//        
		wd.get("https://www.bmo.com/home/personal/banking/financial-planning/financial-planner-contact/?mapfp=true");
		test.log(Status.PASS, "Able to open web link");
		wd.findElement(By.id("questionOneButtonTwo")).click();
		Select UserTitles = new Select(wd.findElement(By.id("userNetworth")));
		UserTitles.selectByIndex(0);
		

	}





}
