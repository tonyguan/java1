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

	// 公有级别限制
	public Person(String n, int a, Date d) {
		name = n;
		age = a;
		birthDate = d;
	}

	// 默认级别限制
	Person(String n, int a) {
		name = n;
		age = a;
	}

	// 保护级别限制
	protected Person(String n, Date d) {
		name = n;
		age = 30;
		birthDate = d;
	}

	// 私有级别限制
	private Person(String n) {
		name = n;
		age = 30;
	}

	public String getInfo() {
		StringBuilder sb = new StringBuilder();
		sb.append("名字: ").append(name).append('\n');
		sb.append("年龄: ").append(age).append('\n');
		sb.append("出生日期: ").append(birthDate).append('\n');
		return sb.toString();
	}
}
