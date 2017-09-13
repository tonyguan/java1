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
package com.a51work6.imp;

import com.a51work6.InterfaceA;

public class HelloWorld {

	public static void main(String[] args) {

		//声明接口类型，对象是实现类，发生多态
		InterfaceA abc = new ABC();

		// 访问实现类methodB方法
		System.out.println(abc.methodB());

		// 访问默认方法methodC
		System.out.println(abc.methodC());

		// 访问默认方法methodD
		System.out.println(abc.methodD());

		// 访问InterfaceA静态方法methodE
		System.out.println(InterfaceA.methodE());
	}
}
