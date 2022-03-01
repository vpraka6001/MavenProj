package LocatorsIN_Selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locators_Selenium {
	
	public static void main(String args[]) throws InterruptedException
	{
		System.setProperty("webDriver.chrome.driver", System.getProperty("user.dir") + "/chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
//		driver.get("https://anypoint.mulesoft.com/");
//		String ActualTitle = driver.getTitle();
//		if(ActualTitle.equals("Anypoint Platform"))
//		{
//			System.out.println("The test is passed");
//		}
//		else
//		{
//			System.out.println("Failed");
//		}
//		
//		String ActualURL = driver.getCurrentUrl();
//		System.out.println("The actual fetched URL is ->" + ActualURL);
//		try {
//			Thread.sleep(5000);
//		} 
//		catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		driver.close();
		
		// Locators by ID
		driver.get("https://anypoint.mulesoft.com/");
		WebElement Username = driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div/main/div/div/div/div[1]/form/div[1]/div/div/input"));
		Username.sendKeys("Rvpatil");
		WebElement Password = driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div/main/div/div/div/div[1]/form/div[2]/input"));
		Password.sendKeys("Spiendy");
		WebElement SignIn = driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div/main/div/div/div/div[1]/form/button"));
		SignIn.click();
		Thread.sleep(3000);
		driver.close();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
