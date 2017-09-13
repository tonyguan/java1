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

		int[] numbers = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

		for (int i = 0; i < numbers.length; i++) {
			if (i == 3) {
				continue;
			}
			System.out.println("Count is: " + i);
		}

		label1: for (int x = 0; x < 5; x++) {
			for (int y = 5; y > 0; y--) {
				if (y == x) {
					continue label1;
				}
				System.out.printf("(x,y) = (%d,%d)", x, y);
				System.out.println();
			}
		}
		System.out.println("Game Over!");
	}
}
