package P1_V1_Property;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class noOfRecordsOnListProperty 
{
	
	public static void main(String [] args)
	{
		try
		{
			WebDriver driver = new FirefoxDriver();
			driver.get("http://ferdinand-dev.coeus-solutions.de/admin/login/");
			
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().window().maximize(); 
			
			WebElement id = driver.findElement(By.id("username"));
			WebElement pass = driver.findElement(By.id("password"));
			
			//give credentials at login page
			id.clear();
			id.sendKeys("super.admin@ferdinand.de");
			pass.clear();
			pass.sendKeys("admin");
			
			//click on login button
			driver.findElement(By.xpath("//form[@id='loginform']/p[4]/button")).click();			
			
			// "Property Management"
			//driver.findElement(By.linkText("Hausverwaltung")).click();
			driver.findElement(By.xpath("/html/body/div/div[1]/div[3]/ul/li[7]/a")).click();
			
			Random rand = new Random();
			
			//driver.findElement(By.xpath("//table[@id='dyntable']/tbody/tr[3]/td[15]/a")).click();
		    //String[] Arr2 = new String[]{"alpha","alpha1234","$$@@"};
			
			int randomVal = rand.nextInt(5) ;
			randomVal = randomVal + 1; 
			new Select(driver.findElement(By.name("dyntable_length"))).selectByIndex(randomVal);

			
			
			// 0 - - 10
			// 1 - - 25
			// 2 - - 50
			// 3 - - 100
			// 4 - - 200
			// 5 - - 500
			// 6 - - 1000
			System.out.println("End result !!!");
			
			//String [] arrayOfTR = null;
			int listOfTR_count = 0;
			
			List<WebElement> listOfTR = driver.findElements(By.xpath("//table[@id='dyntable']/tbody/tr"));
		        	
		    listOfTR_count = listOfTR.size();
		         
		    System.out.println("Total no of rows on the table : "+listOfTR_count);
		     
		    if(randomVal == 0)
		    {
		    	if( listOfTR_count <= 10)
		    	{
		    		System.out.println("record should not be more than 10, it seems fine");
		    	}
		    	else
		    	{
		    		return;
		    	}
		    }
		    else if(randomVal == 1)
		    {
		    	if( listOfTR_count <= 25)
		    	{
		    		System.out.println("record should not be more than 25, it seems fine");
		    	}
		    	else
		    	{
		    		return;
		    	}
		    }
		    else if(randomVal == 2)
		    {
		    	if( listOfTR_count <= 50)
		    	{
		    		System.out.println("record should not be more than 50, it seems fine");
		    	}
		    	else
		    	{
		    		return;
		    	}
		    }
		    else if(randomVal == 3)
		    {
		    	if( listOfTR_count <= 100)
		    	{
		    		System.out.println("record should not be more than 100, it seems fine");
		    	}
		    	else
		    	{
		    		return;
		    	}
		    }
		    else if(randomVal == 4)
		    {
		    	if( listOfTR_count <= 200)
		    	{
		    		System.out.println("record should not be more than 200, it seems fine");
		    	}
		    	else
		    	{
		    		return;
		    	}
		    }
		    else if(randomVal == 5)
		    {
		    	if( listOfTR_count <= 500)
		    	{
		    		System.out.println("record should not be more than 500, it seems fine");
		    	}
		    	else
		    	{
		    		return;
		    	}
		    }
		    else if(randomVal == 6)
		    {
		    	if( listOfTR_count <= 1000)
		    	{
		    		System.out.println("record should not be more than 1000, it seems fine");
		    	}
		    	else
		    	{
		    		return;
		    	}
		    }
		   
		}
		catch(Exception e)
		{
			System.out.println("ERROR in main Thread : "+e);
		}
	}

}