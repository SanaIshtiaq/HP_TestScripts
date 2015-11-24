package P1_V1_Others;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class loginRemeberMe 
{
	public static void main (String [] args)
	{
		try
		{
			WebDriver driver = new FirefoxDriver();
	        driver.get("http://ferdinand-dev.coeus-solutions.de/admin/login/");
	         
	        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	        driver.manage().window().maximize();
	        
	        //logIn credentials
	        WebElement id = driver.findElement(By.id("username"));
	        WebElement pass = driver.findElement(By.id("password"));
	         
	        id.clear();
	        id.sendKeys("super.admin@ferdinand.de");
	         
	        pass.clear();
	        pass.sendKeys("admin");
	        
	        //id = remember_me
	        driver.findElement(By.id("remember_me")).click();
	        
	        // click on login button 
	        driver.findElement(By.xpath("//form[@id='loginform']/p[4]/button")).click();
	        
	        String selectLinkOpeninNewTab = "";
	        
	        /*
	        //The code below will open the link in new Tab.
			selectLinkOpeninNewTab = Keys.chord(Keys.CONTROL,Keys.RETURN); 
			driver.findElement(By.linkText(listOfLinks.get(i).getText())).sendKeys(selectLinkOpeninNewTab);
	        */
	        
	        //driver.close();
	        
	        driver = new FirefoxDriver();
	        driver.get("http://ferdinand-dev.coeus-solutions.de/admin/dashboard");
	         
	        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	        driver.manage().window().maximize();
	        
		}
		catch(Exception e)
		{
			
		}
	}

}
