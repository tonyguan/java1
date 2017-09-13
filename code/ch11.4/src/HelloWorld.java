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
import java.util.Date;
import com.a51work6.Person;

public class HelloWorld {

	public static void main(String[] args) {

		Date now = new Date();
		Person p1 = new Person("Tom", 18, now);
		Person p2 = new Person("Tony", 20);
		Person p3 = new Person("Kity", now);
		Person p4 = new Person("John");

	}
}
