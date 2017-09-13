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

import java.util.Date;

public class HelloWorld {

	public static void main(String[] args) {

		int score = 80;
		String result = score > 60 ? "及格" : "不及格"; // 三元运算符（? : ）
		System.out.println(result);
		
		Date date = new Date(); 	// new运算符可以创建Date对象
		System.out.println(date.toString());// 通过.运算符调用方法

	}
}
