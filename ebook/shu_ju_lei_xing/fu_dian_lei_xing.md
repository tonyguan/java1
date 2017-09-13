## 5.3 浮点类型

浮点类型主要用来储存小数数值，也可以用来储存范围较大的整数。它分为浮点数（float）和双精度浮点数（double）两种，双精度浮点数所使用的内存空间比浮点数多，可表示的数值范围与精确度也比较大。浮点类型说明如表5-2所示。

表 5-2 浮点类型

| **浮点类型** | **宽度** |
| --- | --- |
| float | 4个字节（32位） |
| double | 8个字节（64位） |

Java语言的浮点类型默认是double类型，例如0.0表示double类型常量，而不是float类型。如果想要表示float类型，则需要在数值后面加f或F，示例代码如下：

```java
public class HelloWorld {

	public static void main(String[] args) {
		// 声明浮点数
		// 输出一个默认浮点常量
		System.out.println("默认浮点常量	=  " + 360.66); 		①
		float myMoney = 360.66f; 						②
		double yourMoney = 360.66;						③
		final double PI = 3.14159d;						④
		
		System.out.println("float整数 	=  " + myMoney);
		System.out.println("double整数	=  " + yourMoney);
		System.out.println("PI		=  " + PI);
		
	}
}
```

上述代码①行的360.66是默认浮点类型double。代码②行360.66f是float浮点类型，float浮点类型常量表示时，数值后面需要加f或F。代码第③行的360.66表示是double浮点类型。事实上double浮点数值后面也可以加字母d或D，以表示是double浮点数，代码第④行是声明一个double类型常量，数值后面加了d字母。