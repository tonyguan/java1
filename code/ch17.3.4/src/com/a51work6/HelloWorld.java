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
import java.net.HttpURLConnection;
import java.net.URL;

public class HelloWorld {

	// Web服务网址
	static String urlString = "http://www.51work6.com/service/mynotes/WebService.php?"
			+ "email=tonytest@51work6.com&type=JSON&action=query";

	public static void main(String[] args) {

		BufferedReader br = null;
		HttpURLConnection conn = null;

		try {
			URL reqURL = new URL(urlString);
			conn = (HttpURLConnection) reqURL.openConnection();
			// conn.setRequestMethod("GET");

			// 打开网络通信输入流
			InputStream is = conn.getInputStream();
			// 通过is创建InputStreamReader对象
			InputStreamReader isr = new InputStreamReader(is, "utf-8");
			// 通过isr创建BufferedReader对象
			br = new BufferedReader(isr);

			StringBuilder sb = new StringBuilder();
			String line = br.readLine();
			while (line != null) {
				sb.append(line);
				sb.append('\n');
				line = br.readLine();
			}
			// 日志输出
			System.out.println(sb);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				conn.disconnect();
			}
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
