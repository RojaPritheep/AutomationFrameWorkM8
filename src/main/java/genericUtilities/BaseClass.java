package genericUtilities;

import java.io.IOException;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;
import objectRepository.HomePage;
import objectRepository.LoginPage;

public class BaseClass {
	
	public ExcelFileUtility eUtil=new ExcelFileUtility();
	public JavaUtility jUtil=new JavaUtility();
	public PropertyFileUtility pUtil =new PropertyFileUtility();
	public SeleniumUtility sUtil=new SeleniumUtility();
	
	public WebDriver driver;
	//for listeners
	public static WebDriver sdriver;
	
@BeforeSuite(groups={"SmokeSuite","RegressionSuite"})
public void bsconfig() {
	
	System.out.println("*******DB connection successfull*********");
	
}
//@Parameters("browser")
//@BeforeTest
@BeforeClass(alwaysRun =true)
public void bcConfig(/*String B0ROWSER*/) throws IOException {
	String URL = pUtil.readDataFromPropertyFile("url");
	
//WebDriverManager.edgedriver().setup();
	//driver =new EdgeDriver();
	
	//WebDriverManager.chromedriver().setup();
//	driver =new ChromeDriver();
	WebDriverManager.firefoxdriver().setup();
	driver =new FirefoxDriver();
	
	//if(BROWSER.equals("edge")) {
	//	WebDriverManager.edgedriver().setup();
	//	driver =new EdgeDriver();
	//	}
	//else if(BROWSER.equals("firefox")) {
	//	WebDriverManager.firefoxdriver().setup();
	//	driver =new FirefoxDriver();
	//}
	
	sUtil.maximizeWindow(driver);
	sUtil.addimplicityWait(driver);
	driver.get(URL);
	
	System.out.println("*******browser launch successfull*********");
	
//for listeners
	sdriver=driver;
}
	

@BeforeMethod(alwaysRun =true)
public void bmCongig() throws IOException {
	String USERNAME = pUtil.readDataFromPropertyFile("username");
	String PASSWORD = pUtil.readDataFromPropertyFile("password");
	
	LoginPage lp=new LoginPage(driver);
	lp.loginToApp(USERNAME, PASSWORD);
	System.out.println("*******login to app successfull*********");
	
}
@AfterMethod(alwaysRun =true)
public void amConfig() throws InterruptedException {
	HomePage hp=new HomePage(driver);
	hp.logoutOfApp(driver);
	
	System.out.println("*******logout of app successfull*********");
	
}
//@AfterTest
@AfterClass(alwaysRun =true)
public void acConfig() {
	driver.quit();
	System.out.println("*******browser closure successfull*********");
}
@AfterSuite(alwaysRun =true)
public void asCongif() {
	System.out.println("*******DB closure successfull*********");
}


















}
