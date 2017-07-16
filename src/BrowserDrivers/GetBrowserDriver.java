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
	
	public static WebDriver GetChromeDriver(){
		File Cdriver = null;
		if (OSName.contains("Win")){
			Cdriver = new File ("Drivers/ChromeDriver.exe");
		}
		
		else if (OSName.contains("Mac")){
			Cdriver = new File ("Drivers/chromedriver");
		}
		
		System.out.println(OSName);
		String CDriverFile = Cdriver.toString();
		System.setProperty("webdriver.chrome.driver", CDriverFile);	
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		return driver;
	}
	
	public static WebDriver GetInternetExplorerDriver(){
		if (OSName.contains("Win")){
			File IEdriver = new File ("Drivers/IEDriverServer.exe");
			String IEDriverFile = IEdriver.toString();
			System.setProperty("webdriver.ie.driver", IEDriverFile);
			DesiredCapabilities ieCapabilities = DesiredCapabilities.internetExplorer();
		    ieCapabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
			driver = new InternetExplorerDriver(ieCapabilities);
			driver.manage().window().maximize();
		}
		
		else if (OSName.contains("Mac")){
			System.out.println("IE browser cannot be ran on Mac OS, switch to Safari now");
			GetSafariDriver();
		}
		
		return driver;		
	}
	
	public static WebDriver GetFireFoxDriver(){
		//System.setProperty("webdriver.firefox.bin", "C://Program Files (x86)//Mozilla Firefox//firefox.exe");
		File FFDriver = null;
		
		if (OSName.contains("Win")){
			System.out.println(OSName);
			FFDriver = new File ("Drivers/geckodriver.exe");
		}
		
		else if (OSName.contains("Mac")){
			System.out.println(OSName);
			FFDriver = new File ("Drivers/geckodriver");
		}
		
		String FFDriverFile = FFDriver.toString();
		System.setProperty("webdriver.gecko.driver", FFDriverFile);
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		return driver;
	}
	
	public static WebDriver GetSafariDriver(){
		if (OSName.contains("Windows 7")){
			System.out.println("Safari browser cannot be run on Windows 7, switch to IE now");
			GetInternetExplorerDriver();
		}
		
		else if (OSName.contains("Windows 10")){
			System.out.println("Safari browser cannot be run on Windows 10, switch to Edge now");
			GetEdgeDriver();
		}
		
		else if (OSName.contains("Mac")){
			driver = new SafariDriver();
			driver.manage().window().maximize();	
		}
		
		return driver;
	}
	
	public static WebDriver GetEdgeDriver(){
		if (OSName.contains("Mac")){
			System.out.println("Edge Browser cannot be run on Mac, switch to Safari now");
			GetSafariDriver();
		}
		
		else if (OSName.contains("Windows 7")){
			System.out.println("Edge Browser cannot be run on Windows 7, switch to IE now");
			GetInternetExplorerDriver();
		}
		
		else if (OSName.contains("Windows 10")){
			File EDriver = new File ("Drivers/MicrosoftWebDriver.exe");
			String EDriverFile = EDriver.toString();
			System.setProperty("webdriver.edge.driver",EDriverFile);
			driver = new EdgeDriver();
		}
		return driver;
	}
	
}
