package day20;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class HandlingFrame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.automationtesting.in/Frames.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		// switch to frame using id
		
		//driver.switchTo().frame("singleframe");
		
		// switch to frame using web element
//		WebElement frame = driver.findElement(By.xpath("//iframe[@name='SingleFrame']"));
//		driver.switchTo().frame(frame);
		
		// switch to frame using index
		driver.switchTo().frame(0);  // index starts from 0
		
		String text = driver.findElement(By.tagName("h5")).getText();
		System.out.println(text);
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Hello");
		
		// switch back to default 
		driver.switchTo().defaultContent();
		
		// Nested Iframes
		
		driver.findElement(By.xpath("//a[text()='Iframe with in an Iframe']")).click();
		
		// switch to parent frame
		driver.switchTo().frame(1);
		String text1 = driver.findElement(By.tagName("h5")).getText();
		System.out.println("Inside parent frame: "+ text1);
		
		// switch to child
		driver.switchTo().frame(0);
		String text2 = driver.findElement(By.tagName("h5")).getText();
		System.out.println("Inside child frame :" + text2);
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Hello");
		
		driver.switchTo().parentFrame();
		String text3 = driver.findElement(By.tagName("h5")).getText();
		System.out.println("Back to parent frame: " +text3);
		
		driver.switchTo().defaultContent();
		driver.findElement(By.xpath("//a[text()='Single Iframe ']")).click();
		
		
	}

}
