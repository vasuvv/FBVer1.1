package com.computech.testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.computech.factory.DataProviderFactory;
import com.computech.pages.LoginPage;

public class LoginTestDDT extends BaseClass{
	
	LoginPage lp;
	/*
	@BeforeClass
	public void setUp() {
		ConfigProvider config = new ConfigProvider();
		driver =BrowserFactory.getApplication(config.getBrowser(), config.getStagingURL());
	}*/
	
	
//	driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
	@Test
	public void login() {
		lp=PageFactory.initElements(driver, LoginPage.class);
		lp.loginToApplication(DataProviderFactory.getExcel().getStringData("LoginTest", 0, 0), 
							DataProviderFactory.getExcel().getStringData("LoginTest", 0, 0));
	}
	/*@Test
	public void login() {
		lp=PageFactory.initElements(driver, LoginPage.class);
		ExcelReader excel = new ExcelReader();
		lp.loginToApplication(excel.getStringData("LoginTest", 0, 0), 
							excel.getStringData("LoginTest", 0, 0));
	}*/
	
}
