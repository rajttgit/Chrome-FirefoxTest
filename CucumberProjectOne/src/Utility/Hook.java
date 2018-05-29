package Utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hook {

	static WebDriver driver;
	
	@Before("@chrome")
	public void setUpChrome()
	{
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		driver= new ChromeDriver();
	}
	
	@Before("@firefox")
	public void setUpFirefox()
	{
		System.setProperty("webdriver.firefox.driver","geckodriver.exe");
		driver= new FirefoxDriver();
	}
		
	@After
	public void tearDown()
	{
		driver.quit();
	}
	
	public static WebDriver getDriver()
	{
		return driver;
	}
}