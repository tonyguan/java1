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

		// 进制表示方式
		int decimalInt = 28;
		int binaryInt1 = 0b11100;
		int binaryInt2 = 0B11100;
		int octalInt = 034;
		int hexadecimalInt1 = 0x1C;
		int hexadecimalInt2 = 0X1C;

		System.out.println("十进制表示 		=  " + decimalInt);
		System.out.println("二进制表示 		=  " + binaryInt1);
		System.out.println("八进制表示 		=  " + octalInt);
		System.out.println("十六进制表示	=  " + hexadecimalInt1);

		// 指数表示方式
		double myMoney = 3.36e2;
		double interestRate = 1.56e-2;

	}
}
