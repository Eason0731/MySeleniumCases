package TestCasesForRenRen;

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


public class PostNewMessageWithMovie {
	public static WebDriver driver = GetBrowserDriver.GetChromeDriver();
	String URL = "http://www.renren.com";
  @Test
  //发布文字新鲜事到带电影链接测试用例
  public void PostNewMessageWithMovieTesting() throws Exception {
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
	  
	  WebElement MovieBtn = driver.findElement(By.id("appPublisherBtnMovie"));
	  MovieBtn.click(); //找到“评电影”按钮并点击它
	  Thread.sleep(3000);
	  SetTabFunction();
	  Thread.sleep(3000);
	  SetCtrlVFunction("小时代");
	  Thread.sleep(3000);
	  SetTabFunction(); //利用Tab键选择默认第一个的电影结果
	  Thread.sleep(3000);
	  
	  WebElement SubmitBtn = driver.findElement(By.xpath("//*[@id='nxContainer']/div/div[5]/div[2]/div/div[1]/div/div/div[3]/div[1]/div[2]")); //提交发布内容
	  Thread.sleep(5000);
	  SubmitBtn.click();
	  Thread.sleep(5000);
	  
	  driver.navigate().refresh(); 
	  Thread.sleep(5000);
	  Assert.assertTrue(driver.getPageSource().contains("谢依霖"));
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
  
 
  
  

  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }

  /*
 	发布文字新鲜事到带电影链接测试用例描述
 	1.打开人人网 
 	2.输入正确的用户名和密码
 	3.进入人人网个人首页
 	4.找到新鲜事下方的“评电影”按钮
 	5.输入指定电影后回车
 	6.找到发布按钮并点击	
 	检查点：在页面元素中找到刚刚发布过的电影链接内容
 	7.退出
 	
 */
}
