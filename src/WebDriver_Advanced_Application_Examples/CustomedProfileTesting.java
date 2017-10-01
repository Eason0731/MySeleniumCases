package WebDriver_Advanced_Application_Examples;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import BrowserDrivers.GetBrowserDriver;


public class CustomedProfileTesting {
	WebDriver driver;
	String BaseURL;
	//11.9
	  
  @Test
  
  public void CustomedProfileTest() {
	  ProfilesIni allprofiles = new ProfilesIni();  //声明ProfilesIni对象，并命名为allprofiles
	  
	  FirefoxProfile profile = allprofiles.getProfile("Webdriver"); //声明FirefoxProfile对象，并命名为profile,并调用ProfilesIni对象allprofiles去读取名为Webdriver的Profile文件
	  
	  profile.setPreference("browser.startup.homepage", "http://www.baidu.com"); //调用setPreference方法，将配置文件Webdriver的首页改为http://www.baidu.com
	  
	  //driver = new FirefoxDriver(profile); //实例化profile并且启动该对象 (这一步有问题似乎)
	  
	  WebElement SearchBox = driver.findElement(By.id("kw"));
	  WebElement SearchButton = driver.findElement(By.id("su"));
	  
	  SearchBox.sendKeys("Webdriver");
	  SearchButton.click();
	  
	 
  }

  @BeforeMethod
  public void beforeMethod() {
	  driver = GetBrowserDriver.GetChromeDriver();
	  BaseURL = "http://www.sogou.com";

  }

  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }

}
