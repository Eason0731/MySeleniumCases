package Selenium_Test;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

//推荐使用TestNG作为测试模板，便于查看测试结果
public class Xpath_Assert_Demo1 {
	public WebDriver driver;
	String BaseUrl = "http://www.renren.com/";
  @Test
  public void LoginRenRen() throws InterruptedException {
	  //try{
	  driver.get(BaseUrl + "/");
	  WebElement UserNameTextBox = driver.findElement(By.xpath("//*[@id='email']"));//get the usernamebox name on Web
		WebElement PwdTextBox =driver.findElement(By.xpath("//*[@id='password']")); //get the passwordbox name on Web
		WebElement RememberMe =driver.findElement(By.xpath("//*[@id='autoLogin']")); //get the Rememberlogin checkbox name on Web
		WebElement LoginButton =driver.findElement(By.xpath("//*[@id='login']")); //get the loginbutton name on Web
		
		UserNameTextBox.sendKeys("lonlon29@sina.cn");
		Thread.sleep(3000);
		PwdTextBox.sendKeys("54288288840");
		Thread.sleep(3000);
		RememberMe.click(); //Click First
		Thread.sleep(3000);
		RememberMe.click(); //Cancel Click
		Thread.sleep(3000);
		LoginButton.submit();	
		Thread.sleep(3000);
		//System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		Assert.assertEquals(driver.getTitle(), "人人网 - 张轶晟Dr.Lon"); //assertTrue
	  //}
	  //catch (Exception e)
	  //{
		//  System.out.println(e);
	  //}
	  
	  //finally
	  //{
		//  driver.quit();
	  //}
  }
  @BeforeMethod
  public void beforeMethod() {
		System.setProperty("webdriver.chrome.driver", "D://Selenium//ChromeDriver//chromedriver.exe");
		driver = new ChromeDriver();
  }

  @AfterMethod
  public void afterMethod() {
	  driver.quit(); //Close Browser
  }

}
