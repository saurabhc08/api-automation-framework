package MavenProject.MavenProject;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class Demo1 {
	WebDriver driver;
	@BeforeClass
	  public void beforeClass() {
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	  }
	@BeforeTest
	  public void beforeTest() {
		driver = new ChromeDriver();
		 driver.get("https://www.flipkart.com/");
	  }
	 @BeforeMethod
	  public void beforeMethod() {
		
	  }
  @Test
  public void f() {
	  WebElement ng = driver.findElement(By.xpath("//img[@alt='Minutes']"));
	  ng.click();
  }
 

  @AfterMethod
  public void afterMethod() {
  }

  

  @AfterClass
  public void afterClass() {
  }

  

  @AfterTest
  public void afterTest() {
	  driver.close();
  }

}
