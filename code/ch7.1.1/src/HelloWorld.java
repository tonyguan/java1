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

		// 1. if结构
		int score = 95;
		if (score >= 85) {
			System.out.println("您真优秀！");
		}
		if (score < 60) {
			System.out.println("您需要加倍努力！");
		}
		if ((score >= 60) && (score < 85)) {
			System.out.println("您的成绩还可以，仍需继续努力！");
		}

		// 2. if-else结构
		if (score < 60) {
			System.out.println("不及格");
		} else {
			System.out.println("及格");
		}

		// 3. else-if结构
		int testScore = 76;
		char grade;
		if (testScore >= 90) {
			grade = 'A';
		} else if (testScore >= 80) {
			grade = 'B';
		} else if (testScore >= 70) {
			grade = 'C';
		} else if (testScore >= 60) {
			grade = 'D';
		} else {
			grade = 'F';
		}
		System.out.println("Grade = " + grade);

	}
}
