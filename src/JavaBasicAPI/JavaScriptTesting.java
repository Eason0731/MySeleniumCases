package JavaAPI;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import BrowserDrivers.GetBrowserDriver;


public class JavaScriptTesting {
	public WebDriver driver;
	
	//10.21
  @Test
  public void JavaScriptTest() throws InterruptedException {
	  driver.get("http://www.baidu.com");
	  JavascriptExecutor js = (JavascriptExecutor) driver; //声明一个Javascript执行器对象
	  
	  String title =(String) js.executeScript("return document.title");//调用执行器对象的ExecutorScprit方法来执行脚本JavaScript脚本 return document.title
	  
	  Assert.assertEquals("百度一下，你就知道", title); //用断言Assert来判断title是否符合预期文字
	  
	  String ButtonText = (String) js.executeScript("var ButtonName = document.getElementById('su');return ButtonName.value" );
	  //document.getElementById('su')是JavaScript代码，表示获取页面的搜索按钮对象 
	  //return button.value 表示返回搜索按钮上的文字
	  
	  System.out.println(ButtonText);
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
