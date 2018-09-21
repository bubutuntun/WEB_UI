package utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesUtils {
	private Properties properties=null;
	public String getPropertiesVaule(String keyName){
		properties=new Properties();
		InputStream in=PropertiesUtils.class.getClassLoader().getResourceAsStream("config/"+"a.properties");
		String value=null;
		try {
			properties.load(in);
			value=properties.getProperty(keyName);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return value;	
	}
}
