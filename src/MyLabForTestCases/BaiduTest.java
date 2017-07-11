package MyLabForTestCases;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import BrowserDrivers.GetBrowserDriver;

public class BaiduTest {
	WebDriver driver;
  @Test
  public void CheckOnBaidu() throws Exception {
	  String Baidu = "http://www.baidu.com";
	  driver.navigate().to(Baidu);
	  Thread.sleep(3000);
	  Assert.assertEquals(driver.getTitle(), "百度一下，你就知道");
	  
  }
  @BeforeMethod
  public void beforeMethod() {
	  driver = GetBrowserDriver.GetChromeDriver();
  }

  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }

}
