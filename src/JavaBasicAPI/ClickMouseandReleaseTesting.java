package JavaAPI;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import BrowserDrivers.GetBrowserDriver;

public class ClickMouseandReleaseTesting {
	public WebDriver driver;
	//10.26
  @Test
  public void ClickMouseandReleaseTest() throws Exception {
	  File myHtml = new File ("html/10.26.html");
	  String myHtmlFile = myHtml.getAbsolutePath(); //getAbsolutePath()返回抽象路径名的绝对路径名字符串
	  driver.get("file://" +myHtmlFile);
	  
	  WebElement div1 =driver.findElement(By.id("div1")); //要找到id为div1的div区域，若是找input元素只能clickandhold，release的时候会因为找不到元素而报错
	  
	  Actions action1 = new Actions(driver);
	  
	  action1.clickAndHold(div1).perform(); //利用方法clickandhold实现长按鼠标左键
	  System.out.println(div1.getText());
	  Thread.sleep(5000); //停留5秒
		  
	  action1.release(div1).perform(); //利用release方法将鼠标松开
	  System.out.println(div1.getText());
	  Thread.sleep(3000); //停留3秒
	 
	  
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
