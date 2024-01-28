package practice;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;
public class Scenario1DDT {

	public static void main(String[] args) throws Throwable, IOException {
		//READ all the rwquired data
		FileInputStream fisp=new FileInputStream(".\\src\\test\\resources\\resources\\CommonData.properties");
		Properties p=new Properties();
		p.load(fisp);
		String URL=p.getProperty("url");
		String  USERNAME=p.getProperty("username");
		String PASSWORD=p.getProperty("password");
		
		//read test data from excel file
		FileInputStream fise=new FileInputStream(".\\src\\test\\resources\\resources\\TestData1.xlsx");
		Workbook wb=  WorkbookFactory.create(fise);
		String LASTNAME= wb.getSheet("Sheet1").getRow(1).getCell(2).getStringCellValue();
		
		// 1.launch the the browser
			WebDriverManager.edgedriver().setup();
				WebDriver driver=new EdgeDriver();
				driver.manage().window().maximize();
				 Thread.sleep(1000);

			//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
					
		     	//	2.load the url
				driver.get(URL);
				
				//3.login to application
				driver.findElement(By.name("user_name")).sendKeys(USERNAME);
				driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
				driver.findElement(By.id("submitButton")).click();
	
				
				//4.navigate to contact link
				driver.findElement(By.linkText("Contacts")).click();
				
			    //5.click on the create contact lookup image
				driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
				
				//6.create contact with mandatory details
				driver.findElement(By.name("lastname")).sendKeys(LASTNAME);
				
				//7.save
				driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
				
				//8.validate
			String conHeader=	driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
			if(conHeader.contains(LASTNAME))
			{
			System.out.println("pass");
			System.out.println(conHeader);			
			}
			else {
				System.out.println("fail");
			}
				
				//9.logout  of app
		      WebElement ele=	driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		      Actions act=new Actions(driver);
		      act.moveToElement(ele).perform();
		      Thread.sleep(2000);

		       driver.findElement(By.linkText("Sign Out")).click();

				//10.close the browser
		        driver.close();

	}

}
