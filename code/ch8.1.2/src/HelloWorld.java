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

		// 静态初始化
		int[] intArray1 = { 21, 32, 43, 45 };
		String[] strArray1 = { "张三", "李四", "王五", "董六" };

		int intArray[];
		// 动态初始化int数组
		intArray = new int[4];
		intArray[0] = 21;
		intArray[1] = 32;
		intArray[2] = 43;
		intArray[3] = 45;

		// 动态初始化String数组
		String[] stringArray = new String[4];
		// 初始化数组中元素
		stringArray[0] = "张三";
		stringArray[1] = "李四";
		stringArray[2] = "王五";
		stringArray[3] = "董六";

	}
}
