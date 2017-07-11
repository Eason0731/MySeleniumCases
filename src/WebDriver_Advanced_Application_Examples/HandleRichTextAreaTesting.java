package WebDriver_Advanced_Application_Examples;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import BrowserDrivers.GetBrowserDriver;

public class HandleRichTextAreaTesting {
	public WebDriver driver;
  @Test
  //11.12
  public void HandleRichTextAreaTest() throws Exception {
	  String URL = "http://mail.sohu.com";
	  driver.navigate().to(URL);
	  driver.findElement(By.id("username")).sendKeys("fosterwu");
	  driver.findElement(By.id("password")).sendKeys("1111");
	  driver.findElement(By.id("login_img")).click();
	  
	  WebDriverWait wait = new WebDriverWait (driver,30);
	  wait.until(ExpectedConditions.presenceOfElementLocated(By.id("write_mail")));
	  driver.findElement(By.id("close_alert_ad")).click(); //关闭广告窗口
	  //Assert.assertTrue(driver.getPageSource().contains("您好：fosterwu"));
	  
	  WebElement WriteButton = driver.findElement(By.id("write_mail"));
	  WriteButton.click();
	  
	  driver.findElement(By.id("compose.wto_f")).sendKeys("fosterwu@sohu.com"); //输入收件人邮箱
	  //driver.findElement(By.id("compose.wto_f")).sendKeys("lonlon29@qq.com");
	  PressTabKey(); //输入完收件人邮箱后需要做一个Tab操作，以确保收件人填写进表格了
	  Thread.sleep(6000);
	  //PressTabKey();
	  driver.findElement(By.id("compose.subject")).sendKeys("Selenium测试邮件"); //输入邮件标题内容
	  Thread.sleep(6000);
	  //SetCtrlVFunction("吴老，你好！");
	  PressTabKey();
	  SetCtrlVFunction("正在学习Selenium Webdriver宝典的Robot和处理富文本框的案例，非常实用！"); //输入正文内容（因为这里富文本框不能通过元素定位获取到了，所以采用Tab+黏贴的方法）
	  //SetCtrlVFunction("如果你看到了这封邮件，说明了你已经成功的会利用Selenium自动化脚本来发送邮件了，基本处于初级之上，中级未稳的水平。加油！");
	  //PressEnterKey();
	  Thread.sleep(6000);
	  driver.findElement(By.xpath("//input[@value='发 送']")).click(); //点击发送按钮进行邮件的发送
	  Thread.sleep(6000);
	  Assert.assertTrue(driver.getPageSource().contains("发送成功"));
	  Thread.sleep(6000);
  }
  
  private void SetCtrlVFunction(String content)
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
  
  private void PressTabKey()
  {
	  Robot rbt = null;
	  try {
		  rbt = new Robot();
	  }
	  catch (AWTException e)
	  {
		  e.printStackTrace();
	  }
	  
	  rbt.keyPress(KeyEvent.VK_TAB);
	  rbt.keyRelease(KeyEvent.VK_TAB);
  }
  
  private void PressEnter()
  {
	  Robot rbt = null;
	  try {
		  rbt = new Robot();
	  }
	  catch (AWTException e)
	  {
		  e.printStackTrace();
	  }
	  
	  rbt.keyPress(KeyEvent.VK_ENTER);
	  rbt.keyRelease(KeyEvent.VK_ENTER);
  }
  
  /*
  private void PressEnterKey()
  {
	  Robot rbt = null;
	  try {
		  rbt = new Robot();
	  }
	  catch (AWTException e)
	  {
		  e.printStackTrace();
	  }
	  
	  rbt.keyPress(KeyEvent.VK_Enter);
	  rbt.keyRelease(KeyEvent.VK_Enter);
  }
  */
  @BeforeMethod
  public void beforeMethod() {
	  driver = GetBrowserDriver.GetChromeDriver();
	
	 
  }

  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }

}
