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

public class RadioTesting {
	public WebDriver driver;
	
	//10.16
  @Test
  public void radio() throws InterruptedException {
	  File myHtml = new File ("html/10.16.html");
	  String myHtmlFile = myHtml.getAbsolutePath(); //getAbsolutePath()返回抽象路径名的绝对路径名字符串
	  driver.get("file://" +myHtmlFile);
	  Thread.sleep(5000);
	  WebElement radio = driver.findElement(By.name("driver"));
	  if(!radio.isSelected()){ //判断单选框是否为选中状态
		  radio.click();
	  }
	  Assert.assertTrue(radio.isSelected()); 
	  
	  //查找name为driver的单选框的所有制
	  List<WebElement> drivers = driver.findElements(By.name("driver"));
	  
	  //用For循环去遍历并查找到value为Alo的
	  for (WebElement radiodriver : drivers){
		  if( radiodriver.getAttribute("value").equals("Ham"))
		  {
			  if(!radiodriver.isSelected())
				  radiodriver.click();
			  Thread.sleep(5000);
			  Assert.assertTrue(radiodriver.isSelected());
			  break;
		  }
		  
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
