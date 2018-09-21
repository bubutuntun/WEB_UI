package pages;

import javax.security.auth.kerberos.KerberosKey;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Keyboard;

import utils.BasePage;
import utils.Locator;

public class AddProductPage extends BasePage{

	public AddProductPage(WebDriver dr) {
		super(dr);
	}

	Locator selectProductOwner = getLocator("selectProductOwner");
	Locator productName = getLocator("productName");
	Locator productNumber =getLocator("productNumber");
	Locator saveButton =getLocator("saveButton");
	Locator selectTestOwner=getLocator("selectTestOwner");
	Locator selectAnnounceOwner=getLocator("selectAnnounceOwner");
	
	
	
	public void selectPrductOwner(int index){
		click(selectProductOwner);
		keyboard.sendDown(index-1);
		keyboard.sendEnter();
	}
	
	public void selectTestOwner(int index){
		click(selectTestOwner);
		keyboard.sendDown(index-1);
		keyboard.sendEnter();
	}
	
	public void selectAnnounceOwner(int index){
		click(selectAnnounceOwner);
		keyboard.sendDown(index-1);
		keyboard.sendEnter();
	}
	
	public void inputProductName(String name){
		input(productName,name );
	}
	
	public void inputProductNumber(String number){
		input(productNumber, number);
	}
	
	public void clickSaveButton(){
		click(saveButton);
	}
	

	
}
