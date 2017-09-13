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

//Downloader.java文件
package com.a51work6;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class Downloader {

	// Web服务网址
	private static String urlString = "https://ss0.bdstatic.com/5aV1bjqh_Q23odCf/"
			+ "static/superman/img/logo/bd_logo1_31bdc765.png";

	public static void main(String[] args) {
		download();
	}

	// 下载方法
	private static void download() {

		HttpURLConnection conn = null;

		try {
			// 创建URL对象
			URL reqURL = new URL(urlString);
			// 打开连接
			conn = (HttpURLConnection) reqURL.openConnection();

			try (// 从连接对象获得输入流
					InputStream is = conn.getInputStream();
					BufferedInputStream bin = new BufferedInputStream(is);
					// 创建文件输出流
					OutputStream os = new FileOutputStream("./download.png");
					BufferedOutputStream bout = new BufferedOutputStream(os);) {

				byte[] buffer = new byte[1024];
				int bytesRead = bin.read(buffer);
				while (bytesRead != -1) {
					bout.write(buffer, 0, bytesRead);
					bytesRead = bin.read(buffer);
				}
			} catch (IOException e) {
			}
			System.out.println("下载完成。");
		} catch (IOException e) {
		} finally {
			if (conn != null) {
				conn.disconnect();
			}
		}
	}
}
