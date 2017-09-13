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

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class HelloWorld {

	public static void main(String[] args) {
		try {
			Date date = readDate();
			System.out.println("读取的日期  = " + date);
		} catch (MyException e) {
			System.out.println("处理MyException...");
			e.printStackTrace();
		}

	}

	public static Date readDate() throws MyException {

		// 自动资源管理
		try (FileInputStream readfile = new FileInputStream("readme.txt");
				InputStreamReader ir = new InputStreamReader(readfile);
				BufferedReader in = new BufferedReader(ir)) {

			// 读取文件中的一行数据
			String str = in.readLine();
			if (str == null) {
				return null;
			}

			DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			Date date = df.parse(str);
			return date;

		} catch (FileNotFoundException e) {
			throw new MyException(e.getMessage());
		} catch (IOException e) {
			throw new MyException(e.getMessage());
		} catch (ParseException e) {
			System.out.println("处理ParseException...");
			e.printStackTrace();
		}

		return null;
	}

}
