package Selenium_Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Case7 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		testGoogleSearch();
	}
	public static void testGoogleSearch() throws InterruptedException {
		  // Optional, if not specified, WebDriver will search your path for chromedriver.
		  System.setProperty("webdriver.ie.driver", "D://Selenium//2.48.2//IEDriverServer.exe");

		  WebDriver driver = new InternetExplorerDriver();
		  driver.get("http://www.sogou.com");
		  Thread.sleep(5000);  // Let the user actually see something!
		  WebElement searchBox = driver.findElement(By.name("query"));
		  searchBox.sendKeys("hello selenium!");
		  searchBox.submit();
		  Thread.sleep(5000);  // Let the user actually see something!
		  System.out.println("Page title is: " + driver.getTitle());
		  driver.quit();
		}

}
