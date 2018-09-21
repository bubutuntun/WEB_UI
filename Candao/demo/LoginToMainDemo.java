package demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import actions.LoginOperate;
import actions.MainOperate;
import actions.ProductPageOperate;
import pages.LoginPage;
import pages.MainPage;
import pages.ProductPage;
import utils.DriverFactoryUtil;

public class LoginToMainDemo {
 
	public static void main(String[] args) throws InterruptedException {
		
//		WebDriver driver=DriverFactory.getChromeDriver();
//		LoginPage lp=new LoginPage(driver);
//		MainPage mp=lp.loginOperate("admin","123456");
//		String content=mp.Title();
//		System.out.println(content);
//		ProductPage pg=mp.getProductPage();
//		System.out .println(pg.getTitle());
		
		
		WebDriver driver=DriverFactoryUtil.getChromeDriver();
		LoginOperate.setDriver(driver);
//		MainPage mp=LoginOperate.LoginSuccess("admin", "myh123456");
//		String content=mp.getTitle();
//		System.out.println(content);
		
		
		
		
//		MainOperate.setDriver(driver);
//		ProductPage pg=MainOperate.getProductPage(mp);
//		System.out .println(pg.getTitle());
//		LoginOperate.setDriver(driver);;
//		ProductPage pg=MainOperate.getProductPage("admin", "123456");
//		Thread.sleep(1000);
//		System.out.println(pg.getTitle());
		
	}

}
