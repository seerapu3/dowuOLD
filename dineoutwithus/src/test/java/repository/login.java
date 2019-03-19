package repository;

import org.openqa.selenium.By;

public class login {
	
	
	public static By signInMenu = By.linkText("Sign-in");
	public static By username = By.xpath("//input[@placeholder='Enter your email']");
	public static By password = By.xpath("//input[@placeholder='Enter your password']");
	public static By loginbutton = By.xpath("//div[5]/button");
}
