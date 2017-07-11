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
import org.testng.annotations.Test;

import BrowserDrivers.GetBrowserDriver;


public class AddLike {
	public static WebDriver driver = GetBrowserDriver.GetChromeDriver(); //创建Webdriver对象
	String URL = "http://www.renren.com"; //将人人网网址存入变量URL
	//点赞测试用例
  @Test
  public void PostNewMessageWithPhotosTesting() throws Exception {
	  driver.navigate().to(URL);
	  WebElement LoginName = driver.findElement(By.id("email"));
	  WebElement Password = driver.findElement(By.id("password"));
	  WebElement LoginButton = driver.findElement(By.id("login"));
	  
	  LoginName.clear();
	  Password.clear();
	  LoginName.sendKeys("zhangqiangtest@126.com");  
	  Password.sendKeys("11111111");
	  Thread.sleep(10000); 
	  //这边留10秒主要目的是因为账户过于频繁登陆，所以会出现验证码
	  //验证码的解决目前查阅了许多资料在selenium暂时都没有一个很好的解决方案
	  //这边留10秒也是为了手动输入验证码，10秒后执行后续脚本
	  LoginButton.click();
	  Thread.sleep(5000);
	  driver.findElement(By.xpath("//*[@id='module_40']/div/div/div/p[3]/a")).click(); //因为该账户时间过久，登陆后会提示进一个安全页面，这边用Xpath找到“去人人网”的链接，随后点击
	  Thread.sleep(5000);
	  Assert.assertTrue(driver.getPageSource().contains("王依")); //成功登陆后会进入个人主页，判断页面元素是否包含王依
	
	  WebElement Addlike = driver.findElement(By.xpath("//*[@id='28065581982']/div[3]/a[1]"));
	  Thread.sleep(4000);
	  Addlike.click();
	  Thread.sleep(3000);
	  driver.navigate().refresh(); //刷新页面
	  Thread.sleep(3000);
	  //若是无法通过Assert来验证，则可以加入截图的方法来查看是否成功
	  
	  driver.quit(); //退出浏览器
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
  
  private void SetTabFunction() //该方法用于模拟键盘操作，这里模拟键盘上按下和释放TAB键的操作
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
  

  /*
	点赞测试用例描述
	1.打开人人网 
	2.输入正确的用户名和密码
	3.进入人人网个人首页
	4.找到指定新鲜事内容
	5.点击点赞
	6.刷新页面
	检查点：看点赞的内容是否生效
	7.退出
	
*/

}

