package ee.ut.math.tvt.ants;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class verProp {
	
	
	
	@SuppressWarnings("finally")
	public static String getPropVal(String key) {
		String value = "0";
	
		try {
			File file = new File("version.properties");
			FileInputStream fileInput = new FileInputStream(file);
			Properties properties = new Properties();
			properties.load(fileInput);
			fileInput.close();
			value = properties.getProperty(key);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally{
			return value;
		}
	}

public static void main(String[] args){
	
}}
		
		
	
