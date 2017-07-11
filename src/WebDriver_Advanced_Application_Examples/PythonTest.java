package WebDriver_Advanced_Application_Examples;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import BrowserDrivers.GetBrowserDriver;


public class PythonTest {
	public WebDriver driver;
  @Test
  public void Python() throws Exception {
	  WebElement LeftBox = driver.findElement(By.xpath(""));
	  WebElement Button = driver.findElement(By.id("submitBTN"));
	  Thread.sleep(5000);
	  LeftBox.clear();
	  LeftBox.sendKeys("print 'ABCD'");
	  Thread.sleep(5000);
	  
	  Button.click();
	  Thread.sleep(5000);
  }
  
  
  @BeforeMethod
  public void beforeMethod() {
	  driver = GetBrowserDriver.GetChromeDriver();
	  String URL = "http://www.runoob.com/try/showpy.php?filename=HelloWorld&language=py";
	  driver.navigate().to(URL);
  }

  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }

}
