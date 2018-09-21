package actions;

import org.openqa.selenium.WebDriver;

import pages.LoginPage;
import pages.MainPage;
import utils.BasePage;
import utils.DriverUtil;

public class LoginOperate {
	
	private static WebDriver driver;
	static LoginPage loginpage;
	static BasePage basepage;
	
	public static WebDriver getDriver() {
		return driver;
	}


	public static void setDriver(WebDriver driver) {
		LoginOperate.driver = driver;
	}
	
	
	//登录成功
/*	public static MainPage LoginSuccess(String name,String password){
		 loginpage =new LoginPage(getDriver());
		 loginpage.inputUserName(name);
		 loginpage.inputPassWord(password);
		 loginpage.clickLoginButton();
		 return new MainPage(getDriver());
	}*/
	public static  void LoginSuccess(String name,String password){
		 loginpage =new LoginPage(getDriver());
		 loginpage.inputUserName(name);
		 loginpage.inputPassWord(password);
		 loginpage.clickLoginButton();
		 
	}
	
	//登录失败
	public static String LoginFair(String name,String password){
		loginpage=new LoginPage(getDriver());
		 loginpage.inputUserName(name);
		 loginpage.inputPassWord(password);
		 loginpage.clickLoginButton();
	//	 DriverUtil.wait(3);
		 String value=loginpage.getAlertText();
		 loginpage.alterAccept();
		return value;	
	}



	

}
