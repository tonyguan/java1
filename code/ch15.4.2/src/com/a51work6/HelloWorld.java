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

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class HelloWorld {

	public static void main(String[] args) {

		Map map = new HashMap();

		map.put(102, "张三");
		map.put(105, "李四");
		map.put(109, "王五");
		map.put(110, "董六");
		map.put(111, "李四");

		// 1.使用for-each循环遍历
		System.out.println("--1.使用for-each循环遍历--");
		// 获得键集合
		Set keys = map.keySet();
		for (Object key : keys) {
			int ikey = (Integer) key; // 自动拆箱
			String value = (String) map.get(ikey); // 自动装箱
			System.out.printf("key=%d - value=%s \n", ikey, value);
		}

		// 2.使用迭代器遍历
		System.out.println("--2.使用迭代器遍历--");
		// 获得值集合
		Collection values = map.values();
		// 遍历值集合
		Iterator it = values.iterator();
		while (it.hasNext()) {
			Object item = it.next();
			String s = (String) item;
			System.out.println("值集合元素: " + s);
		}
	}
}
