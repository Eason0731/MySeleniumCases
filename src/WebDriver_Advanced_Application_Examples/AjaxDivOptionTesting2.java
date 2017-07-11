package WebDriver_Advanced_Application_Examples;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import BrowserDrivers.GetBrowserDriver;


public class AjaxDivOptionTesting2 {
	public WebDriver driver;
	String URL = "http://www.sogou.com";

	//11.2
  @Test
  public void AjaxDivOptionTesting() throws Exception {
	  driver.navigate().to(URL);
	  WebElement SearchTextBox = driver.findElement(By.id("query"));
	  SearchTextBox.click();
	  Thread.sleep(5000);
	  WebElement SuggestList = driver.findElement(By.xpath("/html/body/div/div[5]/form/span[1]/div/div[1]/ul/li[3]"));
	  //只将SuggestList中的第三条选中进行点击。这里就不需要新建实例化数组了，直接实例化新对象即可
	  //Xpath的路径可以用FireFox浏览器的Xpath插件进行右键复制xpath的path
	  SuggestList.click();
	  Thread.sleep(6000);
	  
	  Assert.assertEquals(driver.getTitle(), "papi酱疑遭封杀 - 搜狗搜索");
	  
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
