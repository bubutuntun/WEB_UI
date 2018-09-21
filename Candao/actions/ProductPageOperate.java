package actions;

import org.openqa.selenium.WebDriver;

import pages.AddProductPage;
import pages.ProductPage;

public class ProductPageOperate {

	private static WebDriver driver;

	public static WebDriver getDriver() {
		return driver;
	}

	public static void setDriver(WebDriver driver) {
		ProductPageOperate.driver = driver;
	}
	
	/*	public static AddProductPage getAddProductPage(ProductPage productPage){
		ProductPageOperate.setDriver(LoginOperate.getDriver());
		
		productPage.clickAddProduct();
		return new AddProductPage(getDriver());
	}*/
	
	
	public static void getAddproductPage(){
		ProductPageOperate.setDriver(LoginOperate.getDriver());
		ProductPage productPage=new ProductPage(getDriver());
		productPage.clickAddProduct();
	}
	
}
