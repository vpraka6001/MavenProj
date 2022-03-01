package JUnit;

import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenImages {

	WebDriver driver;
	String url = "https://the-internet.herokuapp.com/broken_images";
	@Before
	public void Startup()
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.get(url);
	}
	@Test
	public void findBrokenImg()
	{
		List <WebElement> ImagesOnPage = driver.findElements(By.tagName("img"));
		System.out.println("Number of Images on the page" + url + ImagesOnPage.size());
		
		for(int i=0; i<ImagesOnPage.size();i++)
		{
			String ImageLink = ImagesOnPage.get(i).getAttribute("src");
			try
			{
			URL Imageurl = new URL(ImageLink);
			URLConnection urlConnection = Imageurl.openConnection();
			HttpURLConnection httpurlConnection = (HttpURLConnection) urlConnection;
			httpurlConnection.setConnectTimeout(4000);
			httpurlConnection.connect();
			
			if(httpurlConnection.getResponseCode()==200)
			{
				System.out.println("The Image is not broken as having response code is" + httpurlConnection.getResponseCode());
			}
			else
			{
				System.err.println("The Image is Broken as having response code is" + httpurlConnection.getResponseCode());
			}
			httpurlConnection.disconnect();
			}
			catch(Exception e)
			{
				System.out.println("Some Issue Ocured withimage link");
				e.printStackTrace();
			}
		
	}
	}
	@After
	public void TearDown()
	{
		driver.quit();
	}
}
