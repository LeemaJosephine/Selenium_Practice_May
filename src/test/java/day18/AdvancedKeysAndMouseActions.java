package day18;

import java.time.Duration;

import javax.swing.plaf.synth.SynthStyleFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class AdvancedKeysAndMouseActions {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		// Advanced Key actions
		
		WebElement input = driver.findElement(By.id("name"));
		
		// Type text
		input.sendKeys("Testuser");
		
		// Select All
		input.sendKeys(Keys.CONTROL + "a");
		
		//Copy
		input.sendKeys(Keys.CONTROL + "c");
		
		// Paste
		WebElement mail = driver.findElement(By.id("email"));
		mail.sendKeys(Keys.CONTROL + "v");
		
		//Delete
		mail.sendKeys(Keys.DELETE);
		
		// Backspace
		mail.sendKeys(Keys.BACK_SPACE);
		
		// Advanced Mouse actions
		Actions act = new Actions(driver);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		//Mouse Hover 
		WebElement pointme = driver.findElement(By.className("dropbtn"));
		act.moveToElement(pointme).perform();
		
		// Double click
		WebElement copyText = driver.findElement(By.xpath("//button[text()='Copy Text']"));
		act.doubleClick(copyText).perform();
		
		// Right click
		act.contextClick(copyText).perform();
		
		// Drag and drop
		
		// Move to element - Can scroll and mouse hover
		WebElement scroll = driver.findElement(By.xpath("//h2[text()='Drag and Drop']"));
		//act.moveToElement(scroll).perform();
		js.executeScript("arguments[0].scrollIntoView();", scroll);
		
		WebElement drag = driver.findElement(By.id("draggable"));
		
		WebElement drop = driver.findElement(By.id("droppable"));
		
		act.dragAndDrop(drag, drop).perform();
		
		String cssValue = drop.getCssValue("background");
		
		System.out.println(cssValue);
		
		String text = driver.findElement(By.xpath("//p[text()='Dropped!']")).getText();
		
		if(text.equalsIgnoreCase("Dropped!")) {
			
			System.out.println("Dropped sucessfully");
		}

		
		
		
	}

}
