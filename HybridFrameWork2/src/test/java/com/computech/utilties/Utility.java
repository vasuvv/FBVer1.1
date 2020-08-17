package com.computech.utilties;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Utility {

	public static void getScreenshot(WebDriver driver) {
		String path=System.getProperty("user.dir"+"/Screenshots/OrangeHRM_"+getCurrentDateAndTime()+".png");
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		try {
			FileHandler.copy(src, new File(path));
		} catch (IOException e) {
			System.out.println("Failed to capture the screenshot..");
		}
	}

	public static String getCurrentDateAndTime() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
		Date d = new Date();
		return dateFormat.format(d);
//		String dateStamp =dateFormat.format(d);
//		return dateStamp;
	}
	public static void waitTo(int time)
	{
		try {
			Thread.sleep(time * 1000);
		} catch (InterruptedException e) {
			System.out.println(e.getMessage());
		}
	}
	public static WebElement waitForWebElement(WebDriver driver, By byLocator) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
	
		WebElement element= wait.until(ExpectedConditions.elementToBeClickable(byLocator));
		highLightElement(driver, element);
		return element;
	}
	public static WebElement waitForWebElement(WebDriver driver, By byLocator, int time) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
	
		WebElement element= wait.until(ExpectedConditions.elementToBeClickable(byLocator));
		highLightElement(driver, element);
		return element;
	}
	public static WebElement waitForWebElement(WebDriver driver, By byLocator, int time, WebElement webElement) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
	
		WebElement element= wait.until(ExpectedConditions.elementToBeClickable(webElement));
		highLightElement(driver, element);
		return element;
	}
	public static void highLightElement(WebDriver driver, WebElement element)
	{
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element);
		
		/*try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			
		}*/
		waitTo(1);
		
		js.executeScript("arguments[0].setAttribute('style','border: solid 2px white');", element); 

	}
	public static void acceptAlert(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.alertIsPresent()).accept();
	}

	public static void dismissAlert(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.alertIsPresent()).dismiss();
	}

	public static void verifyAlertText(WebDriver driver, String expectedText) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		String alertTextActual=wait.until(ExpectedConditions.alertIsPresent()).getText();
		Assert.assertEquals(alertTextActual, expectedText);
	}

	public static void verifyTitle(WebDriver driver, String title) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		Assert.assertTrue(wait.until(ExpectedConditions.titleIs(title)));
	}

	public static void verifyURL(WebDriver driver, String url) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		Assert.assertTrue(wait.until(ExpectedConditions.urlToBe(url)));
	}
	
	public static void handleFrameUsingID() {

	}

	public static void handleFrameUsingName() {

	}

	public static void handleFrameUsingIndexNo() {

	}

	public static void handleFrameUsingElement() {

	}
}
