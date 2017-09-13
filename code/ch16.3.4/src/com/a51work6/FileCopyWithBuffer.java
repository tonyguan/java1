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

//FileCopyWithBuffer.java文件
package com.a51work6;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopyWithBuffer {

	public static void main(String[] args) {

		try (FileInputStream fis = new FileInputStream("./TestDir/src.zip");
				BufferedInputStream bis = new BufferedInputStream(fis);
				FileOutputStream fos = new FileOutputStream("./TestDir/subDir/src.zip");
				BufferedOutputStream bos = new BufferedOutputStream(fos)) {
			
			//开始时间
			long startTime = System.nanoTime();
			// 准备一个缓冲区
			byte[] buffer = new byte[1024];
			// 首先读取一次
			int len = bis.read(buffer);

			while (len != -1) {
				// 开始写入数据
				bos.write(buffer, 0, len);
				// 再读取一次
				len = bis.read(buffer);
			}

			//结束时间
			long elapsedTime = System.nanoTime() - startTime;
			System.out.println("耗时：" + (elapsedTime / 1000000.0) + " 毫秒");

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
