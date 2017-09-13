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

//FileCopy.java文件
package com.a51work6;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileCopy {

	public static void main(String[] args) {

		try (FileReader in = new FileReader("./TestDir/build.txt");
				FileWriter out = new FileWriter("./TestDir/subDir/build.txt")) {

			// 准备一个缓冲区
			char[] buffer = new char[10];
			// 首先读取一次
			int len = in.read(buffer);

			while (len != -1) {
				String copyStr = new String(buffer);
				// 打印复制的字符串
				System.out.println(copyStr);
				// 开始写入数据
				out.write(buffer, 0, len);
				// 再读取一次
				len = in.read(buffer);
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
