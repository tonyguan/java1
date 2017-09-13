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

		// 创建字符串对象
		String s1 = new String();
		String s2 = new String("Hello World");
		String s3 = new String("\u0048\u0065\u006c\u006c\u006f\u0020\u0057\u006f\u0072\u006c\u0064");
		System.out.println("s2 = " + s2);
		System.out.println("s3 = " + s3);
		

		char chars[] = { 'a', 'b', 'c', 'd', 'e' };
		// 通过字符数组创建字符串对象
		String s4 = new String(chars);
		// 通过子字符数组创建字符串对象
		String s5 = new String(chars, 1, 4);
		System.out.println("s4 = " + s4);
		System.out.println("s5 = " + s5);

		byte bytes[] = { 97, 98, 99 };
		// 通过byte数组创建字符串对象
		String s6 = new String(bytes);
		System.out.println("s6 = " + s6);
		System.out.println("s6字符串长度 = " + s6.length());

	}
}
