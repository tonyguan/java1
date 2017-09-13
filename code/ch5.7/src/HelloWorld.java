/*
* Created by 智捷课堂
* 本书网站：www.51work6.com 
* 智捷课堂在线课堂：www.zhijieketang.com
* 智捷课堂微信公共号：zhijieketang
* 邮箱：eorient@sina.com
* Java读者服务QQ群：547370999
* 【配套电子书】网址：
*       图灵社区：
*       http://www.ituring.com.cn/book/2480
*       百度阅读：
*       https://yuedu.baidu.com/ebook/7c1499987e192279168884868762caaedd33ba00 
*/

public class HelloWorld {

	public static void main(String[] args) {

		////////// 自动类型转换//////////////
		// 声明整数变量
		byte byteNum = 16;
		short shortNum = 16;
		int intNum = 16;
		long longNum = 16L;

		// byte类型转换为int类型
		intNum = byteNum;
		// 声明char变量
		char charNum = '花';
		// char类型转换为int类型
		intNum = charNum;

		// 声明浮点变量
		// long类型转换为float类型
		float floatNum = longNum;
		// float类型转换为double类型
		double doubleNum = floatNum;

		// 表达式计算后类型是double
		double result = floatNum * intNum + doubleNum / shortNum;

		////////// 强制类型转换//////////////
		//int型变量
		int i = 10;
		//把int变量i强制转换为byte
		byte b = (byte) i; 
		int i2 = (int)i;
		int i3 = (int)b;
		
		//精度与强制类型转换
		float c1 = i / 3;
		System.out.println(c1);
		//把int变量i强制转换为float
		float c2 = (float)i / 3;
		System.out.println(c2);
		
		//强制类型转换导致精度丢失
	    long yourNumber = 6666666666L;
	    System.out.println(yourNumber);
	    int myNuber = (int)yourNumber;
	    System.out.println(myNuber);
	    
	}
}
