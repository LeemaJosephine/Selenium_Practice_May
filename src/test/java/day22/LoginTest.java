package day22;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest {
	
	public static WebDriver driver;
	
	@BeforeMethod
	public void setup_browsedr() {
		
		driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	@Test
	public void login_Test() {
		// TODO Auto-generated method stub	
		WebElement username = driver.findElement(By.name("username"));
		username.sendKeys("Admin");
		
		WebElement password = driver.findElement(By.name("password"));
		password.sendKeys("admin123");
		
		driver.findElement(By.xpath("//button[text()=' Login ']")).click();
		
	}
	
	
	@Test
	public void login_Test_Invalid() {
		// TODO Auto-generated method stub
		
		WebElement username = driver.findElement(By.name("username"));
		username.sendKeys("Admin");
		
		WebElement password = driver.findElement(By.name("password"));
		password.sendKeys("admin");
		
		driver.findElement(By.xpath("//button[text()=' Login ']")).click();
		
	}
	
	@AfterMethod
	public void close_browser() {
		
		driver.close();
	}
	

}
