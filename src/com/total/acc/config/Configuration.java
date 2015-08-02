/**
 * 
 */
package com.total.acc.config;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author Sirimongkol
 *
 */
public class Configuration {
	
	public static final String VERSION;
	public static final String MAIL;
	public static final String MAIL_USER;
	public static final String MAIL_PASSWORD;
	public static final String TEMPLATE_JASPERREPORT_CONTEXTPATH;
	
	static {
		
		Properties prop = new Properties();
		String propFileName = "project.properties";
 
		try {
			InputStream inputStream = Configuration.class.getClassLoader().getResourceAsStream(propFileName);
			 
			if (inputStream != null) {
				prop.load(inputStream);
			} else {
				throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
			}
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		
		VERSION =  prop.getProperty("version");		
		MAIL = prop.getProperty("mail");
		MAIL_USER = prop.getProperty("mail.user");
		MAIL_PASSWORD = prop.getProperty("mail.password");
		TEMPLATE_JASPERREPORT_CONTEXTPATH = prop.getProperty("jasper.contextPath");

	}

}
