package pageobjecttest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	private static WebElement element;
	
	public static WebElement loginUserName(WebDriver driver){
		element=driver.findElement(By.id("account"));
		return element;		
	}
	
	public static WebElement loginPassword(WebDriver driver){
		element=driver.findElement(By.cssSelector("input[type='password']"));
		return element;
	}
	
	public static WebElement loginButton(WebDriver driver){
		element=driver.findElement(By.cssSelector("#submit"));
		return element;	
	}
}
