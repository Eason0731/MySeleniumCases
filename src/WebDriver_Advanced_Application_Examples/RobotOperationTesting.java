package WebDriver_Advanced_Application_Examples;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import BrowserDrivers.GetBrowserDriver;


public class RobotOperationTesting {
	public WebDriver driver;
  @Test
  //11.10
  public void RobotOperationTest() throws Exception {
	  WebDriverWait wait = new WebDriverWait (driver,10); //显式等待10秒
	  wait.until(ExpectedConditions.presenceOfElementLocated(By.id("kw"))); //判断是否显示搜索的文本框
	  SetCTRLVFunction("Selenium Webdriver");
	  SetTabFunction();
	  SetEnterFunction();
	  Thread.sleep(5000); 
	  Assert.assertEquals(driver.getTitle(), "Selenium Webdriver_百度搜索");
	  
  }
  
  private void SetCTRLVFunction(String content)
  {
	  StringSelection stringSelection = new StringSelection(content); //声明StringSelection对象，并使用函数的content进行实例化操作
	  Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null); //使用Toolkit对象的setContents方法将字符串放到剪切板上
	  Robot rbt = null;
	  
	  try {
		  
		  rbt = new Robot();
	  }
	  catch (AWTException e)
	  {
		  e.printStackTrace();;
	  }
	  
	  rbt.keyPress(KeyEvent.VK_CONTROL); //按下Control键
	  rbt.keyPress(KeyEvent.VK_V); //按下V键
	  rbt.keyRelease(KeyEvent.VK_V); //松开V键
	  rbt.keyRelease(KeyEvent.VK_CONTROL); //松开Control键
	  
  }
  
  private void SetTabFunction()
  {
	  Robot rbt1 = null;
	  try
	  {
		  rbt1 = new Robot();
	  }
	  catch (AWTException e){
		  e.printStackTrace();
	  }
	  
	  rbt1.keyPress(KeyEvent.VK_TAB); //按下TAB键
	  rbt1.keyRelease(KeyEvent.VK_TAB); //释放TAB键
	  
  }
  
  private void SetEnterFunction()
  {
	  Robot rbt1 = null;
	  try
	  {
		  rbt1 = new Robot();
	  }
	  catch (AWTException e){
		  e.printStackTrace();
	  }
	  
	  rbt1.keyPress(KeyEvent.VK_ENTER); //按下ENTER键
	  rbt1.keyRelease(KeyEvent.VK_ENTER); //释放ENTER键
	  
  }
  
  @BeforeMethod
  public void beforeMethod() {
	 driver = GetBrowserDriver.GetChromeDriver();
	 String URL = "http://www.baidu.com";
	 driver.navigate().to(URL);
  }

  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }

}
