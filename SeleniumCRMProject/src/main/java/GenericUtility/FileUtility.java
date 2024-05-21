package GenericUtility;

import java.io.FileInputStream;
import java.util.Properties;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class FileUtility {
	/**
	 * Method to get data from property File
	 * @return
	 * @throws Throwable 
	 */
	public String getDataFromPropertiesFile(String key) throws Throwable
	{
		FileInputStream fis=new FileInputStream("./PropertyFile/propertydata.properties");
		Properties prop=new Properties();
		prop.load(fis);
		String data=prop.getProperty(key);
		//System.out.println(data);
		return data;
	}
}
