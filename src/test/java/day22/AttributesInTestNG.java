package day22;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class AttributesInTestNG {

	
	@Test(priority = 1, dependsOnMethods = "sign_up", alwaysRun = true)
	public void login_up() {
		
		System.out.println("Login method");
	}
	
	@Ignore
	@Test
	public void display() {
		
		System.out.println("Display method");
	}
	
	@Test(priority = 0, invocationCount = 3, threadPoolSize = 2, invocationTimeOut = 10000)
	public void sign_up() {
		
		WebDriver driver = new ChromeDriver();
		
		System.out.println("Sign-up method");
	}

	
	
}
