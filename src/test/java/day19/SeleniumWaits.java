package day19;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumWaits {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.hyrtutorials.com/p/waits-demo.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); // wait for the element to be loaded
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5)); // wait for the page to be loaded
		
		// Wait for 5 seconds
		driver.findElement(By.id("btn1")).click();
		driver.findElement(By.id("txt1")).sendKeys("TestUser");
		
		// Wait for 10 seconds
		driver.findElement(By.id("btn2")).click();
		
		// WebDriverWait - Explicit wait
		
		// Step 1: Set the time Duration
		
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//		
//		// Step 2: Set the condition
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("txt2")));
//		
//		// Step 3: Perform your action
//		driver.findElement(By.id("txt2")).sendKeys("TextUser");
		
		// Fluent wait
		
		// Set the time duration
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(15))
				.pollingEvery(Duration.ofMillis(100))
				.withMessage("Increase the time");
		
		// Set the condition
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("txt2")));
		
		// Perform action
		driver.findElement(By.id("txt2")).sendKeys("TextUser");
		
		
		
		
	}

}
