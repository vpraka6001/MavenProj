package JUnit;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ScreenShot {
	
	WebDriver driver;
	WebDriverWait wait;
	@Before
	public void Startup()
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.mulesoft.com/");
	}

	
	
	
	
				
	
	
	@After
	public void TearDown()
	{
		driver.close();
	}
	
    public static void ScreenShotCpature(WebDriver driver,String fileNameToBe)
	
	{
		File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(System.getProperty("user.dir") + "\\src\\ScreenShots");
	}
}
