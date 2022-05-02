package com.CyberSuccess;

import java.awt.AWTException;

import org.openqa.selenium.WebDriver;

public class RightClickOperation extends baseClass {
	/*
	 * static { Objects.requireNonNullElseGet(driver,baseClass.getDefaultBrowser); }
	 * 
	 */

	public static void main(String[] args) throws InterruptedException, AWTException {

		RightClickOperation obj = new RightClickOperation();

//		Objects.requireNonNullElse(driver, obj.getBrowserInstance("Chrome"));

		driver = obj.getBrowserInstance("Chrome");

		driver.navigate().to("https://www.amazon.in/");
	
		System.out.println(driver.getTitle());
		/*
		 * // driver.manage().window().maximize();
		 * 
		 * // driver.manage().window().minimize();
		 * 
		 * JavascriptExecutor js=(JavascriptExecutor)driver;
		 * 
		 * // js.executeScript("window.scrollBy(0,1800)");
		 * 
		 * // js.executeScript("arguments[0].click();",WebElement)
		 * 
		 * js.executeScript("confirm('This is sample alert!');");
		 * 
		 * WebDriverWait wait=new WebDriverWait(driver,10);
		 * 
		 * wait.until(ExpectedConditions.alertIsPresent());
		 * 
		 * 
		 * Alert alert=driver.switchTo().alert();
		 * 
		 * alert.accept(); //accept the alert displayed on webpage
		 * 
		 * alert.dismiss(); //dismiss the alert displayed on webpage
		 * 
		 * 
		 * Optional.ofNullable(ExpectedConditions.alertIsPresent().apply(driver)).
		 * ifPresent(Alert::accept);
		 * 
		 * 
		 * 
		 * // Objects.requireNonNullElseGet(null, null)
		 * 
		 * 
		 * 
		 * 
		 * action.contextClick(element) .build() .perform();
		 * 
		 * Robot rb=new Robot();
		 * 
		 * rb.keyPress(KeyEvent.VK_DOWN); rb.keyRelease(KeyEvent.VK_DOWN);
		 * rb.keyPress(KeyEvent.VK_ENTER); rb.keyRelease(KeyEvent.VK_ENTER);
		 * 
		 * rb.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		 * rb.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		 * 
		 * 
		 * // action.moveToElement(element).click().build().perform();
		 * 
		 * 
		 * // System.out.println(driver.getTitle());
		 * 
		 * 
		 * 
		 */
	}

}
