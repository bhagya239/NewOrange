package com.CyberSuccess;

import org.openqa.selenium.By;
public class Util extends baseClass {

	public PropertyHandling propertyHandling;
		
	public Util() throws Exception{

		propertyHandling = new PropertyHandling();
		}

	public void orangeHrmLogin(String username, String password) {

		driver.findElement(By.id("txtUsername")).sendKeys(username);

		driver.findElement(By.id("txtPassword")).sendKeys(password);

		driver.findElement(By.id("btnLogin")).click();

	}

}
