package WebDriver_Advanced_Application_Examples;

import java.awt.image.BufferedImage;
import java.awt.image.DataBuffer;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import BrowserDrivers.GetBrowserDriver;


public class CaptureImageTesting {
	public WebDriver driver;
	String URL=" http://www.baidu.com";
  @Test
  //11.13
  public void CaptureImageTest() throws IOException,InterruptedException {	  
	  Thread.sleep(3000);
	  driver.navigate().to(URL);
	  File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	  Thread.sleep(5000);
	  
	  FileUtils.copyFile(screenshot, new File("D://Selenium//Screenshots//Baidu_index_actual.jpg"));//对百度首页进行截屏操作
	  
	  File fileInput = new File("D://Selenium//Screenshots//Baidu_index_excepted.jpg");
	  File fileOutput = new File ("D://Selenium//Screenshots//Baidu_index_actual.jpg"); //生成了两个文件对象，一个是期望图片，另一个是实际测试过程中产生的图片
	  
	  /*以下的方法是比较两张图片是否一致，通过计算像素大小*/
	  
	  BufferedImage bufileInput = ImageIO.read(fileInput);
	  DataBuffer dafileInput = bufileInput.getData().getDataBuffer();
	  int sizefileInput = dafileInput.getSize();
	  
	  BufferedImage bufileOutput = ImageIO.read(fileOutput);
	  DataBuffer dafileOutput = bufileOutput.getData().getDataBuffer();
	  int sizefileOutput = dafileOutput.getSize();
	  
	  Boolean matchFlag = true;
	  if(sizefileInput == sizefileOutput){
		  for(int j =0 ; j<sizefileInput ; j++){
			  if(dafileInput.getElem(j)!= dafileOutput.getElem(j)){
				  matchFlag = false;
				  break;
			  }
		  }
	  }
	  
	  else {
		  matchFlag = false;
	  Assert.assertTrue(matchFlag, "测试过程中的截图和期望的截图不一致!");
	  }
  }
  @BeforeMethod
  public void beforeMethod() throws Exception {
	  driver = GetBrowserDriver.GetChromeDriver();
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); //等待10秒
  }

  @AfterMethod
  public void afterMethod() throws Exception {
	  driver.quit();
  }

}
