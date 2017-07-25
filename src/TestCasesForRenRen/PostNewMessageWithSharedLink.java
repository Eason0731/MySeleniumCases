package MyTestCases;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import BrowserDrivers.GetBrowserDriver;



public class PostNewMessageWithSharedLink {
	public static WebDriver driver = GetBrowserDriver.GetChromeDriver();
	String URL = "http://www.renren.com";
	//发布文字新鲜事到带分享链接测试用例
	//小Tips:若遇到网页打不开，可以在标签页上右键"重新加载"，而脚本会继续执行
  @Test
  public void PostNewMessageWithSharedLinkTesting() throws Exception {
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
	  driver.navigate().refresh(); 
	  
	  
	  WebElement TextArea = driver.findElement(By.className("textarea-textzone"));
	  TextArea.click();
	  WebElement ContentArea = driver.findElement(By.xpath("//*[@id='nxContainer']/div/div[5]/div[2]/div/div[1]/div/div/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]"));
	  ContentArea.click();
	  
	  Thread.sleep(3000);
	  SetTabFunction();  //按下和释放Tab键
	  Thread.sleep(3000);
	  SetTabFunction(); //按两次切换到“链接”
	  Thread.sleep(3000);
	  SetEnterFunction(); //按下回车激活“分享链接按钮”
	  Thread.sleep(3000);
	  SetCtrlVFunction("http://www.tudou.com");
	  Thread.sleep(5000);
	  SetEnterFunction(); //按下回车已确定链接
	  Thread.sleep(3000);
	  
	  WebElement SubmitBtn = driver.findElement(By.xpath("//*[@id='nxContainer']/div/div[5]/div[2]/div/div[1]/div/div/div[3]/div[1]/div[2]")); //提交发布内容
	  Thread.sleep(5000);
	  SubmitBtn.click();
	  Thread.sleep(5000);
	  
	  driver.navigate().refresh(); 
	  Assert.assertTrue(driver.getPageSource().contains("土豆_每个人都是生活的导演"));
	 
  }
  
  private void SetCtrlVFunction(String content) //该方法将文字内容传递进来并存储到粘贴板上，再黏贴出来
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
  
  private void SetSpaceFunction() //该方法用于模拟键盘操作，这里模拟键盘上按下和释放SPACE键的操作
  {
	  Robot rbt1 = null;
	  try
	  {
		  rbt1 = new Robot();
	  }
	  catch (AWTException e){
		  e.printStackTrace();
	  }
	  
	  rbt1.keyPress(KeyEvent.VK_SPACE); //按下SPACE空格键
	  rbt1.keyRelease(KeyEvent.VK_SPACE); //释放SPACE空格键
	  
  }
  
  private void SetBackSpaceFunction() //该方法用于模拟键盘操作，这里模拟键盘上按下和释放BACKSPACE键的操作
  {
	  Robot rbt1 = null;
	  try
	  {
		  rbt1 = new Robot();
	  }
	  catch (AWTException e){
		  e.printStackTrace();
	  }
	  
	  rbt1.keyPress(KeyEvent.VK_BACK_SPACE); //按下BACKSPACE空格键
	  rbt1.keyRelease(KeyEvent.VK_BACK_SPACE); //释放BACKSPACE空格键
	  
  }
  
  private void SetTabFunction() //该方法用于模拟键盘操作，这里模拟键盘上按下和释放Tab键的操作
  {
	  Robot rbt1 = null;
	  try
	  {
		  rbt1 = new Robot();
	  }
	  catch (AWTException e){
		  e.printStackTrace();
	  }
	  
	  rbt1.keyPress(KeyEvent.VK_TAB); //按下TAB空格键
	  rbt1.keyRelease(KeyEvent.VK_TAB); //释放TAB空格键
	  
  }
  
  private void SetEnterFunction() //该方法用于模拟键盘操作，这里模拟键盘上按下和释放ENTER键的操作
  {
	  Robot rbt1 = null;
	  try
	  {
		  rbt1 = new Robot();
	  }
	  catch (AWTException e){
		  e.printStackTrace();
	  }
	  
	  rbt1.keyPress(KeyEvent.VK_ENTER); //按下ENTER空格键
	  rbt1.keyRelease(KeyEvent.VK_ENTER); //释放ENTER空格键
	  
  }
  


  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }
  
  /*
	发布文字新鲜事到带分享链接测试用例描述
	1.打开人人网 
	2.输入正确的用户名和密码
	3.进入人人网个人首页
	4.找到发布新鲜事的文本框
	5.输入指定文字
	6.切换到“链接”按钮
	7.输入土豆网网址回车并确定
	8.找到发布按钮并点击	
	检查点：在页面元素中找到刚刚发布过的新鲜事文字内容
	9.退出
	
*/

}
