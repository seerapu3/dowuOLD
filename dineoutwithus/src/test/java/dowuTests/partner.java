package dowuTests;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentTest;
import businessFunctions.hostaccount;
import businessFunctions.partneraccount;
import businessFunctions.staffaccount;

public class partner extends partneraccount {
	static ExtentTest logger;

 @Test (priority = '1')
  public static void loginaspartner() throws Throwable
 {
	 logger = extent.createTest("Login into partner account");
	 partneraccount account = new partneraccount();
	 account.login("cherylgordon@yopmail.com","S03g55a020$");
  }
 
}