package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import config.LocalConfig;
import utils.BasePage;
import utils.Locator;
import utils.PropertiesUtils;

public class LoginPage extends BasePage{
	
	
	
	public WebDriver getDriver(){
		return driver;
	}
	
	public LoginPage(WebDriver dr){
		super(dr);
//		openWeb(LoginConfig.URL);
//		PropertiesUtils propertiesUtils =new PropertiesUtils();
//		driver.get(propertiesUtils.getPropertiesVaule("url"));
//		driver.get(LoginConfig.URL);
		try{
		openWeb(LocalConfig.URL);
		log.info("进入登录页面成功");
		takeScreenShot("LoginPage");
		}catch(Exception e){
			log.error("打开网址："+LocalConfig.URL+"失败");
			takeScreenShot("LoginPage");
			Assert.fail("打开网址失败，退出当前用例");
		}
	}  
	
	Locator userNameInputbox = getLocator("usernameInputbox");
	Locator passWordInputbox = getLocator("passwordInputbox");
	Locator loginButton = getLocator("loginButton");
	
	public void inputUserName(String name){
		input(userNameInputbox, name);
	}
	
	public void inputPassWord(String password){
		input(passWordInputbox, password);
	}
	
	public void clickLoginButton(){
		click(loginButton);
		
	}
	
	
	
//	public MainPage loginOperate(String name,String password){
//		input(usernameInputbox, name);
//		input(passwordInputbox,password);
//		click(loginButton);
//		return new MainPage(getDriver()); 
//	}
//	
//	public String loginFailOperate(String name,String password){
//		input(usernameInputbox, name);
//		input(passwordInputbox, password);
//		click(loginButton);
//		wait(2);
//		String value=getAlertText();
//		alterAccept();
//		return value;
//	}

}
