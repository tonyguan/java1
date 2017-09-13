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

		int intArray[][] = new int[4][]; //先初始化高维数组为4
		//逐一初始化低维数组
		intArray[0] = new int[2]; 
		intArray[1] = new int[1];
		intArray[2] = new int[3];
		intArray[3] = new int[3];
		
		//for循环遍历
		for (int i = 0; i < intArray.length; i++) {
			for (int j = 0; j < intArray[i].length; j++) {
				intArray[i][j] = i + j;
			}
		} 
		//for-each循环遍历
		for (int[] row : intArray) {
			for (int column : row) {				
				System.out.print(column);
				//在元素之间添加制表符，
				System.out.print('\t');
			}
			//一行元素打印完成后换行
			System.out.println();
		} 
		
		//System.out.println(intArray[0][2]); //发生运行期错误		
	}
}
