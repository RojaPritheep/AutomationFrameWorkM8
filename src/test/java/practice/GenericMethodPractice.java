package practice;


import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;

import genericUtilities.ExcelFileUtility;
import genericUtilities.JavaUtility;
import genericUtilities.PropertyFileUtility;


public class GenericMethodPractice {

	public static void main(String[] args) throws  IOException,  EncryptedDocumentException{
		// for property file
		PropertyFileUtility p=new PropertyFileUtility();
	String value =p.readDataFromPropertyFile("url");
		System.out.println(value);
		
		
		//foe Excel file
	ExcelFileUtility e=new ExcelFileUtility();
	String val=e.readDataFromExcel("Sheet1", 1, 1);
	System.out.println(val);
	
	JavaUtility j =new JavaUtility();
	String date=j.getSystemDate();
	System.out.println(date);

		
		}

}
