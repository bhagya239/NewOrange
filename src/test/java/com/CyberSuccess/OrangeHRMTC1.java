package com.CyberSuccess;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class OrangeHRMTC1 extends baseClass {

	public static void main(String[] args) throws Exception {

		OrangeHRMTC1 obj = new OrangeHRMTC1();

		driver = obj.getBrowserInstance("Chrome");

		driver.get("https://opensource-demo.orangehrmlive.com/");
		
		System.out.println(driver.getTitle());

		driver.findElement(By.id("txtUsername")).sendKeys("Admin");

		driver.findElement(By.id("txtPassword")).sendKeys("admin123");

		driver.findElement(By.id("btnLogin")).click();

		driver.findElement(By.id("menu_pim_viewPimModule")).click();

		boolean employeeName = driver.findElement(By.id("empsearch_employee_name_empName")).isDisplayed();

		if (employeeName) {

			WebElement JobTitle = driver.findElement(By.id("empsearch_job_title"));

			Select select = new Select(JobTitle);

			List<WebElement> listOfJobTitle = select.getOptions();

			List<String> listOfJob = new ArrayList<>();

			for (WebElement element : listOfJobTitle) {

				listOfJob.add(element.getText());

			}
			System.out.println(listOfJob);

			if (listOfJob.contains("QA Lead")) {
				System.out.println("Successfully able to validate the QA Lead valyue in the list!");
			} else {
				throw new Exception("QA Lead value not present in the JobTitle dropdown !");

			}

		} else {
			throw new Exception("Failed to land on Employee List page !");
		}

	}

}
