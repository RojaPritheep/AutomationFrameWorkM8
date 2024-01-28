package practice;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class WriteDataPropertyFile {

	public static void main(String[] args) throws IOException {
		 FileOutputStream output= new FileOutputStream(".\\src\\test\\resources\\WriteDataProperty");
		Properties p	=new Properties();
		p.setProperty("id", "123");
		p.setProperty("name", "roja"); 
		p.store(output, null);
		System.out.println("Data has been written to property file");
	
	
	
	}

}
