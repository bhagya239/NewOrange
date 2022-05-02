package com.CyberSuccess;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.List;
import java.util.Objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Amazon extends baseClass{

	public static void main(String[] args) throws MalformedURLException, IOException {
		
		Amazon obj=new Amazon();
		
		driver=obj.getBrowserInstance("Chrome");
		
		driver.get("https:\\amazon.in");
		
		List<WebElement> links=driver.findElements(By.tagName("a"));
		
		for(WebElement element: links) {
			
			
			String url=element.getAttribute("href");
			
			if(Objects.nonNull(url) && url.startsWith("http")) {
				
				
//				URL link=new URL(url);
				
				HttpURLConnection	urI=(HttpURLConnection)new URL(url).openConnection();
				
				urI.connect();
				
				int statusCode=urI.getResponseCode();
				
				if(statusCode!=200) {
					
					System.out.println("Status Code :"+ statusCode +"URL :"+url);

				}
				

			}
			
		}
		

	}

}
