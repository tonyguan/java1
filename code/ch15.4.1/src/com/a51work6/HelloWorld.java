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

import java.util.HashMap;
import java.util.Map;

public class HelloWorld {

	public static void main(String[] args) {

		Map map = new HashMap();

		map.put(102, "张三");
		map.put(105, "李四");
		map.put(109, "王五");
		map.put(110, "董六");
		//"李四"值重复
		map.put(111, "李四");
		//109键已经存在，替换原来值"王五"
		map.put(109, "刘备");

		// 打印集合元素个数
		System.out.println("集合size = " + map.size());
		// 打印集合
		System.out.println(map);

		// 通过键取值
		System.out.println("109 - " + map.get(109));
		System.out.println("108 - " + map.get(108));

		// 删除键值对
		map.remove(109);
		// 判断键集合中是否包含109
		System.out.println("键集合中是否包含109：" + map.containsKey(109));
		// 判断值集合中是否包含 "李四"
		System.out.println("值集合中是否包含：" + map.containsValue("李四"));

		// 判断集合是否为空
		System.out.println("集合是空的：" + map.isEmpty());

		// 清空集合
		map.clear();
		System.out.println(map);
	}
}
