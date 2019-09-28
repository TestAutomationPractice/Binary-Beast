package utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadProperties {
	
	public static Properties prop = null;
	public static File file =null;
	public static FileInputStream fis = null;
	
	static{
		file = new File(System.getProperty("user.dir")+"/src/test/java/resources/Testdata.properties");
	
	try{
		fis = new FileInputStream(file);
		
	} catch (FileNotFoundException e){
		e.printStackTrace();
	}
	prop = new Properties();
	try{
		prop.load(fis);
	}catch(IOException e){
		e.printStackTrace();
	}
}
	public static void main(String[] args) {
		System.out.println(prop.getProperty("Browser"));
		
		
	}
}


