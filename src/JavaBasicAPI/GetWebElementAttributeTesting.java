package JavaAPI;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import BrowserDrivers.GetBrowserDriver;

//10.27
public class GetWebElementAttributeTesting {
	public WebDriver driver;
  @Test
  public void getWebElementAttributeTest() throws InterruptedException {
	  driver.get("http://www.baidu.com");
	  String text="比利时遭遇恐怖袭击";
	  
	  WebElement SearchBox = driver.findElement(By.id("kw")); //将搜索框的id实例化
	  
	  SearchBox.sendKeys(text); 
	  
	  String innerText = SearchBox.getAttribute("value"); //调用attribute方法，并获取搜索框value的值（就是搜索文字的内容）
	  Thread.sleep(3000);
	  
	  Assert.assertEquals(innerText, "比利时遭遇恐怖袭击");
	  
	  
	  
	  
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
