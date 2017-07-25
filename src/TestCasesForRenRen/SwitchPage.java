package TestCasesForRenRen;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import BrowserDrivers.GetBrowserDriver;


public class SwitchPage {
	public static WebDriver driver = GetBrowserDriver.GetChromeDriver();
	String URL="http://www.renren.com";
	//切换页面测试用例
  @Test
  public void SwitchPageTesting() throws Exception {
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
	  
	  Thread.sleep(2000);
	  String CurrentURL = driver.getCurrentUrl();
	  
	  driver.findElement(By.linkText("原创内容")).click(); //切换至原创内容页面
	  Thread.sleep(3000);
	  Assert.assertEquals(CurrentURL+"/newsfeed/origin", driver.getCurrentUrl());
	  System.out.println(CurrentURL+"/newsfeed/origin");
	  Thread.sleep(3000);
	  
	  Thread.sleep(3000);
	  driver.findElement(By.linkText("个人主页")).click(); //切换至个人主页页面
	  Thread.sleep(3000);
	  Assert.assertEquals(CurrentURL+"/profile", driver.getCurrentUrl());
	  System.out.println(CurrentURL+"/profile");
	  Thread.sleep(3000);
	  
	  Thread.sleep(3000);
	  driver.findElement(By.linkText("我的相册")).click(); //切换至我的相册页面
	  Thread.sleep(3000);
	  Assert.assertEquals("http://photo.renren.com/photo/255329305/albumlist/v7#", driver.getCurrentUrl());
	  Thread.sleep(3000);
	  
	  driver.navigate().back();
	  Thread.sleep(2000);
	  driver.navigate().back();
	  Thread.sleep(2000);
	  driver.navigate().back();
	  Thread.sleep(2000); //回退三次返回主页
	  
	  Assert.assertEquals(CurrentURL, "http://www.renren.com/255329305");
	  Thread.sleep(2000);
  }
  

  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }
  
  /* 切换页面截图对比测试
  1.打开人人网首页
  2.输入正确的用户名和密码并登陆
  3.进入“原创内容”页面
    检查点：URL地址是否正确
  4.进入“个人主页”页面
    检查点：URL地址是否正确
  5.进入“我的相册”页面
    检查点：URL地址是否正确
  6.退回3次，回到“主页”页面
    检查点：URL地址是否正确
  7.退出
*/
}
