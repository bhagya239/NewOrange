package RegressionTests;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.CyberSuccess.PropertyHandling;
import com.CyberSuccess.baseClass;
import com.aventstack.extentreports.Status;

import junit.framework.Assert;


public class OrangeHRMLogin extends baseClass{

	PropertyHandling propertyHandling;
	
	OrangeHRMLogin hrmLogin;
	
	@BeforeTest(groups= {"sanity"})
	 @Parameters({"browser"})
	public void beforeTest(String browser){	
		
		 driver=getBrowserInstance(browser);
		System.out.println("This is before test method");
		
	}

	@AfterTest(groups= {"sanity"})
	public void afterTest() {
		driver.quit();
	}
	@BeforeClass(groups= {"sanity"})
	public void beforeClass() throws Exception {
		
		hrmLogin=new OrangeHRMLogin();

		System.out.println("This is a before class method");
		
		  propertyHandling=new PropertyHandling();
	}
	
	@AfterClass(groups= {"sanity"})
	public void afterClass() {
		
		System.out.println("This is a after class method");
		  
	}

	
	
  @Test (priority=0, groups= {"sanity"})
  public void launchBrowser() {	  
		System.out.println("This is a launch berowser method");
		
	  driver.navigate().to(propertyHandling.getProperty("orangeHRMUrl"));
	  
	  Assert.assertEquals("Unable to verify the title of orange hrm login page",
			  "OrangeHRM",
			  driver.getTitle());
	  
	  extentTest.log(Status.INFO, "Successfully able to land on login page");
	  
	  }
  
  @Test (priority=1, dependsOnMethods="launchBrowser",groups= {"sanity"})
  public void login() {
		System.out.println("This is a login method");

	  	driver.findElement(By.id("txtUsername")).sendKeys(propertyHandling.getProperty("organgeHRMUsername"));

		driver.findElement(By.id("txtPassword")).sendKeys(propertyHandling.getProperty("organgeHRMPassword"));

		driver.findElement(By.id("btnLogin")).click();
		
		  extentTest.log(Status.INFO, "Successfully able to click on login");
  
  }
  	  
  @Test (priority=2, dependsOnMethods={"login","launchBrowser"},groups= {"sanity"})
  public void logout() throws IOException {
	  
	 extentTest.log(Status.INFO, "Logut method initiated"); 
	  
		try {
	  	driver.findElement(By.id("welcome")).click();
		
		waitElementToBeVisible(driver.findElement(By.id("welcome-menu")));
		
		driver.findElement(By.xpath("//div[@id=\"welcome-menu\"]/descendant::a[4]")).click();
		
		Assert.assertTrue("Failed to logout from application :",driver.findElement(By.id("btnLogin")).isDisplayed());

		}catch(Exception e) {
				e.printStackTrace();
				 extentTest.log(Status.FAIL, "unable to logout from application because : "+e ); 
		}
  }
}
