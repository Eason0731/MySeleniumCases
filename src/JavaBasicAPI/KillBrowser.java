package JavaBasicAPI;

import org.openqa.selenium.os.WindowsUtils;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class KillBrowser {
	//10.18
  @Test
  public void KillBrowserTesting() {
	  //WindowsUtils.tryToKillByName("iexplore.exe"); //Kill IE
	  WindowsUtils.killByName("iexplore.exe"); //Kill IE
	  
	  //WindowsUtils.tryToKillByName("chrome.exe"); //kill chrome
	  WindowsUtils.killByName("chrome.exe"); //kill chrome
	  
	  //WindowsUtils.tryToKillByName("firefox.exe"); //kill firefox
	  WindowsUtils.killByName("firefox.exe"); //kill firefox
  }
  @BeforeMethod
  public void beforeMethod() {
  }

  @AfterMethod
  public void afterMethod() {
  }

}
