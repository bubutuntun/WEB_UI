package UI;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleSwitch {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.get("http://www.baidu.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		String url=driver.findElement(By.cssSelector("[name=tj_trnews]")).getAttribute("href");
		System.out.println(url);
		//利用JS打开新的handle
		JavascriptExecutor js= (JavascriptExecutor) driver;
		js.executeScript("window.open('"+url+"')");
		String defaulthandle=driver.getWindowHandle();
		List<String> list= (List<String>) driver.getWindowHandles();
		Iterator<String> it=list.iterator();
		while(it.hasNext()){
			String handle=it.next();
			if(!handle.equals(defaulthandle)){
				driver.switchTo().window(handle);
			}
		}
	}

}
