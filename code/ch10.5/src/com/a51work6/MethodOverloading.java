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

// MethodOverloading.java文件
package com.a51work6;

class MethodOverloading {

	void receive(int i) {
		System.out.println("接收一个int参数");
		System.out.println("i = " + i);
	}

	void receive(int x, int y) {
		System.out.println("接收两个int参数");
		System.out.printf("x = %d, y = %d \r", x, y);
		return;
	}
	
	int receive(double x, double y) {
		System.out.println("接收两个double参数");
		System.out.printf("x = %f, y = %f \r", x, y);
		return 0;
	}
}
