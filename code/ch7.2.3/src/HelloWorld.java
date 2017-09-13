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

		System.out.println("---------");

		for (int i = 1; i < 10; i++) {
			System.out.printf("%d x %d = %d", i, i, i * i);
			// 打印一个换行符，实现换行
			System.out.println();
		}

		System.out.println("---------");
		
		int x;
		int y;

		for (x = 0, y = 10; x < y; x++, y--) {
			System.out.printf("(x,y) = (%d, %d)", x, y);
			// 打印一个换行符，实现换行
			System.out.println();
		}

	}
}
