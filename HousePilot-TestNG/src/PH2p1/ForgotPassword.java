package PH2p1;

import static org.testng.AssertJUnit.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class ForgotPassword 
{
	//handling htaccess ---  good to go
	WebDriver driver = new FirefoxDriver();
	String URL = "http://" + "ferdinand" + ":" + "coeus123" + "@" + "ferdinand-qa.coeus-solutions.de/user/login";
	@Test
	public void f() 
	{
		driver.get(URL);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize(); 
         
         // ..................................................................................
         
		driver.findElement(By.id("forgot_password")).click();
		
		String msg = "";
		// verifying the page title
		driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div")).click();
		msg = driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div")).getText();
		assertTrue( ("Forgot Password").equals(msg) ) ;
		
		WebElement id = driver.findElement(By.id("user_email"));
		
		//for invalid email
		/*id.clear();
		id.sendKeys(RandomStringUtils.randomAlphabetic(7));
		driver.findElement(By.id("submt-btn")).click();
		driver.findElement(By.xpath("/html/body/div[2]/div[1]")).click();
		msg = driver.findElement(By.xpath("/html/body/div[2]/div[1]")).getText();
		assertTrue( ("Please enter a valid email address.").equals(msg) ) ;
		*/
		
		//for unauthorized email
		id.clear();
		id.sendKeys("abc@abc.com");
		driver.findElement(By.id("submt-btn")).click();
		driver.findElement(By.xpath("/html/body/div[2]/div[1]")).click();
		msg = driver.findElement(By.xpath("/html/body/div[2]/div[1]")).getText();
		assertTrue( ("No user found with given email address").equals(msg) ) ;
		
		//for authorized email
		id.clear();
		id.sendKeys("sana.ishtiaq20@gmail");
		driver.findElement(By.id("submt-btn")).click();
		driver.findElement(By.xpath("/html/body/div[2]/div[1]")).click();
		msg = driver.findElement(By.xpath("/html/body/div[2]/div[1]")).getText();
		assertTrue( ("An email for resetting password is sent to you").equals(msg) ) ;
		
		System.out.println("Success END !!!");
	}
}
