## 14.2 异常类继承层次

异常封装成为类Exception，此外，还有Throwable和Error类，异常类继承层次如图14-1所示。

![14-1](.../assets/14-1.jpg)

图14-1　Java异常类继承层次

### 14.2.1 Throwable类

从图14-1可见，所有的异常类都直接或间接地继承于java.lang.Throwable类，在Throwable类有几个非常重要的方法：

*   String getMessage()：获得发生异常的详细消息。
*   void printStackTrace()：打印异常堆栈跟踪信息。
*   String toString()：获得异常对象的描述。

**提示 堆栈跟踪是方法调用过程的轨迹，它包含了程序执行过程中方法调用的顺序和所在源代码行号。**

为了介绍Throwable类的使用，下面修改14.1节的示例代码如下：


```java
//HelloWorld.java文件
package com.a51work6;

public class HelloWorld {

	public static void main(String[] args) {

		int a = 0;
		int result = divide(5, a);
		System.out.printf("divide(%d, %d) = %d", 5, a, result);
	}

	public static int divide(int number, int divisor) {

		try {
			return number / divisor;
		} catch (Throwable throwable) { ①

			System.out.println("getMessage() : " + throwable.getMessage()); ②

			System.out.println("toString() : " + throwable.toString()); ③

			System.out.println("printStackTrace()输出信息如下：");
			throwable.printStackTrace();	④
		}

		return 0;
	}
}
```


运行结果如下：

	getMessage() : / by zero
	toString() : java.lang.ArithmeticException: / by zero
	printStackTrace()输出信息如下：
	java.lang.ArithmeticException: / by zero
		at com.a51work6.HelloWorld.divide(HelloWorld.java:17)
		at com.a51work6.HelloWorld.main(HelloWorld.java:10)
	divide(5, 0) = 0


将可以发生异常的语句System.out.println(5 / a)放到try-catch代码块中，称为捕获异常，有关捕获异常的相关知识会在下一节详细介绍。在catch中有一个Throwable对象throwable，throwable对象是系统在程序发生异常时创建，通过throwable对象可以调用Throwable中定义的方法。

代码第②行是调用getMessage()方法获得异常消息，输出结果是“/ by zero”。代码第③行是调用toString()方法获得异常对象的描述，输出结果是java.lang.ArithmeticException: / by zero。代码第④行是调用printStackTrace()方法打印异常堆栈跟踪信息。

提示 堆栈跟踪信息从下往上，是方法调用的顺序。首先JVM调用是com.a51work6.HelloWorld类的main方法，接着在HelloWorld.java源代码第10行调用com.a51work6.HelloWorld类的divide方法，在HelloWorld.java源代码第17行发生了异常，最后输出的是异常信息。

### 14.2.2 Error和Exception

从图14-1可见，Throwable有两个直接子类：Error和Exception。

#####1.  Error

Error是程序无法恢复的严重错误，程序员根本无能为力，只能让程序终止。例如：JVM内部错误、内存溢出和资源耗尽等严重情况。

#####2.  Exception

Exception是程序可以恢复的异常，它是程序员所能掌控的。例如：除零异常、空指针访问、网络连接中断和读取不存在的文件等。本章所讨论的异常处理就是对Exception及其子类的异常处理。

###14.2.3 受检查异常和运行时异常

从图14-1可见，Exception类可以分为：受检查异常和运行时异常。

#####1.  受检查异常

如图14-1所示，受检查异常是除RuntimeException以外的异常类。它们的共同特点是：编译器会检查这类异常是否进行了处理，即要么捕获（try-catch语句），要么不抛出（通过在方法后声明throws），否则会发生编译错误。它们种类很多，前面遇到过的日期解析异常ParseException。

#####2.  运行时异常

运行时异常是继承RuntimeException类的直接或间接子类。运行时异常往往是程序员所犯错误导致的，健壮的程序不应该发生运行时异常。它们的共同特点是：编译器不检查这类异常是否进行了处理，也就是对于这类异常不捕获也不抛出，程序也可以编译通过。由于没有进行异常处理，一旦运行时异常发生就会导致程序的终止，这是用户不希望看到的。由于14.2.1节除零示例的ArithmeticException异常属于RuntimeException异常，见图14-1所示，可以不用加try-catch语句捕获异常。

**提示 对于运行时异常通常不采用抛出或捕获处理方式，而是应该提前预判，防止这种发生异常，做到未雨绸缪。例如14.2.1节除零示例，在进行除法运算之前应该判断除数是非零的，修改示例代码如下，从代码可见提前预判这样处理要比通过try-catch捕获异常要友好的多。
**

```java
//HelloWorld.java文件
package com.a51work6;

public class HelloWorld {

	public static void main(String[] args) {

		int a = 0;
		int result = divide(5, a);
		System.out.printf("divide(%d, %d) = %d", 5, a, result);
	}

	public static int divide(int number, int divisor) {

		//判断除数divisor非零，防止运行时异常
		if (divisor != 0) {
			return number / divisor;
		}
		return 0;
	}

}


```

除了图14-1所示异常，还有很多异常，本书不能一一穷尽，随着学习的深入会介绍一些常用的异常，其他异常读者可以自己查询API文档。