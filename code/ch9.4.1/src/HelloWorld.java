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

		//-----------------------------------
		// 字符串长度length和字符串缓冲区容量capacity
		StringBuilder sbuilder1 = new StringBuilder();
		System.out.println("包含的字符串长度：" + sbuilder1.length());
		System.out.println("字符串缓冲区容量：" + sbuilder1.capacity());

		StringBuilder sbuilder2 = new StringBuilder("Hello");
		System.out.println("包含的字符串长度：" + sbuilder2.length());
		System.out.println("字符串缓冲区容量：" + sbuilder2.capacity());

		// 字符串缓冲区初始容量是16，超过之后会扩容
		StringBuilder sbuilder3 = new StringBuilder();
		for (int i = 0; i < 17; i++) {
			sbuilder3.append(8);
		}
		System.out.println("包含的字符串长度：" + sbuilder3.length());
		System.out.println("字符串缓冲区容量：" + sbuilder3.capacity());
		
	}
}
