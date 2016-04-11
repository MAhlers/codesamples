package myPkg;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class GetProperties {
	
	public static Properties getProperties() {
		
		Properties prop = new Properties();
		InputStream inputStream = GetProperties.class.getResourceAsStream("/config.properties");
		
		try {
			prop.load(inputStream);
		} catch (IOException e) {
			LogMessage.postLogMessage("EXCEPTION: GetProperties.getProperties() - " + e);
		}
		
		return prop;
	}
}