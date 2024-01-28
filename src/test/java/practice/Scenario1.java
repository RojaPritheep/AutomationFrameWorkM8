package practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Scenario1 {

	public static void main(String[] args) throws Throwable {
		// 1.launch the the browser
		WebDriverManager.edgedriver().setup();
		WebDriver driver=new EdgeDriver();
		driver.manage().window().maximize();
	//	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
     	//	2.load the url
		driver.get("http://localhost:8888");
		
		//3.login to application
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		
		//4.navigate to contact link
		driver.findElement(By.linkText("Contacts")).click();
		
	    //5.click on the create contact lookup image
		driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
		
		//6.create contact with mandatory details
		driver.findElement(By.name("lastname")).sendKeys("Roja");
		
		//7.save
		driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
		
		//8.validate
	String conHeader=	driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
	if(conHeader.contains("Roja")){
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
