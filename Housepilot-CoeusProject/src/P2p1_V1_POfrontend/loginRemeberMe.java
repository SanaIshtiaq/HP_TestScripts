package P2p1_V1_POfrontend;

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
			//handling htaccess ---  good to go
    		WebDriver driver = new FirefoxDriver();
	        String URL = "http://" + "ferdinand" + ":" + "coeus123" + "@" + "ferdinand-qa.coeus-solutions.de/user/login";
    	    driver.get(URL);
    	        	 
    		//WebDriver driver = new FirefoxDriver();
	        //driver.get("http://ferdinand-qa.coeus-solutions.de/user/login");
	         
	        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	        driver.manage().window().maximize();  
	        // ..................................................................................
	        
	        //logIn credentials
	        driver.findElement(By.id("email")).clear();
	         driver.findElement(By.id("email")).sendKeys("sana.ishtiaq20@gmail.com");
	         
	         driver.findElement(By.id("password")).clear();
	         driver.findElement(By.id("password")).sendKeys("Ste1234");
	        
	        //id = remember_me
	        driver.findElement(By.id("remember_me")).click();
	        
	        // click on login button 
	        driver.findElement(By.id("user-login-btn")).click();
	        
	        String selectLinkOpeninNewTab = "";
	        
	        /*
	        //The code below will open the link in new Tab.
			selectLinkOpeninNewTab = Keys.chord(Keys.CONTROL,Keys.RETURN); 
			driver.findElement(By.linkText(listOfLinks.get(i).getText())).sendKeys(selectLinkOpeninNewTab);
	        */
	        
	        //driver.close();
	        
	        driver = new FirefoxDriver();
	        driver.get("http://ferdinand-qa.coeus-solutions.de/user/login");
	         
	        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	        driver.manage().window().maximize();
	        
		}
		catch(Exception e)
		{
			System.out.println("Exception is : "+e);
		}
	}

}
