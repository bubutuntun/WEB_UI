package utils;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;

public class BasePage extends WebElementUtil{
	
	public BasePage(WebDriver dr){
		super(dr);
	}

	public void alterAccept(){
		wait(2);
		Alert alert=driver.switchTo().alert();
		alert.accept();
	}
	
	public void cancelAlert(){
		wait(3);
		Alert alert=driver.switchTo().alert();
		alert.dismiss();
	}
	
	public String getAlertText(){
		wait(3);
		Alert alert =driver.switchTo().alert();
		return alert.getText();
	}
}
