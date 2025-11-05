package PrakshaGithub;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class Saucedemo_Login {
	public WebDriver driver;
	@BeforeTest
	  public void beforeTest() {
		
        // Launch Chrome with the configured options
		ChromeOptions options = new ChromeOptions();
		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("credentials_enable_service", false);
		prefs.put("profile.password_manager_enabled", false);
		prefs.put("profile.password_manager_leak_detection", false);
		options.setExperimentalOption("prefs", prefs);
		driver = new ChromeDriver(options);
        
		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com/");
	
	  }
	@Test
	  public void Login() throws InterruptedException {
	driver.findElement(By.xpath("//*[@id=\"user-name\"]")).sendKeys("standard_user");
	driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("secret_sauce");
	driver.findElement(By.xpath("//*[@id=\"login-button\"]")).click();
	Thread.sleep(5000);
	

	 }

	

  @AfterTest
  public void afterTest() {
  }

}
