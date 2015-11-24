package PH2p1;

import java.io.File;
import java.net.URISyntaxException;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;

public class CreatePropertyByPO 
{
	 //handling htaccess ---  good to go
	WebDriver driver = new FirefoxDriver();
	String URL = "http://" + "ferdinand" + ":" + "coeus123" + "@" + "ferdinand-qa.coeus-solutions.de/user/login";
    
	@Test(priority = 1)
	public void f() 
	{
		driver.get(URL);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize(); 
         
         // ..................................................................................
		
        driver.findElement(By.id("email")).clear();
        driver.findElement(By.id("email")).sendKeys("sana_ishtiaq20@yahoo.com");
         
         driver.findElement(By.id("password")).clear();
         driver.findElement(By.id("password")).sendKeys("Ste123");
         
         //driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/form/button")).click();
         driver.findElement(By.id("user-login-btn")).click();
		
		//click on add new property
         driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/a[4]")).click();
		
		 Random rand = new Random();
		
		 
		//property creation form starts from here
		
		// 1 id = title - - any type of input is acceptable
		//valid condition for title  
		driver.findElement(By.id("title")).clear();
	    driver.findElement(By.id("title")).sendKeys("property "+RandomStringUtils.randomAlphabetic(10));
	    
	    // ..............................................................................
	    // 2 id = property_desc - - any type of input is acceptable except of integers only
	    //Invalid input for description field 
	    driver.findElement(By.id("property_desc")).clear();
	    driver.findElement(By.id("property_desc")).sendKeys("300000"); // RandomStringUtils.randomAlphabetic(7) 
	    Assert.assertTrue(true); //, "The field can not contain numbers only"
	    System.out.println("description check point 1");
	    
	    //Valid input for description field 
	    driver.findElement(By.id("property_desc")).clear();
	    driver.findElement(By.id("property_desc")).sendKeys("description "+RandomStringUtils.randomAlphabetic(10));
	    // ...............................................................................
	    
	   // 3 id = street - - any data is valid for street
	   //valid condition for street 
	    driver.findElement(By.id("street")).clear();
	    driver.findElement(By.id("street")).sendKeys("1"+rand.nextInt(15));
	    
	    
	    String[] Arr2 = new String[]{"alpha","alpha1234","$$@@"};
        
	    // .............................................................
	    // 4 id = house_number - - only integers are acceptable
        //Invalid condition for house#
        for(int k = 0 ; k<3 ; k++)
        {
        	driver.findElement(By.id("house_number")).clear();
    	    driver.findElement(By.id("house_number")).sendKeys(Arr2[k]);
	        System.out.println("check point house# : "+k);
	        Assert.assertTrue(true, "The field value must be a number");   
	    }
	    //valid condition for house#
	    driver.findElement(By.id("house_number")).clear();
	    driver.findElement(By.id("house_number")).sendKeys("4");
	    // ..................................................................
	    
	    // ...................................................................
	    String errMsg = "";
	    // 5 id = property_zip - - only integers are acceptable
	   //Invalid input for zip code
        /*for(int k = 0 ; k<3 ; k++)
        {
        	driver.findElement(By.id("property_zip")).clear();
    	    driver.findElement(By.id("property_zip")).sendKeys(Arr2[k]);
	        
    	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    	    driver.findElement(By.id("property_zip-error")).click();
    	    errMsg =  driver.findElement(By.id("property_zip-error")).getText();
	 	    assertTrue( ("Please enter a valid number.").equals(errMsg) );
    	    //assertEquals("Please enter a valid number.", errMsg);
	    }*/
	    //valid data for zip code
	    driver.findElement(By.id("property_zip")).clear();
	    driver.findElement(By.id("property_zip")).sendKeys("12345");
	    // .......................................................................
	    //16 RandomStringUtils.randomAlphabetic(5)
        
      //******************************************************************************************  
	    try
	    {
		    //id = location
		    driver.findElement(By.id("location")).click();
		    //driver.findElement(By.xpath("/html/body/div[7]")).click();
		     // /html/body/div[7]/div[3]
		    ///html/body/div[7]/div[4]
		    Robot robot1 = new Robot();
		    robot1.keyPress(66);
		    robot1.keyRelease(66);
		    robot1.keyPress(69);
		    robot1.keyRelease(69);
		    robot1.keyPress(82);
		    robot1.keyRelease(82);
		    //driver.findElement(By.xpath("/html/body/div[7]/div[3]")).click();
		    driver.findElement(By.xpath("/html/body/div[7]/div[4]")).click();
		    /*robot1.keyPress(40);
		    robot1.keyRelease(40);
			robot1.keyPress(13);
			robot1.keyRelease(13);*/
		    /*robot1.keyPress(KeyEvent.VK_DOWN);
		    robot1.keyRelease(KeyEvent.VK_DOWN);
			robot1.keyPress(KeyEvent.VK_ENTER);
			robot1.keyRelease(KeyEvent.VK_ENTER);*/
	    }
	    catch(Exception e)
	    {
	    	System.out.println("Error at location field"+e);
	    }
	    
	   //******************************************************************************************* 
	    // .........................................................................
	    
	    // 8 id = property_address - - The field can not contain numbers only
	    //invalid input
	    driver.findElement(By.id("property_address")).clear();
	    driver.findElement(By.id("property_address")).sendKeys("12345");
	    //Assert.assertTrue(true, "The field can not contain numbers only");
	    
	    //valid input
	    driver.findElement(By.id("property_address")).clear();
	    driver.findElement(By.id("property_address")).sendKeys(RandomStringUtils.randomAlphabetic(5) + " " + rand.nextInt(5000));
	   
	    //............................................................................    
	    	    
	    // 9 id = minimum_rent_per_month  ... currency
	    
	    //Invalid condition for minimum_rent_per_month
        for(int k = 0 ; k<3 ; k++)
        {
        	driver.findElement(By.id("minimum_rent_per_month")).clear();
    	    driver.findElement(By.id("minimum_rent_per_month")).sendKeys(Arr2[k]);
	        //Assert.assertTrue(true, "The field value must be a number");   
	    }
	    //valid condition for minimum_rent_per_month
        driver.findElement(By.id("minimum_rent_per_month")).clear();
	    driver.findElement(By.id("minimum_rent_per_month")).sendKeys("2500");
	    
	    // .............................................................................
	    
	    // 10 id = maximum_rent_per_month  ... currency
	    driver.findElement(By.id("maximum_rent_per_month")).clear();
	    driver.findElement(By.id("maximum_rent_per_month")).sendKeys("5000");
	    
	    // 11 id = no_of_rooms         ... dropdown (no.s)
	    new Select(driver.findElement(By.id("no_of_rooms"))).selectByVisibleText("3.5");
	    // ................................................................................
	    
	    // 12 id = property_type           ... dropdown
	    new Select(driver.findElement(By.id("property_type"))).selectByVisibleText("Mietwohnung");
	   
	    // depends on 12
	    new Select(driver.findElement(By.id("property_child_type"))).selectByIndex(3);
	    
	    //checked *****************************************
	    
     	 // 14 id = date_picker_create_property ... calendar
	    driver.findElement(By.id("date_picker_create_property")).click();
	    driver.findElement(By.xpath("/html/body/div[6]/table/tbody/tr[5]/td[3]/a")).click();
	    	    

	    // 15 id = security_deposit ... currency
	    //Invalid condition for security deposit
        for(int k = 0 ; k<3 ; k++)
        {    
    	    driver.findElement(By.id("security_deposit")).clear();
    	    driver.findElement(By.id("security_deposit")).sendKeys(Arr2[k]);
    	    System.out.println("check point for security deposit : "+k);
     	    Assert.assertTrue(true,"The field value must be a number");
        }
	    driver.findElement(By.id("security_deposit")).clear();
	    driver.findElement(By.id("security_deposit")).sendKeys("5000");
	    
	    // 16 id = utility_costs_per_month ... currency
	    driver.findElement(By.id("utility_costs_per_month")).clear();
	    driver.findElement(By.id("utility_costs_per_month")).sendKeys("2000");
	    
	    // 17 id = heating_costs_per_month ... currency
	    driver.findElement(By.id("heating_costs_per_month")).clear();
	    driver.findElement(By.id("heating_costs_per_month")).sendKeys("1000");
	    
	    // 18 id = heating_cost_included .. dropdown 
	    new Select(driver.findElement(By.id("heating_cost_included"))).selectByIndex(1);//.selectByVisibleText("Nein");
	    
	 	// 19 id = total_rent_per_month ... auto fill
	    //login needs here
	    
	    // 20 id = living_area_approx
	    driver.findElement(By.id("living_area_approx")).clear();
	    driver.findElement(By.id("living_area_approx")).sendKeys("400");
	    
	    // 21 id = rent_per_sqm ... auto fill
	    //login needs here
	    
	    // 22 id = usable_space
	    // ..........................................................................................
	    //Invalid condition for usable space
        for(int k = 0 ; k<3 ; k++)
        {
        	driver.findElement(By.id("usable_space")).clear();
    	    driver.findElement(By.id("usable_space")).sendKeys(Arr2[k]);
    	    System.out.println("check point for usable space : "+k);
     	    Assert.assertTrue(true,"The field value must be a number");   
        }
        //valid condition for usable space, approx land area, no garage, deposit cooperative share, commision agent
	    driver.findElement(By.id("usable_space")).clear();
	    driver.findElement(By.id("usable_space")).sendKeys("25");
	
	    // 23 id = land_area_Approx ... digits
	    for(int k = 0 ; k<3 ; k++)
        {
        	driver.findElement(By.id("land_area_approx")).clear();
    	    driver.findElement(By.id("land_area_approx")).sendKeys(Arr2[k]);
    	    System.out.println("check point for land area approx : "+k);
     	    Assert.assertTrue(true,"The field value must be a number");   
        }
        //valid condition for approx land area
	    driver.findElement(By.id("land_area_approx")).clear();
	    driver.findElement(By.id("land_area_approx")).sendKeys("250");
	
	    // .................................................................................
	    // 24 id = garage_parking_space ... dropdown
	    new Select(driver.findElement(By.id("garage_parking_space"))).selectByVisibleText("Garage");
	    
	    //24.1 id = no_garage_parking_space   ... digit
	    //24.2 id = rent_garage_parking_space ... currency
	    //Invalid condition for no_garage_parking_space, rent_garage_parking_space
        for(int k = 0 ; k<3 ; k++)
        {
    	    driver.findElement(By.id("no_garage_parking_space")).clear();
    	    driver.findElement(By.id("no_garage_parking_space")).sendKeys(Arr2[k]);
    	    System.out.println("check point for no_garage_parking_space : "+k);
     	    Assert.assertTrue(true,"The field value must be a number");
     	    
    	    driver.findElement(By.id("rent_garage_parking_space")).clear();
    	    driver.findElement(By.id("rent_garage_parking_space")).sendKeys(Arr2[k]);
    	    System.out.println("check point for approx_land_area : "+k);
     	    Assert.assertTrue(true,"The field value must be a number");   
        }
	    driver.findElement(By.id("no_garage_parking_space")).clear();
	    driver.findElement(By.id("no_garage_parking_space")).sendKeys("5");
	    
	    driver.findElement(By.id("rent_garage_parking_space")).clear();
	    driver.findElement(By.id("rent_garage_parking_space")).sendKeys("43");
	    
	    // .....................................................................................
	    // 25 id = property_lease_term
	    //valid data for lease term || no validation check required
	    driver.findElement(By.id("property_lease_term")).clear();
	    driver.findElement(By.id("property_lease_term")).sendKeys("5");
	    // .....................................................................................
	 
	    // 26 id = furnishing ... dropdown
	    new Select(driver.findElement(By.id("furnishing"))).selectByIndex(2);
	    
	    // 27 id = property_condition .. dropdown
	    new Select(driver.findElement(By.id("property_condition"))).selectByIndex(3);
	    
	    // 28 id = uniform_property_renovated ... radio buttons
    	// ............................................................................................
	    //driver.findElement(By.xpath("(//input[@id='flooring_type'])[2]")).click();
	    //property_renovated
	    driver.findElement(By.xpath("/html/body/div[2]/div/form/div[3]/div[3]/div/label[1]/input")).click();
	    
	    // 29 id = construction_year ... dropdown
	    new Select(driver.findElement(By.id("construction_year"))).selectByVisibleText("1915");
	    
	    // 30 id = year_unknown ... checkbox
	    
	    // 31 id = total_floors ... digits
	    //valid data for total_floors
	    driver.findElement(By.id("total_floors")).clear();
	    driver.findElement(By.id("total_floors")).sendKeys("4");
	    
	    // 32 id = floor_number ... digit
	    //valid data for floor_number
	    driver.findElement(By.id("floor_number")).clear();
	    driver.findElement(By.id("floor_number")).sendKeys("3");
	    
	    // 33 id = no_of_bedrooms ... dropdown
	    new Select(driver.findElement(By.id("no_of_bedrooms"))).selectByVisibleText("5.0");
	    
	    // 34 id = no_of_toilts ... dropdown
	    new Select(driver.findElement(By.id("no_of_toilets"))).selectByVisibleText("2.0");
	    
	    // 35 id = no_of_bathrooms ... dropdown
	    new Select(driver.findElement(By.id("no_of_bathrooms"))).selectByVisibleText("1.0");
	    
	    	
	     // ............................................................................................
		 // 36 id = ceiling_height ... digit
	        //Invalid condition for ceiling height
	        for(int k = 0 ; k<3 ; k++)
	        {
	        	driver.findElement(By.id("ceiling_height")).clear();
	        	driver.findElement(By.id("ceiling_height")).sendKeys(Arr2[k]);
	        	System.out.println("check point for ceiling height : "+k);
	     	    Assert.assertTrue(true,"The field value must be a number");
	        }
	        //valid condition for ceiling height
	        driver.findElement(By.id("ceiling_height")).clear();
	    	driver.findElement(By.id("ceiling_height")).sendKeys("20");
	    // ...............................................................................................
	    	
	    // 37 id = uniform-flooring_type ... radio button
	    	new Select(driver.findElement(By.id("flooring_type"))).selectByIndex(2);

	    	//**************************need to check this **********************
	    // 41 id = credit_report_required ... checkbox
	    //driver.findElement(By.id("credit_report_required")).click();
	    //************************************************************************
			
	    // ..............................................................................................
	    // 38 id = transport_distance ... digit  , school , kindergarten
	    new Select(driver.findElement(By.xpath("/html/body/div[2]/div/form/div[4]/div[1]/div/label/select"))).selectByIndex(2);
	    new Select(driver.findElement(By.xpath("/html/body/div[2]/div/form/div[4]/div[2]/div/label/select"))).selectByIndex(2);
	    new Select(driver.findElement(By.xpath("/html/body/div[2]/div/form/div[4]/div[3]/div/label/select"))).selectByIndex(2);
		// ............................................................................................   	
    	
	    // 42 id = facilities_note ... textarea
	    //valid data for facilities_note
	    driver.findElement(By.id("facilities_note")).clear();
	    driver.findElement(By.id("facilities_note")).sendKeys("abc 44563");
	    
	    // 43 id = location_note ... textarea
	    //valid data for price
	    driver.findElement(By.id("location_note")).clear();
	    driver.findElement(By.id("location_note")).sendKeys("abc 44563");
	    
	    // 44 id = detailed_info_on_property ... textarea
	    //valid data for price
	    driver.findElement(By.id("detailed_info_on_property")).clear();
	    driver.findElement(By.id("detailed_info_on_property")).sendKeys("abc 44563");
	    
	    // 45 id = other_desc ... textarea
	    //valid data for price
	    driver.findElement(By.id("other_desc")).clear();
	    driver.findElement(By.id("other_desc")).sendKeys("abc 44563");
	    
	    // ............... NEW
	    driver.findElement(By.name("eligibility_to_public_housing")).click();
	}
	
