package day13;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstScript {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Step 1: Launch the browser
		
		WebDriver driver = new ChromeDriver();
		
		// Step 2: Pass the url
		
		driver.get("https://www.amazon.in");
		
		// Step 3: Maximize the browser
		
		driver.manage().window().maximize();
		
		// Step 4: Close the browser
		
		driver.close();
		
		
	}

}
