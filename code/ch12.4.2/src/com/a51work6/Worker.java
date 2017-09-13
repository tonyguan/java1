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

//Worker.java文件
package com.a51work6;

public class Worker extends Person {

	String factory;

	public Worker(String name, int age, String factory) {
		super(name, age);
		this.factory = factory;
	}

	@Override
	public String toString() {
		return "Worker [factory=" + factory 
				+ ", name=" + name 
				+ ", age=" + age + "]";
	}
}
