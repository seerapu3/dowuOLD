package Listner_demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(Listner_demo.ListenerTest.class)
public class lTestCases {
	
	@Test
	public void Login()
	{
		System.out.println("Login done");
		
	}
	
	// Forcefully failed this test as verify listener
	@Test
	public void TestToFail()
	{
		System.out.println("This method to test fail");
		Assert.assertTrue(false);
	}

}
