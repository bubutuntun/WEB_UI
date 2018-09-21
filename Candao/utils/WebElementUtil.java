package utils;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import utils.Locator.ByType;

public class WebElementUtil extends DriverUtil {
	
	protected HashMap<String,Locator> locatorMap;
	protected String path;
	
	public WebElementUtil(WebDriver dr) {
		super(dr);
		/*
		 读取相应page的XML文件  
		 */
		path=System.getProperty("user.dir")+"/webelementdata/"
				+this.getClass().getSimpleName()+".xml";
		locatorMap =xmlUtils.readElementInfo(path);
	}
	
	public WebElement getElement(Locator locator){
		WebElement el = null;
		ByType type=locator.getByType();
		try{
		switch(type){
			case id:
				el= driver.findElement(By.id(locator.getLocatorInfo()));
				break;
			case name:
				el=driver.findElement(By.name(locator.getLocatorInfo()));
				break;
			case className:
				el=driver.findElement(By.className(locator.getLocatorInfo()));
				break;
			case xpath:
				el=driver.findElement(By.xpath(locator.getLocatorInfo()));
				break;
			case cssSelector:
				el=driver.findElement(By.cssSelector(locator.getLocatorInfo()));
				break;
			default:
				el=driver.findElement(By.cssSelector(locator.getLocatorInfo()));				
		}}catch(Exception e){
			log.error("元素："+locator.getElementName()+" 识别异常");
			takeScreenShot("findElementErrorImage");			
			Assert.fail("查找元素异常，退出当前测试用例");
		}
		return el;
	}
	
	public WebElement findElement(Locator locator){
		WebDriverWait wait = new WebDriverWait(driver, locator.getTimeOut());
		WebElement el = wait.until(new ExpectedCondition<WebElement>() {   
            public WebElement apply(WebDriver d) {
                return getElement(locator);  
//                return driver.findElement(By.cssSelector("..."));
            }  
        });
		return el;	
	}
	
	
	//通过键值对获取XML定位信息
		public Locator getLocator(String locatorName){
			Locator locator = locatorMap.get(locatorName);
			return locator;
		}
		
	
	
	//点击元素
	public void click(Locator locator){
		WebElement el=findElement(locator);
		el.click();
		log.info("点击元素"+locator.getElementName());
	}
	
	//输入框操作
	public void input(Locator locator,String content){
		WebElement e = findElement(locator);
		e.sendKeys(content);
		log.info("在元素  "+locator.getElementName()+" 输入："+content);
	}
	
	//提交操作
	public void summit(Locator locator){
		WebElement e = findElement(locator);
		e.submit();
	}
	
	//获取文本信息
	public String getText(Locator locator){
		WebElement e = findElement(locator);
		log.info("获取元素："+locator.getElementName()+"文本值");
		return e.getText();
	}
	
	//获取元素的属性值
	public String getAttribute(Locator locator,String value){
		WebElement el=findElement(locator);
		log.info("获取元素"+locator.getElementName()+"属性值");
		return el.getAttribute(value);
	}
	
	
	
	//控制浏览器的滚动条
	public void setScroll(int height){
		try{
		String setscroll="document.body.scrollTop="+height;
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript(setscroll);
		log.info("页面滚动成功");
		}catch(Exception e){
			log.error("页面滚动失败");
		}
	}
	
	
	
	//下拉框的处理
	public void selectByIndex(WebElement el,int index){
		Select select=new Select(el);
		select.selectByIndex(index);
	}
	
	public void selectByText(WebElement el,String text){
		Select select =new Select(el);
		select.selectByVisibleText(text);
	}
	
	public void selectByValue(WebElement el,String Value){
		Select select =new Select(el);
		select.selectByValue(Value);
	}
	

}
