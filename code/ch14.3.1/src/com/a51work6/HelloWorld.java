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

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class HelloWorld {

	public static void main(String[] args) {
		Date date = readDate();
		System.out.println("日期  = " + date);
	}

	// 解析日期
	public static Date readDate() {

		try {
			String str = "2018-18-18"; //"201A-18-18"
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			// 从字符串中解析日期
			Date date = df.parse(str);
			return date;
		} catch (ParseException e) {
			System.out.println("处理ParseException...");
			e.printStackTrace();
		}
		return null;
	}
}
