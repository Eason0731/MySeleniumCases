package JavaBasicAPI;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import BrowserDrivers.GetBrowserDriver;

public class DoubleClickTesting {
	public WebDriver driver;
	//10.12
  @Test
  public void DoubleClickTest() throws InterruptedException, Exception {
	  File myHtml = new File ("html/10.12.html");
	  String myHtmlFile = myHtml.getAbsolutePath(); //getAbsolutePath()返回抽象路径名的绝对路径名字符串
	  System.out.println(myHtmlFile);
	  driver.navigate().to("file://" +myHtmlFile);
	  WebElement TextBox = driver.findElement(By.id("inputbox"));  
	  
	  Actions action1 = new Actions(driver); //实例化动作，声明Action行为	 
	  Thread.sleep(3000);
	  action1.doubleClick(TextBox).build().perform(); //将文本框TextBox进行双击的动作操作
	  Thread.sleep(3000);
	  
	  
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
