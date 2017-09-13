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

public class HelloWorld {

	public static void main(String[] args) {

		String s1 = "Hello";
		// 使用+运算符连接
		String s2 = s1 + " ";
		String s3 = s2 + "World";
		System.out.println(s3);

		String s4 = "Hello";
		// 使用+运算符连接，支持+=赋值运算符
		s4 += " ";
		s4 += "World";
		System.out.println(s4);

		String s5 = "Hello";
		// 使用concat方法连接
		s5 = s5.concat(" ").concat("World");
		System.out.println(s5);

		int age = 18;
		String s6= "她的年龄是" + age + "岁。";
		System.out.println(s6);
		
		char score = 'A';
		String s7= "她的英语成绩是" + score;
		System.out.println(s7);
		
		java.util.Date now = new java.util.Date();
		//对象拼接自动调用toString()方法
		String s8= "今天是：" + now;
		System.out.println(s8);
		
	}
}
