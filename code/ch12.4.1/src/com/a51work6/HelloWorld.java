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

//HelloWorld.java文件
package com.a51work6;

public class HelloWorld {

	public static void main(String[] args) {
		
		// f1变量是父类类型，指向父类实例
		Figure f1 = new Figure();
		f1.onDraw();

		// f2变量是父类类型，指向子类实例，发生多态
		Figure f2 = new Triangle();
		f2.onDraw();

		// f3变量是父类类型，指向子类实例，发生多态
		Figure f3 = new Ellipse();
		f3.onDraw();

		// f4变量是子类类型，指向子类实例
		Triangle f4 = new Triangle();
		f4.onDraw();

	}
}
