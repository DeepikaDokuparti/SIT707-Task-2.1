package sit707_week2;

import org.openqa.selenium.By;
import java.io.File;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;


/**
 * This class demonstrates Selenium locator APIs to identify HTML elements.
 * 
 * Details in Selenium documentation https://www.selenium.dev/documentation/webdriver/elements/locators/
 * 
 * @author Ahsan Habib
 */
public class SeleniumOperations2 {

	public static void sleep(int sec) {
		try {
			Thread.sleep(sec*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public static void pinterest_signup_page(String url) {
		// Step 1: Locate chrome driver folder in the local drive.
		System.setProperty("webdriver.chrome.driver", "C:/Users/Deepika Dokuparti/Downloads/chromedriver-win64/chromedriver.exe");
		
		// Step 2: Use above chrome driver to open up a chromium browser.
		System.out.println("Fire up chrome browser.");
		WebDriver driver = new ChromeDriver();
		
		System.out.println("Driver info: " + driver);
		
		sleep(2);
	
		// Load a webpage in chromium browser.
		driver.get(url);
		
		/*
		 * How to identify a HTML input field -
		 * Step 1: Inspect the webpage, 
		 * Step 2: locate the input field, 
		 * Step 3: Find out how to identify it, by id/name/...
		 */
		
		// Find first input field which is firstname
		WebElement element = driver.findElement(By.id("firstname"));
		System.out.println("Found element: " + element);
		// Send first name
		element.sendKeys("Deepika");
		
		/*
		 * Find following input fields and populate with values
		 */
		 WebElement usernameInput = driver.findElement(By.id("username"));
		 WebElement passwordInput = driver.findElement(By.id("password"));
		 usernameInput.sendKeys("url_Deepika");
		 passwordInput.sendKeys("url_password");
		
		
		/*
		 * Identify button 'Create account' and click to submit using Selenium API.
		 */
		 WebElement createAccountButton = driver.findElement(By.id("create_account-btn"));
		 createAccountButton.click();
		
		/*
		 * Take screenshot using selenium API.
		 */
		 TakesScreenshot screenshotDriver = (TakesScreenshot) driver;
         File screenshotFile = screenshotDriver.getScreenshotAs(OutputType.FILE);
		 try {
			 FileUtils.copyFile(screenshotFile, new File("screenshot.png"));
		 } catch (Exception e) {
			 e.printStackTrace();
		 }
		
		
		// Sleep a while
		sleep(2);
		
		// close chrome driver
		driver.close();	
	}
	
	
}
