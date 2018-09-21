package utils;


import java.io.IOException;
import java.util.Arrays;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import config.LocalConfig;

public class DriverFactoryUtil {
	
	private static WebDriver driver;
	static Runtime runtime = Runtime.getRuntime();
	protected static Log log = new Log(DriverFactoryUtil.class);
	
	public static WebDriver getChromeDriver(){
		try {
			runtime.exec("taskkill /F /IM chrome.exe");
			log.info("杀死chrome浏览器进程成功");
		} catch (IOException e) {
			log.error("杀进程出现异常");
		}
		String driverPath = System.getProperty("user.dir")+LocalConfig.CHROME_PATH;
		System.setProperty("webdriver.chrome.driver",driverPath);
		ChromeOptions options = new ChromeOptions();
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		capabilities.setCapability("chrome.switches",
				Arrays.asList("--start-maximized"));
		options.addArguments("--test-type", "--start-maximized");
		driver = new ChromeDriver(options);
		return driver;
	}
	
	
	public static WebDriver getFireFoxDriver(){
		String driverPath = System.getProperty("user.dir")+LocalConfig.FIREFOX_PATH;
		System.setProperty("webdriver.firefox.driver",driverPath);
//		ChromeOptions options = new ChromeOptions();
//		FirefoxProfile profile = new FirefoxProfile();
//		profile.setPreference("browser.download.folderList", 2);
//		profile.setPreference("browser.download.dir", "C:\\selenium");
//		profile.setPreference(
//				"browser.helperApps.neverAsk.saveToDisk",
//				"application/octet-stream, application/vnd.ms-excel, text/csv, application/zip,application/exe");
		driver = new FirefoxDriver();
		return driver;
	}
	
	
	public static WebDriver getIEDriver(){
		String driverPath = System.getProperty("user.dir")+LocalConfig.IE_PATH;
		System.setProperty("webdriver.ie.driver", driverPath);
		String PROXY = "http://proxy:8083";
		org.openqa.selenium.Proxy proxy = new org.openqa.selenium.Proxy();
		proxy.setHttpProxy(PROXY).setFtpProxy(PROXY).setSslProxy(PROXY);

		DesiredCapabilities ds = DesiredCapabilities.internetExplorer();
		ds.setCapability(
				InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,
				true);
		ds.setCapability("ignoreProtectedModeSettings", true);
		ds.setCapability(CapabilityType.PROXY, proxy);
		WebDriver driver = new InternetExplorerDriver(ds);
		return driver;
	}

}
