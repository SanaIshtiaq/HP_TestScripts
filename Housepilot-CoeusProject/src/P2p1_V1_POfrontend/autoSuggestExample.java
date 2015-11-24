package P2p1_V1_POfrontend;

import java.util.Iterator;  
import java.util.List;  
import java.util.concurrent.TimeUnit;  
import org.openqa.selenium.By;  
import org.openqa.selenium.WebDriver;  
import org.openqa.selenium.WebElement;  
import org.openqa.selenium.firefox.FirefoxDriver;  
import org.testng.annotations.BeforeTest;  
import org.testng.annotations.Test;  
  
public class autoSuggestExample 
{  
   public static void main(String [] args)
   {
	   WebDriver driver;  
	   driver = new FirefoxDriver();
	   
	   driver.get("http://google.com");  
	   driver.findElement(By.id("gs_htif0")).sendKeys("vam");  
	   driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);  
	     
	    WebElement table = driver.findElement(By.className("sbsb_b"));   
	    List<WebElement> rows = table.findElements(By.tagName("tr"));   
	    Iterator<WebElement> i = rows.iterator();   
	    System.out.println("-----------------------------------------");   
	    while(i.hasNext()) 
	    {   
	            WebElement row = i.next();   
	            List<WebElement> columns = row.findElements(By.tagName("td"));   
	            Iterator<WebElement> j = columns.iterator();   
	            while(j.hasNext()) {   
	                    WebElement column = j.next();   
	                    System.out.println(column.getText());   
	    }   
	    System.out.println("");   
	               
	    System.out.println("-----------------------------------------");   
   
   }
 }    
}  