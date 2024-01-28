package practice;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WriteDataExcelSheet {
	public static void main(String[] args) throws IOException {
	FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\TestData1.xlsx");
	Workbook book = WorkbookFactory.create(fis);
	book.getSheet("Sheet1").createRow(5).createCell(2).setCellValue("Land");
	FileOutputStream fos = new FileOutputStream(".\\src\\test\\resources\\TestData1.xlsx"); 
	book.write(fos); 
//	book.close();
}
}