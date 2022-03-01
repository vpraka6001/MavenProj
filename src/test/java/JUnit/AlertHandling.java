package JUnit;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertHandling {
	
	WebDriver driver;
	
	@Before
	public void Begining()
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://demo.automationtesting.in/Alerts.html");
	}
	
	@Test
	public void HandleAlert() throws InterruptedException
	{
		WebElement Button = driver.findElement(By.xpath("//div/button[@class='btn btn-danger']"));
		Button.click();
		Thread.sleep(2000);
		Alert alert = driver.switchTo().alert();
		Thread.sleep(2000);
		alert.accept();
		Thread.sleep(2000);
	}
	@Test
	public void DismissAlert() throws InterruptedException
	{
		WebElement Switch = driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div[1]/ul/li[2]/a"));
		Switch.click();
		Thread.sleep(1000);
		WebElement ClickButton = driver.findElement(By.xpath("//button[@onclick='confirmbox()']"));
		ClickButton.click();
		Thread.sleep(1000);
		Alert alert = driver.switchTo().alert();
		Thread.sleep(1000);
		alert.dismiss();
	}
	@After
	public void TearDown()
	{
		driver.quit();
	}
}
