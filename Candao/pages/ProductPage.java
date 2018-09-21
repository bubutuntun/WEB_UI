package pages;

import org.openqa.selenium.WebDriver;

import utils.BasePage;
import utils.Locator;


public class ProductPage extends BasePage {


	Locator addProduct=getLocator("addProduct");
	
	public ProductPage(WebDriver dr){
		super(dr);
	}

	
	public WebDriver getDriver() {
		return driver;
	}
	
	public void clickAddProduct(){
		click(addProduct);
	}
	
	
	
//	public String getTitle(){
//		wait(2); 
//		String title=this.driver.getTitle();
//		return title;
//	}
	
	
}
