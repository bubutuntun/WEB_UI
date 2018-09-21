package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utils.BasePage;
import utils.Locator;

public class MainPage extends BasePage{
	
	Locator productHomePage=getLocator("productHomePage");
	
	public WebDriver getDriver() {
		return driver;
	}
	
	public MainPage(WebDriver dr){
		super(dr);
	}
	
	public  void clickProduct(){
		click(productHomePage);
	}
	
	
	
	
	
//	public ProductPage getProductPage(){
//		wait(2);
//		click(productHomePage);
//		return new ProductPage(getDriver());
//	}
	
	
//	public String Title(){
//		wait(2);
//		String title=driver.getTitle();
//		return title;	
//	}


	

}
