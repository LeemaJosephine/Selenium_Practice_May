package day14;

import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserAndNavigationCommands {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Step 1: Launch the browser
		
		WebDriver driver = new ChromeDriver();
		
		// Step 2: Load the URL
		
		// using get command
		driver.get("https://www.myntra.com/");
		
		// Step 3: Maximize the screen
		
		driver.manage().window().maximize();
		// driver.manage().window().minimize();  // minimize the browser
		// driver.manage().window().setPosition(new Point(150,250)); // change the position of the window
		
		
		// To get the title of the webpage
		
		String expected_title ="Online Shopping for Women, Men, Kids Fashion & Lifestyle - Myntra";
		
		String actual_title = driver.getTitle();
		
		// Validate the title
		
		if(expected_title.equals(actual_title)) {  // using .equals method to validate
			System.out.println("Title matches");
		} else {
			System.out.println("Title mismatch");
		}
		
		System.out.println("The title of the webpage is: " +actual_title);
		
		// To get the page url
		
		String url = driver.getCurrentUrl();
		System.out.println("The URL of the webpage is: " +url);
		
		// To get the page source
		
		String pageSource = driver.getPageSource();
		// System.out.println("The source of the current page: " +pageSource);
		
		// Using navigate to()
		
		driver.navigate().to("https://www.google.com/");
		
		// to go back in the browser
		
		driver.navigate().back();  
		
		// to go forward 
		
		driver.navigate().forward();
		
		// to refresh 
		
		driver.navigate().refresh();
		
		// Step 4: Close the browser
		
		//driver.close();
	}

}
