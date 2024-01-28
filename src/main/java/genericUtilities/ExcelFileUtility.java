package genericUtilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
/**
* This Class consists of generic method related to excel file
*  @author Roja
*
*/


public class ExcelFileUtility {
	/**
	 * This Method will read data from excel file and return the value to caller 
	 * @param SheetName
	 * @return  rowIndex
	 * @return celIndex
	 * @return 
	 * @exception EncryptedDocumentEexception
	 * @throws IOException
	 */
	public String readDataFromExcel(String sheetName,int rowIndex,int celIndex) throws EncryptedDocumentException,IOException
	{
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\resources\\TestData1.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		String value =wb.getSheet(sheetName).getRow(rowIndex).getCell(celIndex).getStringCellValue();
		return  value;
	
		
	}

}
