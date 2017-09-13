## 5.2 整型类型

从图5-1可见Java中整数类型包括：byte、short、int和long ，它们之间的区别仅仅是宽度和范围的不同。Java中整数都是有符号，与C不同没有无符号的整数类型。

Java的数据类型是跨平台的（与平台无关），无论你计算机是32位的还是64为的，byte类型整数都是一个字节（8位）。这些整数类型的宽度和范围如表5-1所示。

表 5-1 整数类型

| **整数类型** | **宽度** | **取值范围** |
| --- | --- | --- |
| byte | 1个字节（8位） | -128~127 |
| short | 2个字节（16位） | -2<sup>15</sup>~2<sup>15</sup>-1 |
| int | 4个字节（32位） | -2<sup>31</sup>~2<sup>31</sup>-1 |
| long | 8个字节（64位） | -2<sup>63</sup>~2<sup>63</sup>-1 |

Java语言的整型类型默认是int类型，例如16表示为int类型常量，而不是short或byte，更不是long，long类型需要在数值后面加l（小写英文字母）或L（大写英文字母），示例代码如下：


```java
public class HelloWorld {

	public static void main(String[] args) {
		// 声明整数变量
		// 输出一个默认整数常量
		System.out.println("默认整数常量	=  " + 16);		①
		byte a = 16;								②
		short b = 16; 								③
		int c = 16; 									④
		long d = 16L; 								⑤
		long e = 16l; 								⑥
		
		System.out.println("byte整数 		=  " + a);
		System.out.println("short整数		=  " + b);
		System.out.println("int整数		=  " + c);
		System.out.println("long整数 		=  " + d);
		System.out.println("long整数 		=  " + e);
		
	}
}
```

上述代码多次用到了16整数，但它们是有所区别的。其中代码①行的16是默认整数类型，即int类型常量。代码②行16是byte整数类型。代码③行的16是short类型。代码第④行的16是int类型。代码第⑤行的16后加了L，这是说明long类型整数。代码第⑥行的16后加了l（小写英文字母l），这是也long类型整数。

**提示 在程序代码中，尽量不用小写英文字母l，因为它容易与数字1混淆，特别是在Java中表示long类型整数时候很少使用小写英文字母l，而是使用大写的英文字母L。例如：16L要比16l可读性更好。**