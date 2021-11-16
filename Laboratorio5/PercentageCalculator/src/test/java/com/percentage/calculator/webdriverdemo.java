package com.percentage.calculator;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class webdriverdemo {

	private WebDriver driver;
	
	@Before
	public void setUp(){
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.calculator.net");
		driver.manage().window().maximize();			 
	}
	
	@Test
	public void testGooglePage1() {
		// Verifica el titulo de la pagina
		Boolean verifyTitle = driver.getTitle().equalsIgnoreCase("Calculator.net: Free Online Calculators - Math, Fitness, Finance, Science");
		assertNotNull(verifyTitle);
		assertTrue(verifyTitle);		
	}
	
	@Test
	public void testGooglePage2() {
		  driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		  // Case 1
		  // Click on Math Calculators
	      driver.findElement(By.xpath("//*[@id=\"contentout\"]/table/tbody/tr/td[3]/div[2]/a")).click();
	      // Click on Percent Calculators
	      driver.findElement(By.xpath("//*[@id=\"content\"]/table[2]/tbody/tr/td/div[3]/a")).click();
	      // Enter value 10 in the first number of the percent Calculator
	      driver.findElement(By.id("cpar1")).sendKeys("10");
	      // Enter value 1000 in the second number of the percent Calculator
	      driver.findElement(By.id("cpar2")).sendKeys("1000");	      
	      // Click Calculate Button
	      driver.findElement(By.xpath(".//*[@id = 'content']/table/tbody/tr[2]/td/input[2]")).click();	      
	      // Get the Result Text based on its xpath
	      String result1 =
	         driver.findElement(By.xpath(".//*[@id = 'content']/p[2]/font/b")).getText();
	      // Verifica el resultado     
	      String ExpectedResult = "100";
	      Assert.assertEquals(ExpectedResult, result1);
	      // Print a Log In message to the screen
	      //System.out.println(" The Result is " + result1);	      
	}
	
	@Test
	public void testGooglePage3() {
		  driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		  // Case 2
		  // Click on Math Calculators
	      driver.findElement(By.xpath("//*[@id=\"contentout\"]/table/tbody/tr/td[3]/div[2]/a")).click();
	      // Click on Percent Calculators
	      driver.findElement(By.xpath("//*[@id=\"content\"]/table[2]/tbody/tr/td/div[3]/a")).click();
	      // Enter value 20 in the first number of the percent Calculator
	      driver.findElement(By.id("cpar1")).sendKeys("20");
	      // Enter value 1000 in the second number of the percent Calculator
	      driver.findElement(By.id("cpar2")).sendKeys("1000");	      
	      // Click Calculate Button
	      driver.findElement(By.xpath(".//*[@id = 'content']/table/tbody/tr[2]/td/input[2]")).click();	      
	      // Get the Result Text based on its xpath
	      String result1 =
	         driver.findElement(By.xpath(".//*[@id = 'content']/p[2]/font/b")).getText();
	      // Verifica el resultado 
	      String ExpectedResult = "100";
	      Assert.assertEquals(ExpectedResult, result1);
	      // Print a Log In message to the screen
	      //System.out.println(" The Result is " + result1);	      
	}
		
	
	@After
	public void tearDown() {
		driver.quit();
	}
}