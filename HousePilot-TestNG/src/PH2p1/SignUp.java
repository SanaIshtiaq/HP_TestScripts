package PH2p1;

import static org.testng.AssertJUnit.assertTrue;

import java.util.Iterator;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SignUp 
{
	public WebDriver driver = new FirefoxDriver();
	public String url = "http://" + "ferdinand" + ":" + "coeus123" + "@" + "ferdinand-qa.coeus-solutions.de/";
    
	 //driver.get("http://ferdinand-qa.coeus-solutions.de/admin/login/");
    
	@Test(priority = 0)
	public void f1() 
	{
		System.out.println("start of test");
	}
	
	@Test(priority = 1)
	public void registrationProcess() 
	{
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize(); 
		// id = first_name
		// id = last_name
		// id = email
		// id = password
		// id = user-registration-btn
	  
		driver.findElement(By.xpath("/html/body/div[1]/nav/section/ul[1]/li/a")).click();
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/div")).click();
	    String regText =  driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/div")).getText();
 	    assertTrue( ("Registration").equals(regText) );
		
		// ........................................................
		String[] NameArr = new String[]{"1234","gema1234","gema@123"};
      
		//invalid conditions
		for(int k = 0 ; k<3 ; k++)
		{
			driver.findElement(By.id("first_name")).clear();
			driver.findElement(By.id("first_name")).sendKeys(NameArr[k]);
	         System.out.println("check point k : "+k);
	         Assert.assertTrue(true, "Digits are not allowed.");
		}
      
		//valid condition
		driver.findElement(By.id("first_name")).clear();
		//driver.findElement(By.id("first_name")).sendKeys("AD auto");
		driver.findElement(By.id("first_name")).sendKeys("AD Sana");
		System.out.println("check point firstname");
      	
		// ........................................................
		
		//invalid conditions
		for(int j = 0 ; j<3 ; j++)
		{
			driver.findElement(By.id("last_name")).clear();
			driver.findElement(By.id("last_name")).sendKeys(NameArr[j]);
	        Assert.assertTrue(true, "Digits are not allowed.");
		}
      
		//valid condition
		driver.findElement(By.id("last_name")).clear();
		//driver.findElement(By.id("last_name")).sendKeys(RandomStringUtils.randomAlphabetic(5));
		driver.findElement(By.id("last_name")).sendKeys("Ishtiaq");
		System.out.println("check point lastname");
      
		// ..........................................................
		String[] emailArr = new String[]{"gemacoeus.de","gema@coeus","gemacoeus"};
      
		//invalid conditions
		for(int i = 0 ; i<3 ; i++)
		{
			driver.findElement(By.id("email")).clear();
			driver.findElement(By.id("email")).sendKeys(emailArr[i]);
	        Assert.assertTrue(true, "Please enter a valid email address.");
		}
		Random rand = new Random();
      
        //RandomStringUtils.randomAlphabetic(5)
      
		//valid condition
		driver.findElement(By.id("email")).clear();
		//driver.findElement(By.id("email")).sendKeys("autotest"+rand.nextInt(200)+"@coeus-solutions.de");
		driver.findElement(By.id("email")).sendKeys("sana1@coeus-solutions.de");
		System.out.println("check point email");
      
		// ..............................................................
      
		String[] passArr = new String[]{"pass","123","pass123"};
	    
		/*
		//invalid conditions
		for(int i = 0 ; i<3 ; i++)
		{
			driver.findElement(By.id("password")).clear();
			driver.findElement(By.id("password")).sendKeys(passArr[i]);
	        Assert.assertTrue(true, "Password should be at least 6 characters");
	        Assert.assertTrue(true, "Password should atleast contain one capital letter and one number");
		}
		Random rand = new Random();
      
        //RandomStringUtils.randomAlphabetic(5)
        */
		//valid condition
		driver.findElement(By.id("password")).clear();
		//driver.findElement(By.id("email")).sendKeys("autotest"+rand.nextInt(200)+"@coeus-solutions.de");
		driver.findElement(By.id("password")).sendKeys("Ste123");
		System.out.println("check point password");
      
		// ..............................................................
		
		driver.findElement(By.id("user-registration-btn")).click();
		
		// for PO = /html/body/div[3]/div[1]/div/div[3]/a[1]/span
		// for HP = /html/body/div[3]/div[1]/div/div[3]/a[2]/span
		
		// for tenant = /html/body/div[3]/div[1]/div/div[3]/a[3]/span
		driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/div[3]/a[3]/span")).click();
		
		
		String parentWindowHandler = driver.getWindowHandle(); // Store your parent window
		String subWindowHandler = null;

		Set<String> handles = driver.getWindowHandles(); // get all window handles
		Iterator<String> iterator = handles.iterator();
		while (iterator.hasNext()){
		    subWindowHandler = iterator.next();
		}
		driver.switchTo().window(subWindowHandler); // switch to popup window
		                                            // perform operations on popup
	// driver.switchTo().window(parentWindowHandler);  // switch back to parent window

		driver.findElement(By.id("tenant-accept-terms-and-conditions-btn")).click();
		
		parentWindowHandler = driver.getWindowHandle(); // Store your parent window
		subWindowHandler = null;

		handles = driver.getWindowHandles(); // get all window handles
		iterator = handles.iterator();
		while (iterator.hasNext()){
		    subWindowHandler = iterator.next();
		}
		driver.switchTo().window(subWindowHandler); // switch to popup window
		                                            // perform operations on popup
		driver.findElement(By.id("select_tenant")).click();
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    driver.findElement(By.xpath("/html/body/div[2]/div/div/div[1]/div")).click();
	    regText =  driver.findElement(By.xpath("/html/body/div[2]/div/div/div[1]/div")).getText();
 	    assertTrue( ("Almost Finish! Please verify your Email").equals(regText) );
		
	}
	@Test(priority = 2)
	public void f2() 
	{
		System.out.println("end of test!!!");
	}
}
