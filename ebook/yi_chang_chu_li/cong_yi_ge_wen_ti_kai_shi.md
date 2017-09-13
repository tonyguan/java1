## 14.1 从一个问题开始

为了学习Java异常处理机制，首先看看下面程序。


```java
//HelloWorld.java文件
package com.a51work6;

public class HelloWorld {

	public static void main(String[] args) {
		int a = 0;
		System.out.println(5 / a);			
	}
}
```


这个程序没有编译错误，但会发生如下的运行时错误：

	Exception in thread "main" java.lang.ArithmeticException: / by zero
		at com.a51work6.HelloWorld.main(HelloWorld.java:9)


在数学上除数不能为0，所以程序运行时表达式（5 / a）会抛出ArithmeticException异常，ArithmeticException是数学计算异常，凡是发生数学计算错误都会抛出该异常。

程序运行过程中难免会发生异常，发生异常并不可怕，程序员应该考虑到有可能发生这些异常，编程时应该捕获并进行处理异常，不能让程序发生终止，这就是健壮的程序。