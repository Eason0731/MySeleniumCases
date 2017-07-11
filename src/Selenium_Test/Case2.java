package Selenium_Test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Case2 {
 WebDriver driver;

 @Before
 public void setUp() throws Exception {
  driver = new FirefoxDriver();
 }

 @Test
 public void test_case2() throws Exception {
  driver.get("http://www.baidu.com");
  WebElement element = driver.findElement(By.id("kw"));
  element.sendKeys("hello Selenium!");
  element.submit();
 }

 @After
 public void tearDown() throws Exception {
  System.out.println("Page title is: " + driver.getTitle());
  driver.quit();
 }
}