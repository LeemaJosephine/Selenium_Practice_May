package day19;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumAlert {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		// Simple alert
		driver.findElement(By.id("alertBtn")).click();
		
		// switching to alert
		Alert simplealert = driver.switchTo().alert();
		
		System.out.println("Alert appeared: " +simplealert.getText());
		simplealert.accept();
		
		// Confirmation alert
		driver.findElement(By.id("confirmBtn")).click();
		
		Alert confrAlert = driver.switchTo().alert();
		
		confrAlert.dismiss();
		
		String text = driver.findElement(By.id("demo")).getText();
		System.out.println(text);
		
		// Prompt alert
		driver.findElement(By.id("promptBtn")).click();
		
		Alert promAlert = driver.switchTo().alert();
		
		promAlert.sendKeys("TestUser");
		promAlert.accept();
		
		String text1 = driver.findElement(By.id("demo")).getText();
		System.out.println(text1);
		
		
		
		
	}

}
