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
		
		// 静态初始化二维数组
		int[][] intArray = { 
				{ 1, 2, 3 }, 
				{ 11, 12, 13 }, 
				{ 21, 22, 23 },
				{ 31, 32, 33 } };

		// 动态初始化二维数组
		double[][] doubleArray = new double[4][3];

		// 计算数组intArray元素的平方根，结果保存到doubleArray
		for (int i = 0; i < intArray.length; i++) {
			for (int j = 0; j < intArray[i].length; j++) {
				// 计算平方根
				doubleArray[i][j] = Math.sqrt(intArray[i][j]);
			}
		} 

		// 打印数组doubleArray
		for (int i = 0; i < doubleArray.length; i++) {
			for (int j = 0; j < doubleArray[i].length; j++) {
				System.out.printf("[%d][%d] = %f", i, j, doubleArray[i][j]);
				System.out.print('\t');
			}
			System.out.println();
		}

	}
}
