package businessFunctions;

import static org.testng.Assert.assertEquals;

import java.awt.Robot;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.sun.glass.events.KeyEvent;

import accelerators.Actiondrivers;
import repository.*;

public class hostaccount extends Actiondrivers{
	
	// Sign Up as a Host account
	public void signup(String firstname,String lastname, String email) throws Throwable
	{
		Robot robot = null;
		driver.findElement(By.linkText("Sign Up")).click();
	    driver.findElement(By.name("email")).click();
	    driver.findElement(By.name("email")).clear();
	    driver.findElement(By.name("email")).sendKeys(email);
	    driver.findElement(By.xpath("//form[@id='createAccountForm']/div/div/input")).click();
	    driver.findElement(By.xpath("//form[@id='createAccountForm']/div/div/input")).clear();
	    driver.findElement(By.xpath("//form[@id='createAccountForm']/div/div/input")).sendKeys(firstname);
	    driver.findElement(By.xpath("//form[@id='createAccountForm']/div[2]/div/input")).click();
	    driver.findElement(By.xpath("//form[@id='createAccountForm']/div[2]/div/input")).clear();
	    driver.findElement(By.xpath("//form[@id='createAccountForm']/div[2]/div/input")).sendKeys(lastname);
	    driver.findElement(By.xpath("//form[@id='createAccountForm']/div[4]/div/input")).clear();
	    driver.findElement(By.xpath("//form[@id='createAccountForm']/div[4]/div/input")).sendKeys("S03g55a020$");
	    driver.findElement(By.xpath("//form[@id='createAccountForm']/div[5]/div/input")).clear();
	    driver.findElement(By.xpath("//form[@id='createAccountForm']/div[5]/div/input")).sendKeys("S03g55a020$");
	    robot = new Robot();
	    robot.keyPress(KeyEvent.VK_ENTER);
	    //driver.findElement(By.xpath("//form[@id='createAccountForm']/div[6]/button")).click();
	}

	// Login into Account
	public boolean login(String email, String password, ExtentTest logger) throws Throwable
	{
		boolean bRetValue = false;
		//By.linkText("Sign-in")
			if(!click(login.signInMenu, "Sign In",logger))
			{
				bRetValue = false;
			}else
				bRetValue = true;
			
			if(!enter(login.username,email,logger))
			{
				bRetValue = false;
			}else
				bRetValue = true;
			if(!enter(login.password,password,logger))
			{
				bRetValue = false;
			}else
				bRetValue = true;
			
			if(!click(login.loginbutton, "Login button",logger))
			{
				bRetValue = false;
			}else
				bRetValue = true;
		
			return bRetValue;
			
	}
	
	// select the Resturants
	public void selectResturants() throws Throwable
	{
		
		List<WebElement> Resturants = driver.findElements(By.xpath("//div[@class='col span_3_of_12']//div[@class='wellHeader']"));
		System.out.println(Resturants.size());
		// for each loop 
        for(int i = 0; i < Resturants.size();i++)
        {
        	//System.out.println(Resturants.get(i).getText());
        	Resturants.get(i).click();
 	    }
        
        
        driver.findElement(By.xpath("//div[5]/button")).click();
        selectMenu();
	}
	
		// select the Menus
		public void selectMenu() throws Throwable
		{
			// Enter the party size
		    driver.findElement(By.xpath("(//input[@name='miles'])[2]")).click();
		    driver.findElement(By.xpath("(//input[@name='miles'])[2]")).clear();
		    driver.findElement(By.xpath("(//input[@name='miles'])[2]")).sendKeys("7");
		    driver.findElement(By.xpath("//div[2]/i")).click();
		    driver.findElement(By.xpath("//tr[6]/td[4]/button/span")).click();
		    driver.findElement(By.xpath("//select")).click();
		    new Select(driver.findElement(By.xpath("//select"))).selectByVisibleText("4:00");
		    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Did you have a specific price range in mind?'])[1]/preceding::select[2]")).click();
		    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='$ 56 per person'])[1]/preceding::h4[1]")).click();
		    driver.findElement(By.linkText("Ready to book")).click();
		    driver.findElement(By.id("bookEvent")).click();
		    driver.findElement(By.id("test_1")).click();
		    driver.findElement(By.id("customGuest")).click();
		    driver.findElement(By.linkText("Finalize Booking")).click();
		    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='$ 56 per person'])[1]/preceding::h4[1]")).click();
		  }
		
		// Select the Card / Add new cards
		public void selectCard() throws Throwable
		{}
		
		// Select the options 
		public void selectBookingOption() throws Throwable
		{}
		
		// Finalize booking
		public void finalizeBooking() throws Throwable
		{}
		
		// Host is paying for guests
		// Host sending the reminders
		// Saving the details
		
}
