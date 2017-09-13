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

		//添加字符串、字符
		StringBuilder sbuilder1 = new StringBuilder("Hello");
		sbuilder1.append(" ").append("World");
		sbuilder1.append('.');
		System.out.println(sbuilder1);
		
		StringBuilder sbuilder2 = new StringBuilder();
		Object obj = null;
		//添加布尔值、转义符和空对象
		sbuilder2.append(false).append('\t').append(obj);
		System.out.println(sbuilder2);

		//添加数值
		StringBuilder sbuilder3 = new StringBuilder();
		for (int i = 0; i < 10; i++) {
			sbuilder3.append(i);
		} 
		System.out.println(sbuilder3);
	}
}
