package JUnit;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectDate {
	
	WebDriver driver;
	
	@Before
	public void Selectone()
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.facebook.com/");
	}
	
	@Test
	public void Elements() throws InterruptedException
	{
		WebElement CreateAcc = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[1]/div/div/div/div[2]/div/div[1]/form/div[5]/a"));
		CreateAcc.click();
		
		WebElement Day = driver.findElement(By.id("day"));
		WebElement Month = driver.findElement(By.id("month"));
		WebElement Year = driver.findElement(By.id("year"));
		
		Select dayselect = new Select(Day);
		dayselect.selectByVisibleText("3");
		Thread.sleep(2000);
		Select monthselect = new Select(Month);
		monthselect.selectByVisibleText("Apr");
		Thread.sleep(2000);
		Select yearselect = new Select(Year);
		yearselect.selectByVisibleText("2019");
		Thread.sleep(2000);
	}
	
	@After
	public void Teardown()
	{
		driver.quit();
	}
}
