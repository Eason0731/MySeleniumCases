package MyTestItem;

import java.util.Arrays;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Methods {
	
	public static WebDriver BeforeMethodChrome(){
        System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\ChromeDriver\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
     
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        capabilities.setCapability("chrome.switches",
                Arrays.asList("--start-maximized"));
        options.addArguments("--test-type", "--start-maximized");
        
        WebDriver driver=new ChromeDriver(options);
        return driver;
		
	}
	
	public static WebDriver BeforeMethodIE(){
		 System.setProperty("webdriver.ie.driver", "D:\\Selenium\\IEDriverServer.exe");
		 WebDriver driver = new InternetExplorerDriver();
		 driver.manage().window().setSize(new Dimension(1920,1080));
		 return driver;
	}
	
}
