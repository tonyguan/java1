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

	// 声明int型成员变量
	int y;

	public static void main(String[] args) {

		// 声明int型局部变量
		int x;
		// 声明float型变量并赋值
		float f = 4.5f;

		x = 10;
		System.out.println("x = " + x);// 编译错误，局部变量 x未初始化
		System.out.println("f = " + f);

		if (f < 10) {
			// 声明型局部变量
			int m = 5;
		}
		//System.out.println(m);
	}

}
