package WebDriver_Advanced_Application_Examples;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import BrowserDrivers.GetBrowserDriver;


public class TableTesting {
	public WebDriver driver;
	//private Table table;
	
  @Test
  //11.17
  public void TableTest() throws Exception {
	  Thread.sleep(5000);
	  WebElement webtable = driver.findElement(By.xpath("//table")); //在页面上找到table元素
	  Table table = new Table(webtable); //使用webtable进行Table的实例化
	  WebElement cell = table.getCell(3, 3); //调用Table方法的getCell方法
	  Assert.assertEquals(cell.getText(), "第三行第三列"); //判断是不是第三行第三列
	  WebElement cellInput = table.getinCell(3, 3, By.tagName("input")); //调用Table方法的getinCell方法,找到第三行第三列单元格的输入框对象
	  cellInput.sendKeys("第三行第三列确实被找到了！");
	  Thread.sleep(5000);
  }
  @BeforeMethod
  public void beforeMethod() {
	  driver = GetBrowserDriver.GetChromeDriver();
	  File myHtml = new File ("html/11.17.html");
	  String myHtmlFile = myHtml.getAbsolutePath(); //getAbsolutePath()返回抽象路径名的绝对路径名字符串
	  driver.navigate().to("file://" +myHtmlFile);
  }

  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }

}
