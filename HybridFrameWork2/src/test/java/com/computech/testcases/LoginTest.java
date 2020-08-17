package com.computech.testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.computech.factory.BrowserFactory;
import com.computech.factory.ConfigProvider;
import com.computech.pages.LoginPage;

public class LoginTest extends BaseClass{
	LoginPage lp;
	
	
	@Test
	public void login() {
		lp=PageFactory.initElements(driver, LoginPage.class);
		lp.loginToApplication();
	}
	
}