	/*
	@Test(priority = 2)
	public void f4()
	{
	    // ..............................................................................................
	    // 46 id = add_property_images_btn  .... button to upload images   
	    //open upload window
	    driver.findElement(By.id("add_property_images_btn")).click();

		//put path to your image in a clipboard
		StringSelection ss = new StringSelection("C:\\Users\\coeus\\Downloads\\pictures for HP\\45.jpg");
		//C:\Users\coeus\Downloads\pictures for HP\45.jpg
		try
		{
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		  //native key strokes for CTRL, V and ENTER keys
		   Robot robot = new Robot();
		  robot.keyPress(KeyEvent.VK_CONTROL);
		  robot.keyPress(KeyEvent.VK_V);
		  robot.keyRelease(KeyEvent.VK_V);
		  robot.keyRelease(KeyEvent.VK_CONTROL);
		  robot.keyPress(13);
		  robot.keyRelease(13);
		  //robot.keyPress(KeyEvent.VK_ENTER);
		  //robot.keyRelease(KeyEvent.VK_ENTER);
		 
		}
		catch (Exception e)
		{
			System.out.println("exception is : "+e);
		}
	}
	*/
	@Test(priority = 3)
	public void f3() 
	{
		
	    // 47 id = energy_certificate  ... dropdown   .. 1
	    new Select(driver.findElement(By.id("energy_certificate"))).selectByIndex(2);
	    
	    // 48 id = certificate_creation ... dropdown 2 ... depend on 1
	    new Select(driver.findElement(By.id("certificate_creation"))).selectByIndex(1);
	    
	    // 49 id = cerftificate_type ... dropdown 3 ... depend on 1
	    new Select(driver.findElement(By.id("certificate_type"))).selectByIndex(1);
	    
	    // 50 id = energy_demand ... textfield ... depend on 3
	    driver.findElement(By.id("energy_demand")).clear();
	    driver.findElement(By.id("energy_demand")).sendKeys("testing");
	    
	    // 51 id = energy_consumption ... textfield ... depend on 3
 		
	    // 52 id = energy_carrier  ... dropdown
	    new Select(driver.findElement(By.id("energy_carrier"))).selectByVisibleText("Kohle/Koks");

 		// 53 id = heating ... dropdown
	    new Select(driver.findElement(By.id("heating"))).selectByIndex(1);
 		
 		// 54 check boxes at last
	    driver.findElement(By.xpath("(//input[@name='meta_array[]'])[29]")).click();
	    driver.findElement(By.xpath("(//input[@name='meta_array[]'])[32]")).click();
	    //driver.findElement(By.xpath("(//div[@id='uniform-undefined']/span)[35]")).click();
	    
	    // 55 metas  
	    //adding user defined metas
	    /*driver.findElement(By.id("other_metas_cb")).click();
	    driver.findElement(By.id("add_new_metas_input_tagsinput")).clear();
	    driver.findElement(By.id("add_new_metas_input_tagsinput")).sendKeys("auto meta 1");
	    driver.findElement(By.id("add_new_metas_input_tagsinput")).sendKeys("\n");
	    driver.findElement(By.id("add_new_metas_input_tagsinput")).click();
	    */
	    try
	    {
	    	driver.findElement(By.id("other_metas_cb")).click();
		    //id = location
	    	driver.findElement(By.id("add_new_metas_input_tagsinput")).click();
		    Robot robot2 = new Robot();
		    robot2.keyPress(66);
		    robot2.keyRelease(66);
		    robot2.keyPress(69);
		    robot2.keyRelease(69);
		    robot2.keyPress(82);
		    robot2.keyRelease(82);
		    robot2.keyPress(13);
		    robot2.keyRelease(13);		    
	    }
	    catch(Exception e)
	    {
	    	System.out.println("Error at custom meta field"+e);
	    }
	    
	    // ............................................................................................
	    
	    // selection from drop downs
	    //new Select(driver.findElement(By.id("property_child_type"))).selectByVisibleText("Duplex / Maisonette");
	    
	    //scroll down
	    JavascriptExecutor jsx = (JavascriptExecutor) driver;
	    jsx.executeScript("window.scrollBy(0,100)","");
	    // .........................................................................................
	    //preview button
	    driver.findElement(By.id("save_property_without_wishlist")).click();
	    // save property buttton
	    //driver.findElement(By.xpath("/html/body/div[2]/div/form/div[8]/button[2]")).click();
	    //driver.findElement(By.cssSelector("input.btn.btn-primary")).click();
	    
	    //Assert.assertTrue(true, "Immobilien erfolgreich erstellt");
	    
	    /*  // writing output to file
	    PrintStream ps = null;

	      try 
	      {
	    	  ps = new PrintStream(new FileOutputStream("myfile.txt",true));
  		  
	    	  if( driver.getPageSource().contains("Immobilien erfolgreich erstellt") )
	    	  {
	    		  ps.println(" \" create property \" || PASS ");
	    		  ps.println(" .............................................. ");
	    		  System.out.println("Pass Written successfully");
	    	  }
	    	  else
	    	  {
	    		  ps.println(" \" create property \" || FAIL ");
	    		  ps.println(" .............................................. ");
	    		  System.out.println("Fail Written successfully");
	    	  }
	      } 
	      catch (IOException e) 
	      {
	          System.err.println("Error in writing to file");
	          //throw e;
	      } 
	      finally 
	      {
	          if (ps != null) ps.close();
	      }
	      */
	
	}
}

