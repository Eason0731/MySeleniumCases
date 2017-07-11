package Javademos;
//引入util包，为了能够实现键盘输入
import java.util.Scanner;
public class BubbleSort {
	
	public static void Sort(float x1,float x2,float x3,float x4,float x5){
		float b;
		int i,j;
		float a[] = {x1,x2,x3,x4,x5};	
		
		for (i=0; i<a.length;i++){			//外循环
		for (j=i+1; j<a.length;j++){ //内循环
			
			if (a[i] > a[j]) {
				b = a[i];
				a[i] = a[j];
				a[j] = b;				
			}			
		}
		
		}
		
		for (int k=0;k<a.length;k++)
		{
			System.out.println(a[k]);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Sort(48,69,25,13,74);
		
		Scanner in=new Scanner(System.in); //Scanner方法可以实现键盘输入
		
		System.out.println("please enter the fisrt number: ");
			float a1=in.nextFloat();//这是输入a1，这里是输入float型的数字
		System.out.println("Please enter the second number: ");
			float a2=in.nextFloat();//这是输入a2
		System.out.println("please enter the third number: ");
			float a3=in.nextFloat();//这是输入a3
		System.out.println("Please enter the forth number: ");
			float a4=in.nextFloat();//这是输入a4
		System.out.println("Please enter the fifth number: ");
			float a5=in.nextFloat();//这是输入a5
		
		System.out.println("You can type some words here: ");
			String abc = in.next();
		System.out.println(abc);
		
		Sort(a1,a2,a3,a4,a5);
		     
		
	}

}
