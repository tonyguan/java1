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

		// 声明并初始化int数组
		int[] numbers = { 43, 32, 53, 54, 75, 7, 10 };

		System.out.println("----for-------");
		// for语句
		for (int i = 0; i < numbers.length; i++) {
			System.out.println("Count is:" + numbers[i]);
		}

		System.out.println("----for each----");
		// for-each语句
		for (int item : numbers) {
			System.out.println("Count is:" + item);
		}

	}
}
