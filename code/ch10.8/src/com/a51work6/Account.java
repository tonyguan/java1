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

// Account.java文件
package com.a51work6;

public class Account {

	// 实例变量账户金额
	double amount = 0.0;
	// 实例变量账户名
	String owner;

	// 静态变量利率
	static double interestRate;

	// 静态方法
	public static double interestBy(double amt) {
		// 静态方法可以访问静态变量和其他静态方法
		return interestRate * amt;
	}

	// 静态代码块
	static {
		System.out.println("静态代码块被调用...");
		// 初始化静态变量
		interestRate = 0.0668;
	}
}
