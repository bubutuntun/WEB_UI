package actions;

import javax.annotation.Generated;

import org.openqa.selenium.WebDriver;

import pages.MainPage;
import pages.ProductPage;

public class MainOperate {
	private static WebDriver driver;

	
	public static WebDriver getDriver() {
		return driver;
	}
	
	
	public static void setDriver(WebDriver driver) {
		MainOperate.driver = driver;
	}
	
/*	public static ProductPage getProductPage(String name,String password){
		MainOperate.setDriver(LoginOperate.getDriver());
//		LoginOperate.setDriver(getDriver());
		MainPage mainPage=LoginOperate.LoginSuccess(name, password);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		mainPage.clickProduct();
		return new ProductPage(getDriver());
	}*/
	
	public static void getProductPage(){
		MainOperate.setDriver(LoginOperate.getDriver());
		MainPage mainPage=new MainPage(getDriver());
		mainPage.clickProduct();
		//return new ProductPage(getDriver());
		
	}
	
	


	
	
	
	





	
	
}
