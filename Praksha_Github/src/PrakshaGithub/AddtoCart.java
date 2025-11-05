package PrakshaGithub;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;

public class AddtoCart {
 public WebDriver driver;
	@BeforeTest
	  public void beforeTest() {
		ChromeOptions options = new ChromeOptions();
		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("credentials_enable_service", false);
		prefs.put("profile.password_manager_enabled", false);
		prefs.put("profile.password_manager_leak_detection", false);
		options.setExperimentalOption("prefs", prefs);
		driver = new ChromeDriver(options);	

		driver.get("https://www.saucedemo.com/");

		driver.manage().window().maximize();
	  }
	
	@Test (priority=0)

	  public void login() throws InterruptedException {

	 		driver.findElement(By.id("user-name")).sendKeys("standard_user");

			driver.findElement(By.id("password")).sendKeys("secret_sauce");

			driver.findElement(By.id("login-button")).click();

			Thread.sleep(3000);

			String actual_message = driver.getTitle();

			String expected_message = "Swag Labs";

		    Assert.assertEquals(actual_message, expected_message);

		    System.out.println("Page Title: " + expected_message);

		}

	
		@Test (priority=1)

		  public void VerifyProductName() throws InterruptedException {

		  	  String actual_message = driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/span")).getText();;

			  String expected_message = "Products";

			  Assert.assertEquals(actual_message, expected_message);	

					
			  String actual_message1 =driver.findElement(By.xpath("//*[@id=\"item_4_title_link\"]/div")).getText();

			  String expected_message1 = "Sauce Labs Backpack1";

			  Thread.sleep(3000);	

			  Assert.assertEquals(actual_message1, expected_message1);	

			}

		
		@Test (priority=2)

		  public void AddtoCart() throws InterruptedException {

			    driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();

				driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a")).click();

				Thread.sleep(3000);

				String actual_message= driver .findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/span")).getText();

				String expected_message = "Your Cart1";

				Assert.assertEquals(actual_message, expected_message);

				
				String actual_message1= driver.findElement(By.xpath("//*[@id=\"item_4_title_link\"]/div")).getText();	 

				String expected_message1 = "Sauce Labs Backpack";

				Assert.assertEquals(actual_message1, expected_message1);

			

		}
		

		@Test (priority=3)

		  public void Checkout() throws InterruptedException {
		

			driver.findElement(By.xpath("//*[@id=\"checkout\"]")).click();	
			 Thread.sleep(3000);

			   String actual_message = driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/span")).getText();

			   String expected_message = "Checkout: Your Information1";

			   Assert.assertEquals(actual_message, expected_message);

			
			   Thread.sleep(3000);
			    driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/form/div[1]/div[1]/input")).sendKeys("Megha");

			    driver.findElement(By.xpath("//*[@id=\"last-name\"]")).sendKeys("Kothari");

			    driver.findElement(By.xpath("//*[@id=\"postal-code\"]")).sendKeys("380015");

				driver.findElement(By.id("continue")).click();

				Thread.sleep(3000);

			}

		

		@Test (priority=4)

		  public void VerifyCheckoutOverview() throws InterruptedException {
	    

			   String actual_message = driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/span")).getText();

			   String expected_message = "Checkout: Overview";

			   Assert.assertEquals(actual_message, expected_message);

			   

			   String actual_message1 = driver.findElement(By.xpath("//*[@id=\"item_4_title_link\"]/div")).getText();

			   String expected_message1 = "Sauce Labs Backpack1";

			   Assert.assertEquals(actual_message1, expected_message1);
			 

			   Thread.sleep(3000);			   

			  driver.findElement(By.xpath("//*[@id=\"finish\"]")).click();  

			   	}
	

		@Test (priority=5)

		  public void CheckoutComplete() throws InterruptedException {

			String actual_message = driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/span")).getText();

			   String expected_message = "Checkout: Complete";

			   Assert.assertEquals(actual_message, expected_message);

			   
			   String actual_message1 = driver.findElement(By.xpath("//*[@id=\"checkout_complete_container\"]/h2")).getText();

			   String expected_message1 = "Thank you for your order";

			   Assert.assertEquals(actual_message1, expected_message1);   

			   Thread.sleep(3000);			   

			   driver.findElement(By.xpath("//*[@id=\"back-to-products\"]")).click();	

		}		

		@Test (priority=6)

		  public void ProductsText() throws InterruptedException {

			   String actual_message = driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/span")).getText();

			   String expected_message = "Product";

			   Assert.assertEquals(actual_message, expected_message); 

			   Thread.sleep(3000);			   

			  driver.findElement(By.xpath("//*[@id=\"react-burger-menu-btn\"]")).click();

			  Thread.sleep(3000);			  

			  driver.findElement(By.xpath("//*[@id=\"logout_sidebar_link\"]")).click();

			  Thread.sleep(3000);   

			  }
		
		@AfterMethod

		public void Screenshot(ITestResult result) throws IOException {

		if(ITestResult.FAILURE==result.getStatus()) {

		TakesScreenshot screenshot=(TakesScreenshot)driver;

		File src=screenshot.getScreenshotAs(OutputType.FILE);

		FileUtils.copyFile(src, new File("C:\\Users\\ankur\\OneDrive\\Desktop\\Screenshot\\"+result.getName()+".png"));
		}
			

		}
  

  @AfterTest
  public void afterTest() {
  }

}
