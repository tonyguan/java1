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

import java.io.File;
import java.io.FilenameFilter;

public class HelloWorld {

	public static void main(String[] args) {

		// 用File对象表示一个目录,.表示当前目录
		File dir = new File("./TestDir");//TestDir
		// 创建HTML文件过滤器
		Filter filter = new Filter("html");

		System.out.println("HTML文件目录：" + dir);
		// 列出目录TestDir下，文件后缀名为HTML的所有文件
		String files[] = dir.list(filter); //dir.list();
		// 遍历文件列表
		for (String fileName : files) {
			// 为目录TestDir下的文件或目录创建File对象
			File f = new File(dir, fileName);
			// 如果该f对象是文件，则打印文件名
			if (f.isFile()) {
				System.out.println("文件名：" + f.getName());
				System.out.println("文件绝对路径：" + f.getAbsolutePath());
				System.out.println("文件路径：" + f.getPath());
			} else {
				System.out.println("子目录：" + f);
			}
		}

	}
}

// 自定义基于文件扩展名的文件过滤器
class Filter implements FilenameFilter {

	// 文件扩展名
	String extent;

	// 构造方法
	Filter(String extent) {
		this.extent = extent;
	}

	@Override
	public boolean accept(File dir, String name) {
		// 测试文件扩展名是否为extent所指定的
		return name.endsWith("." + extent);
	}
}
