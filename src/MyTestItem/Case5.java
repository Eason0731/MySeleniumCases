package MyTestItem;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Case5 {
	//this case launched with Google Chrome browser
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		//testGoogleSearch();
		LoginRenRen();
	}
	
	/*public static void testGoogleSearch() throws InterruptedException {
		  // Optional, if not specified, WebDriver will search your path for chromedriver.
		  System.setProperty("webdriver.chrome.driver", "D://Selenium//ChromeDriver//chromedriver.exe");WebDriver driver = new ChromeDriver();
		  driver.get("http://www.baidu.com");
		  Thread.sleep(5000);  // Let the user actually see something!
		  WebElement searchBox = driver.findElement(By.name("wd"));
		  searchBox.sendKeys("hello selenium!");
		  searchBox.submit();
		  Thread.sleep(5000);  // Let the user actually see something!
		  System.out.println("Page title is: " + driver.getTitle());
		  driver.quit();
		}*/
	
	public static void LoginRenRen() throws InterruptedException{
		
		System.setProperty("webdriver.chrome.driver", "D://Selenium//ChromeDriver//chromedriver.exe");WebDriver driver = new ChromeDriver();
		driver.get("http://www.renren.com");
		Thread.sleep(3000);
		
		WebElement UserNameTextBox = driver.findElement(By.id("email"));//get the usernamebox name on Web
		WebElement PwdTextBox =driver.findElement(By.id("password")); //get the passwordbox name on Web
		WebElement RememberMe =driver.findElement(By.id("autoLogin")); //get the Rememberlogin checkbox name on Web
		WebElement LoginButton =driver.findElement(By.id("login")); //get the loginbutton name on Web
		
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
		driver.quit(); //Close Browser
		
		
	}

}
