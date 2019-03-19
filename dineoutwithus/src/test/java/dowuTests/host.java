package dowuTests;

import java.util.NoSuchElementException;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import businessFunctions.hostaccount;
import businessFunctions.partneraccount;

public class host extends hostaccount{
	
	 @Test (enabled=false)
	 public static void loginasdoctor() throws Throwable
	 {
		 logger = extent.startTest("Login into Dineout test case");
		 hostaccount create = new hostaccount();
		 create.signup("Michele", "Sanchez", "michelesanchez@yopmail.com");
	 }
	 
	 @Test (priority = '1')
	 public static void hostlogin() throws Throwable
	 {
		 logger = extent.startTest("Login into Dineout test case");
		 
		 try {
			 
			 hostaccount account = new hostaccount();
			 if(!account.login("kennethpeters@yopmail.com", "S03g55a020%",logger))
			 {
				 logger.log(LogStatus.FAIL, "Host unable to login into the Dineout application");
			 } else
			 {
				logger.log(LogStatus.PASS, "Host successfully logged into the Dineout application");
			 }
			
		} finally
		{
			if(flag)
			{
				throw new NoSuchElementException("Element Not Found");
			}
		}
		 
	 }

}
