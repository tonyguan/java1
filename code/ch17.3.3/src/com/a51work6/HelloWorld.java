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
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class HelloWorld {

	public static void main(String[] args) {
		// Web网址
		String url = "http://www.sina.com.cn/";
		URL reqURL;
		try {
			reqURL = new URL(url);
		} catch (MalformedURLException e1) {
			return;
		}

		try ( // 打开网络通信输入流
				InputStream is = reqURL.openStream();
				InputStreamReader isr = new InputStreamReader(is, "utf-8");
				BufferedReader br = new BufferedReader(isr)) {

			StringBuilder sb = new StringBuilder();
			String line = br.readLine();
			while (line != null) {
				sb.append(line);
				line = br.readLine();
			}
			// 日志输出
			System.out.println(sb);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
