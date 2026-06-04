package day22;

import org.testng.annotations.Test;

public class TestNgAnnotation {

	@org.testng.annotations.BeforeSuite
	public void BeforeSuite() {
		
		System.out.println("Before Suite Method");
	}
	
	@org.testng.annotations.BeforeClass
	public void BeforeClass() {
		
		System.out.println("Before Class Method");
	}
	
	@org.testng.annotations.BeforeTest
	public void BeforeTest() {
		
		System.out.println("Before Test Method");
	}
	
	@org.testng.annotations.BeforeMethod
	public void BeforeMethod() {
		
		System.out.println("Before Method");
	}
	
	@Test
	public void test() {
		
		System.out.println("Test Method");
	}
	
	@org.testng.annotations.AfterSuite
	public void AfterSuite() {
		
		System.out.println("After Suite Method");
		
	}
	
	@org.testng.annotations.AfterClass
	public void AfterClass() {
		
		System.out.println("After Class Method");
	}
	
	@org.testng.annotations.AfterMethod
	public void AfterMethod() {
		
		System.out.println("After Method");
		
	}
	
	@org.testng.annotations.AfterTest
	public void AfterTest() {
		
		System.out.println("After Test Method");
		
	}

}
