package JUnit;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ToolTips {

	WebDriver driver;
	
	@Before
	public void Startup()
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://demoqa.com/tool-tips/");
	}
	
	@Test
	public void TolltipDetect() throws InterruptedException
	{
		WebElement HoverButton = driver.findElement(By.xpath("//button[text()='Hover me to see']"));
		
		Actions act = new Actions(driver);
		act.moveToElement(HoverButton).build().perform();
		Thread.sleep(1000);
		
		WebElement ButtonText = driver.findElement(By.xpath("//div[text()='You hovered over the Button']"));
		System.out.println("The text of hovered button Popup is " + ButtonText.getText());
	
	}
	
	@After
	public void TearDown() {
		
		driver.quit();
	}
}
