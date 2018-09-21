package pageobjecttest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {
	private	static	WebDriver driver;
	
	public static void login(WebDriver driver,String username,String password){
		LoginPage.loginUserName(driver).sendKeys(username);
		LoginPage.loginPassword(driver).sendKeys(password);
		LoginPage.loginButton(driver).click();
		
	}
	
	public static void main(String[] args) throws InterruptedException {
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("http://127.0.0.1:81/zentao/");
		login(driver, "admin", "meiyanghua123");
		Thread.sleep(3000);
		driver.quit();
	}
	
	
	

}
