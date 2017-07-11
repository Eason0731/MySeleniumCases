package WebDriver_Advanced_Application_Examples;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import BrowserDrivers.GetBrowserDriver;


public class DatePickerTesting {
	public WebDriver driver;
	JavascriptExecutor js;
  @Test
  //11.4
  public void DatePickerTest() throws Exception {
	  WebElement TextBox = driver.findElement(By.id("datepicker"));
	  TextBox.click();
	  TextBox.sendKeys("02/29/2016");
	  Thread.sleep(6000);
	  
  }
  @BeforeMethod
  public void beforeMethod() {
	  driver = GetBrowserDriver.GetChromeDriver();
	  String URL = "http://jqueryui.com/resources/demos/datepicker/other-months.html";
	  driver.navigate().to(URL);
  }

  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }

}
