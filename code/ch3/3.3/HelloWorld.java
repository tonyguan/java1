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
		
		//通过print打印第一个控制台参数
		System.out.print(args[0]);  
		//通过println打印第二个控制台参数
		System.out.println(args[1]);
		//通过printf打印第三个控制台参数，%s表示格式化字符串
		System.out.printf("%s", args[2]);
		System.out.println();

		int i = 123;
		//%d表示格式化整数
		System.out.printf("%d\n", i);

		double d = 123.456;
		//%f表示格式化浮点数
		System.out.printf("%f%n", d); 
		System.out.printf("%5.2f", d);

	}
}