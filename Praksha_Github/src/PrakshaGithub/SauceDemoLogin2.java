package PrakshaGithub;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class SauceDemoLogin2 {
	public WebDriver driver;
	@BeforeTest
	  public void beforeTest() throws InterruptedException {
		
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://ankittest.plusphysio.com");
		Thread.sleep(5000);
	  }
	
	@Test (priority=0)
	 
	public void bothvalueblank() throws InterruptedException {
	//Both Value Blank
	driver.findElement(By.cssSelector("#mat-mdc-form-field-label-0")).sendKeys("ankit@yopmail.com");
	Thread.sleep(5000);

	}
	
	

  @AfterTest
  public void afterTest() {
  }

}
