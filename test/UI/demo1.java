package UI;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class demo1 {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.get("http://www.baidu.com");
		driver.manage().window().maximize();
		driver.findElement(By.id("kw")).sendKeys("12306");
		driver.findElement(By.id("su")).click();;
		String value=driver.findElement(By.id("su")).getText();
		System.out.println(value);
		driver.findElement(By.cssSelector("#s_tab > div"
				+ " > a:nth-child(2)")).click();;
		String URL=driver.getCurrentUrl();
		System.out.println(URL);

	}
	
}
