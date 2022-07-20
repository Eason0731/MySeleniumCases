package BrowserDrivers;

import java.io.File;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;


public class GetBrowserDriver {
	public static WebDriver driver = null;
	public static String OSName = System.getProperties().getProperty("os.name");
	
	public static WebDriver GetInternetExplorerDriver(){
		if (OSName.contains("Windows 7") || OSName.contains("Windows 8")){
			File IEdriver = new File ("Drivers/IEDriverServer.exe");
			System.setProperty("webdriver.ie.driver", IEdriver.toString());
			//DesiredCapabilities ieCapabilities = DesiredCapabilities.internetExplorer();
		    //ieCapabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
			//driver = new InternetExplorerDriver(ieCapabilities);
			driver = new InternetExplorerDriver();
			driver.manage().window().maximize();
		}
		
		else if (OSName.contains("Windows 10") || OSName.contains("Windows 11")){
			System.out.println("IE browser has been removed on Windows 10 and Windows 11 since June 16 ,2022 , switch to Edge now");
			GetEdgeDriver();
		}
		
		else if (OSName.contains("Mac")){
			System.out.println("IE browser cannot be ran on Mac OS, switch to Safari now");
			GetSafariDriver();
		}
		
		return driver;		
	}
	
	public static WebDriver GetChromeDriver(){
		File Cdriver = null;
		if (OSName.contains("Windows")){
			Cdriver = new File ("Drivers/chromedriver.exe");
		}
		
		else if (OSName.contains("Mac")){
			Cdriver = new File ("Drivers/chromedriver");
		}
		
		System.setProperty("webdriver.chrome.driver", Cdriver.toString());	
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		return driver;
	}
	
	public static WebDriver GetFireFoxDriver(){	
		File FFDriver = null;
		
		if (OSName.contains("Windows")){
			FFDriver = new File ("Drivers/geckodriver.exe");
		}
		
		else if (OSName.contains("Mac")){
			FFDriver = new File ("Drivers/geckodriver");
		}
		
		System.setProperty("webdriver.gecko.driver", FFDriver.toString());
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		return driver;
	}
	
	public static WebDriver GetSafariDriver(){
		if (OSName.contains("Windows 7") || OSName.contains("Windows 8")){
			System.out.println("Safari browser cannot be run on Windows 7 or 8, switch to IE now");
			GetInternetExplorerDriver();
		}
		
		
		else if (OSName.contains("Windows 10") || OSName.contains("Windows 11")){
			System.out.println("Safari browser cannot be run on Windows 10 or Windows 11, switch to Edge now");
			GetEdgeDriver();
		}
		
		
		else if (OSName.contains("Mac")){
			driver = new SafariDriver();
			driver.manage().window().maximize();	
		}
		
		return driver;
	}
	
	public static WebDriver GetEdgeDriver(){
		if (OSName.contains("Windows 7") || OSName.contains("Windows 8")){
			System.out.println("IE browser still can be run on Windows 7 or 8, switch to IE now");
			GetInternetExplorerDriver();
		}
		
		else if (OSName.contains("Windows 10") || OSName.contains("Windows 11")){
			File EDriver = new File ("Drivers/msedgedriver.exe");
			System.setProperty("webdriver.edge.driver", EDriver.toString());
			driver = new EdgeDriver();
			driver.manage().window().maximize();
		}
		
		else if (OSName.contains("Mac")){
			System.out.println("Edge browser cannot be run on Mac, switch to Safari now");
			GetSafariDriver();
		}
		
		return driver;
	}
	
}
