package com.CyberSuccess;

import java.util.Set;
import java.util.stream.Collectors;

import org.openqa.selenium.By;

public class WindowsHandling extends baseClass{

	public static void main(String[] args) {
		
		WindowsHandling obj=new WindowsHandling();
		
		driver=obj.getBrowserInstance("Chrome");
		
		driver.get("https://www.redbus.com/");
		
		driver.manage().window().maximize();
		
		driver.manage().window().minimize();
		
		String homePageTitle=driver.getTitle();
		
		//get id of parent window
		String parentWindow=driver.getWindowHandle();
		
		driver.findElement(By.xpath("//a[@href='/info/redcare']")).click();
		
		//get list of all opened windows
		Set<String> windows=driver.getWindowHandles();
		
//		windows.stream()
//		.filter(val->!val.equals(parentWindow))
//		.map(val-> driver.switchTo().window(val));
//		
		System.out.println("Title of child window: "+driver.getTitle());

		
		//iterate the list of windows id and switch to child window
		/*
		 * windows.forEach(id->{ if(!id.equals(parentWindow)) {
		 * 
		 * String childWindowId=id;
		 * 
		 * driver.switchTo().window(childWindowId);
		 * 
		 * System.out.println("control is on child window");
		 * 
		 * System.out.println("Title of child window: "+driver.getTitle());
		 * 
		 * driver.close(); } });
		 */
		
		//iterate the list of windows id and switch to child window
		/*
		 * for(String windowId:windows) {
		 * 
		 * if(!windowId.equals(parentWindow)) {
		 * 
		 * String childWindowId=windowId;
		 * 
		 * driver.switchTo().window(childWindowId);
		 * 
		 * System.out.println("control is on child window");
		 * 
		 * System.out.println("Title of child window: "+driver.getTitle());
		 * 
		 * driver.close(); } }
		 */
		//command to switch to parent window
		driver.switchTo().window(parentWindow);
		
		System.out.println("Title of parent window: "+driver.getTitle());
		
		driver.quit();	

	}

}
