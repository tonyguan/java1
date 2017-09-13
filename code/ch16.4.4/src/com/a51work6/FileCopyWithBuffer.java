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

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileCopyWithBuffer {

	public static void main(String[] args) {

		try (FileReader fis = new FileReader("./TestDir/JButton.html");
				BufferedReader bis = new BufferedReader(fis);
				FileWriter fos = new FileWriter("./TestDir/subDir/JButton.html");
				BufferedWriter bos = new BufferedWriter(fos)) {

			// 首先读取一行文本
			String line = bis.readLine();
			
			while (line != null) {
				// 开始写入数据
				bos.write(line);
				//写一个换行符
				bos.newLine();
				// 再读取一行文本
				line = bis.readLine();
			}
			System.out.println("复制完成");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
