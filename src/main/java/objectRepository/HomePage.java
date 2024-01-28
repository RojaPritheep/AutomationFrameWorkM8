package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtilities.SeleniumUtility;

public class HomePage extends SeleniumUtility
{
	//declaratiom- webelemnts-dropdown,windows,frames,mouseovering
	@FindBy(linkText="Contacts")
	private WebElement contactsLnk;
	
	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement administratorImg;
	
	@FindBy(linkText ="Sign Out")
	private WebElement signoutLnk;
	
	//initialization
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
	}
	//utilization
	
	public WebElement getContactLnk() {
		return contactsLnk;
	}

	public WebElement getAdministratorImg() {
		return administratorImg;
	}

	public WebElement getSignoutLink() {
		return signoutLnk;
	}
	
	//business library
	public void clickOnContactsLink() {
		contactsLnk.click();
		}
	
	/**
	 * this method will perform logout of the operation
	 * @param driver
	 * @throws InterruptedException
	 */
	public void logoutOfApp(WebDriver driver) throws  InterruptedException{
		mouseOverAction(driver,administratorImg);
		Thread.sleep(1000);
		signoutLnk.click();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
