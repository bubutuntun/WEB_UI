package config;

import utils.PropertiesUtils;

public class LocalConfig {

		static PropertiesUtils propertiesUtils=new PropertiesUtils();
		public static final String URL = propertiesUtils.getPropertiesVaule("url");
		public static final String CHROME_PATH=propertiesUtils.getPropertiesVaule("chromeDriverPath");
		public static final String FIREFOX_PATH=propertiesUtils.getPropertiesVaule("fireFoxDriverPath");
		public static final String IE_PATH=propertiesUtils.getPropertiesVaule("ieDriverPath");
		public static final String SCREENSHOTPATH = propertiesUtils.getPropertiesVaule("shotPath");
		public static final String EXCEL=propertiesUtils.getPropertiesVaule("excel");
}
