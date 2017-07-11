package JavaAPI;

import java.io.File;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import BrowserDrivers.GetBrowserDriver;

public class HandleFrameByPageSourceTesting {
	 public WebDriver driver;
	 //10.39
  @Test
  public void HandleFrameByPageSourceTest() throws InterruptedException {
	 File myHtml = new File ("html/10.38/frameset.html");
	 String myHtmlFile = myHtml.getAbsolutePath(); //getAbsolutePath()返回抽象路径名的绝对路径名字符串
	 driver.get("file://" +myHtmlFile);
	 Thread.sleep(6000);
	 List<WebElement> frames = driver.findElements(By.tagName("frame"));
	 
	 for( WebElement frame:frames) //进入Frame
	 {
		 driver.switchTo().frame(frame); 
		 
		if( driver.getPageSource().contains("frame")) //判断每个frame的HTML源码中是不是包含frame
		{  
			WebElement frm = driver.findElement(By.xpath("//p"));
			Thread.sleep(6000);
			Assert.assertEquals("This is Left side Frame",frm.getText()); //判断左边Frame的文字是否匹配
			Assert.assertEquals("This is Middle side Frame",frm.getText()); //判断中间Frame的文字是否匹配
			Assert.assertEquals("This is Right side Frame",frm.getText()); //判断右边Frame的文字是否匹配
			
			break; //找出指定的Frame退出for循环
		}
		
		
		else
		{
			driver.switchTo().defaultContent(); //转换回默认主页面
		}
		
		driver.switchTo().defaultContent();  //转换回默认主页面
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
