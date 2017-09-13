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

		String sourceStr = "There is a string accessing example.";

		//获得字符串长度
		int len = sourceStr.length();
		//获得索引位置16的字符
		char ch = sourceStr.charAt(16);

		//查找字符和子字符串
		int firstChar1 = sourceStr.indexOf('r');
		int lastChar1 = sourceStr.lastIndexOf('r');
		int firstStr1 = sourceStr.indexOf("ing");
		int lastStr1 = sourceStr.lastIndexOf("ing");
		int firstChar2 = sourceStr.indexOf('e', 15);
		int lastChar2 = sourceStr.lastIndexOf('e', 15);
		int firstStr2 = sourceStr.indexOf("ing", 5);
		int lastStr2 = sourceStr.lastIndexOf("ing", 5);

		System.out.println("原始字符串:" + sourceStr);
		System.out.println("字符串长度:" + len);
		System.out.println("索引16的字符:" + ch);
		System.out.println("从前往后搜索r字符，第一次找到它所在索引:" + firstChar1);
		System.out.println("从后往前搜索r字符，第一次找到它所在的索引:" + lastChar1);
		System.out.println("从前往后搜索ing字符串，第一次找到它所在索引:" + firstStr1);
		System.out.println("从后往前搜索ing字符串，第一次找到它所在索引:" + lastStr1);
		System.out.println("从索引为15位置开始，从前往后搜索e字符，第一次找到它所在索引:" + firstChar2);
		System.out.println("从索引为15位置开始，从后往前搜索e字符，第一次找到它所在索引:" + lastChar2);
		System.out.println("从索引为5位置开始，从前往后搜索ing字符串，第一次找到它所在索引:" + firstStr2);
		System.out.println("从索引为5位置开始，从后往前搜索ing字符串，第一次找到它所在索引:" + lastStr2);

	}
}
