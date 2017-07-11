package WebDriver_Advanced_Application_Examples;

import org.apache.log4j.Logger;
//This class use for 11.16
public class Log {
	private static Logger Log = Logger.getLogger(Log.class.getName());
	//初始化一个Logger对象
	
	public static void startTestcase (String sTestCaseName){
	//定义一个静态方法，可以打印自定义的某个测试用例开始执行的日志信息
		Log.info("---------------------------------------------");
		Log.info("**********		"+ sTestCaseName + "**********		");
	}
	
	public static void endTestcase (String sTestCaseName){
	//定义一个静态方法，可以打印自定义的某个测试用例结束执行的日志信息
		Log.info("---------------------------------------------");
		Log.info("**********		"+ sTestCaseName + "**********		");
	}
	
	public static void Info (String message){
		//定义一个静态info方法，打印自定义的info级别的日志消息
		Log.info(message);
		
	}
	
	public static void Warn (String message){
		//定义一个静态warn方法，打印自定义的info级别的日志消息
		Log.warn(message);
		
	}
	
	public static void Fatal (String message){
		//定义一个静态fatal(致命级别的错误)方法，打印自定义的info级别的日志消息
		Log.fatal(message);
		
	}
	
	
	public static void Debug (String message){
		//定义一个静态debug方法，打印自定义的info级别的日志消息
		Log.debug(message);
		
	}
}
