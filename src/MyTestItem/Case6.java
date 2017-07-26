package MyTestItem;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Case6 {
	//this case launched with FireFox browser
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		testGoogleSearch();
	}
	
	public static void testGoogleSearch() throws InterruptedException {
		  // Optional, if not specified, WebDriver will search your path for chromedriver.
		  

		  WebDriver driver = new FirefoxDriver();
		  driver.get("http://www.baidu.com");
		  Thread.sleep(5000);  // Let the user actually see something!
		  WebElement searchBox = driver.findElement(By.id("kw"));
		  searchBox.sendKeys("hello selenium!");
		  searchBox.submit();
		  Thread.sleep(5000);  // Let the user actually see something!
		  System.out.println("Page title is: " + driver.getTitle());
		  driver.quit();
		}

}
