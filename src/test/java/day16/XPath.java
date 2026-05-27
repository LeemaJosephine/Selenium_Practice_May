package day16;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class XPath {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.get("https://amazon.in");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		// Locate Search bar using absolute xpath
		
		driver.findElement(By.xpath("/html/body/div/header/div/div/div/div/form/div[2]/div/input")).sendKeys("Laptop",Keys.ENTER);
		
		// Attribute based xpath
		
		WebElement search = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
		search.clear(); // clear the exsisting text
		search.sendKeys("Mobile",Keys.ENTER);
		
		// Text Based xpath
		driver.findElement(By.xpath("//a[text()='MX Player']")).click();
		
		driver.navigate().back();
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).clear();
		// Contains and collection
		
		driver.findElement(By.xpath("(//input[contains(@class,'nav-progressive-attribute')])[5]")).sendKeys("Lipstick",Keys.ENTER);
		
		// Relation based xpath - Parent to child
		
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).clear();
		driver.findElement(By.xpath("//div[@class='nav-search-field ']/input")).sendKeys("dress",Keys.ENTER);
		
		
		
		
	}

}
