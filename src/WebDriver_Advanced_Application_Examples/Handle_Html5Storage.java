package WebDriver_Advanced_Application_Examples;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import BrowserDrivers.GetBrowserDriver;


public class Handle_Html5Storage {
	public WebDriver driver;
	String localStorage = "http://www.w3school.com.cn/tiy/loadtext.asp?f=html5_webstorage_local";
	  
    String SessionStorage = "http://www.w3school.com.cn/tiy/loadtext.asp?f=html5_webstorage_session";
    JavascriptExecutor jse; 
    //11.20
  @Test
  public void Html5localStorageTest() throws InterruptedException {
	 driver.navigate().to(localStorage);
	
	 jse = (JavascriptExecutor) driver;
	 String lastname = (String) jse.executeScript("return localStorage.lastname;"); //获取存储在localStorage中的lastname的值
	 
	 Assert.assertEquals(lastname, "Smith"); //判断lastname是不是叫Smith
	 Thread.sleep(5000);
	 jse.executeScript("localStorage.clear()"); //清除localStorage的值
	  
  }
  
  @Test
  public void Html5SessionStorageTest() throws Exception {
	  driver.navigate().to(SessionStorage);
	 

	  jse = (JavascriptExecutor) driver;
	  String lastname = (String) jse.executeScript("return sessionStorage.lastname;"); //获取存储在sessionStorage中的lastname的值
	 
    	Assert.assertEquals(lastname, "Smith"); //判断lastname是不是叫Smith
    	Thread.sleep(5000);
    	jse.executeScript("sessionStorage.clear()"); //清除sessionStorage的值
    
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
