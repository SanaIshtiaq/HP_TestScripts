package P2p1_V1_POfrontend;

import static org.testng.AssertJUnit.assertTrue;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class POprofile 
{
	public static void main(String [] args)
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
	         
	         Random rand = new Random();
	         // ..................................................................................
	         driver.findElement(By.id("email")).clear();
	         driver.findElement(By.id("email")).sendKeys("sana.ishtiaq20@gmail.com");
	         
	         driver.findElement(By.id("password")).clear();
	         driver.findElement(By.id("password")).sendKeys("Ste123");
	         
	         driver.findElement(By.id("user-login-btn")).click();
	         
	         //click on profile link at dashboard 
	         driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/a[2]")).click();
	         
	         // assert test for "hey, i am PO"
	         
	         //click on edit profile button
	         driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/a")).click();
	         
	         String msg = "";
	         driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    	 driver.findElement(By.xpath("/html/body/div[2]/div[1]/h3")).click();
	    	 msg =  driver.findElement(By.xpath("/html/body/div[2]/div[1]/h3")).getText();
		 	 assertTrue( ("Profile Settings").equals(msg) );
	         
		 	 //tab 1
		 	driver.findElement(By.id("first_name")).clear();
		 	driver.findElement(By.id("first_name")).sendKeys(RandomStringUtils.randomAlphabetic(5));
		 	 
		 	driver.findElement(By.id("last_name")).clear();
		 	driver.findElement(By.id("last_name")).sendKeys(RandomStringUtils.randomAlphabetic(7));
		 	
		 	driver.findElement(By.id("date_of_birth")).click();
		    driver.findElement(By.xpath("/html/body/div[5]/table/tbody/tr[1]/td[2]/a")).click();
		 	 
		 	//gender
		    new Select(driver.findElement(By.xpath("/html/body/div[2]/div[3]/div[1]/div/div[2]/div[1]/form/div[4]/label/select")) ).selectByIndex(1);
		 	
		    new Select( driver.findElement(By.id("nationality")) ).selectByIndex(1);
		 	
		    driver.findElement(By.id("about_me")).clear();
		    driver.findElement(By.id("about_me")).sendKeys(RandomStringUtils.randomAlphabetic(10));
		 	
		 	//save button
		 	//driver.findElement(By.id("save-profile-basic-info")).click();
		 	
		 	// click on contact tab
		 	driver.findElement(By.id("user-contact-information-header")).click();
		 	
		 	String Msg = "";
		 	//heading of popUp
		 	// /html/body/div[7]/h3
		 	driver.findElement(By.xpath("/html/body/div[7]/h3")).click();
    	    Msg =  driver.findElement(By.xpath("/html/body/div[7]/h3")).getText();
	 	    assertTrue( ("Tab switching").equals(Msg) );
    	    
		 	//switch tab after saving data
		 	// /html/body/div[7]/a[1]
		 	driver.findElement(By.xpath(" /html/body/div[7]/a[1]")).click();
	 	    
	 	    //switch tab without saving data
		 	// /html/body/div[7]/a[2]
		 	
		 	//tab 2
		 	driver.findElement(By.id("street")).clear();
		 	driver.findElement(By.id("street")).sendKeys("st");// +RandomStringUtils.randomAlphabetic(4));
		 	
		 	driver.findElement(By.id("house_number")).clear();
		 	driver.findElement(By.id("house_number")).sendKeys("1"); //+rand.nextInt(5));
		 	
		 	driver.findElement(By.id("address")).clear();
		 	driver.findElement(By.id("address")).sendKeys("ad");// +RandomStringUtils.randomAlphabetic(4));
		 	
		 	//country dropdown
		 	new Select( driver.findElement(By.xpath("/html/body/div[2]/div/div[3]/div[1]/div/div[2]/div[1]/form/div[3]/label/select")) ).selectByIndex(1);
		 	
		 	driver.findElement(By.id("location")).clear();
		 	driver.findElement(By.id("location")).sendKeys("Prenzlauer Berg Berlin Berlin");
		 	
		 	driver.findElement(By.id("zip_code")).clear();
		 	driver.findElement(By.id("zip_code")).sendKeys("12345");
		 	
		 	driver.findElement(By.id("telephone_area_code")).clear();
		 	driver.findElement(By.id("telephone_area_code")).sendKeys("1" +rand.nextInt(5));
		 	
		 	driver.findElement(By.id("telephone_number")).clear();
		 	driver.findElement(By.id("telephone_number")).sendKeys("1" +rand.nextInt(5));
		 	
		 	//mobile number
		 	driver.findElement(By.xpath("/html/body/div[2]/div/div[3]/div[1]/div/div[2]/div[1]/form/div[7]/div/label[2]/input")).clear();
		 	driver.findElement(By.xpath("/html/body/div[2]/div/div[3]/div[1]/div/div[2]/div[1]/form/div[7]/div/label[2]/input")).sendKeys("1" +rand.nextInt(5));
		 	
		 	//save button
		 	driver.findElement(By.id("save-user-contact-info")).click();
		 	
		 	
		 	//tab 3
		 	driver.findElement(By.id("household_size")).clear();
		 	driver.findElement(By.id("household_size")).sendKeys("1" +rand.nextInt(5));
		 	
		 	new Select( driver.findElement(By.id("total_adults")) ).selectByIndex(1);
		 	
		 	new Select( driver.findElement(By.id("total_childrens")) ).selectByIndex(1);
		 	
		 	new Select( driver.findElement(By.id("current_housing_type")) ).selectByIndex(1);
		 	
		 	driver.findElement(By.id("house_rent")).clear();
		 	driver.findElement(By.id("house_rent")).sendKeys("1" +rand.nextInt(5));
		 	
		 	//click on checkbox
		 	driver.findElement(By.xpath("/html/body/div[2]/div/div[3]/div[1]/div/div[2]/div[1]/form/div[7]/div/label[2]/input")).click();
		 	
		 	driver.findElement(By.id("hobbies")).clear();
		 	driver.findElement(By.id("hobbies")).sendKeys("hobb. " +RandomStringUtils.randomAlphabetic(4));
		 	
		 	//click on radio button
		 	driver.findElement(By.xpath("/html/body/div[2]/div/div[3]/div[1]/div/div[2]/div[1]/form/div[10]/div/label[1]/input")).click();
		 	
		 	//type of payment
		 	new Select( driver.findElement(By.id("/html/body/div[2]/div/div[3]/div[1]/div/div[2]/div[1]/form/div[11]/label/select")) ).selectByIndex(1);
		 	
		 	//click on save button
		 	driver.findElement(By.id("save-user-living-info")).click();
		 	
		}
		catch(Exception e)
		{
			System.out.println("Exception is : "+e);
		}
	}

}
