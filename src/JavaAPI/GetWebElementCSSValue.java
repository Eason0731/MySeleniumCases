package JavaAPI;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import BrowserDrivers.GetBrowserDriver;

//10.28
public class GetWebElementCSSValue {
	public WebDriver driver;
  @Test
  public void getWebElementCSSValueTesting() throws InterruptedException {
	  driver.get("http://www.baidu.com");
	  
	  WebElement SearchButton = driver.findElement(By.id("su")); //实例化搜索按钮
	  WebElement SearchText = driver.findElement(By.id("kw"));  //实例化搜索文本框
	  
	  String Buttonheight = SearchButton.getCssValue("height"); //用getCssValue获取按钮的高度
	  System.out.println("按钮的高度为"+ Buttonheight);
	  Assert.assertEquals(Buttonheight, "36px");
	  
	  String Buttonwidth = SearchButton.getCssValue("width"); //用getCssValue获取按钮的宽度
	  System.out.println("按钮的宽度为"+ Buttonwidth);
	  Assert.assertEquals(Buttonwidth, "100px");
	  Thread.sleep(3000);
	  
	  String Textheight = SearchText.getCssValue("height"); //用getCssValue获取文本框的高度
	  System.out.println("文本框的高度为"+ Textheight);
	  Assert.assertEquals(Textheight, "22px");
	  
	  String Textwidth = SearchText.getCssValue("width"); //用getCssValue获取文本框的宽度
	  System.out.println("文本框的宽度为"+ Textwidth);
	  Assert.assertEquals(Textwidth, "500px");
	  Thread.sleep(3000);
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
