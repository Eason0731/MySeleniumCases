package WebDriver_Advanced_Application_Examples;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import BrowserDrivers.GetBrowserDriver;


public class HandleScollBarTesting {
	public WebDriver driver;
	JavascriptExecutor jse;
  
  //11.8
  @Test(priority = 1) //Means this test will be first executed
  public void ScollingtoBottom() throws Exception {
	 ((JavascriptExecutor) driver).executeScript("window.scrollTo(0,document.body.scrollHeight)");
	 //使用Javascript的scrollTo函数和0,document.body.scrollHeight参数，并将页面拖动至最下方
	 Thread.sleep(3000);
  }
  
 
  @Test(priority = 2) //Means this test will be second executed
  public void ScollingtoElement() throws Exception
  {
	  //driver.switchTo().frame("main_frame"); //找到id为main_frame的frame页中进行并进入该页 (没找到，所以Failed)
	  WebElement name = driver.findElement(By.xpath("/html/body/div/div[2]/div[2]/div[3]/div[2]/div[1]/h3/a")); //利用xpath路径找到“电视剧”的元素
	  ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();",name); //利用scrollIntoView()函数将其滚动至该页面
	  Thread.sleep(3000);
  }
  
  @Test(priority = 3) //Means this test will be third executed
  public void ScollingtoByCoordinate() throws Exception
  {
	  ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,1000)"); //使用Javascript的scrollBy函数，让滚动条下滑1000个元素
	  Thread.sleep(3000);
	  
  }
  
  
  @BeforeMethod
  public void beforeMethod() {
	 driver = GetBrowserDriver.GetChromeDriver();
	 String URL = "http://v.sogou.com";
	 driver.navigate().to(URL);
  }

  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }

}
