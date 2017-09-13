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

		String sourceStr = "There is a string accessing example.";
		// 截取example.子字符串
		String subStr1 = sourceStr.substring(28);
		// 截取string子字符串
		String subStr2 = sourceStr.substring(11, 17);
		System.out.printf("subStr1 = %s%n", subStr1);
		System.out.printf("subStr2 = %s%n",subStr2);

		// 使用split方法分割字符串
		System.out.println("-----使用split方法-----");
		String[] array = sourceStr.split(" ");
		for (String str : array) {
			System.out.println(str);
		}
	}
}
