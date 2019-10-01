package com.cucum.utils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import com.cucum.TestRunner.TestRunner;

public class ConfigReader {
	//defines the path for the config properties
	static String configFilePath = "config.properties";
	static Properties prop;
	
	public static void loadProperties() {
			try {
				prop = new Properties();
				prop.load(new FileInputStream(new File(configFilePath)));
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new RuntimeException("Properties file not found at"+configFilePath);
			} catch(IOException e) {
				throw new RuntimeException("IO Exception occured file trying to read properties file"+configFilePath);
			}
		}
	
	public static String baseURL() {
		String baseURL;
		if(TestRunner.env.equals("int")) {
			baseURL = prop.getProperty("dev_url");
		}else {
			baseURL = prop.getProperty("qa_url");
		}
		
		if(baseURL!=null) {
			return baseURL;
		}else {
			throw new RuntimeException("Baseurl is not defined");
		}
	}
	}

