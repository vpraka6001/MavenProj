package JUnit;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestJUnit {

	WebDriver driver;
	
	String PageTitle = "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
	
	@Before
	public void Setup()
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.amazon.in/");
	}
	
	@Test
	public void TitleValidation()
	{
		Assert.assertEquals("The Test is Failed",PageTitle,driver.getTitle());
		System.out.println("The test is passed");
	}
	
	@Test
	public void Search() throws InterruptedException
	{
		WebElement Serchbox = driver.findElement(By.xpath("/html/body/div[1]/header/div/div[1]/div[2]/div/form/div[2]/div[1]/input"));
		Serchbox.sendKeys("Realme");
		WebElement Search = driver.findElement(By.xpath("/html/body/div[1]/header/div/div[1]/div[2]/div/form/div[3]/div/span/input"));
		Search.click();
		Thread.sleep(2000);
		WebElement SearchResult = driver.findElement(By.xpath("/html/body/div[1]/div[2]/span/div/h1/div/div[1]/div/div/span[3]"));
		String Text = SearchResult.getText();
		
		Assert.assertEquals(Text, "\"Realme\"", Text);
		Thread.sleep(2000);
	}
	
	@After
	public void Teardown()
	{
		driver.quit();
	}
	
}
