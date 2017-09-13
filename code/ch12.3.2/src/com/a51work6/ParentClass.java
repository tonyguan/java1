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

//ParentClass.java文件
package com.a51work6;

class ParentClass {
	// x成员变量
	int x;

	protected void setValue() {
		x = 10;
	}
}

class SubClass extends ParentClass {
	// 屏蔽父类x成员变量
	int x;

	@Override
	public void setValue() { // 覆盖父类方法
		// 访问子类对象x成员变量
		x = 20;
		// 调用父类setValue()方法
		super.setValue();
	}

	public void print() {
		// 访问子类对象x成员变量
		System.out.println("x = " + x);
		// 访问父类x成员变量
		System.out.println("super.x = " + super.x);
	}
}
