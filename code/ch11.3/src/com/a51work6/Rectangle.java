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

//Rectangle.java文件
package com.a51work6;

// 矩形类
public class Rectangle {

	// 矩形宽度
	int width;
	// 矩形高度
	int height;
	// 矩形面积
	int area;

	// 构造方法
	public Rectangle(int w, int h) {
		width = w;
		height = h;
		area = getArea(w, h);
	}

	// 计算矩形面积
	int getArea(int w, int h) {
		int a;
		a = w * h;
		return a;
	}

	// 绘制矩形
	public void drawRect() {
		System.out.printf("绘制 %d X %d 矩形", width, height);
	}
}
