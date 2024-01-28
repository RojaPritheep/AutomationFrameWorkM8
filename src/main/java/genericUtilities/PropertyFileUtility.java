package genericUtilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
* This Class consists of generic method related to Property file
*  @author Roja
*
*/
public class PropertyFileUtility{
	/**
	 * This Method will read data from property file and return the value to caller 
	 * @param
	 * @return
	 * @throws IOException
	 */
	public String readDataFromPropertyFile(String key) throws IOException 
	{
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\resources\\CommonData.properties");
		Properties p=new Properties();
		p.load(fis);
		String value =p.getProperty(key);
		return value;
	}
}