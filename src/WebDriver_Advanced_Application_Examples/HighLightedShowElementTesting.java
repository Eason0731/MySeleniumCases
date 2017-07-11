package WebDriver_Advanced_Application_Examples;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import BrowserDrivers.GetBrowserDriver;


public class HighLightedShowElementTesting {
	public WebDriver driver;
  @Test
  //11.14
  public void HighLightedShowElementTest() throws Exception {
	  WebElement SearchBox = driver.findElement(By.id("query"));
	 
	  highlightElement (SearchBox);
	  Thread.sleep(3000);
	  SearchBox.sendKeys("Hello Selenium");
	  
	  WebElement SearchButton = driver.findElement(By.id("stb"));
	  highlightElement2 (SearchBox);
	  highlightElement3 (SearchButton);
	  Thread.sleep(3000);
	  SearchButton.click();
	  Thread.sleep(3000);
	  WebElement SearchBox2 = driver.findElement(By.id("upquery")); 
	  highlightElement2 (SearchBox2);
	  Thread.sleep(3000);

	  Assert.assertEquals(driver.getTitle(), "Hello Selenium - 搜狗搜索");
  }
  
  private void highlightElement(WebElement element) { //高亮显示正在操作元素的方法
	// TODO Auto-generated method stub
	JavascriptExecutor jse = (JavascriptExecutor) driver;
	jse.executeScript("arguments[0].setAttribute('style',arguments[1]);", element, "border-color: blue; border-width: 3px;");
	//jse.executeScript("arguments[0].setAttribute('style',arguments[1]);", element, "background-color: blue;");
	
}
  
  private void highlightElement2(WebElement element) { //高亮显示正在操作元素的方法
		// TODO Auto-generated method stub
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].setAttribute('style',arguments[1]);", element, "");
	}
  
  private void highlightElement3(WebElement element) { //高亮显示正在操作元素的方法
		// TODO Auto-generated method stub
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].setAttribute('style',arguments[1]);", element, "background-color:rgba(130, 240, 128, 0.98)");
	}
  
@BeforeMethod
  public void beforeMethod() {
	  driver = GetBrowserDriver.GetChromeDriver();
	  String Url = "http://www.sogou.com";
	  driver.navigate().to(Url);
  }

  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }

}
