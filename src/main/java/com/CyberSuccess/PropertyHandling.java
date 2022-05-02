package com.CyberSuccess;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertyHandling {
	
		final FileInputStream file;
		final Properties prop;
		
		public PropertyHandling() throws Exception {
			file=new FileInputStream("C:\\Users\\danghar\\eclipse-workspace\\CyberSuccess\\config.properties");
			
			prop=new Properties();
			
			prop.load(file);		
		}
		
		public String getProperty(String key) {
			
			return prop.getProperty(key);
			
		}
	
	
	
	

}
