package Selenium_Test;

import java.util.Calendar;

public class TryCatch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try { 
			int i= 1;
			i = i % 0;
		}
		
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		finally 
		{
			
			System.out.println("Force close!");
		}
	}
	
	public void Date()
	{
		Calendar a=Calendar.getInstance();
		System.out.println(a.get(Calendar.YEAR));//得到年
		System.out.println(a.get(Calendar.MONTH)+1);//由于月份是从0开始的所以加1
		System.out.println(a.get(Calendar.DATE));
	}

}
