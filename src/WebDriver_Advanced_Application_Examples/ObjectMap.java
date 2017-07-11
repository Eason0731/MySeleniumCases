package WebDriver_Advanced_Application_Examples;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.By;

public class ObjectMap { //This class using for 11.11

	Properties properties;
	
	public ObjectMap (String propFile){
		properties = new Properties();
		try {
			FileInputStream in = new FileInputStream(propFile);
			properties.load(in);
			in.close();
		}

		catch (Exception e)	{
		System.out.println("读取文件对象出错!");
		e.printStackTrace();
	
		}
	
		
	}
	
	public By getLocator (String ElementNameInpropFile) throws Exception{
		String locator = properties.getProperty(ElementNameInpropFile);
		
		String locatorType = locator.split(":")[0];
		String locatorValue = locator.split(":")[1];
		
		System.out.println("获取数据的类型: "+ locatorType + "\t 获取的定位表达式" +locatorValue);
		
		if (locatorType.toLowerCase().equals("id"))
			return By.id(locatorValue);
		else if (locatorType.toLowerCase().equals("name"))
			return By.name(locatorValue);
		else if (locatorType.toLowerCase().equals("class")||locatorType.toLowerCase().equals("classname"))
			return By.className(locatorValue);
		else if (locatorType.toLowerCase().equals("tag")||locatorType.toLowerCase().equals("tagname"))
			return By.className(locatorValue);
		else if (locatorType.toLowerCase().equals("linktext")||locatorType.toLowerCase().equals("link"))
			return By.linkText(locatorValue);
		else if (locatorType.toLowerCase().equals("partiallinktext"))
			return By.partialLinkText(locatorValue);
		else if (locatorType.toLowerCase().equals("cssselector")||locatorType.toLowerCase().equals("css"))
			return By.cssSelector(locatorValue);
		else if (locatorType.toLowerCase().equals("xpath"))
			return By.xpath(locatorValue);
		else
			throw new Exception("输入的locator tyoe未在程序中定义:"+locatorType);
		
	}
	
}
