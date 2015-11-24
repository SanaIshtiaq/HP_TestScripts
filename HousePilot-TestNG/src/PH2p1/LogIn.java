package PH2p1;

import static org.testng.AssertJUnit.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LogIn 
{  
	WebDriver driver = new FirefoxDriver();
    String URL = "http://" + "ferdinand" + ":" + "coeus123" + "@" + "ferdinand-qa.coeus-solutions.de/user/login";
    
    @BeforeTest
	public void beforeAllTests()
	{
		System.out.println("this is before the logIn functionality");
		//handling htaccess ---  good to go
		driver.get(URL);
			          		 
		//WebDriver driver = new FirefoxDriver();
		//driver.get("http://ferdinand-qa.coeus-solutions.de/user/login");   
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize(); 
	}
    
    //@BeforeMethod should contain methods that you need to run before each test case while 
    //@AfterMethod should contain methods that you need to run after each test case.
    
	@Test(priority = 1)
	public void loginFunc() 
	{
		System.out.println("in login functionality");
		 
         // ..................................................................................
         driver.findElement(By.id("email")).clear();
         driver.findElement(By.id("email")).sendKeys("sana.ishtiaq20@gmail.com");
         
         driver.findElement(By.id("password")).clear();
         driver.findElement(By.id("password")).sendKeys("ste123");
         
         //driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/form/button")).click();
         driver.findElement(By.id("user-login-btn")).click();
         
         String errMsg = "";
         driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    	 driver.findElement(By.xpath("/html/body/div[2]/div[1]")).click();
    	 errMsg =  driver.findElement(By.xpath("/html/body/div[2]/div[1]")).getText();
	 	 assertTrue( ("Incorrect information").equals(errMsg) );
    	   
         //Assert.assertTrue(true, "Incorrect information");
         System.out.println("success 1 !!!");
         
         //..................................................................................
         driver.findElement(By.id("email")).clear();
         driver.findElement(By.id("email")).sendKeys("sana.ishtiaq20@gmail.com");
         
         driver.findElement(By.id("password")).clear();
         driver.findElement(By.id("password")).sendKeys("Ste123");
         
         //driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/form/button")).click();
         driver.findElement(By.id("user-login-btn")).click();
         
         driver.findElement(By.xpath("/html/body/div[2]/div[1]/h3")).click();
         errMsg = driver.findElement(By.xpath("/html/body/div[2]/div[1]/h3")).getText();
         assertTrue( ("Dashboard").equals(errMsg) );
         
         //Assert.assertTrue(true, "Dashboard");
         System.out.println("success 2 !!!");
         
         // verify the title of page
         String expectedTitle = "Dashboard";
         String actualTitle = "";
  
         // get the actual value of the title
         actualTitle = driver.getTitle();
  
         System.out.println("actual title : "+actualTitle);
         
         /*
          * compare the actual title of the page with the expected one and print
          * the result as "Passed" or "Failed"
          */
         if (actualTitle.contentEquals(expectedTitle))
         {
             System.out.println("Test Passed!");
         } 
         else 
         {
             System.out.println("Test Failed");
         }
         
         //close Firefox
         //driver.close();
	}
	
	@Test(priority = 2)
	public void logoutFunc()
	{
		//click on logout
		new Select(driver.findElement(By.xpath("/html/body/div/div[2]/div[1]/div/div[2]/a"))).selectByVisibleText(" Abmelden");
	}
	
	@AfterTest
	public void afterAllTests()
	{
		System.out.println("this is after the logIn functionality");
		driver.quit();
	}
}
