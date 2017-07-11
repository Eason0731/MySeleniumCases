package JavaAPI;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import BrowserDrivers.GetBrowserDriver;

public class OperateBrowser {
	public WebDriver driver;
	
	//10.5
  @Test
  public void WindowsTesting() {
	  Point point = new Point(150,150); 
	  //声明一个Point对象，两个150表示浏览器的位置相对于屏幕的左上角（0，0）的横坐标距离和纵坐标距离
	  Dimension Dim = new Dimension (500,500);
	  
	  driver.manage().window().setPosition(point);
	//setPosition方法设定浏览器在屏幕上的位置为point对象的坐标（150,150）
	  driver.manage().window().setSize(Dim);
	//setsize方法设定浏览器的窗口大小为长为500个单位，宽为500个单位
	  System.out.println(driver.manage().window().getPosition());
	  //getPosition用于获取当前浏览器在屏幕的位置
	  System.out.println(driver.manage().window().getSize());
	  //getSize用于获取当前浏览器的窗口大小
	  driver.manage().window().maximize(); //最大化窗口
	  driver.get("http://www.baidu.com");
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
