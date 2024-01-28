package practice;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
public class ReadDataFromPropertyFile {

	public static void main(String[] args) throws IOException {
       //1.open the document in java readable format
		FileInputStream fis= new FileInputStream(".\\src\\test\\resources\\resources\\CommonData.properties");
		
		//2.create obj of properties class from java.util
	Properties p	=new Properties();
	 
	  //3.load the fileinput stream into properties class
	p.load(fis);
	
	
	  //4.provide key and read the value
	String value=p.getProperty("username");
	String value1=p.getProperty("password");
	System.out.println(value);
	System.out.println(value1);
	
	}

}
