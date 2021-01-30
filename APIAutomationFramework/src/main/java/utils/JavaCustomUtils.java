package utils;

import java.util.Random;



public class JavaCustomUtils {
	
	
	public static String getRandomNumberAsString() {

		return Integer.toString(new Random().nextInt(100));
			
	}
	
	public static String getRandomString() {

		return org.apache.commons.lang3.RandomStringUtils.randomAlphabetic(8);
			
	}

}
