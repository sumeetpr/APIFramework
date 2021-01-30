package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class FileAndEnv {
	
	public static Map<String, String> fileAndEnv = new HashMap<String, String>();
	public static Properties propMain = new Properties();
	public static Properties propPreSet = new Properties();
	
	public static Map<String, String> envAndfile(){
		
		
		String evnvirnment = System.getProperty("env");
		try {
		if (evnvirnment.equalsIgnoreCase("QA")) 
		{
			
			propMain.load(new FileInputStream(System.getProperty("user.dir") + "/input/qa.properties"));
			fileAndEnv.put("ServerUrl", propMain.getProperty("ServerUrl"));
			fileAndEnv.put("portNo", propMain.getProperty("portNo"));
			fileAndEnv.put("username", propMain.getProperty("username"));
			fileAndEnv.put("password", propMain.getProperty("password"));
			
		} 
		else if (evnvirnment.equalsIgnoreCase("DEV")) 
		{
			propMain.load(new FileInputStream(System.getProperty("user.dir") + "/input/dev.properties"));
			fileAndEnv.put("ServerUrl", propMain.getProperty("ServerUrl"));
			fileAndEnv.put("portNo", propMain.getProperty("portNo"));
			fileAndEnv.put("username", propMain.getProperty("username"));
			fileAndEnv.put("password", propMain.getProperty("password"));
		} 
		else if (evnvirnment.equalsIgnoreCase("STAGING")) 
		{
			propMain.load(new FileInputStream(System.getProperty("user.dir") + "/input/staging.properties"));
			fileAndEnv.put("ServerUrl", propMain.getProperty("ServerUrl"));
			fileAndEnv.put("portNo", propMain.getProperty("portNo"));
			fileAndEnv.put("username", propMain.getProperty("username"));
			fileAndEnv.put("password", propMain.getProperty("password"));
		}
		
		}
		catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return fileAndEnv;
		
		
		
	}

}
