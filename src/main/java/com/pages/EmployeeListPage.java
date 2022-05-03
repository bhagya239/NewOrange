package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EmployeeListPage {
	
	//PIM Module
//		public By pimModule=By.id("menu_admin_viewAdminModule");
	
	// EmployeeList Module 
			public By employeeListMenu=By.id("menu_pim_viewEmployeeList"); 

	//Search Buttom
			
			public By searchButton=By.id("searchBtn");
			
	//Reset Button
			
			public By resetButton=By.id("resetBtn");
			
	//Employee Name Text Box
			
			public By emplNameTextBox=By.id("empsearch_employee_name_empName");
			
			
			@FindBy(id="menu_admin_viewAdminModule")
			public WebElement pimModule;
			
			public By supName=By.id("empsearch_supervisor_name");
}
