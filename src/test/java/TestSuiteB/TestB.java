package TestSuiteB;

import org.testng.annotations.Test;

public class TestB {
	
	@Test
	public void testB() throws InterruptedException {
		 System.out.println("The thread ID for testB is "+ Thread.currentThread().getId());
		 
		System.out.println("I am test B");
		Thread.sleep(2000);
		System.out.println("I am test BCDE");
	}

}