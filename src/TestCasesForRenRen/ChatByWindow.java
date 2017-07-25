package TestCasesForRenRen;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import BrowserDrivers.GetBrowserDriver;


public class ChatByWindow {
	public static WebDriver driver = GetBrowserDriver.GetChromeDriver();
	String URL = "http://www.renren.com";
	//人人网小窗聊天测试用例
  @Test
  public void ChatByWindowTesting() throws Exception {
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
	  ScollingonPage(); //调用方法将页面下滑500个元素
	  Thread.sleep(3000);
	  
	  driver.findElement(By.id("wp_b_r_chat_630000001")).click(); //找到人人助手聊天框，并打开
	  Thread.sleep(3000);
	  SetCtrlFunction("我认为Selenium是一个很不错的Web页面测试方法"); //输入聊天内容
	  Thread.sleep(3000);
	  SetCTRLandEnterFunction(); //按下CTRL+Enter键
	  Thread.sleep(3000);
	  
	  CaptureImageMethod(); //调用给屏幕截图的方法
	  Thread.sleep(3000);
	  
  }
  
  private void SetCtrlFunction(String content) //该方法将文字内容传递进来并存储到粘贴板上，再黏贴出来
  {
	  StringSelection ssl = new StringSelection (content);  //声明StringSelection对象，并使用函数的content进行实例化操作
	  Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ssl, null); //使用Toolkit对象的setContents方法将字符串放到剪切板上
	  Robot rbt = null;
	  try {
		  rbt = new Robot();
	  }
	  catch (AWTException e)
	  {
		  e.printStackTrace();
	  }
	  
	  rbt.keyPress(KeyEvent.VK_CONTROL);
	  rbt.keyPress(KeyEvent.VK_V);
	  rbt.keyRelease(KeyEvent.VK_CONTROL);
	  rbt.keyRelease(KeyEvent.VK_CONTROL);
  }
  
  private void SetCTRLandEnterFunction() //该方法用于模拟键盘操作，这里模拟键盘上按下和释放CTRL+ENTER键的操作
  {
	  Robot rbt1 = null;
	  try
	  {
		  rbt1 = new Robot();
	  }
	  catch (AWTException e){
		  e.printStackTrace();
	  }
	  
	  rbt1.keyPress(KeyEvent.VK_CONTROL); //按下ctrl键
	  rbt1.keyPress(KeyEvent.VK_ENTER);//按下空格键
	  rbt1.keyRelease(KeyEvent.VK_CONTROL); //释放CTRL键
	  rbt1.keyRelease(KeyEvent.VK_ENTER); //释放空格键
	  
  }
  
  public void CaptureImageMethod() {
	  //新建File，截图
	  File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	  
	  try
	  {
		  FileUtils.copyFile(scrFile,new File("D:\\Selenium\\Screenshots\\ChatOnRenRen.png"));
	  }
	  
	  catch(Exception e)
	  {
		  System.out.println(e);
	  }
  
  }
  
  public void ScollingonPage() throws Exception
  {
	  ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,500)"); //使用Javascript的scrollBy函数，让滚动条下滑500个元素
	  Thread.sleep(3000);
	  
  }
  

  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }

  /* 人人网小窗聊天测试用例描述
  1.打开人人网首页
  2.输入正确的用户名和密码并登陆
  3.找到“人人助手”并打开
  4.输入聊天内容并发送
  5.截图保存看是否正确
  6.退出
*/
}
