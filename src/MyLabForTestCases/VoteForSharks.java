package MyLabForTestCases;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import BrowserDrivers.GetBrowserDriver;

public class VoteForSharks {
	public WebDriver driver;
  @Test
  public void VoteSharks() throws Exception {
	  int i;
	  String URL = "http://www.wa5.com/news/nls";
	  driver.navigate().to(URL);
	  Assert.assertEquals(driver.getTitle(), "投票"); //actual, expected
	 
	  Assert.assertTrue(driver.getPageSource().contains("绿地"));
	  /*for (i=0 ; i<100; i++){
		  WebElement radio = driver.findElement(By.xpath("/html/body/div[4]/div/div/div/div[1]/input[3]"));
		  WebElement SubmitButton = driver.findElement(By.id("doVote"));
		  radio.click();
		  Thread.sleep(2000);
		  SubmitButton.click();
		  Thread.sleep(2000);
		  Alert alert = driver.switchTo().alert();
		  Thread.sleep(2000);
		  Assert.assertEquals("投票成功", alert.getText());
		  alert.accept();
		  driver.navigate().refresh();
		  
	  }
	  
	  System.out.println(i);
	  */
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
