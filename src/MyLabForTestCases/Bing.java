package MyLabForTestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import BrowserDrivers.GetBrowserDriver;


public class Bing {
	public WebDriver driver = GetBrowserDriver.GetFireFoxDriver();
	String wangzhi = "http://cn.bing.com";
  @Test
  public void MySeleniumBackOnBing() throws Exception {
	  driver.navigate().to(wangzhi);
	  Thread.sleep(2000);
	  Assert.assertEquals( driver.getTitle(),"微软必应搜索 - 全球搜索，有问必应 (Bing)"); //actual，excepted
	  //Assert.assertEquals(driver.getTitle(), "Bing"); //Assert.assertEquals(actual, expected)
	  
	  WebElement SearchBox = driver.findElement(By.id("sb_form_q"));
	  WebElement SearchButton = driver.findElement(By.id("sb_form_go"));
	   
	  String Content = "Fernando Alonso";
	  SearchBox.sendKeys(Content);
	  Thread.sleep(2000);
	  SearchButton.click();
	  Thread.sleep(3000);
	  
	  Assert.assertEquals(Content+" - 必应", driver.getTitle());
	  
	  driver.quit();
  }
  /*
  @BeforeMethod
  public void beforeMethod() {
	  System.setProperty("webdriver.chrome.driver", "D://Selenium//ChromeDriver//ChromeDriver.exe");
	  driver = new ChromeDriver();
	  driver.manage().window().setSize(new Dimension(1920,1080));
	  driver.navigate().to(wangzhi);
  }

  
  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }
*/
}
