package JUnit;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Synchronization {
	
	WebDriver driver;
	WebDriverWait Wait;
	@Before
	public void startup()
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.amazon.in/");
		Wait = new WebDriverWait(driver,15);
	}
	
	@Test
	public void synchronize()
	{
		WebElement Searchbox = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
		Searchbox.sendKeys("Nokia");
		
		List<WebElement> Suggestions = driver.findElements(By.xpath("//div[@class='autocomplete-results-container']"));
		
		Wait.until(ExpectedConditions.visibilityOfAllElements(Suggestions));
		
		for(int i=0;i<Suggestions.size();i++)
		{
			
		System.out.println("SearchList is" + Suggestions.get(i).getText());
			
		}
		
	}
	
	@After
	
	public void Teardown()
	{
		driver.quit();
	}

}
