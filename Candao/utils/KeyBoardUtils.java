package utils;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class KeyBoardUtils {
	
	private Actions action;
	private Log log =new Log(KeyBoardUtils.class);

	public KeyBoardUtils(WebDriver dr){
		action = new Actions(dr);
	}
	
	public void pressDown(int times){
		try {
			Robot robot = new Robot();
			for(int i=0;i<times;i++){
				robot.keyPress(KeyEvent.VK_DOWN);				 
				Thread.sleep(1000);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	public void sendDown(int times){
		try {
			for(int i=0;i<times;i++){
				action.sendKeys(Keys.DOWN).perform();
				log.info("按下键成功");
				Thread.sleep(1000);
			}	
		} catch (Exception e) {
			log.error("按下键失败");
		}

	}
	public void sendEnter(){
		try {
				action.sendKeys(Keys.ENTER).perform();			 
				Thread.sleep(1000);
				log.info("ENTER成功");
		} catch (Exception e) {
			log.error("ENTER失败");			
		}

	}
}
