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

public class Drag_And_Drop {
	
	WebDriver driver;
	
	@Before
	public void Trial()
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://demoqa.com/droppable");
	}
	@Test
	public void Dragging() throws InterruptedException
	{
		WebElement element1 = driver.findElement(By.id("draggable"));
		WebElement Drop = driver.findElement(By.id("droppable"));
		
		Actions act = new Actions(driver);
		
		//act.clickAndHold(element1).moveToElement(Drop).build().perform();
		act.dragAndDrop(element1, Drop).build().perform();
		act.contextClick(Drop);
		act.doubleClick(Drop);
		Thread.sleep(3000);
			
	}
	@After
	public void teardown()
	{
		driver.quit();
	}
}
