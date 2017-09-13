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

		Student student1 = new Student("Tom", 18, "清华大学");
		Student student2 = new Student("Ben", 28, "北京大学");
		Student student3 = new Student("Tony", 38, "香港大学");

		Worker worker1 = new Worker("Tom", 18, "钢厂");
		Worker worker2 = new Worker("Ben", 20, "电厂");

		Person[] people = { student1, student2, student3, worker1, worker2 };

		int studentCount = 0;
		int workerCount = 0;

		for (Person item : people) {
			if (item instanceof Worker) {
				workerCount++;
			} else if (item instanceof Student) {
				studentCount++;
			}
		}
		
		System.out.printf("工人人数：%d，学生人数：%d", workerCount, studentCount);
	}
}
