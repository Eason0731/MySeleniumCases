package JavaAPI;

import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import BrowserDrivers.GetBrowserDriver;

public class UseCookieTesting {
	public WebDriver driver;
	//10.41
  @Test
  public void UseCookieTest() {
	  driver.get("http://www.sogou.com");
	  
	  Set<Cookie> cookies = driver.manage().getCookies(); //得到当前页面下所有的cookies，并且输出它们所在的域，name，value，有效日期和路径
	  Cookie newcookie = new Cookie("cookiename","cookievalue");
	  System.out.println(String.format("Domain -> name -> value -> expiry -> path"));
	  for (Cookie cook : cookies) //定义变量cook为cookie类型，能够输出以上定义的cookie类型
		  System.out.println(String.format("%s \n -> %s \n -> %s \n -> %s \n -> %s \n",cook.getDomain(),cook.getName(),cook.getValue(),cook.getExpiry(),cook.getPath()));
	   // \n位换行符
	  	//driver.manage().deleteCookieNamed("cookiename"); //删除cookie的name属性实现删除cookie
	  
	  	//driver.manage().deleteCookie(newcookie); //删除cookie对象实现删除cookie
	  	driver.manage().deleteAllCookies(); //删除所有的cookie
	  
	  	try 
	  	{
	  		Thread.sleep(5000);
	  	}
	  	catch (Exception e)
	  	{
	  		e.printStackTrace();
	  	}
  }
  
  @BeforeMethod
  public void beforeMethod() {
	  driver = GetBrowserDriver.GetChromeDriver();
  }

  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }

}
