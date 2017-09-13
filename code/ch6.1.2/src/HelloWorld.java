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
		
		//声明一个字符类型变量
		char charNum = 'A';
		// 声明一个整数类型变量
		int intResult = charNum + 1;
		System.out.println(intResult);

		intResult = intResult - 1;
		System.out.println(intResult);

		intResult = intResult * 2;
		System.out.println(intResult);

		intResult = intResult / 2;
		System.out.println(intResult);

		intResult = intResult + 8;
		intResult = intResult % 7;
		System.out.println(intResult);

		System.out.println("-------");

		// 声明一个浮点类型变量
		double doubleResult = 10.0;
		System.out.println(doubleResult);

		doubleResult = doubleResult - 1;
		System.out.println(doubleResult);

		doubleResult = doubleResult * 2;
		System.out.println(doubleResult);

		doubleResult = doubleResult / 2;
		System.out.println(doubleResult);

		doubleResult = doubleResult + 8;
		doubleResult = doubleResult % 7;
		System.out.println(doubleResult);

	}
}
