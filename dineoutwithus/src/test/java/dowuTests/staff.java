package dowuTests;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentTest;
import businessFunctions.hostaccount;
import businessFunctions.staffaccount;

public class staff extends staffaccount {
	static ExtentTest logger;

 @Test (priority = '1')
  public static void loginasdoctor() throws Throwable
 {
	 logger = extent.createTest("Login as doctor");
		 
 }
 
 }