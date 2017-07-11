package MyTestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import BrowserDrivers.GetBrowserDriver;


public class QianDao {
	public static WebDriver driver = GetBrowserDriver.GetChromeDriver();
	String URL = "http://www.renren.com";
	//签到测试用例
  @Test
  public void QianDaoTesting() throws Exception {
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
	  //driver.navigate().refresh(); 
	  //Assert.assertTrue(driver.getPageSource().contains("你今天攒过了，尝试每半小时刷新获取更多人品吧"));
	  
	  WebElement QianDaoButton = driver.findElement(By.id("assembleBtn"));
	  QianDaoButton.click();
	  Thread.sleep(5000);
	  
	  
	  if (driver.getPageSource().contains("恭喜您获得了")){
		  System.out.println("签到成功");
	  }
	  
	  else { System.out.println("今日已签到过");}
	  
	  //System.out.println(driver.findElement(By.xpath("//*[@id='fortune_win']/div[5]/span")).getText());
	  
  }
  

  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }

  
  /*
	签到测试用例描述
	1.打开人人网 
	2.输入正确的用户名和密码
	3.进入人人网个人首页
	4.点击签到按钮
	检查点：如果页面上显示“你今天攒过了”，则返回已经签到过了，
	否则返回签到成功
	5.退出
	
*/
}
