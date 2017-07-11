package WebDriver_Advanced_Application_Examples;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import BrowserDrivers.GetBrowserDriver;


public class HandleDrawingOnBrowserTesting {
	public WebDriver driver;	
	JavascriptExecutor jse;
	
	String WebUrl="http://www.w3school.com.cn/tiy/loadtext.asp?f=html5_canvas_line";
	//11.19
  @Test
  public void HandleDrawingOnBrowserTest() throws Exception {
	  File captureScreenFile =null;
	  driver.navigate().to(WebUrl);
	  Assert.assertTrue(driver.getPageSource().contains("Your browser does not support the canvas element."));
	  
	  //WebElement Canvas = driver.findElement(By.id("myCanvas"));
	  
	  Thread.sleep(5000); 
	  JavascriptExecutor jse = (JavascriptExecutor) driver;	  
	  
	  jse.executeScript("var canvas = document.getElementById('myCanvas');"
			  + "var cxt = canvas.getContext('2d');"
			  + "cxt.fillStyle = 'blue';"
			  + "cxt.fillRect(0,0,150,150);");
			   
	  //调用Javascript的executeScript执行语句
	  //var canvas = document.getElementByid('myCanvas'); 负责找到myCanvas元素，并给变量canvas
	  //var cxt = canvas.getContext('2d'); 设定画布为2d
	  //cxt.fillStyle = '#FF0000'; 将画布的颜色设定为红色 
	  //cxt.fillRect(0,0,150,150); 在画布上绘制矩形
	  
	  Thread.sleep(5000);
	  captureScreenFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);   
	  FileUtils.copyFile(captureScreenFile, new File("D://Selenium//Screenshots//canvans_pic.jpg"));
	  //将绘制的矩形进行截图，然后保存到指定目录
	  
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
