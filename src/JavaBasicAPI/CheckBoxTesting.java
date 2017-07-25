package JavaBasicAPI;

import java.io.File;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import BrowserDrivers.GetBrowserDriver;

public class CheckBoxTesting {
	public WebDriver driver;
	//10.17
  @Test
  public void CheckBox() throws InterruptedException {
	  File myHtml = new File ("html/10.17.html");
	  String myHtmlFile = myHtml.getAbsolutePath(); //getAbsolutePath()返回抽象路径名的绝对路径名字符串
	  driver.get("file://" +myHtmlFile);
	  
	  WebElement CheckBox = driver.findElement(By.name("driver"));
	  
	  if(!CheckBox.isSelected()){
		  CheckBox.click();
	  Assert.assertTrue(CheckBox.isSelected());
	  }
	  
	  //新建List用存储name为driver的多选框的值
	  List<WebElement> drivercheckbox = driver.findElements(By.name("driver"));
      //fou循环遍历值并选中多选框内的所有值
	  for (WebElement driverCB : drivercheckbox)
		  driverCB.click();
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
