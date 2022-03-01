package JUnit;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class DesireCapabilities {
	
	WebDriver driver;
	
	@Before
	public void Startup() throws InterruptedException
	{
		DesiredCapabilities cap = new DesiredCapabilities();
		driver = new ChromeDriver(cap);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://cacert.com/");
		Thread.sleep(1000);
		cap.setAcceptInsecureCerts(true);
	}
	
	@Test
	public void Middle()
	{
	System.out.println("The Title of Page is " + driver.getTitle());
	}
	
	@After
	public void TearingDown()
	{
		driver.quit();
	}
}
