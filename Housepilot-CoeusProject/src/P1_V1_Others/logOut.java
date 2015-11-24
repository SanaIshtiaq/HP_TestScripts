package P1_V1_Others;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class logOut 
{
	public static void main(String []args)
	{
		try
		{
			WebDriver driver = new FirefoxDriver();
		
			//click on logout
			new Select(driver.findElement(By.xpath("/html/body/div/div[2]/div[1]/div/div[2]/a"))).selectByVisibleText(" Abmelden");
		}
		catch(Exception e)
		{
			
		}
		
	}
}
