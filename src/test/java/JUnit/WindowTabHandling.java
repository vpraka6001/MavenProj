package JUnit;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowTabHandling {
	
	WebDriver driver;
	
	@Before
	public void Start()
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://demoqa.com/browser-windows");
	}
	
	@Test
	public void TabSwitch() throws InterruptedException
	{
		WebElement NewTabButton = driver.findElement(By.xpath("//button[@id='tabButton']"));
		NewTabButton.click();
		Thread.sleep(1000);
		Set<String> handles = driver.getWindowHandles();
		Iterator<String> it = handles.iterator();
		
		String parentWindowID = it.next();
		String ChildWindowID = it.next();
		
		System.out.println("The Parent Window Id Is " + parentWindowID);
		System.out.println("The Parent Window Id Is " + ChildWindowID);
		
		driver.switchTo().window(ChildWindowID);
		Thread.sleep(1000);
		
		WebElement Text = driver.findElement(By.xpath("//h1[@id='sampleHeading']"));
		System.out.println("The Test on New Tab is " + Text.getText());
	}
	
	@After
	
	public void TearDown()
	{
		driver.quit();
	}
}
