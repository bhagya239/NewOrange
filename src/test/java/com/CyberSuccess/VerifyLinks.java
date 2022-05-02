package com.CyberSuccess;

import java.util.List;
import java.util.Objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class VerifyLinks extends baseClass{

	public static void main(String[] args) {
		
		VerifyLinks obj=new VerifyLinks();
		
		driver = obj.getBrowserInstance("Chrome");

		driver.get("https://opensource-demo.orangehrmlive.com/");
		
		driver.get("https://opensource-demo.orangehrmlive.com/");

		driver.findElement(By.id("txtUsername")).sendKeys("Admin");

		driver.findElement(By.id("txtPassword")).sendKeys("admin123");

		driver.findElement(By.id("btnLogin")).click();

		driver.findElement(By.id("menu_pim_viewPimModule")).click();

		List<WebElement> links=driver.findElements(By.tagName("a"));
		
		for(WebElement element:links) {
			
			String url=element.getAttribute("href");
											
			if(Objects.nonNull(url) && url.startsWith("https") ){
				
				System.out.println(url);

				
			}
		}
		

	}

}
