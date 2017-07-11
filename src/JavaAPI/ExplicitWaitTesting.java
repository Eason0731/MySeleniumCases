package JavaAPI;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import BrowserDrivers.GetBrowserDriver;

public class ExplicitWaitTesting {
	public WebDriver driver;
  @Test
  //10.30 显式等待
  public void ExplicitWaitTest() {
	  File myHtml = new File ("html/10.30.html");
	  String myHtmlFile = myHtml.getAbsolutePath(); //getAbsolutePath()返回抽象路径名的绝对路径名字符串
	  driver.get("file://" +myHtmlFile);
	  WebDriverWait wait = new WebDriverWait(driver,10); 
	  //声明一个WebDriverWait对象，设定触发条件为10秒
	  wait.until(ExpectedConditions.titleContains("10"));
	  //调用ExpectedConditions的titleContains方法判断页面的title属性是否包含“10”
	  
	  System.out.println("网页标题出现了 10");
	  
	  WebElement option = driver.findElement(By.id("alonso"));
	  wait.until(ExpectedConditions.elementToBeSelected(option));
	  //调用ExpectedConditions的elementToBeSelected方法,判断页面上的“Fernando Alonso”是否处于选中状态
	  
	  System.out.println("下拉列表的 Fernando Alonso 出于选中状态");
	  
	  wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='checkbox']")));
	  System.out.println("复选框 出于选中状态");
	  //调用ExpectedConditions的elementToBeClickable方法,判断页面上的复选框是否处于选中状态
	  
	  
	  wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//p")));
	  System.out.println("p标签 出于选中状态");
	  //调用ExpectedConditions的presenceOfElementLocated方法,判断页面上的p标签是否存在
	  
	  WebElement p = driver.findElement(By.xpath("//p"));
	  wait.until(ExpectedConditions.textToBePresentInElement(p, "driver"));
	  //调用ExpectedConditions的textToBePresentInElement方法,判断页面上的p标签是否包含driver
	  
	  System.out.println("p标签包含10.33");
	  
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
