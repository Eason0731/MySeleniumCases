package WebDriver_Advanced_Application_Examples;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import BrowserDrivers.GetBrowserDriver;


public class AjaxDivOptionTesting {
	public WebDriver driver;
	JavascriptExecutor Jse;
  //11.2
  @Test
  public void AjaxDivOptionTest() throws Exception {
	  String URL = "http://www.sogou.com";
	  driver.navigate().to(URL);
	  WebElement SearchTextBox = driver.findElement(By.id("query"));
	  SearchTextBox.click();
	  //Thread.sleep(5000);
	  
	  //新建数组SuggestList并存储搜索框存储的下拉列表框的内容
	  List<WebElement> SuggestList = driver.findElements(By.xpath("/html/body/div/div[5]/form/span[1]/div/div[1]/ul"));
	  
	  for (WebElement yuansu: SuggestList)
	  {
		  if (yuansu.getText().contains("papi酱"))
		  {
			 yuansu.click();
			 //Assert.assertEquals(driver.getTitle(), "papi酱疑遭封杀 - 百度搜索");
			 break;
		  }
		  
		  else 
		  { 
			  System.out.print("没找到指定内容");}
		  
		 // System.out.print(yuansu.getText()); 读取浮动窗口的所有内容并显示
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
