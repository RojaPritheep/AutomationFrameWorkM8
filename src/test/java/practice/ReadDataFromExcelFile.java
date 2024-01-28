package practice;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataFromExcelFile {

	public static void main(String[] args) throws EncryptedDocumentException, IOException   {

		//1.open the document in java readable format
		FileInputStream fis= new FileInputStream(".\\src\\test\\resources\\resources\\TestData1.xlsx");
		
		//2.create a workbook
		Workbook wb=WorkbookFactory.create(fis);
		
		//3.navigate to required sheet
		Sheet sh=wb.getSheet("Sheet1");
		
		//4.navigate to required row
		Row rw=sh.getRow(0);
		
		//5.navigate to required cell
		Cell cl = rw.getCell(0);
		
		//6.capture the value in the cell
		String value=cl.getStringCellValue();
		System.out.println(value);
	
		//7.close the workbook
		wb.close();
	}

}
