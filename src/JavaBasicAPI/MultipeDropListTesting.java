package JavaBasicAPI;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import BrowserDrivers.GetBrowserDriver;


public class MultipeDropListTesting {
	public WebDriver driver;
	
	//10.15
  @Test
  public void MultipeDropList() throws InterruptedException {
	  File myHtml = new File ("html/10.15.html");
	  String myHtmlFile = myHtml.getAbsolutePath(); //getAbsolutePath()返回抽象路径名的绝对路径名字符串
	  driver.get("file://" +myHtmlFile);
	  Select droplist = new Select( driver.findElement(By.name("driver")));
	  
	  Assert.assertTrue(droplist.isMultiple());
	  
	  droplist.selectByIndex(2);
	  droplist.selectByValue("Ham");
	  droplist.selectByVisibleText("Sebastian Vettel");
	  Thread.sleep(5000);
	  droplist.deselectAll(); //清除所有选项
	 
	  
	  droplist.selectByIndex(2);
	  Assert.assertEquals("Jenson Button",droplist.getFirstSelectedOption().getText()); //actual,expected
	  droplist.deselectByIndex(2); //清除单个选项用deselect
	  Thread.sleep(5000);
	  
	  droplist.selectByValue("Ham");
	  Assert.assertEquals("Lewis Hamilton",droplist.getFirstSelectedOption().getText());
	  droplist.deselectByValue("Ham");
	  Thread.sleep(5000);
	  
	  droplist.selectByVisibleText("Sebastian Vettel");
	  Assert.assertEquals("Sebastian Vettel",droplist.getFirstSelectedOption().getText());
	  droplist.deselectByVisibleText("Sebastian Vettel");
	  Thread.sleep(5000);
	  
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
