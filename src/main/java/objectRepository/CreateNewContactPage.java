package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtilities.SeleniumUtility;

public class CreateNewContactPage extends SeleniumUtility {
	@FindBy(name= "lastname")
	private WebElement LastnameEdt;
	
@FindBy(xpath= "(//input[@title='Save [Alt+S]'])[2]")
private WebElement SaveBtn;

@FindBy(name="leadsource") 
private WebElement leadSourceDropDown;

//initiliization 
public CreateNewContactPage(WebDriver driver) {
	PageFactory.initElements(driver, this);	
}//utilization 

public WebElement getLastnameEdt() {
	return LastnameEdt;
}

public WebElement getSaveBtn() {
	return SaveBtn;
}

public WebElement getLeadSourceDropDown() {
	return leadSourceDropDown;
}
//business logic
/**
 * this method will create new contact with mandatory fields
 * @param LASTNAME
 */
public void createnewContact(String LASTNAME) {
	LastnameEdt.sendKeys(LASTNAME);
	SaveBtn.click();
}
public void createnewContact(String LASTNAME,String LEADSOURCEValue) {
	LastnameEdt.sendKeys(LASTNAME);
	handleDropdown(leadSourceDropDown,LEADSOURCEValue);
	SaveBtn.click();
	
}
}
