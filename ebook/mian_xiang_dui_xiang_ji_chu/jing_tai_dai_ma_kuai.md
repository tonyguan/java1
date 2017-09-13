## 10.8 静态代码块

前面介绍的静态变量interestRate，可以在声明同时初始化，如下代码所示。

```java
public class Account {

	// 静态变量利率
	static double interestRate = 0.0668;
	...
}

```

如果初始化静态变量不是简单常量，需要进行计算才能初始化，可以使用静态（static）代码块，静态代码块在类第一次加载时执行，并只执行一次。示例代码如下：

```java
// Account.java文件
package com.a51work6;

public class Account {

	// 实例变量账户金额
	double amount = 0.0;
	// 实例变量账户名
	String owner;

	// 静态变量利率
	static double interestRate;

	// 静态方法
	public static double interestBy(double amt) {
		// 静态方法可以访问静态变量和其他静态方法
		return interestRate * amt;
	}

	// 静态代码块
	static { ①
		System.out.println("静态代码块被调用...");
		// 初始化静态变量
		interestRate = 0.0668;	②
	}
}
```

上述代码第①行是静态代码块，在静态代码块中可以初始化静态变量，见代码第②行，也可以调用静态方法。
调用Account代码如下：

```java
// HelloWorld.java文件
package com.a51work6;

public class HelloWorld {

	public static void main(String[] args) {

		Account myAccount = new Account();①
		// 访问静态变量
		System.out.println(Account.interestRate);②
		// 访问静态方法
		System.out.println(Account.interestBy(1000));

	}
}
```

Account静态代码块是在第一次加载Account类时调用。上述代码第①行是第一次使用Account类，此时会调用静态代码块。