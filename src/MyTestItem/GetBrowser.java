package MyTestItem;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class GetBrowser {
	
	
  public static WebDriver getIE(){
	  System.setProperty("webdriver.ie.driver", "D:\\Selenium\\IEDriverServer.exe");
	  WebDriver driver = new InternetExplorerDriver();
	  //driver.manage().window().setSize(new Dimension(1920,1080));
	  return driver;
  }
  
  public static WebDriver getChrome(){
	  System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\ChromeDriver\\ChromeDriver.exe");
	  WebDriver driver = new ChromeDriver();
	  //driver.manage().window().setSize(new Dimension(1920,1080));
	  return driver;
  }
	
  
  
  

 
}
