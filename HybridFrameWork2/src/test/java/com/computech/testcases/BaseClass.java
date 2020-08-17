package com.computech.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.computech.factory.BrowserFactory;
import com.computech.factory.DataProviderFactory;
import com.computech.utilties.Utility;

public class BaseClass {
	WebDriver driver;
	
	@BeforeClass
	public void setUp() {
		
		driver =BrowserFactory.getApplication(DataProviderFactory.getConfig().getBrowser(), 
												DataProviderFactory.getConfig().getStagingURL());
	}
	
	@AfterClass
	public void tearDown() {
		Utility.waitTo(3);
		BrowserFactory.closeApplication(driver);
	}
}
