package JavaBasicAPI;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import BrowserDrivers.GetBrowserDriver;


public class ClickKeyTesting {
	public WebDriver driver;
  @Test
  //10.23
  public void ClickKeyTest() throws InterruptedException {
	  driver.get("http://www.sogou.com");
	  Actions action = new Actions(driver);
	  action.keyDown(Keys.CONTROL); //按下CTRL键  
	  Thread.sleep (3000);
	  action.keyDown(Keys.SHIFT); //按下SHIFT键  
	  Thread.sleep (3000);
	  action.keyDown(Keys.ALT); //按下ALT键
	  Thread.sleep (3000);
	  
	  action.keyUp(Keys.CONTROL); //松开CTRL键
	  Thread.sleep (3000);
	  action.keyUp(Keys.SHIFT); //松开SHIFT键
	  Thread.sleep (3000);
	  action.keyUp(Keys.ALT); //松开ALT键
	  Thread.sleep (3000);
	  
	  action.keyDown(Keys.SHIFT).sendKeys("alonso is world champion").perform(); //模拟按住SHIFT键位，输入大写字符串alonso is world champion
	  
	  Thread.sleep (3000);
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
