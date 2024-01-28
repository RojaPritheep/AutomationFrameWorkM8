package contactsTests;

import java.io.IOException;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import genericUtilities.BaseClass;
import genericUtilities.ExcelFileUtility;
import genericUtilities.PropertyFileUtility;
import genericUtilities.SeleniumUtility;
import io.github.bonigarcia.wdm.WebDriverManager;
import objectRepository.HomePage;
import objectRepository.LoginPage;
import objectRepository.ContactInfoPage;
import objectRepository.ContactsPage;
import objectRepository.CreateNewContactPage;

@Listeners(genericUtilities.ListenersImplementation.class)
public class CreateContactTest extends BaseClass{
	@Test(groups="SmokeSuite")
	public void createContactWithMandatoryInfo() throws IOException, InterruptedException {
		

	
		//read test data from excel file

		String LASTNAME= eUtil.readDataFromExcel("Sheet1", 1, 2);
	
			//4.navigate to contact link
				
				HomePage hp=new HomePage(driver);
				hp.clickOnContactsLink();
				
			    //5.click on the create contact lookup image
				ContactsPage cp=new ContactsPage(driver);
				cp.clickOnCreateContactLookUpImg();
				
				
				//6.create  and save contact with mandatory details
				CreateNewContactPage cncp=new CreateNewContactPage(driver);
				cncp.createnewContact(LASTNAME);
				
				//8.validate
				ContactInfoPage cip=new ContactInfoPage(driver);
				String conHeader = cip.captureHeaderText();
				Assert.assertTrue(conHeader.contains(LASTNAME));
				System.out.println(conHeader);
				}
	
			
			@Test
		public void  demoTest()
			{
				Assert.fail();
				System.out.println("Hi");
			}

			
}
