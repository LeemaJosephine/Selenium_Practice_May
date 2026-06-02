package day20;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingWindows {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.automationtesting.in/Windows.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		// To get the current window address
		
		String windowHandle = driver.getWindowHandle();
		System.out.println("Address of the current window: "+windowHandle);
		String title = driver.getTitle();
		System.out.println("Title of the new page " +title);
		
		driver.findElement(By.xpath("(//button[contains(text(),'click')])[1]")).click();
		
		// Handle single tab
		Set<String> windowHandles = driver.getWindowHandles();
		
		for(String window : windowHandles) {
			
			if(!window.equals(windowHandle)) {
				driver.switchTo().window(window);
			}
		}
		
		
		// Handle Multiple Windows
		
//		Set<String> windowHandles = driver.getWindowHandles(); // retuns set
//		
//		// Convert Set to List
//		
//		List<String> lstWindow = new ArrayList<String>(windowHandles);
//		
//		// Switch to the window by their index
//		
//		driver.switchTo().window(lstWindow.get(1));
		
		String windowHandle1 = driver.getWindowHandle();
		System.out.println("Address of the current window: "+windowHandle1);
		String title1 = driver.getTitle();
		System.out.println("Title of the new page " +title1);

		
		//driver.close();
		driver.quit();
		
	}

}
