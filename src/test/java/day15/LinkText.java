package day15;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LinkText {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.get("https://amazon.in");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		// By link text - when a text is present inside <a>linktext</a>
		driver.findElement(By.linkText("MX Player")).click();
		
		driver.navigate().back();
		
		// By partial link text
		
		// findelement - return a single web element
		driver.findElement(By.partialLinkText("Today's Dea")).click();
		
		// Capture all the links
		
		// findelements - returns a list of webelement 
		List<WebElement> elements = driver.findElements(By.tagName("a"));
		
		// Using for loop
//		for(int i=0; i<elements.size(); i++) {
//			
//			System.out.println(elements.get(i).getText());
//			
//		}
		
		
		// using for each 
		for(WebElement ele : elements) {
			
			String linkText = ele.getText();
			String actualLink = ele.getAttribute("href");
			System.out.println(linkText+" -> "+actualLink);  
		}
	}

}
