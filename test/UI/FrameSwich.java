package UI;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FrameSwich {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.get("file:///C:/iframe.html");
		driver.manage().window().maximize();
		
		driver.switchTo().frame("if");
		System.out.println(driver.findElement(By.cssSelector("#kw")).isDisplayed());
		System.out.println(driver.findElement(By.cssSelector("#kw")).isEnabled());
		System.out.println(driver.findElement(By.cssSelector("#kw")).isSelected());
		
		boolean result=driver.findElement(By.cssSelector("#kw")).isDisplayed();
		if(result){
			driver.findElement(By.cssSelector("#kw")).sendKeys("switch successfully!");
			driver.switchTo().parentFrame();
			try {
				driver.findElement(By.cssSelector("#kw"));
				System.out.println("21");
			} catch (Exception e) {
				System.out.println("21");
				String js="alert(\"switch to parent\")";
				((JavascriptExecutor) driver).executeScript(js);
				waitTime(3000);
				driver.switchTo().alert().accept();;
			}
			finally {
				
				
			}
			}
		
	
		
		
		}
	


	
	public static void waitTime(int time){
		try {
			Thread.sleep(time);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
