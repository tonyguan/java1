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

		char c1 = 'A';
		char c2 = '\u0041';
		char c3 = '花';

		System.out.println(c1);
		System.out.println(c2);
		System.out.println(c3);
		
		//转义符
		//在Hello和World插入制表符
		String specialCharTab1 = "Hello\tWorld.";
		//在Hello和World插入制表符，制表符采用Unicode编码\u0009表示
		String specialCharTab2 = "Hello\u0009World.";
		//在Hello和World插入换行符
		String specialCharNewLine = "Hello\nWorld.";
		//在Hello和World插入回车符
		String specialCharReturn = "Hello\rWorld.";
		//在Hello和World插入双引号
		String specialCharQuotationMark = "Hello\"World\".";
		//在Hello和World插入单引号
		String specialCharApostrophe = "Hello\'World\'.";
		//在Hello和World插入反斜杠
		String specialCharReverseSolidus = "Hello\\World.";
		
		System.out.println("水平制表符tab1: " + specialCharTab1);
		System.out.println("水平制表符tab2: " + specialCharTab2);
		System.out.println("换行: " + specialCharNewLine);
		System.out.println("回车: " + specialCharReturn);
		System.out.println("双引号: " + specialCharQuotationMark);
		System.out.println("单引号: " + specialCharApostrophe);
		System.out.println("反斜杠: " + specialCharReverseSolidus);		
		
	}
}
