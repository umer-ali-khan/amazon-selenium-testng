/**
 * 
 */
package com.amazon.auto.utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import java.util.Properties;



/**
 * @author Umar Khan
 *
 */
public class PropertiesManager {

	private static final String PROPERTY_FILE_PATH = "config//autoconfig.properties";
	
	private static Properties properties = new Properties();

	public static Properties getProperties() throws IOException {
		
		BufferedReader reader;

		try {

			reader = new BufferedReader(new FileReader(PROPERTY_FILE_PATH));

				properties.load(reader);
				reader.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("config.properties not found at " + PROPERTY_FILE_PATH);
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		
		return properties;

	}

	public static String getProperty(String propertyKey) throws Exception {
		
		String propValue = null;
		
		try {
			
			 propValue = properties.getProperty(propertyKey);
		}
		catch(Exception e) {
			
			System.out.println("Could not get the property file" + e.getMessage());
			
		}
		
		if(propValue == null) {
			
			throw new Exception();
		}
		
		return propValue;
		
	}
	
	
	
	
}
