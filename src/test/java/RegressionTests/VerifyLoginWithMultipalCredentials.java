package RegressionTests;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.CyberSuccess.ExcelUtil;
import com.CyberSuccess.PropertyHandling;
import com.CyberSuccess.Util;
import com.CyberSuccess.baseClass;


public class VerifyLoginWithMultipalCredentials  extends baseClass{
	
	ExcelUtil excelUtil;
	Util util;
	VerifyLoginWithMultipalCredentials verifyLogin;
	
	@BeforeClass
	public void beforeClass() throws Exception {
		
		excelUtil=new ExcelUtil();
		
		verifyLogin=new VerifyLoginWithMultipalCredentials();
			
		util=new Util();
		  
		driver=baseClass.getBrowserInstance("Chrome");
	}
	
	@Test(enabled=true)
	public void launchBrowser() {
		
		driver.navigate().to(util.propertyHandling.getProperty("orangeHRMUrl"));
	}

  @Test(dataProvider="data")
  public void login(Object username,Object password) throws IOException {
	  
	  System.out.println("Username: "+ username + " Password: "+password);
	  
	  util.orangeHrmLogin(username.toString(), password.toString());
	  
	  System.out.println("login method sucessfully");
	  
  }
  
  @DataProvider(name="data")
  public Object[][] dataProvide() throws IOException {
	  
	 
	  return new Object[][] {
		  
		  {"username1","password1"},
		  {"username2","password2"},
		  
	  };
  }
  
}
