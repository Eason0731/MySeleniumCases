package WebDriver_Advanced_Application_Examples;


import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import BrowserDrivers.GetBrowserDriver;



public class HandleHTML5MediaPlayerTesting {
	public WebDriver driver;
	JavascriptExecutor jse;
	String wangzhi = "http://www.w3school.com.cn/tiy/loadtext.asp?f=html5_video_simple";
  @Test
  //11.18
  public void HandleHTML5MediaPlayerTest() throws InterruptedException, IOException {
	  File captureScreenFile = null; //初始化定义页面截图文件的对象，用于后面的屏幕截图存储
	  
	  driver.navigate().to(wangzhi);
	  Thread.sleep(5000);	  
	  Assert.assertTrue(driver.getPageSource().contains("Your browser does not support the video tag."));
	  System.out.println(driver.getPageSource()); //输出页面源代码信息内容
	  
	  jse = (JavascriptExecutor) driver;
	 
	  
	  WebElement MediaPlayer = driver.findElement(By.tagName("video")); //找到播放器
	  
	  
	  String playerURL = (String) jse.executeScript("return arguments[0].currentSrc", MediaPlayer); 
	  //利用executeScript方法可以执行javascript的语法语句,"return arguments[0].currentSrc"为了获取播放器的网址
	  System.out.println(playerURL); //输出浏览器的播放地址
	  Assert.assertEquals(playerURL, "http://www.w3school.com.cn/i/movie.ogg"); //比较输出的视频文件网址是否一致
	  
	  Double videoDuration =  (Double) jse.executeScript("return arguments[0].duration", MediaPlayer);
	  //利用executeScript方法可以执行javascript的语法语句,"return arguments[0].duration"为了获取播放视频的时间	  
	  System.out.println(videoDuration.intValue()); //因为获取的时间是Double类型，为了输出，将其改为int类型输出
	  Thread.sleep(5000); //等待5秒为了让视频加载
	  
	  jse.executeScript("return arguments[0].play()", MediaPlayer); //利用executeScript方法可以执行javascript的语法语句,"return arguments[0].play()" 能够点击视频并且播放
	  Thread.sleep(1000); //播放1秒
	  
	  jse.executeScript("return arguments[0].pause()", MediaPlayer); //利用executeScript方法可以执行javascript的语法语句,"return arguments[0].pause()" 能够暂停视频
	  Thread.sleep(3000); //暂停3秒看是否生效
	  
	  
	  captureScreenFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);   
	  FileUtils.copyFile(captureScreenFile, new File("D://Selenium//Screenshots//video_pic.jpg"));
	  //将暂停时候的视频进行截图，然后保存到指定目录
	  
	  
	  
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
