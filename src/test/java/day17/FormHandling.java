package day17;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class FormHandling {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		// Handle TextBox
		
		driver.findElement(By.id("name")).sendKeys("Leema");
		driver.findElement(By.id("email")).sendKeys("testuser@gmail.com");
		driver.findElement(By.id("phone")).sendKeys("9876543210");
		driver.findElement(By.xpath("//textarea[@id='textarea']")).sendKeys("No. street name, arae name, city, state, country");
		
		// Handle Radio button
		
		WebElement female = driver.findElement(By.id("female"));
		WebElement male=driver.findElement(By.id("male"));
		female.click();
		System.out.println(female.isSelected());
		System.out.println(male.isSelected());
		
		// Handle Checkbox
		
		WebElement monday = driver.findElement(By.id("monday"));
		
		if(monday.isDisplayed()) { // checking whether the element is visible on the screen
			
			monday.click();
			
		}
		
		if(monday.isSelected()) {
			
			System.out.println("Option selected");
		} else {
			System.out.println("Option not selected ");
		}
		
		// isEnabled
		
		WebElement start = driver.findElement(By.name("start"));
		
		if(start.isEnabled()) { // CHecking whether the button is in state to click
			
			start.click();
		}
		
		// To handle dropdown
		
		// Using Select class - visible text
		
		WebElement dropdown = driver.findElement(By.id("country"));
		
		Select select = new Select(dropdown);
		
		select.selectByContainsVisibleText("Canada");
		
		// By  value
		
		WebElement colours = driver.findElement(By.id("colors"));
		
		Select sel = new Select(colours);
		
		sel.selectByValue("blue");
		
		// By index
		
		WebElement animals = driver.findElement(By.id("animals"));
		
		Select sel1 = new Select(animals);
		
		sel1.selectByIndex(3);  // index starts from 0
		sel1.deselectByIndex(3);
		
	}

}
