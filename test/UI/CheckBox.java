package UI;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CheckBox {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.get("file:///c:/CheckBox.html");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		List<WebElement> list=driver.findElements(By.cssSelector("[type=checkbox]"));
		Iterator it=list.iterator();
		while(it.hasNext()){
			WebElement el=(WebElement) it.next();
			el.click();
		}
		
		WaitTime(3000);
		System.out.println(list.get(0));
		list.get(0).click();
		
		String js="alert(\"switch to parent\")";
		((JavascriptExecutor) driver).executeScript(js);
		
		WaitTime(1000);
		driver.close();
	}
	
	public static void WaitTime(int time){
		try {
			Thread.sleep(time);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
