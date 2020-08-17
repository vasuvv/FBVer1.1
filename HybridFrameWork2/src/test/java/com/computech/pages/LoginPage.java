package com.computech.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.computech.utilties.Utility;

public class LoginPage {

	WebDriver driver;
	public LoginPage(WebDriver driver) {
		this.driver=driver;
	}
	
	//@FindBy(how = How.ID, using ="txtUsername") WebElement userName;
	//@FindBy(id="txtUsername") WebElement userName;
	/*@FindBy(how = How.ID, using ="txtUsername")
	@CacheLookup
	WebElement userName;*/
	By userName=By.id("txtUsername");
	By passWord=By.name("txtPassword");
	By loginButton=By.xpath("//input[@value='LOGIN']");
	public void typeUsername() {
		driver.findElement(userName).sendKeys("Admin");
	}
	public void typePassword() {
		driver.findElement(passWord).sendKeys("admin123");
	}
	public void clickOnLoginButton() {
		driver.findElement(loginButton).click();
	}
	
	public void loginToApplication() {
		Utility.waitForWebElement(driver, userName).sendKeys("Admin");
		Utility.waitForWebElement(driver, passWord).sendKeys("admin123");
		Utility.waitForWebElement(driver, loginButton).click();
		/*
		 * driver.findElement(userName).sendKeys("Admin");
		 * driver.findElement(passWord).sendKeys("admin123");
		 * driver.findElement(loginButton).click();
		 */
	}
	public void loginToApplication(String user, String pwd) {
		driver.findElement(userName).sendKeys(user);
		driver.findElement(passWord).sendKeys(pwd);
		driver.findElement(loginButton).click();
	}
}
