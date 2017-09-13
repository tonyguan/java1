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

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class HelloWorld {

	public static void main(String[] args) {

		List list = new ArrayList();

		String b = "B";
		// 向集合中添加元素
		list.add("A");
		list.add(b);
		list.add("C");
		list.add(b);
		list.add("D");
		list.add("E");

		// 1.使用for循环遍历
		System.out.println("--1.使用for循环遍历--");
		for (int i = 0; i < list.size(); i++) {
			System.out.printf("读取集合元素(%d): %s \n", i, list.get(i));
		}

		// 2.使用for-each循环遍历
		System.out.println("--2.使用for-each循环遍历--");
		for (Object item : list) {
			String s = (String) item;
			System.out.println("读取集合元素: " + s);
		}

		// 3.使用迭代器遍历
		System.out.println("--3.使用迭代器遍历--");
		Iterator it = list.iterator();
		while (it.hasNext()) {
			Object item = it.next();
			String s = (String) item;
			System.out.println("读取集合元素: " + s);
		}
	}
}
