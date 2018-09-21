package utils;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import config.LocalConfig;

public class DriverUtil {
	
	protected WebDriver driver;
	protected static Log log = new Log(DriverUtil.class);
	protected static KeyBoardUtils keyboard;
	protected static MouseUtils mouse;
	public DriverUtil(WebDriver dr){
		driver = dr;
		keyboard = new KeyBoardUtils(driver);
		mouse = new	MouseUtils(driver);
	}
	//定义等待时间
	public static void wait(int seconds){
		try {
			Thread.sleep(seconds*1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	//打开网页
	public void openWeb(String url){
		driver.get(url);
		log.info("打开网址: "+url);
	}
	
	public String getTitle(){
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
		String value=driver.getTitle();
		log.info("成功获取网页标题");
		return value;
	}
	
	 public void takeScreenShot(String... pngName) {
	    	String fileName ;
	    	String filePath = LocalConfig.SCREENSHOTPATH;
	    	File file = new File(filePath);
	    	if(!file.exists()) {
	    	    file.mkdir();
	    	}
	        if (pngName.length == 0) {
	        	fileName = "shotImage";
	        } else {
	        	fileName = pngName[0];
	        }
	        SimpleDateFormat sf = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
	        Calendar cal = Calendar.getInstance();
	        Date date = cal.getTime();
	        String dateStr = sf.format(date);
	        String path =  "\\"+ filePath +"\\" + fileName + "_" + dateStr + ".png";
	        takeScreenShot(driver, path);    	
	    }
	    
	    public void takeScreenShot(WebDriver drivername, String path) {
	        String currentPath = System.getProperty("user.dir"); // get current work
	        File scrFile = ((TakesScreenshot) drivername).getScreenshotAs(OutputType.FILE);
	        File picFile = new File(currentPath + path);
	        try {
	            FileUtils.copyFile(scrFile, picFile);
	            log.info("截图成功，图片保存路径为："+currentPath + path);
	        } catch (Exception e) {
	        	log.error("截图失败");
	        } 
	        log.screenShotLog("截图：" + scrFile, picFile);
	    }


}
