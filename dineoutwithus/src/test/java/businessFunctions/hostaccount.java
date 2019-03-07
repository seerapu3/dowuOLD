package businessFunctions;

import static org.testng.Assert.assertEquals;

import java.awt.Robot;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.ExtentTest;
import com.mongodb.diagnostics.logging.Logger;
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
	public void login(String email, String password, ExtentTest log) throws Throwable
	{
		driver.findElement(By.linkText("Sign-in")).click();
		driver.findElement(By.xpath("//input[@placeholder='Enter your email']")).click();
	    driver.findElement(By.xpath("//input[@placeholder='Enter your email']")).clear();
	    driver.findElement(By.xpath("//input[@placeholder='Enter your email']")).sendKeys("kennethpeters@yopmail.com");
	    driver.findElement(By.xpath("//input[@placeholder='Enter your password']")).click();
	    driver.findElement(By.xpath("//input[@placeholder='Enter your password']")).clear();
	    driver.findElement(By.xpath("//input[@placeholder='Enter your password']")).sendKeys("S03g55a020%");
	    driver.findElement(By.xpath("//div[5]/button")).click();
	    log.fail("Successfully login into application");
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
			driver.findElement(By.xpath("//input[@type='number'][@min='6']")).click();
		}
    
}
