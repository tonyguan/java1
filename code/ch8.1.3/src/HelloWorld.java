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

/*
 * 本例实现数组合并
 */
public class HelloWorld {

	public static void main(String[] args) {
		// 两个待合并数组
		int array1[] = { 20, 10, 50, 40, 30 };
		int array2[] = { 1, 2, 3 };

		// 动态初始化数组，设置数组的长度是array1和array2长度之和
		int array[] = new int[array1.length + array2.length];

		// 循环添加数组内容
		for (int i = 0; i < array.length; i++) {

			if (i < array1.length) {
				array[i] = array1[i];
			} else {
				array[i] = array2[i - array1.length];
			}
		}

		System.out.println("合并后:");
		for (int element : array) {
			System.out.printf("%d ", element);
		}
	}
}
