package genericUtilities;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

import jdk.jfr.Timespan;

public class SeleniumUtility  {
	public void maximizeWindow(WebDriver driver) {
		driver.manage().window().maximize();
	}
	

	public void addimplicityWait(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	//	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	public void minimizeWindow(WebDriver driver)
	{
		driver.manage().window().minimize();
	//	driver.manage().window().setPosition(new Point(0, -2000));
	
		}
	
public void waitForElementToBeVisible(WebDriver driver, WebElement element) {
	WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void handleDropdown(WebElement element,int index) {
		Select sel=new Select(element);
		sel.selectByIndex(index);
	}
	public void handleDropdown(WebElement element,String  value) {
		Select sel=new Select(element);
		sel.selectByValue(value);
	}
	public void handleDropdown(String text,WebElement element)
	{
		Select sel=new Select(element);
		sel.selectByVisibleText(text);
	}
	public void rightClickAction(WebDriver driver,WebElement element) {
		Actions act=new Actions(driver);
		act.contextClick(element).perform();
	}
	
	public void doubleClickAction(WebDriver driver,WebElement element) {
		Actions act=new Actions(driver);
		act.doubleClick(element).perform();
	}
	public void dropAndDropAction(WebDriver driver,WebElement src,WebElement target) {
		Actions act=new Actions(driver);
		act.dragAndDrop(src, target);
	}
	public void mouseOverAction(WebDriver driver,WebElement ele)
	{
		Actions act=new Actions(driver);
		act.moveToElement(ele).perform();
	}
	public void handleFrame(WebDriver driver,int frameindex) {
		driver.switchTo().frame(frameindex);
	}
	public void handleFrame(WebDriver driver,String frameNameorID)
	{
		driver.switchTo().frame(frameNameorID);
	}
	public void handleFrame(WebDriver driver,WebElement frameElement)
	{
		driver.switchTo().frame(frameElement);
	}
	public String  captureScreenShot(WebDriver driver,String screenshotName) throws IOException
	{
		
		TakesScreenshot ts=(TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
	File dst=new File(".\\Screenshots\\"+screenshotName+".png");
		
	Files.copy(src, dst);
	
	return dst.getAbsolutePath();
	
	
		
	}
	
		
	}
	

