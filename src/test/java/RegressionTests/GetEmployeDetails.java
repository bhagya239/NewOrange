package RegressionTests;

import java.io.FileNotFoundException;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.CyberSuccess.ExcelUtil;
import com.CyberSuccess.Util;
import com.CyberSuccess.baseClass;

import junit.framework.Assert;

public class GetEmployeDetails extends baseClass {

	Util util;
	ExcelUtil excelUtil;

	@BeforeTest
	@Parameters({ "browser" })
	public void beforeTest(String browser) {

		driver = getBrowserInstance(browser);

	}

	@BeforeClass
	public void beforeClass() throws Exception {

		util = new Util();
		excelUtil = new ExcelUtil();

		driver.navigate().to(util.propertyHandling.getProperty("orangeHRMUrl"));

	}

	@Test
	public void login() {

		String username = util.propertyHandling.getProperty("organgeHRMUsername");

		String password = util.propertyHandling.getProperty("organgeHRMPassword");

		util.orangeHrmLogin(username, password);

	}

	@Test
	public void verifyEmpList() throws FileNotFoundException {

		driver.findElement(By.id("menu_pim_viewPimModule")).click();

		Assert.assertTrue("Unable to navigate on Employee List module: ",
				driver.findElement(By.id("searchBtn")).isDisplayed());

		List<WebElement> headers = driver.findElements(By.xpath("//table[@id='resultTable']/descendant::th/a"));

//	  headers.forEach(val-> System.out.println(val.getText()));

		String filePath = util.propertyHandling.getProperty("inputExcelFilePath");

		for (int i = 0; i < headers.size(); i++) {

			try {

				excelUtil.writeDataInExcel(filePath, 0, i, headers.get(i).getText());

			} catch (FileNotFoundException e) {

				e.printStackTrace();
			}

		}
		setEmplDetailsInSheet(filePath, headers.size());

	}

	public void setEmplDetailsInSheet(String filePath, int colSize) throws FileNotFoundException {

		int rowSize = driver.findElements(By.xpath("//table[@id='resultTable']/tbody/descendant::tr")).size();

		for (int i = 2; i <= rowSize; i++) {

			for (int j = 2; j <= colSize; j++) {

				try {
					
					WebElement element= driver.findElement(By.xpath("//table[@id='resultTable']/descendant::tr[" + i + "]/td[" + j + "]/a"));
					
					excelUtil.writeDataInExcel(filePath, i, j, element.getText());
					
				}catch(NoSuchElementException | FileNotFoundException  |NullPointerException  e) {
					
					excelUtil.writeDataInExcel(filePath, i, j, StringUtils.EMPTY);
				}
				
			}

		}

	}

}
