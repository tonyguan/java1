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

// HelloWorld.java文件
package com.a51work6;

public class HelloWorld {

	public static void main(String[] args) {
		// 访问静态变量
		System.out.println(Account.interestRate);
		// 访问静态方法
		System.out.println(Account.interestBy(1000));

		Account myAccount = new Account();
		// 访问实例变量
		myAccount.amount = 1000000;
		myAccount.owner = "Tony";
		// 访问实例方法
		System.out.println(myAccount.messageWith(1000));

		// 通过实例访问静态变量
		System.out.println(myAccount.interestRate);
	}
}
