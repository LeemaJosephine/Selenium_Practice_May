package day15;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumLocators {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		// driver.get("https://www.demoblaze.com/");
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20)); // This is a selenium wait that helps you to wait for all the elements upto 20 secs
		
		// By ID
//		WebElement signup = driver.findElement(By.id("signin2"));
//		signup.click();
//		
//		driver.findElement(By.id("sign-username")).sendKeys("testuserpass");
//		
//		driver.findElement(By.id("sign-password")).sendKeys("testuserpass");
		
		// By Tagname
		String text = driver.findElement(By.tagName("h5")).getText();
		
		if(text.equalsIgnoreCase("Login")) {
			System.out.println("Element validated " + text);
		} else {
			System.out.println("Invalid element");
		}
		
		// By name
		WebElement username = driver.findElement(By.name("username"));
		username.sendKeys("Admin");
		
		WebElement password = driver.findElement(By.name("password"));
		password.sendKeys("admin123");
		
		// By class name - Don't use class name attribute if it has space in between the attribute value
		driver.findElement(By.className("oxd-button oxd-button--medium oxd-button--main orangehrm-login-button")).click();
		
		
	}

}
