package RegressionTests;

import org.testng.annotations.Test;
import com.CyberSuccess.Util;
import com.CyberSuccess.baseClass;
import com.pages.EmployeeListPage;
import com.pages.UserMgmtPage;
import junit.framework.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;

public class VerifyUserSearchInAdmin extends baseClass{
	
	Util util;
	UserMgmtPage userMgmt;
	EmployeeListPage empListPage;
	
	@BeforeTest
	@Parameters({"browser"})
	public void beforeTest(String browser) {
		
		 driver=getBrowserInstance(browser);

		
	}

  @Test
  public void loginToOrangeHRM() {
	  
	  driver.navigate().to(util.propertyHandling.getProperty("orangeHRMUrl"));
	  String username=util.propertyHandling.getProperty("organgeHRMUsername");
	  String password=util.propertyHandling.getProperty("organgeHRMPassword");
	  
	  util.orangeHrmLogin(username, password);
	  
  }
  @Test
  public void verifyUserSearch() {
	  
	  driver.findElement(userMgmt.adminModule).click();
	  
	  driver.findElement(userMgmt.systemUserTxtBox).sendKeys(util.propertyHandling.getProperty("organgeHRMUsername"));
	  
	  driver.findElement(empListPage.searchButton).click();
	  
	  Assert.assertTrue("Failed to login to application :",driver.findElement(By.id("welcome")).isDisplayed());
	  
  }
  
  
  @BeforeClass
  public void beforeClass() throws Exception {
	  
	  util=new Util();
	  userMgmt= new UserMgmtPage();
	  empListPage= new EmployeeListPage();
	  
  }

  @AfterClass
  public void afterClass() {
  }

}
