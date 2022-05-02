package com.CyberSuccess;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Objects;
import java.util.function.Function;
import javax.annotation.Nonnull;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import io.github.bonigarcia.wdm.WebDriverManager;

public class baseClass {

	  public static WebDriver driver = null;
	 public WebDriverWait wait;
	 public static ExtentReports extentReports;
	 public static ExtentTest extentTest;
	
	 

//	public static Supplier<WebDriver> getDefaultBrowser= getDefaultBrowser() ;

	/*
	 * @SuppressWarnings("unchecked") public static Supplier<WebDriver>
	 * getDefaultBrowser() { System.setProperty("webdriver.chrome.driver",
	 * "C://CyberSuccess//Drivers//chromedriver.exe");
	 * 
	 * return (Supplier<WebDriver>) new ChromeDriver(); }
	 */
		
	public static WebDriver getBrowserInstance(String browserName) {

		switch (browserName) {

		
		case "Chrome":
			WebDriverManager.chromedriver().setup();
//			setCapabilitiesForChrome() 
			driver = new ChromeDriver();

			return driver;

		case "Mozila":
					
			WebDriverManager.firefoxdriver().setup();
			
//			System.setProperty("webdriver.gecko.driver", "C://CyberSuccess//Drivers//geckodriver.exe");

			driver = new FirefoxDriver( setCapabilitiesForMozila() );

			return driver;

		default:
			System.setProperty("webdriver.chrome.driver", "C://CyberSuccess//Drivers//chromedriver.exe");

			driver = new ChromeDriver();

			return driver;

		}

	}
	
public static ChromeOptions setCapabilitiesForChrome() {
		
		ChromeOptions profile=new ChromeOptions();
		
		profile.addArguments("start-maximized");
		
		profile.addArguments("--disable-notifications");
		
		profile.addArguments("incognito");
		
//		profile.addArguments("--headless");
		
//		profile.addExtensions(new File("C:\\Users\\danghar\\Downloads\\extension_2_0_2_0.crx"));
		
		profile.addArguments("--disable-extension");
		
		profile.addArguments("--disable-popup-blocking");
		
//		profile.addArguments("--auto-open-devtools-for-tabs");
		
		/*
		 * Map<String, Object> map=new HashMap<String,Object>();
		 * map.put("download.default_directory", "C://WS");
		 * 
		 * profile.setExperimentalOption("prefs", map);
		 */
		
		return profile;
		
	}
public static FirefoxOptions setCapabilitiesForMozila() {
	
	FirefoxOptions option=new FirefoxOptions();
	option.addArguments("start-maximized");
	
	option.addArguments("--disable-notifications");
	
	option.addArguments("--incognito");
	
//	profile.addArguments("--headless");
	
//	profile.addExtensions(new File("C:\\Users\\danghar\\Downloads\\extension_6_1_11_0.crx"));
	
	option.addArguments("--disable-extension");
	
	option.addArguments("--disable-popup-blocking");
	
	option.addArguments("--auto-open-devtools-for-tabs");
	
	return option;
	
}
	public void selectValueFromDropdown(@Nonnull WebElement element, int index, String value, String text) {

		Select select = new Select(element);

		if (index > 0) {

			select.selectByIndex(index);
		} else if (Objects.nonNull(value)) {
			select.selectByValue(value);
		} else if (Objects.nonNull(text)) {
			select.selectByVisibleText(text);
		}

	}

	public void deselectValueFromDropdown(@Nonnull WebElement element, int index, String value, String text) {
		Select select = new Select(element);

		if (index > 0) {

			select.deselectByIndex(index);
		} else if (Objects.nonNull(value)) {
			select.deselectByValue(value);
		} else if (Objects.nonNull(text)) {
			
			select.deselectByVisibleText(text);
		} else {
				select.deselectAll();
		}

	}

	/*
	 * public String generateRandomString(long length) {
	 * 
	 * int minValue = 70; int maxValue = 122;
	 * 
	 * Random random = new Random();
	 * 
	 * return random.ints(minValue, maxValue).limit(length)
	 * .collect(StringBuilder::new, StringBuilder::appendCodePoint,
	 * StringBuilder::append).toString(); }
	 */
	/*
	 * public String generateRandomEmailId(String domain) {
	 * 
	 * return generateRandomString(4) + "@" + domain + ".com"; }
	 */
	
	public void fluentWait(WebDriver driverInstace,final WebElement element) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driverInstace)
				.withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofSeconds(2))
				.ignoring(Exception.class);
		
		wait.until(new Function<WebDriver,WebElement>() {
			
			@Override
			public WebElement apply(WebDriver t) {
				return element;
			}
		});
		
	}
	
	public void click(WebElement element) {
		element.click();
	}
	
	public void waitElementToBeClickable(WebElement element) {
		wait=new WebDriverWait(driver,10);
	  	wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public void waitElementToBeVisible(WebElement element) {
		wait=new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOf(element));
		
	}
	
	public static String takeScreenShot(String methodName) throws IOException {
		
		String  filePath=System.getProperty("user.dir")+"\\CyberSuccess\\ScreenShots\\"+methodName+".png";
		TakesScreenshot screenShot=(TakesScreenshot)driver;
		
		File file=screenShot.getScreenshotAs(OutputType.FILE);
		
		FileUtils.copyFile(file, new File(filePath));
		
		return filePath;
		
	}

}
