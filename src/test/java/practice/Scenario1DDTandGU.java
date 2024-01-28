package practice;
import java.io.IOException;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import genericUtilities.ExcelFileUtility;
import genericUtilities.PropertyFileUtility;
import genericUtilities.SeleniumUtility;
import io.github.bonigarcia.wdm.WebDriverManager;
import objectRepository.LoginPage;

public class Scenario1DDTandGU{


	public static void main(String[] args) throws Throwable, IOException {
		//READ all the rwquired data
	//	FileInputStream fisp=new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		//Properties p=new Properties();
		//p.load(fisp);
		PropertyFileUtility p=new PropertyFileUtility();
		ExcelFileUtility e=new ExcelFileUtility();
		SeleniumUtility s=new SeleniumUtility();
	String URL=p.readDataFromPropertyFile("url");
		String  USERNAME=p.readDataFromPropertyFile("username");
	String PASSWORD=p.readDataFromPropertyFile("password");
		
		//read test data from excel file
	//	FileInputStream fise=new FileInputStream(".\\src\\test\\resources\\TestData1.xlsx");
		//Workbook wb=  WorkbookFactory.create(fise);
		String LASTNAME= e.readDataFromExcel("Sheet1", 1, 2);
		
		
		// 1.launch the the browser
			WebDriverManager.edgedriver().setup();
				WebDriver driver=new EdgeDriver();
				//driver.manage().window().maximize();
			//	 Thread.sleep(1000);
				s.maximizeWindow(driver);
				s.addimplicityWait(driver);
				//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
				
				driver.get(URL);
				
				//3.login to application
			//	driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		//	driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		//		driver.findElement(By.id("submitButton")).click();
			
			LoginPage lp=new LoginPage(driver);
			lp.getUsernameEdt().sendKeys(USERNAME);
			lp.getPasswordEdt().sendKeys(PASSWORD);
			lp.getLoginBtn().click();
				
				//4.navigate to contact link
				driver.findElement(By.linkText("Contacts")).click();
				//HomePage hp=HomePage(driver);
			//	hp.getContactLnk().click();
				
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
		     s.mouseOverAction(driver, ele);
		      Thread.sleep(2000);

		       driver.findElement(By.linkText("Sign Out")).click();

				//10.close the browser
		        driver.close();

	}

}

