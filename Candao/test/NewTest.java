package test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import actions.AddProductOperate;
import actions.LoginOperate;
import actions.MainOperate;
import actions.ProductPageOperate;
import pages.AddProductPage;
import pages.MainPage;
import pages.ProductPage;
import pages.ScanProductPage;
import utils.AssertUtils;
import utils.DriverFactoryUtil;

public class NewTest {
	  
		WebDriver driver=null;
		AssertUtils assertUtils=new AssertUtils();
		@BeforeMethod
		public void setUp(){
			driver=DriverFactoryUtil.getChromeDriver();
			LoginOperate.setDriver(driver);
		
		}
		
		//成功登录
/*		@Test
	  public void f1(){

			MainPage mp=LoginOperate.LoginSuccess("admin", "myh123456");
			String content=mp.getTitle();
			assertUtils.checkStringContains(content,"我的地盘","登录成功");
			System.out.println("当前网页："+content);
	  }*/
//		//登录失败
//		@Test
//		public void f2(){
//			String content=LoginOperate.LoginFair("admin", "");
//			assertUtils.checkStringContains(content, "登录失败","登录失败");
//		}
		
//		@Test
//		public void f3(){
//			ProductPage p=MainOperate.getProductPage("admin", "123456");
//			String content=p.getTitle();
//			assertUtils.checkStringContains(content,"我的地盘");
//			System.out.println(content);
//		}
//		@Test
//		public void f3(){
//			ProductPage p=MainOperate.getProductPage("admin", "123456");
//			System.out.println("当前网页："+p.getTitle());
//			AddProductPage addp= ProductPageOperate.getAddProductPage(p);
//			System.out.println("当前网页："+addp.getTitle());
//			
//		}
		
		/*@Test
		public void f4(){
			ProductPage p=MainOperate.getProductPage("admin", "123456");
			System.out.println("当前网页："+p.getTitle());
			AddProductPage addp=ProductPageOperate.getAddProductPage(p);
			System.out.println("当前网页："+addp.getTitle());
			ScanProductPage scanp=AddProductOperate.addProduct(addp, "蛇皮", "001");
			System.out.println("当前网页："+scanp.getTitle());
		}*/
		
		@Test
		public void f5(){
			LoginOperate.LoginSuccess("admin", "meiyanghua123");
			MainOperate.getProductPage();
			ProductPageOperate.getAddproductPage();
			AddProductOperate.addProduct("product01", "test01");
			
		}
		
		
		
		
		@AfterMethod
		public void teardown() throws InterruptedException{
	    	Thread.sleep(3000);
	    	driver.close();
		}
}
