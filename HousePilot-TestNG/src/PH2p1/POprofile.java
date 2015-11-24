package PH2p1;

import static org.testng.AssertJUnit.assertTrue;

import java.awt.Robot;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class POprofile 
{
	WebDriver driver = new FirefoxDriver();
    String URL = "http://" + "ferdinand" + ":" + "coeus123" + "@" + "ferdinand-qa.coeus-solutions.de/user/login";
    Random rand = new Random();
    
	@BeforeTest
	public void beforeAllTests()
	{
		
		System.out.println("before tests");
		//handling htaccess ---  good to go
		driver.get(URL);
			          		 
		//WebDriver driver = new FirefoxDriver();
		//driver.get("http://ferdinand-qa.coeus-solutions.de/user/login");   
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize(); 
	}
	    
	@Test (priority = 1)
	public void basicInfoTab() 
	{     
     
         // ..................................................................................
         driver.findElement(By.id("email")).clear();
         driver.findElement(By.id("email")).sendKeys("sana_ishtiaq20@yahoo.com");
         
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
         
	 	 /*
	 	 //tab 1
	 	driver.findElement(By.id("first_name")).clear();
	 	driver.findElement(By.id("first_name")).sendKeys(RandomStringUtils.randomAlphabetic(5));
	 	 
	 	driver.findElement(By.id("last_name")).clear();
	 	driver.findElement(By.id("last_name")).sendKeys(RandomStringUtils.randomAlphabetic(7));
	 	
	 	driver.findElement(By.id("date_of_birth")).click();
	    driver.findElement(By.xpath("/html/body/div[5]/table/tbody/tr[1]/td[2]")).click();
	 	 
	 	//gender
	    new Select(driver.findElement(By.xpath("/html/body/div[2]/div[3]/div[1]/div/div[2]/div[1]/form/div[4]/label/select")) ).selectByIndex(1);
	 	
	    new Select( driver.findElement(By.id("nationality")) ).selectByIndex(1);
	 	
	    driver.findElement(By.id("about_me")).clear();
	    driver.findElement(By.id("about_me")).sendKeys(RandomStringUtils.randomAlphabetic(10));
	 	
	 	//save button
	 	//driver.findElement(By.id("save-profile-basic-info")).click();
	 	*/
	}
	
	@Test ( priority = 2 )
	public void contactTab()
	{
	 	// click on contact tab
	 	driver.findElement(By.id("user-contact-information-header")).click();
	 	
	 	/*
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
	 	*/
	 	
	 	//tab 2
	 	//driver.findElement(By.id("street")).clear();
	 	//driver.findElement(By.id("street")).sendKeys("st123");// +RandomStringUtils.randomAlphabetic(4));
	 	
	 	//driver.findElement(By.id("house_number")).clear();
	 	//driver.findElement(By.id("house_number")).sendKeys("1"); //+rand.nextInt(5));
	 	
	 	/*driver.findElement(By.id("address")).clear();
	 	driver.findElement(By.id("address")).sendKeys("ad");// +RandomStringUtils.randomAlphabetic(4));
	 	
	 	
	 	//country dropdown
	 	new Select( driver.findElement(By.xpath("/html/body/div[2]/div[3]/div[1]/div/div[2]/div[1]/form/div[3]/label/select")) ).selectByIndex(0);
	 	                                         
	 	//driver.findElement(By.id("location")).clear();
	 	//driver.findElement(By.id("location")).sendKeys("Prenzlauer Berg Berlin Berlin");
	 	
	 	//******************************************************************************************  
	    try
	    {
		    //id = location
	    	driver.findElement(By.id("location")).clear();
		    driver.findElement(By.id("location")).click();
		    
		    Robot robot1 = new Robot();
		    robot1.keyPress(66); //B
		    robot1.keyRelease(66);
		    robot1.keyPress(69); //E
		    robot1.keyRelease(69);
		    robot1.keyPress(82); //R
		    robot1.keyRelease(82);
		    driver.findElement(By.xpath("/html/body/div[7]/div[4]")).click();
		    
	    }
	    catch(Exception e)
	    {
	    	System.out.println("Error at location field"+e);
	    }
	    
	   //*******************************************************************************************
	 	
	 	driver.findElement(By.id("zip_code")).clear();
	 	driver.findElement(By.id("zip_code")).sendKeys("12345");
	 	*/
	 	driver.findElement(By.id("telephone_area_code")).clear();
	 	driver.findElement(By.id("telephone_area_code")).sendKeys("1" +rand.nextInt(5));
	 	
	 	driver.findElement(By.id("telephone_number")).clear();
	 	driver.findElement(By.id("telephone_number")).sendKeys("1" +rand.nextInt(5));
	 	
	 	//mobile number
	 	driver.findElement(By.xpath("/html/body/div[2]/div/div[3]/div[1]/div/div[2]/div[1]/form/div[7]/div/label[2]/input")).clear();
	 	driver.findElement(By.xpath("/html/body/div[2]/div/div[3]/div[1]/div/div[2]/div[1]/form/div[7]/div/label[2]/input")).sendKeys("1" +rand.nextInt(5));
	 	
	 	//save button
	 	driver.findElement(By.id("save-user-contact-info")).click(); 
	}
	/*
	@Test ( priority = 3 )
	public void livingTab()
	{
	 	
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
	
	@AfterTest
	public void afterAllTests()
	{
		System.out.println("after tests");
	}
	*/
}
