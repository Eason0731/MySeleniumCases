package JavaBasicAPI;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import BrowserDrivers.GetBrowserDriver;

public class GetPageSourceTesting {
	public WebDriver driver;
	
	//10.7
  @Test
  public void  GetPageSource() {
	  driver.get("http://www.baidu.com");
	  //WebElement SearchBox = driver.findElement(By.xpath("//*[@id='kw']"));
	  //WebElement SearchButton = driver.findElement(By.xpath("//*[@id='su']"));
	  //SearchBox.sendKeys("Hello Selenium!");
	  //SearchButton.click();
	  
	  String abc = driver.getPageSource()+"\n";
	  System.out.println(abc);
	  
	  Assert.assertTrue(abc.contains("贴吧"));
	  //断言判断网页源代码里是否包含“贴吧”
	  
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
