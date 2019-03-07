package businessFunctions;

import org.openqa.selenium.By;

import accelerators.Actiondrivers;

public class partneraccount extends Actiondrivers{
	
	// Login into Account
		public void login(String email, String password) throws Throwable
		{
			driver.findElement(By.linkText("Sign-in")).click();
			Thread.sleep(5000);
			driver.findElement(By.xpath("//input[@placeholder='Enter your email']")).click();
		    driver.findElement(By.xpath("//input[@placeholder='Enter your email']")).clear();
		    driver.findElement(By.xpath("//input[@placeholder='Enter your email']")).sendKeys(email);
		    driver.findElement(By.xpath("//input[@placeholder='Enter your password']")).click();
		    driver.findElement(By.xpath("//input[@placeholder='Enter your password']")).clear();
		    driver.findElement(By.xpath("//input[@placeholder='Enter your password']")).sendKeys(password);
		    driver.findElement(By.xpath("//div[5]/button")).click();
		    uploadimage();
		}
		
	// Edit Profile
		public void uploadimage() throws Throwable
		{
		    driver.findElement(By.xpath("//div[@id='pageStart']/div/div[3]/div/button")).click();
		    driver.findElement(By.xpath("//div[@id='editPartner']/div[3]/form/div/div[2]/button")).click();
		    
		    // below line execute the AutoIT script
		    Runtime.getRuntime().exec("C:\\Users\\Praniksha\\Desktop\\uploadImage2.exe");
		    Thread.sleep(5000);
		    
		}

}
