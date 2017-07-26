package MyTestItem;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Options {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\ChromeDriver\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("user-data-dir=C:\\Users\\t_zhanj\\AppData\\Local\\Google"
				+ "\\Chrome\\User Data\\");
		ChromeDriver driver = new ChromeDriver(options);
		driver.get("https://www.google.com/");
		driver.get("http://www.baidu.com/");
	}

}
