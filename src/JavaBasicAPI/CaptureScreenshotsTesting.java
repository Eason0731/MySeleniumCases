package JavaBasicAPI;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import BrowserDrivers.GetBrowserDriver;

public class CaptureScreenshotsTesting {
	public WebDriver driver;
  @Test
  //10.19
  public void CaptureScreenshots() {
	  driver.get("http://twitter.com");
	  //新建File，截图
	  File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	  
	  try
	  {
		  FileUtils.copyFile(scrFile,new File("D:\\Selenium\\Screenshots\\a.png"));
	  }
	  
	  catch(Exception e)
	  {
		  System.out.println(e);
	  }
  
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
