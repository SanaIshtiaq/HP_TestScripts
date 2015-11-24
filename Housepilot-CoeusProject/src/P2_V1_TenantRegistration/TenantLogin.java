package P2_V1_TenantRegistration;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TenantLogin 
{
	public static void main(String [] args)
	{
		try
		{
			WebDriver driver = new FirefoxDriver();
			
			//welcome page
			driver.get("http://ferdinand-dev.coeus-solutions.de/");
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			
			//System.out.println("I will do it after demo");
			driver.findElement(By.id("search_location_value")).sendKeys("Berlin");
			driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[1]/div/form/button")).click();
			
			//google map
			//driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div[1]/div[2]"));
		}
		catch(Exception e)
		{
			System.out.println("Exception in the main thread is : "+e);
		}
	}
}
