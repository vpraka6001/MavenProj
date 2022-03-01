package JUnit;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class InvokePropertiesFile {
	public Properties Prop;
	WebDriver driver;

	@Test
	public void ReadProperties() throws InterruptedException, IOException
	{
		Prop = new Properties();
		try {
			FileInputStream ip = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\java\\JUnit\\Config.properties");
			Prop.load(ip);
		} catch (FileNotFoundException e) {
			System.out.println("The config.properties file can not found, please update path");
			e.printStackTrace();
				
			
		}
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(Prop.getProperty("url"));
		
	}
	
	
}
