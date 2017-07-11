package MyTestItem;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class Test2 {
	//WebDriver driver = Methods.BeforeMethodChrome();
	//WebDriver driver = Methods.BeforeMethodIE();
	
	WebDriver driver = GetBrowser.getIE();
	WebDriver driver2 = GetBrowser.getChrome();
	
	String wangzhi = "http://www.baidu.com/";
	String titleName = "百度一下，你就知道";
	

	
  @Test(priority = 0)
  public void CookieTestIE() {
	  driver.navigate().to(wangzhi);
	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); //隐式等待30秒
	  Assert.assertEquals(driver.getTitle(), titleName);
	  //Assert.assertTrue(false, driver.getTitle());
	  Assert.assertEquals(driver.getCurrentUrl(), wangzhi);
	  
	 
  }
  
  @Test(priority = 1)
  public void CookieTestChrome() {
	  driver2.navigate().to(wangzhi);
	  driver2.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); //隐式等待30秒
	  Assert.assertEquals(driver2.getTitle(), titleName);
	  //Assert.assertTrue(false, driver.getTitle());
	  Assert.assertEquals(driver2.getCurrentUrl(), wangzhi);
	  
	 
  }
  
  
  @AfterMethod
  public void AfterMethod() {
	  driver.quit();	
  }
  
  @AfterClass //优先级较低
  public void AfterClass() {
	  driver2.close();	
  }
  

 
}
