package step.definitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import Utility.Hook;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Step 
{
	
	private WebDriver driver;
	
	public Step()
	{
		this.driver=Hook.getDriver();
	}
	
	
	@Given("^I navigated to ups login page$")
	public void i_navigated_to_ups_login_page() throws Throwable 
	{
		/*System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		driver= new ChromeDriver();*/
		driver.get("https://www.ups.com/lasso/login?loc=en_US&returnto=https%3A%2F%2Fwww.ups.com%2Fus%2Fen%2FHome.page");
	   	driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Given("^I entered wrong \"(.*)\" and \"(.*)\"$")
	public void i_entered_wrong_user_and_password(String userid, String password) throws Throwable 
	{
		driver.findElement(By.xpath("//*[@id='email']")).sendKeys(userid);
	    driver.findElement(By.xpath("//*[@id='pwd']")).sendKeys(password);
	}

	@When("^I click on login$")
	public void i_click_on_login() throws Throwable 
	{
		WebElement submit = driver.findElement(By.xpath("//*[@id='submitBtn']"));
		submit.click();
	}

	@Then("^I should receive an error message$")
	public void i_should_receive_an_error_message() throws Throwable 
	{
		String actual=driver.getCurrentUrl();
		System.out.println("tested");
		Assert.assertEquals(actual, "https://www.ups.com/us/en/Home.page");
		//driver.quit();	
	}

}