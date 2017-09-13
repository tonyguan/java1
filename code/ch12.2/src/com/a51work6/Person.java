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

//Person.java文件
package com.a51work6;

import java.util.Date;

public class Person {

	// 名字
	private String name;
	// 年龄
	private int age;
	// 出生日期
	private Date birthDate;

	// 三个参数构造方法
	public Person(String name, int age, Date d) {
		this.name = name;
		this.age = age;
		birthDate = d;
	}

	public Person(String name, int age) {
		// 调用三个参数构造方法
		this(name, age, new Date());
	}
	
//	public Person() {
//		
//	}

	@Override
	public String toString() {
		return "Person [name=" + name 
				+ ", age=" + age 
				+ ", birthDate=" + birthDate + "]";
	}

}
