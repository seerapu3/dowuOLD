package repository;

import org.openqa.selenium.By;

public class login {
	
	public static By loginmenu = By.xpath("//a[contains(text(),'Login')]");
	public static By username = By.xpath("//input[@id='inputEmail3']");
	public static By password = By.id("inputPassword3");
	public static By loginbutton = By.xpath("//form[@id='loginform']/div[2]/button");
}
