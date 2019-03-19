package dowuTests;
import org.testng.annotations.Test;
import businessFunctions.hostaccount;
import businessFunctions.partneraccount;
import businessFunctions.staffaccount;

public class partner extends partneraccount {

 @Test (priority = '1')
  public static void loginaspartner() throws Throwable
 {
	 logger = extent.startTest("Login into partner account");
	 partneraccount account = new partneraccount();
	 account.login("cherylgordon@yopmail.com","S03g55a020$");
  }
 
}