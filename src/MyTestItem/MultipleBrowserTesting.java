package MyTestItem;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class MultipleBrowserTesting {
	public WebDriver driver;
	String Url = "http:\\www.baidu.com";
  @Parameters ("browser")
  @Test
  public void testSearchonBaidu() {
	  driver.get(Url + "/");
	  WebElement searchBox = driver.findElement(By.xpath("//*[@id='kw']"));
	  WebElement searchButton = driver.findElement(By.xpath("//*[@id='su']"));
	  searchBox.sendKeys("Hello Selenium");
	  searchButton.submit();
	  try
	  {
		  Thread.sleep(3000);
	  }
	  catch (Exception e){
		  System.out.println(e);
	  }
	  
	  Assert.assertTrue(driver.getPageSource().contains("Hello Selenium"));
  }
  @BeforeClass
  public void beforeClass(String liulanqi) {
	  liulanqi = "Chrome";
	  try{
	  if (liulanqi.equalsIgnoreCase("Firefox")){
		System.setProperty("webdriver.firefox.bin", "C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");
		driver = new FirefoxDriver();
	  }
	  
	  else if (liulanqi.equalsIgnoreCase("Chrome")){
		  System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\ChromeDriver\\ChromeDriver.exe");
		  driver = new ChromeDriver();
	  }
	  
	  else {
		  System.setProperty("webdriver.ie.driver", "D:\\Selenium\\2.48.2\\IEDriverServer.exe");
		  driver = new InternetExplorerDriver();
	  }
	  }
	  catch (Exception e)
	  {
		  System.out.println(e);
	  }
  }

  @AfterClass
  public void afterClass() {
	 driver.quit();
  }

}
