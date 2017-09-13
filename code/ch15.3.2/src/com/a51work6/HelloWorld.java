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

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HelloWorld {

	public static void main(String[] args) {

		Set set = new HashSet();

		String b = "B";
		// 向集合中添加元素
		set.add("A");
		set.add(b);
		set.add("C");
		set.add(b);
		set.add("D");
		set.add("E");

		// 1.使用for-each循环遍历
		System.out.println("--1.使用for-each循环遍历--");
		for (Object item : set) {
			String s = (String) item;
			System.out.println("读取集合元素: " + s);
		}

		// 2.使用迭代器遍历
		System.out.println("--2.使用迭代器遍历--");
		Iterator it = set.iterator();
		while (it.hasNext()) {
			Object item = it.next();
			String s = (String) item;
			System.out.println("读取集合元素: " + s);
		}
	}
}
