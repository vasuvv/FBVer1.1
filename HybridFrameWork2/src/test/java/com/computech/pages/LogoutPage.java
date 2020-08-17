package com.computech.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.computech.utilties.Utility;

public class LogoutPage {
	
	WebDriver driver;
	public LogoutPage(WebDriver driver) {
		this.driver=driver;
	}
	
	By welcomeLink = By.xpath("//a[text()='Welcome Admin'] ");
	By loutLink= By.xpath("//a[text()='Logout']");
	
	public void logoutFromApplication() {
		Utility.waitForWebElement(driver, welcomeLink).click();
		Utility.waitTo(2);
		Utility.waitForWebElement(driver, loutLink).click();
	}
	/*
	 public void logoutFromApplication() {
		driver.findElement(welcomeLink).click();
		driver.findElement(loutLink).click();
	}
	 */

}
