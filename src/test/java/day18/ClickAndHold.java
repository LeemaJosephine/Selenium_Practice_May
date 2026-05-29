package day18;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ClickAndHold {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.get("https://jqueryui.com/selectable/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		
		driver.switchTo().frame(0);
		
		List<WebElement> elements = driver.findElements(By.xpath("//li[@class='ui-widget-content ui-selectee']"));
		
		System.out.println(elements.size());
		Actions act = new Actions(driver);
		act.clickAndHold(elements.get(0)).moveToElement(elements.get(3)).release().perform();
	}

}
