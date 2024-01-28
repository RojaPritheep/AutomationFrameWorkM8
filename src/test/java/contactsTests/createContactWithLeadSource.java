package contactsTests;
import java.io.IOException;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import genericUtilities.BaseClass;
import genericUtilities.ExcelFileUtility;
import genericUtilities.PropertyFileUtility;
import genericUtilities.SeleniumUtility;
import io.github.bonigarcia.wdm.WebDriverManager;
import objectRepository.ContactInfoPage;
import objectRepository.ContactsPage;
import objectRepository.CreateNewContactPage;
import objectRepository.HomePage;
import objectRepository.LoginPage;
@Listeners(genericUtilities.ListenersImplementation.class)
public class createContactWithLeadSource extends BaseClass{
	
	
	@Test(groups ="SmokeSuite")
	public void createContactWithLead() throws IOException, InterruptedException {
		
//		PropertyFileUtility p=new PropertyFileUtility();
	//	ExcelFileUtility e=new ExcelFileUtility();
		//SeleniumUtility s= new SeleniumUtility();
		
//			String URL =p.readDataFromPropertyFile("url");
	//        String USERNAME = p.readDataFromPropertyFile("username");
	  //      String PASSWORD = p.readDataFromPropertyFile("password");
	        
	        String LASTNAME= eUtil.readDataFromExcel("Sheet1", 3, 2);
	        String LEADSOURCE=eUtil.readDataFromExcel("Sheet1", 3,3 );
	        //launch the browser
	     //   WebDriverManager.edgedriver().setup();
	//		WebDriver driver=new EdgeDriver();
		//	s.maximizeWindow(driver);
			//s.addimplicityWait(driver);RegressionSuite
			//2.load the url
	   //     driver.get(URL);
	        
	        //3.login to the application
	    //    LoginPage lp=new LoginPage(driver);
	    //    lp.loginToApp(USERNAME, PASSWORD);
		
	        //4.navigate to contact link
	        HomePage hp=new HomePage(driver);
	        hp.clickOnContactsLink();
		  
		  //5.click on the create contact lookup image
		  ContactsPage cp=new ContactsPage(driver);
		  cp.clickOnCreateContactLookUpImg();
		  
		  //6.create contact with mandatory details
		  CreateNewContactPage cncp=new CreateNewContactPage(driver);
		  cncp.createnewContact(LASTNAME, LEADSOURCE);
		  
		  //validate
		  ContactInfoPage cip=new ContactInfoPage(driver);
			String conHeader = cip.captureHeaderText();
			if(conHeader.contains(LASTNAME))
			{
				System.out.println("pass");
				System.out.println(conHeader);			
			}
			else {
			System.out.println("fail");
		}
		
			//9.logout  of app
	//	hp.logoutOfApp(driver);
		
		//10.close the browser
	//	 driver.close();

	}
}
