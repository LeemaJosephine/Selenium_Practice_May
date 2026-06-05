package day23;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TC001_LoginTest_Valid {

	
	public static WebDriver driver;
	
	@Parameters({"browser","url"})
	@BeforeMethod
	public void setup_browsedr(String browser, String url) {
		
		if(browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if(browser.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		} else if (browser.equalsIgnoreCase("FireFox")) {
			driver = new FirefoxDriver();
		} else {
			driver = new ChromeDriver();
		}
		
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	@Test
	public void login_Test() throws IOException, InterruptedException {
		// TODO Auto-generated method stub	
		WebElement username = driver.findElement(By.name("username"));
		username.sendKeys("Admin");
		
		WebElement password = driver.findElement(By.name("password"));
		password.sendKeys("admin123");
		
		driver.findElement(By.xpath("//button[text()=' Login ']")).click();
		
		Thread.sleep(3000);
		
		// To take screenshot
		
		// Convert webdriver object to take screenshot
		
		TakesScreenshot screenshot = ((TakesScreenshot)driver);
		
		// call the getScreenshotAs method to create the image file
		
		File src = screenshot.getScreenshotAs(OutputType.FILE);
		
		// Mention the destination
		File dest = new File("C:\\Users\\leema\\eclipse-workspace\\SelenimProject\\src\\test\\java\\screenshot\\ValidloginTest.png");
		
		// Copy from source to destination
		
		FileUtils.copyFile(src, dest);
		
		// Assertion
		
		String expectedText ="Dashboa";
		
		String actualText = driver.findElement(By.xpath("//h6[text()='Dashboard']")).getText();
		
		// Hard Assertion
		
		// Assert.assertEquals(actualText, expectedText);
		
		// Soft Assertion
		
		SoftAssert assertObj = new SoftAssert();
		assertObj.assertEquals(actualText, expectedText);
		assertObj.assertAll();  //causes and exception when assert fails
		
	}
	
	@AfterMethod
	public void close_browser() {
		
		driver.close();
	}
	
}
