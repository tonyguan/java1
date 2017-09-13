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

//FinalDemo.java文件
package com.a51work6;

class FinalDemo {

	void doSomething() {
		// 没有在声明的同时赋值
		final int e;
		// 只能赋值一次
		e = 100;
		System.out.print(e);
		// 声明的同时赋值
		final int f = 200;
	}

	// 实例常量
	final int a = 5; // 直接赋值
	final int b; // 空白final变量

	// 静态常量
	final static int c = 12;// 直接赋值
	final static int d; // 空白final变量

	// 静态代码块
	static {
		// 初始化静态变量
		d = 32;
	}

	// 构造方法
	FinalDemo() {
		// 初始化实例变量
		b = 3;
		// 第二次赋值，会发生编译错误
		// b = 4;
	}
}