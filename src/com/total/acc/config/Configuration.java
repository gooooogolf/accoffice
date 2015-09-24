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
	public static final String MAIL_RETURN;
	public static final String MAIL_HOST;
	public static final String MAIL_USER;
	public static final String MAIL_PASSWORD;
	public static final String MAIL_PORT;
	public static final String TEMPLATE_JASPERREPORT_CONTEXTPATH;
	
	public static final String FTP_HOST;
	public static final String FTP_USERNAME;
	public static final String FTP_PASSWORD;
	
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
		MAIL_RETURN = prop.getProperty("mail.return");
		MAIL_HOST = prop.getProperty("mail.host");
		MAIL_USER = prop.getProperty("mail.user");
		MAIL_PASSWORD = prop.getProperty("mail.password");
		MAIL_PORT = prop.getProperty("mail.port");
		TEMPLATE_JASPERREPORT_CONTEXTPATH = prop.getProperty("jasper.contextPath");
		FTP_HOST = prop.getProperty("ftp.host");
		FTP_USERNAME = prop.getProperty("ftp.user");
		FTP_PASSWORD = prop.getProperty("ftp.password");
	}

}
