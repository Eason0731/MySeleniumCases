package TestCasesForRenRen;

import java.awt.image.BufferedImage;
import java.awt.image.DataBuffer;
import java.io.File;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import BrowserDrivers.GetBrowserDriver;



public class CaptureImageonIndex {
	public static WebDriver driver = GetBrowserDriver.GetChromeDriver();
	String URL="http://www.renren.com";
  @Test
  //人人登陆主页截图对比测试用例
  public void CaptureImageonIndexTesting() throws Exception {
	  driver.navigate().to(URL);
	  WebElement LoginName = driver.findElement(By.id("email"));
	  WebElement Password = driver.findElement(By.id("password"));
	  WebElement LoginButton = driver.findElement(By.id("login"));
	  
	  LoginName.clear();
	  Password.clear();
	  LoginName.sendKeys("zhangqiangtest@126.com");  
	  Password.sendKeys("11111111");
	  Thread.sleep(10000);
	  LoginButton.click();
	  Thread.sleep(5000);
	  driver.findElement(By.xpath("//*[@id='module_40']/div/div/div/p[3]/a")).click(); //因为该账户时间过久，登陆后会提示进一个安全页面，这边用Xpath找到“去人人网”的链接，随后点击
	  Thread.sleep(5000);
	  Assert.assertTrue(driver.getPageSource().contains("王依")); //成功登陆后会进入个人主页，判断页面元素是否包含王依
	  
	  Thread.sleep(3000);
	  CaptureImageMethod();
	  
  }
  
  	public static void CaptureImageMethod() throws Exception{
  	  File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
  	  Thread.sleep(5000);
  	  
  	  FileUtils.copyFile(screenshot, new File("D://Selenium//Screenshots//RenRen_index_actual.jpg"));//对人人首页进行截屏操作
  	  
  	  File fileInput = new File("D://Selenium//Screenshots//RenRen_index_excepted.jpg");
  	  File fileOutput = new File ("D://Selenium//Screenshots//RenRen_index_actual.jpg"); //生成了两个文件对象，一个是期望图片，另一个是实际测试过程中产生的图片
  	  
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
  
  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }

  /* 人人网截图对比测试
   1.打开人人网首页
   2.输入正确的用户名和密码并登陆
   3.对登陆的主页进行截图
   4.与本地存放的图片进行对比
      检查点：两张图片是否一致
   5.退出
 */
}
