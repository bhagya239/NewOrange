package RegressionTests;

import java.time.LocalDateTime;

import java.util.List;
import java.util.stream.Stream;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.CyberSuccess.baseClass;

import junit.framework.Assert;
public class RedBusTC1  extends baseClass{
	
	RedBusTC1 redBusObj;
	
	@BeforeTest
//	@Parameters({"browser"})
	public void beforeTest(/* String browser */) {
		 driver=getBrowserInstance("Chrome");
		 redBusObj=new RedBusTC1();
	}

	@Test(priority=0)
	public void verifyRedBusPage() {
		
		driver.navigate().to("https://www.redbus.com/");
		
		Assert.assertTrue("Failed to navigate on Redbus website",driver.findElement(By.id("search_btn")).isDisplayed());
	}
	
  @Test(priority=1)
  public void verifySearchBus() throws InterruptedException {
	  
	  driver.findElement(By.id("src")).sendKeys("Pune");
	 
	  Thread.sleep(1000);
	  List<WebElement> srcSearchResults=driver.findElements(By.xpath("//*[@class='autoFill homeSearch']/li"));
	  
	  srcSearchResults.stream()
	  .filter(val->val.getText().equals("Pune, Maharashtra, India"))
	  .findFirst().ifPresent(element-> element.click());
	
	  driver.findElement(By.id("dest")).sendKeys("Mumbai");
	  
	  Thread.sleep(1000);
	  
	  List<WebElement> destSearchResults=driver.findElements(By.xpath("//*[@class='autoFill homeSearch']/li"));
	  
	  destSearchResults.stream()
	  .filter(val->val.getText().equals("Mumbai, Maharashtra, India"))
	  .findFirst().ifPresent(element-> element.click());
	  
	 
		
		for(int i=4;i<=45;i++) {
			
			WebElement element=driver.findElement(By.xpath("//*[@id=\"rb-calendar_onward_cal\"]/descendant::td["+i+"]"));
			
			if(!element.getAttribute("class").equals("past day") && !element.getAttribute("class").equals("empty day")) {
				
				if(Integer.parseInt(element.getText())== LocalDateTime.now().getDayOfMonth()) {
					element.click();
				}			
				
			}
			
		}
		
  }
}
