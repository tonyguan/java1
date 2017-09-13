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

		// 打印集合元素个数
		System.out.println("集合size = " + set.size());
		// 打印集合
		System.out.println(set);

		// 删除集合中第一个"B"元素
		set.remove(b);
		// 判断集合中是否包含"B"元素
		System.out.println("是否包含\"B\"：" + set.contains(b));
		// 判断集合是否为空
		System.out.println("set集合是空的：" + set.isEmpty());

		// 清空集合
		set.clear();
		System.out.println(set);
	}
}
