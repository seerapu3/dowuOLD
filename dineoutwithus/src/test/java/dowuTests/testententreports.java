package dowuTests;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import accelerators.Base;

public class testententreports extends Base {
	
	//@Test
	public static void main(String[] args) 
	{
		/*logger = extent.createTest("LoginTest");
		logger.log(Status.INFO, "Login to Jiyyo");
		logger.log(Status.PASS, "Title verified");*/
		extent.flush();
	}
	

}
