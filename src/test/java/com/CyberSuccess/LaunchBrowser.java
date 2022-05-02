package com.CyberSuccess;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LaunchBrowser extends baseClass{

	public static void main(String[] args) throws InterruptedException {
		
		LaunchBrowser obj=new LaunchBrowser();
		
		driver=obj.getBrowserInstance("Chrome");

		
		System.out.println("Successfully Launched Chrome Browser");
		
		driver.get("https://www.snapdeal.com/");
				
		System.out.println(driver.getTitle().equals("Shop Online for Men, Women & Kids Clothing, Shoes, Home Decor Items"));

		driver.findElement(By.linkText("Gift Cards")).click();
		
		System.out.println(driver.getTitle().equals("Digital Entertainment: Buy Digital Movies, Books, Magazines, OGLE & more Online on Snapdeal"));
		
		Thread.sleep(1000);
			
		String text=driver.findElement(By.xpath("//h1[contains(text(),\"Digital Entertainment\")]")).getText();
		
		System.out.println(text.equals("Digital Entertainment"));
		
		driver.close();
	}

}
