package actions;

import org.openqa.selenium.WebDriver;

import pages.AddProductPage;
import pages.ScanProductPage;

public class AddProductOperate {
	private static WebDriver driver;
//	static AddProductPage addProductPage;

	public static WebDriver getDriver() {
		return driver;
	}

	public static void setDriver(WebDriver driver) {
		AddProductOperate.driver = driver;
	}
	
	/*public static ScanProductPage addProduct(AddProductPage addProductPage,String name,String number){
		AddProductOperate.setDriver(LoginOperate.getDriver());
		addProductPage.inputProductName(name);
		addProductPage.inputProductNumber(number);
		addProductPage.selectPrductOwner(2);
		addProductPage.selectTestOwner(2);
		addProductPage.selectAnnounceOwner(5);
		addProductPage.setScroll(500);
		addProductPage.clickSaveButton();
		return new ScanProductPage(getDriver());	
	}*/
	
	public static void addProduct(String name,String number){
		AddProductOperate.setDriver(LoginOperate.getDriver());
		AddProductPage addProductPage=new AddProductPage(getDriver());
		addProductPage.inputProductName(name);
		addProductPage.inputProductNumber(number);
		addProductPage.selectPrductOwner(2);
		addProductPage.selectTestOwner(2);
		addProductPage.clickSaveButton();
	}
	
	
}
