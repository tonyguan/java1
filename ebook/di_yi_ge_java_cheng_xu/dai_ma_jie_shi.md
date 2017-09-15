## 3.3 代码解释

经过前文的介绍，读者应该能够照猫画虎，自己动手做一个Java应用程序了。但还是对其中的一些代码不甚了解，下面来详细解释一下HelloWorld示例中的代码。


```java
//包定义
package com.a51work6; ①

//类定义
public class HelloWorld { ②

	//定义静态main方法
	public static void main(String[] args) { ③
		System.out.print("Hello World.");  ④	
	}

}

```

代码第①行是定义类所在的包，package是关键字，com.a51work6是包名，包是一个命名空间，可以防止命名冲突问题，关于包的概念将在后面章节详细介绍。

代码第②行是定义类，public修饰符是声明类是公有的，class是定义类关键字，HelloWorld是自定义的类名了，后面跟有“{…}”是类体，类体中会有成员变量和方法，也会有一些静态变量和方法。

代码第③行是定义静态main方法，而作为一个Java应用程序，类中必须包含静态main方法，程序执行是从main方法开始的。main方法中除参数名args可以自定义外，其他必须严格遵守如下来两种格式：


```java
public static void main(String args[])
public static void main(String[] args)
```

这两种格式本质上就是一种，String args[]和String[] args都是声明String数组。另外，args参数是程序运行时，通过控制台向应用程序传递字符串参数。

代码第④行System.out.print(&quot;Hello World.&quot;);语句是通过Java输出流（PrintStream）对象System.out打印Hello World.字符串，System.out是标准输出流对象，它默认输出到控制台。输出流（PrintStream）中常用打印方法：

*   print(String s) ：打印字符串不换行，有多个重载方法，可以打印任何类型数据。
*   println(String x) ：打印字符串换行，有多个重载方法，可以打印任何类型数据。
*   printf(String format, Object... args) ：使用指定输出格式，打印任何长度的数据，但不换行。

修改HelloWorld.java示例代码如下：

```java
public class HelloWorld {
	public static void main(String[] args) {
		
		//通过print打印第一个控制台参数
		System.out.print(args[0]);  ①
		//通过println打印第二个控制台参数
		System.out.println(args[1]);  ②
		//通过printf打印第三个控制台参数，%s表示格式化字符串
		System.out.printf("%s", args[2]);  ③
		System.out.println();

		int i = 123;
		//%d表示格式化整数
		System.out.printf("%d\n", i);  ④

		double d = 123.456;
		//%f表示格式化浮点数
		System.out.printf("%f%n", d);  ⑤
		System.out.printf("%5.2f", d);  ⑥

	}
}
```

编译HelloWorld.java源代码后，通过如图3-11所示，其中的java命令行后面的HelloWorld是要运行的类文件，Tony Hello World.是参数，多个参数用空格分割。

![3-11](../assets/3-11.jpeg)

图3-11 在命令行中运行程序

上述代码第①行使用print方法打印第一个参数args[0]，注意该方法是打印完成后面不换行，从输出结果中可见第一个参数Tony和第二个参数Hello连在一起了。代码第②行使用println方法打印第二个参数args[1]，从输出结果中可见第二个参数Hello后面是有换行的。

代码第③、④、⑤、⑥行都是使用printf方法打印，注意printf方法后面是没有换行的，想在后面换行可以通过System.out.println()语句实现，或在打印第字符串后面添加换行符号（\n或%n），见代码第④行和第⑤行。代码第%5.2f也表示格式化浮点数，5表示总输出的长度，2表示保留的小数位。