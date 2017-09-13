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

public class HelloWorld {

	public static void main(String[] args) {

		Person p1 = new Student("Tom", 18, "清华大学");
		Person p2 = new Worker("Tom", 18, "钢厂");

		Person p3 = new Person("Tom", 28);
		Student p4 = new Student("Ben", 40, "清华大学");
		Worker p5 = new Worker("Tony", 28, "钢厂");

		// 向上转型
		Person p = (Person) p4;

		// 向下转型
		Student p11 = (Student) p1;
		Worker p12 = (Worker) p2;

		// Student p111 = (Student) p2;	//运行时异常
		if (p2 instanceof Student) {
			Student p111 = (Student) p2;
		}
		// Worker p121 = (Worker) p1;	//运行时异常
		if (p1 instanceof Worker) {
			Worker p121 = (Worker) p1;
		}
		// Student p131 = (Student) p3;	//运行时异常
		if (p3 instanceof Student) {
			Student p131 = (Student) p3;
		}

	}
}
