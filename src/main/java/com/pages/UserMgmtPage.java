package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserMgmtPage {
	
//	public By adminModule=By.id("menu_admin_viewAdminModule");
	
//	public By userMgmtModule= By.id("menu_admin_UserManagement");
	
	public By systemUserTxtBox= By.id("searchSystemUser_userName");
	
	@FindBy(id="menu_admin_viewAdminModule")
	public WebElement adminModule;
	
	@FindBy(id="menu_admin_UserManagement")
	public WebElement userMgmtModule;

}
