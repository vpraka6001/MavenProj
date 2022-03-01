package WebDriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeInvocation {
	
	public static void main(String args[])
	{
		System.setProperty("webDriver.chrome.driver", System.getProperty("user.dir") + "/chromedriver.exe");
		WebDriver Dr = new ChromeDriver();
		
		Dr.manage().window().maximize();
		Dr.manage().deleteAllCookies();
		
		Dr.get("https://accounts.google.com/");
		String ActualUrl = Dr.getCurrentUrl();
		System.out.println("The actual App Url is -> " + ActualUrl);
		Dr.navigate().to("https://mvnrepository.com/");
		Dr.navigate().back();
		Dr.close();
	}

}
