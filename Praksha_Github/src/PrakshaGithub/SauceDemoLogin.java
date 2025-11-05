package PrakshaGithub;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class SauceDemoLogin {
	public WebDriver driver;
	@BeforeTest
	  public void beforeTest() {
		
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com/");
	
	  }
	
	@Test (priority=0)
	 
	public void bothvalueblank() throws InterruptedException {
	//Both Value Blank
	driver.findElement(By.xpath("//*[@id=\"login-button\"]")).click();
	Thread.sleep(5000);

	String actual_message=driver.findElement(By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]")).getText();
	String expect_message="Epic sadface: Username is required";
	Assert.assertEquals(actual_message, expect_message);		
	
	}
	
	
	@Test (priority=1)
	 
	public void UsernameBlank() throws InterruptedException {
	//Both Value Blank
		driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("secret_sauce");
		driver.findElement(By.xpath("//*[@id=\"login-button\"]")).click();
	Thread.sleep(5000);

	String actual_message=driver.findElement(By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]/h3")).getText();
	String expect_message="Epic sadface: Username is required";
	Assert.assertEquals(actual_message, expect_message);
	
	
	}
	
	
	
	@Test (priority=2)
	 public void Passwordblank() throws InterruptedException {
	
	driver.findElement(By.xpath("//*[@id=\"user-name\"]")).sendKeys("standard_user");
	driver.findElement(By.xpath("//*[@id=\"login-button\"]")).click();
	Thread.sleep(3000);
	String actual_message=driver.findElement(By.xpath("/html/body/div[2]")).getText();
	String expect_message="Your Birth Date is 2023-12-31\n"
			+ "Your Birth Time is 23:59";
	Assert.assertEquals(actual_message, expect_message);

	 }

	 @Test (priority=3)
	 public void testcase2() throws InterruptedException {
	Thread.sleep(5000);
	driver.findElement(By.xpath("//*[@id=\"user-name\"]")).clear();
	driver.findElement(By.xpath("//*[@id=\"user-name\"]")).sendKeys("khushbu123");
	driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("secret_sauce");
	driver.findElement(By.xpath("//*[@id=\"login-button\"]")).click();
	String actual_message=driver.findElement(By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]")).getText();
	String expect_message="Epic sadface: Username and password do not match any user in this service";
	Assert.assertEquals(actual_message, expect_message);

	 }

	 @Test (priority=4)
	 public void testcase3() throws InterruptedException {
	Thread.sleep(3000);
	driver.findElement(By.xpath("//*[@id=\"user-name\"]")).clear();
	driver.findElement(By.xpath("//*[@id=\"password\"]")).clear();
	driver.findElement(By.xpath("//*[@id=\"user-name\"]")).sendKeys("standard_user");
	driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("khushbu123");
	driver.findElement(By.xpath("//*[@id=\"login-button\"]")).click();
	String actual_message=driver.findElement(By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]")).getText();
	String expect_message="Epic sadface: Username and password do not match any user in this service1";
	Assert.assertEquals(actual_message, expect_message);

	 }
	 @Test (priority=5)
	 public void testcase4() throws InterruptedException {
	 //driver.get("https://www.saucedemo.com/");
	 driver.navigate().refresh();
	Thread.sleep(5000);
	driver.findElement(By.xpath("//*[@id=\"user-name\"]")).sendKeys("standard_user");
	driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("secret_sauce");
	driver.findElement(By.xpath("//*[@id=\"login-button\"]")).click();
	Thread.sleep(5000);

	driver.findElement(By.xpath("//*[@id=\"react-burger-menu-btn\"]")).click();
	Thread.sleep(5000);
	driver.findElement(By.xpath("//*[@id=\"logout_sidebar_link\"]")).click();


	 }

  @AfterTest
  public void afterTest() {
  }

}
