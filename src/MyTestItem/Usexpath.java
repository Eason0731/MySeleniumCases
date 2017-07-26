package Selenium_Test;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Usexpath {
	//this case launched with Google Chrome browser
	public static void main(String[] args) throws InterruptedException {
		
		LoginRenRen();
	}
	
	public static void LoginRenRen() throws InterruptedException{
		
		System.setProperty("webdriver.chrome.driver", "D://Selenium//ChromeDriver//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.renren.com");
		Thread.sleep(3000);
		
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
		System.out.println(driver.getTitle());
		Assert.assertEquals(driver.getTitle(), "人人网 - 张轶晟Dr.Lon"); //assertTrue
		driver.quit(); //Close Browser
		
		
	}

}
