package JavaAPI;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import BrowserDrivers.GetBrowserDriver;

public class DragPageElementTesting {
	//10.22
	public WebDriver driver;
  @Test
  public void dragPageElement() throws InterruptedException {
	  driver.get("http://jqueryui.com/resources/demos/draggable/scroll.html");
	  
	  WebElement draggable = driver.findElement(By.id("draggable"));
	  //在也面上找到id为draggtable的对象
	  
	  for (int mc=0; mc<5  ; mc++) //向下拖动10个元素
	  {
		  new Actions (driver) .dragAndDropBy(draggable, 0, 10).build().perform(); //dragAndDropBy解释：(元素, (x轴), （y轴）)
		  Thread.sleep(3000);
	  }
	  
	  for (int alo=0 ; alo<5; alo++) //向右拖动10个元素
	  {
		  new Actions (driver).dragAndDropBy(draggable, 10, 0).build().perform();
		  Thread.sleep(3000);
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
