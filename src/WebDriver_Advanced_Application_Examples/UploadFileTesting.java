package WebDriver_Advanced_Application_Examples;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.time.Duration;

import BrowserDrivers.GetBrowserDriver;


public class UploadFileTesting {
	public WebDriver driver;
	JavascriptExecutor jse;
  @Test
  //11.6
  public void UploadFileTest() throws Exception {
	  WebElement inputBox = driver.findElement(By.id("file"));
	  File attahcedFile = new File ("html/11.6/Test.txt");
	  String attachedFilePath = attahcedFile.getAbsolutePath();
	  inputBox.sendKeys(attachedFilePath);
	  
	  //WebDriverWait wait = new WebDriverWait (driver,5); //Wait for 5 seconds
	  WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10)); //显式等待新语法5秒
	  wait.until(ExpectedConditions.elementToBeClickable(By.id("filesumbit"))); //Judge that button can click or not
	  
	  WebElement Button = driver.findElement(By.id("filesumbit"));
	  Button.click();
	  Thread.sleep(5000);
	  //Actions action = new Actions (driver);
	  //action.keyDown(Keys.ENTER);
	  
	  wait.until(ExpectedConditions.titleContains("Upload file succeed!"));
  }
  @BeforeMethod
  public void beforeMethod() {
	  driver = GetBrowserDriver.GetChromeDriver();
	  File myHtml = new File ("html/11.6/upload.html");
	  String myHtmlFile = myHtml.getAbsolutePath(); //getAbsolutePath()返回抽象路径名的绝对路径名字符串
	  driver.navigate().to("file://" +myHtmlFile);
	 
  }

  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }

}
