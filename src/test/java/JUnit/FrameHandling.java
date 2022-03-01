package JUnit;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FrameHandling {
	
	WebDriver driver;
	
	@Before
	public void Start()
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://demo.automationtesting.in/Frames.html");
	}
	
	@Test
	public void HandleFrame() throws InterruptedException
	{
		WebElement InnerFrame = driver.findElement(By.xpath("//iframe[@id='singleframe']"));
		driver.switchTo().frame(InnerFrame);
		WebElement TextBox = driver.findElement(By.xpath("//input[@type='text']"));
		TextBox.sendKeys("RvPatil");
		Thread.sleep(1000);
		driver.switchTo().defaultContent();
		WebElement CentreText = driver.findElement(By.xpath("//h1[text()='Automation Demo Site ']"));
		System.out.println("The Centre Text of the Page is" + CentreText.getText());
	}
	
	@After
	public void TearDown()
	{
		driver.quit();
	}
}
