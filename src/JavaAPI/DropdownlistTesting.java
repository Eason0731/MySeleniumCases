package JavaAPI;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import BrowserDrivers.GetBrowserDriver;

public class DropdownlistTesting {
	public WebDriver driver;
	//10.13 and 10.14
  @Test
   public void Dropdownlist() throws InterruptedException {
	  File myHtml = new File ("html/10.13.html");
	  String myHtmlFile = myHtml.getAbsolutePath(); //getAbsolutePath()返回抽象路径名的绝对路径名字符串
	  driver.get("file://" +myHtmlFile);
	  //实例化下拉列表框，用select，并非之前的Webelement
	  Select droplist = new Select(driver.findElement(By.name("driver")));
	  
	  Assert.assertFalse(droplist.isMultiple()); //判断下拉列表框是否允许多选
	  
	  Assert.assertEquals("Fernando Alonso", droplist.getFirstSelectedOption().getText());
	  //droplist.getFirstSelectedOption().getText()为选中下拉列表框当前选中的选项，并取出值（默认从下标0开始）
	  Thread.sleep(3000);
	  
	  droplist.selectByIndex(2); //用下标取值
	  Assert.assertEquals("Jenson Button", droplist.getFirstSelectedOption().getText());
	  Thread.sleep(3000);
	  
	  droplist.selectByValue("Ham");//根据下拉列表的Value的值，进行操作
	  Assert.assertEquals("Lewis Hamilton", droplist.getFirstSelectedOption().getText());
	  Thread.sleep(3000);
	  
	  droplist.selectByVisibleText("Kimi Raikkonen"); //selectByVisibleText 表示通过选中的文字进行操作
	  Assert.assertEquals("Kimi Raikkonen", droplist.getFirstSelectedOption().getText());
	  Thread.sleep(3000);
  } 
  
  @Test
  public void Dropdownlist2(){
	  File myHtml = new File ("html/10.13.html");
	  String myHtmlFile = myHtml.getAbsolutePath(); //getAbsolutePath()返回抽象路径名的绝对路径名字符串
	  driver.get("file://" +myHtmlFile);
	  //实例化下拉列表框，用select，并非之前的Webelement
	  Select droplist = new Select(driver.findElement(By.name("driver")));
	 
	  //声明对象List，Arrays.asList表示将一个数组转换为一个对象
	  List<String> expect_val = Arrays.asList(new String[]{"Fernando Alonso","Lewis Hamilton","Jenson Button","Sebastian Vettel","Kimi Raikkonen"});
	  //再声明对象List，用于存储下拉列表获取的值
	  List<String> actual_val = new ArrayList<String>();
	  
	  //droplist.getOptions()用于获取下拉列表上所有对象，并存储到新的List中
	  for (WebElement option : droplist.getOptions()) 
		  //新建WebElment对象Option，随后循环遍历，并将遍历到的值存储在新建的数组中
		  
		  actual_val.add(option.getText());

	  Assert.assertEquals(expect_val.toArray(),actual_val.toArray());
	  
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
