package MyTestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import BrowserDrivers.GetBrowserDriver;

public class Login {
	//public static WebDriver driver; //创建Webdriver对象
	String URL = "http://www.renren.com"; //将人人网网址存入变量URL
	public static WebDriver driver = GetBrowserDriver.GetChromeDriver();
  @Test //为测试方法
  //登陆测试用例
  public void LoginTesting() throws Exception {
	  driver.navigate().to(URL);
	  Thread.sleep(5000); //等待时间5秒
	  Assert.assertTrue(driver.getTitle().contains("人人网")); //判断打开网址的标题是否包含人人网
	  
	  WebElement LoginName = driver.findElement(By.id("email")); //定义WebElement对象，找到用户名框并存入变量中
	  WebElement Password = driver.findElement(By.id("password")); //定义WebElement对象，找到密码框并存入变量中
	  WebElement LoginButton = driver.findElement(By.id("login")); //定义WebElement对象，找到登录框并存入变量中
	  
	  LoginName.clear(); //将用户名框的内容清空
	  Password.clear(); //将密码框的内容清空
	  LoginName.sendKeys("zhangqiangtest@126.com"); //在用户名框内输入用户名
	  Password.sendKeys("12345678"); //在密码框内输入密码
	  LoginButton.click(); //点击登陆按钮
	  Thread.sleep(5000); //等待5秒
	  Assert.assertTrue(driver.getPageSource().contains("您的用户名和密码不匹配"));//因为这边测试是错误的用户名和密码登陆，所以找到页面元素是否包含"您的用户名和密码不匹配"
	  
	  LoginToRenRen(); //调用正确用户名密码登陆的方法LoginToRenRen()
	  
	  driver.quit();
	  
  }
  
  public static void LoginToRenRen() throws Exception{
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
	  
	 
	  
  }
  
 
 
  
  /*
  	登陆测试用例描述
  	1.打开人人网 
  	检查点：验证是否为人人网
  	2.清除用户名和密码框中的内容
  	3.输入错误的用户名和密码
  	检查点：应提示用户名或密码错误的信息
  	4.清除用户名和密码框中的内容
  	5.输入正确的用户名和密码
  	6.进入人人网个人首页
  	检查点：是否登陆成功
  	7.退出
  	
  */

}
