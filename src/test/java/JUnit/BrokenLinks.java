package JUnit;

import java.io.IOException;
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

public class BrokenLinks {
	
	WebDriver driver;
	String url = "http://automationpractice.com/index.php";
@Before
public void Startup()
{
driver = new ChromeDriver();
driver.manage().window().maximize();
driver.manage().deleteAllCookies();
driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
driver.get(url);
}
@Test
public void FindBrokenLinks() throws IOException
{
	List<WebElement> LinksBrokenList = driver.findElements(By.tagName("a"));
	
	System.out.println("The Number of all Links Available on the page are" + " " + LinksBrokenList.size());
	
	for(int i=0; i<LinksBrokenList.size();i++)
	{
		String IndividualLinkfromList = LinksBrokenList.get(i).getAttribute("href");
	
	try {
		URL url = new URL(IndividualLinkfromList);
		URLConnection urlConnection = url.openConnection();
		HttpURLConnection httpurlConnection = (HttpURLConnection) urlConnection;
		httpurlConnection.setConnectTimeout(4000);
		httpurlConnection.connect();
		
		if(httpurlConnection.getResponseCode()==200)
		{
			System.out.println("The Link is fine as having Response code is ->" + " " + httpurlConnection.getResponseCode());
		}
		else
		{
			System.err.println("The Link is not Fine as having Response code is ->" + " " + httpurlConnection.getResponseCode());	
		}
		httpurlConnection.disconnect();
	}
	
	catch(Exception e)
	{
		System.out.println("There is issue with Link");
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
