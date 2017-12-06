package com.pch.test;

import static org.junit.Assert.*;
import org.junit.Test;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.By.ById;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverTest {
	
	WebDriver driver;

	@Before
	public void setUp() {
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\Pooja.Kasture\\workspace\\DomAndTom\\thirdparty\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	
	
	/**
	 * Test to navigate Yahoo page
	 * 
	 * Starting point will be the yahoo.com
	 * 
	 * *** You may want to do a manual test at first to gather the needed
	 * element locators needed for the test ****** Run Thru The Debugger
	 * 
	 * https://www.yahoo.com
	 * 
	 * Follow Steps below
	 * 
	 */
		
	@Test
	public void funWithYahooPage() {
		
		driver.get("https://www.yahoo.com/");
		driver.manage().window().maximize();
		
		
		// Step 1. Assert that we are on the correct page by checking that title = 'Yahoo' 
		String expectedTitle = "Yahoo";
		String actualTitle = driver.findElement(By.cssSelector("title")).getText();
		assert(actualTitle).equals(expectedTitle);
		
		
		 /* Step 2. Display the count of options on the left side panel ('Mail', 'News', 'Sports',......) */
		 /* including 'More Yahoo Sites' option */
	 	 
		WebElement expectedUlElement = driver.findElement(By.tagName("ul"));
		List<WebElement> expectedNavItemsList = expectedUlElement.findElements(By.tagName("li"));
		System.out.println("Count of options on the left side panel: " + expectedNavItemsList.size());
				
			
		// Step 3: Enter 'Nutrition' on the search bar on the top
		driver.findElement(By.id("uh-search-box")).sendKeys("Nutrition");
				
		// Step 4: Click Search button
		driver.findElement(By.id("uh-search-button")).click();

		// Step 5: Display count of Images on the page
		List<WebElement> expectedImagesList = driver.findElements(By.tagName("img"));
		System.out.println("Number of images on the page: "+ expectedImagesList.size());
		
		// Step 6. Click 'Sign In' button on the top left side
		driver.findElement(By.id("yucs-login_signIn")).click();
				
		// Step 7. Display the boolean state of the checkbox next to 'Keep me signed in'
		WebElement expectedCheckbox = driver.findElement(By.id("persistent"));
		boolean expectedCheckedStatus = expectedCheckbox.isSelected();
		System.out.println("Boolean state of checkbox : "+ expectedCheckedStatus);
		
		// Step 8. Click 'Sign In' button  
		
		driver.findElement(By.id("login-signin")).click();
		 
		
		 /* Step 9. Error will be displayed. */
		 /* Assert true when the error message contains the expectedErrorStr defined below */
		 
		String expectedErrorStr = "Sorry, we don't recognize this email.";
		String actualErrorStr =	driver.findElement(By.id("username-error")).getText();
		assert(actualErrorStr).equals(expectedErrorStr);
	}
	
	private void assertTrue(Object click) {
		// TODO Auto-generated method stub
		
	}

	private WebElement findElement(By id) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Test to simulate an attempted Sign in to Paypal and validate error
	 * message returned
	 * 
	 * Starting point will be the PayPal
	 * 
	 * *** You may want to do a manual test at first to gather the needed
	 * element locators needed for the test ****** Run Thru The Debugger
	 * 
	 * https://www.paypal.com
	 * 
	 * Follow Steps below
	 * 
	 */
		
	@Test
	public void funWithPayPalSignUpPage() {
		
		driver.get("https://www.paypal.com");
		
		/*
		 * Step 1. Assert that we are on the correct page by checking that title = 'Send Money, Pay Online or Set Up
		 * a Merchant Account - PayPal'  
		 */ 
		String expectedTitle = "Send Money, Pay Online or Set Up a Merchant Account - PayPal";
		String actualTitle = driver.findElement(By.tagName("title")).getText();
		assert(actualTitle).equals(expectedTitle);

		// Step 2. Click 'Sign Up for Free' button
		 driver.findElement(By.className("round-icon")).click();
		 driver.findElement(By.xpath("//*[@id='left-hero']/div/div/div[3]/a")).click();
		
		// Step 3: Enter email address test@google.com 
	 	driver.findElement(By.id("paypalAccountData_firstName")).sendKeys("test");
	 	driver.findElement(By.id("paypalAccountData_lastName")).sendKeys("Test");
	 	driver.findElement(By.id("paypalAccountData_email")).sendKeys("test@google.com");
		 	
		 
		
		// Step 4: Enter password test1234 
	 	driver.findElement(By.id("paypalAccountData_password")).sendKeys("test1234");
        
		// Step 5: Enter confirm password test1234
	 	driver.findElement(By.id("paypalAccountData_confirmPassword")).sendKeys("test1234");
		 	
		// Step 6: Click 'Continue' button  
	 	driver.findElement(By.id("/appData/action")).click();
		 		
        
		/*
		 * Step 7. Error will be displayed		
		 * Assert True that error message contains the expectedErrorStr defined below
 		 */
	 	String expectedErrorStr = "It looks like you already signed up."; 	
	 	
	 	String actualErrorStr =	driver.findElement(By.xpath("//*[@id='PageMainForm']/div[2]/div[3]/div/div/div[2]")).getText();
		assert(actualErrorStr).equals(expectedErrorStr);
		 	
		// Step 8. Print out the boolean state of the 'confirmPassword' input field displayed
		
		// Step 9. Display the count of Images on the Sign In page
		
		List<WebElement> expectedImagesList = driver.findElements(By.tagName("img"));
		System.out.println("Number of images on the page: "+ expectedImagesList.size());
			
		// Step 10. Display the country flag shown on the bottom right side
		assert(driver.findElement(By.className("country US"))).isDisplayed();
	}


	@After
	public void tearDown() {
		driver.quit();
	}	
}
