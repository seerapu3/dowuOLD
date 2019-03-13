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

public class Actiondrivers extends Base{
	

	public static WebDriverWait wait;

	/**
	 * This Method is to perform click operation on (link,button,check box,radio
	 * button) Before click the element it will wait until the element present.
	 * 

	 */
	public static boolean click(By locator, String locatorName)
			throws Throwable {
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
			/*	Reporters.failureReport("Click ", "Unable to click on :"
						+ locatorName);*/
			} 
			else
			{/*Reporters.SuccessReport("Click ", "able to click on :"
					+ locatorName);*/
			}
		}
	}
	
	/**
	 * This method for type in to text box or text area
	*/
	public static boolean type(By locator, String testdata)
			throws Throwable {
		boolean flag = false;
		try {
			System.out.println(locator);
			System.out.println(testdata);
			driver.findElement(locator).click();
			//driver.findElement(locator).clear();
			driver.findElement(locator).sendKeys(testdata);
			return true;
		} catch (NoSuchElementException e) {
			flag = true;
			return false;
		} finally {
			if (flag) {
				/*Reporters.failureReport("Type ",			
						"Data typing action is not perform on: " + locatorName+" with data is "+testdata);*/
				// throw new ElementNotFoundException("", "", "");

			} else {
				//Reporters.SuccessReport("Type ","Data typing action is performed on:" + locatorName+" with data is "+testdata);
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
