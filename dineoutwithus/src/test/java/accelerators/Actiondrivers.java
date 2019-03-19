package accelerators;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Actiondrivers extends Base{

public static WebDriverWait wait;

public static boolean click(By locator, String locatorName, ExtentTest logger) throws Throwable {
	 boolean flag = false;
	 try {
	  driver.findElement(locator).click();
	  return true;
	 } catch (Exception e) {
	  System.out.println(e.getMessage());
	  flag = true;
	  return false;
	 } finally {
	  if (flag) {
		  logger.log(LogStatus.FAIL,"Unable to locate the "+locatorName);
	  } else {
		  logger.log(LogStatus.PASS,"Successfully click on the "+locatorName);
	  }
	 }
	}

	/**
	 * This method for type in to text box or text area
	 */
	public static boolean enter(By locator, String testdata,ExtentTest logger) throws Throwable {
		boolean flag = false;
		try {
			System.out.println(locator);
			System.out.println(testdata);
			driver.findElement(locator).click();
			driver.findElement(locator).sendKeys(testdata);
			return true;
		} catch (NoSuchElementException e) {
			flag = true;
			return false;
		} finally {
			if (flag) {
				logger.log(LogStatus.FAIL, "Unable to Enter the "+testdata); 
			} else {
				logger.log(LogStatus.PASS, "Successfully Enter the "+testdata);
			}
		}
	}


	public static boolean upload()
			throws Throwable {
		return false;
	}
	public static boolean download()
			throws Throwable {
		return false;
	}

	public static boolean alertMethods()
			throws Throwable {
		// using windows handlers
		return false;
	}

	public static boolean waits()
			throws Throwable {
		// using windows handlers
		return false;
	}

	public static boolean select()
			throws Throwable {
		// using windows handlers
		return false;
	}
}
