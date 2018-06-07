package properties;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesConfig {

	public static void main(String[] args) throws IOException {

		Properties property = new Properties();
		String fileConfigPath = System.getProperty("user.dir") + "/src/main/resources/config/config.properties";
	File file = new File (fileConfigPath);
	FileInputStream fis = new FileInputStream(file);
	property.load(fis);
	System.out.println(property.getProperty("categories"));
	
		
	}

}
