package day23;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
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
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TC001_LoginTest_Valid {

	
	public static WebDriver driver;
	public String sheetName;
	
	@BeforeTest
	public void setup_Test() {
		
		sheetName="LoginData";
	}
	
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
	
	
	@DataProvider
	public String[][] readData() throws IOException {
		
		return readDataFromExcel(sheetName);
	}
	
	public static void takeScreenShot(String screenShotName) throws IOException {
				
				// Convert webdriver object to take screenshot
				
				TakesScreenshot screenshot = ((TakesScreenshot)driver);
				
				// call the getScreenshotAs method to create the image file
				
				File src = screenshot.getScreenshotAs(OutputType.FILE);
				
				// Mention the destination
				File dest = new File("C:\\Users\\leema\\eclipse-workspace\\SelenimProject\\src\\test\\java\\screenshot\\"+screenShotName+".png");
				
				// Copy from source to destination
				
				FileUtils.copyFile(src, dest);
	}

	public static String[][] readDataFromExcel(String sheetname) throws IOException {
		
				System.out.println(sheetname);
				// Open the workbook
				XSSFWorkbook book = new XSSFWorkbook("C:\\Users\\leema\\eclipse-workspace\\SelenimProject\\src\\test\\resources\\TestData\\TestData_OrangeHRM.xlsx");
				
				// Open the sheet
				XSSFSheet sheet = book.getSheet(sheetname);
				
				// Get the no.of rows
				int rowCount = sheet.getLastRowNum();
				
				// Get the column count
				int columnCount = sheet.getRow(0).getLastCellNum();
				
				//Create 2D Array
				String[][] data = new String[rowCount][columnCount];
				
				// Get into each row
				
				for(int i=1; i<=rowCount; i++) {
					
					XSSFRow row = sheet.getRow(i);
					
					// get into the column
					
					for(int j=0; j<columnCount; j++) {
						
						XSSFCell cell = row.getCell(j);
						
						// to store in array
						
						data[i-1][j]=cell.getStringCellValue();
					}
					
				}
				book.close();
				return data;
				
	}
	
	
	@Test(dataProvider = "readData")
	public void login_Test(String user_name,String pass, String test_type, String expectedText) throws IOException, InterruptedException {
		// TODO Auto-generated method stub	
		WebElement username = driver.findElement(By.name("username"));
		username.sendKeys(user_name);
		
		WebElement password = driver.findElement(By.name("password"));
		password.sendKeys(pass);
		
		driver.findElement(By.xpath("//button[text()=' Login ']")).click();
				
		Thread.sleep(3000);
		
		takeScreenShot("Valid_Login");
		
		// Assertion
		if(test_type.equalsIgnoreCase("ValidUnValidPass")) {
			
			String actualText = driver.findElement(By.xpath("//h6[text()='Dashboard']")).getText();
			Assert.assertEquals(actualText, expectedText);
			
		} else if(test_type.equalsIgnoreCase("ValidUnInvalidPass") || test_type.equalsIgnoreCase("InvalidUnValidPass") || test_type.equalsIgnoreCase("InvalidUnInvalidPass") ) {
			
			String errorText = driver.findElement(By.xpath("//p[text()='Invalid credentials']")).getText();
			Assert.assertEquals(errorText, expectedText); 
		}
		
		// Soft Assertion
//		SoftAssert assertObj = new SoftAssert();
//		assertObj.assertEquals(actualText, expectedText);
//		assertObj.assertAll();  //causes and exception when assert fails	
	}
	
	@AfterMethod
	public void close_browser() {
		
		driver.close();
	}
	
}
