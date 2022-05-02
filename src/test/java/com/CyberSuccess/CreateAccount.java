/*
 * package com.CyberSuccess;
 * 
 * import java.time.Duration; import java.util.concurrent.TimeUnit; import
 * java.util.function.Function;
 * 
 * import org.openqa.selenium.By; import org.openqa.selenium.WebDriver; import
 * org.openqa.selenium.WebElement; import
 * org.openqa.selenium.support.ui.ExpectedConditions; import
 * org.openqa.selenium.support.ui.FluentWait; import
 * org.openqa.selenium.support.ui.Wait; import
 * org.openqa.selenium.support.ui.WebDriverWait;
 * 
 * public class CreateAccount extends baseClass {
 * 
 * @SuppressWarnings("deprecation") public static void main(String[] args)
 * throws Exception {
 * 
 * CreateAccount obj = new CreateAccount(); driver =
 * obj.getBrowserInstance("Chrome");
 * 
 * driver.get("http://automationpractice.com/");
 * 
 * driver.findElement(By.className("login")).click();
 * 
 * driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
 * 
 * // WebDriverWait wait=new WebDriverWait(driver,10);
 * 
 * // String expectedEmailId = obj.generateRandomString(5) + "@yopmail.com";
 * 
 * WebElement emailAddress=driver.findElement(By.id("email_create"));
 * 
 * // emailAddress.sendKeys(expectedEmailId);
 * 
 * WebElement emailTextBox=driver.findElement(By.
 * xpath("//p[contains(text(),'Please enter your email')]/following::li[1]"));
 * 
 * // wait.until(ExpectedConditions.visibilityOf(emailTextBox));
 * 
 * // expectedEmailId=obj.generateRandomString(5) + "@yopmail.com";
 * 
 * emailAddress.clear();
 * 
 * emailAddress.sendKeys(expectedEmailId);
 * 
 * 
 * driver.findElement(By.xpath("//button[@id='SubmitCreate']/descendant::i")).
 * click();
 * 
 * 
 * 
 * 
 * 
 * // wait.until(ExpectedConditions.elementToBeClickable(emailTextBox));
 * WebElement element =
 * driver.findElement(By.cssSelector("input#customer_firstname"));
 * 
 * 
 * obj.fluentWait(driver, element);
 * 
 * 
 * if (element.isDisplayed()) {
 * 
 * driver.findElement(By.id("id_gender1")).click();
 * 
 * 
 * driver.findElement(By.id("customer_firstname")).sendKeys(obj.
 * generateRandomString(5));
 * 
 * driver.findElement(By.id("customer_lastname")).sendKeys(obj.
 * generateRandomString(5));
 * 
 * 
 * String actualEmailId =
 * driver.findElement(By.name("email")).getAttribute("value");
 * 
 * 
 * if(expectedEmailId.equals(actualEmailId)) {
 * 
 * System.out.println("Successfully validated emaild"); } else { throw new
 * Exception("Failed to verify emaild Id ! and the actual is : "+
 * actualEmailId); }
 * 
 * // emailId.equals("test123456789@yopmail.com")?System.out.println(""):throw
 * new Exception("Failed to create account!");
 * 
 * // driver.findElement(By.id("passwd")).sendKeys(obj.generateRandomString(5));
 * 
 * WebElement daysDropdown=driver.findElement(By.id("days"));
 * 
 * obj.selectValueFromDropdown(daysDropdown, 10, null, null);
 * 
 * obj.selectValueFromDropdown(driver.findElement(By.id("months")), -1, "3",
 * null);
 * 
 * obj.selectValueFromDropdown(driver.findElement(By.id("years")), -1, null,
 * "2020 ");
 * 
 * obj.deselectValueFromDropdown(daysDropdown, -1, null, null);
 * 
 * } else { throw new Exception("Failed to create account!");
 * 
 * }
 * 
 * }
 * 
 * }
 */