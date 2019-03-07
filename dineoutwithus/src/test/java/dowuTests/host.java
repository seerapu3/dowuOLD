package dowuTests;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;

import businessFunctions.hostaccount;
import businessFunctions.partneraccount;

public class host extends hostaccount{
	
	static ExtentTest logger;

	 @Test (enabled=false)
	 public static void loginasdoctor() throws Throwable
	 {
		 logger = extent.createTest("Create Host Account");
		 hostaccount create = new hostaccount();
		 create.signup("Michele", "Sanchez", "michelesanchez@yopmail.com");
	 }
	 
	 @Test (priority = '1')
	 public static void hostlogin() throws Throwable
	 {
		 logger = extent.createTest("Login into host account");
		 hostaccount account = new hostaccount();
		 account.login("kennethpeters@yopmail.com", "S03g55a020%", logger);

		 hostaccount select = new hostaccount();
		 select.selectResturants();
	 }
	 
}
