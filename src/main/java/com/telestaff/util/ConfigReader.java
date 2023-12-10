package com.telestaff.util;

import java.util.Properties;
import java.io.*;

public class ConfigReader {
	
	private Properties prop;
	
	public Properties init_properties() {
		prop=new Properties();
		try {
			FileInputStream ip=new FileInputStream("/Users/vivekchoudhary/Desktop/Selenium_Cucumber_Framework/SeleniumCucumber/src/test/resources/config/config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		return prop;
	}

}
