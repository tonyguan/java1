## 12.5 再谈final关键字

在前面的学习过程中，为了声明常量使用过final关键字，在Java中final关键字的作用还有很多，final关键字能修饰变量、方法和类。下面详细说明。

### 12.5.1 final修饰变量

final修饰的变量即成为常量，只能赋值一次，但是final所修饰局部变量和成员变量有所不同。

**1.  final修饰的局部变量必须使用之前被赋值一次才能使用。
2.  final修饰的成员变量在声明时没有赋值的叫“空白final变量”。空白final变量必须在构造方法或静态代码块中初始化。**

final修饰变量示例代码如下：


```java
//FinalDemo.java文件
package com.a51work6;

class FinalDemo {

	void doSomething() {
		// 没有在声明的同时赋值
		final int e;  ①
		// 只能赋值一次
		e = 100;      ②
		System.out.print(e);
		// 声明的同时赋值
		final int f = 200; ③
	}

	//实例常量
	final int a = 5; // 直接赋值  ④
	final int b; // 空白final变量 ⑤

	//静态常量
	final static int c = 12;// 直接赋值  ⑥
	final static int d; // 空白final变量 ⑦

	// 静态代码块
	static {					
		// 初始化静态变量
		d = 32;   ⑧
	}

	// 构造方法
	FinalDemo() {			
		// 初始化实例变量
		b = 3;     ⑨
		// 第二次赋值，会发生编译错误
		// b = 4;  ⑩
	}
}

```


上述代码第①行和第③行是声明局部常量，其中第①行只是声明没有赋值，但必须在使用之前赋值（见代码第②行），其实局部常量最好在声明的同时初始化。

代码第④、⑤、⑥和⑦行都声明成员常量。代码第④和⑤行是实例常量，如果是空白final变量（见代码第⑤行），则需要在构造方法中初始化（见代码第⑨行）。代码第⑥和⑦行是静态常量，如果是空白final变量（见代码第⑦行），则需要在静态代码块中初始化（见代码第⑧行）。

另外，无论是那种常量只能赋值一次，见代码第⑩行为b常量赋值，因为之前b已经赋值过一次，因此这里会发生编译错误。

### 12.5.2 final修饰类

final修饰的类不能被继承。有时出于设计安全的目的，不想让自己编写的类被别人继承，这是可以使用final关键字修饰父类。

示例代码如下：


```java
//SuperClass.java文件
package com.a51work6;

final class SuperClass {
}

class SubClass extends SuperClass { //编译错误
}
```

在声明SubClass类时会发生编译错误。

### 12.5.3 final修饰方法

final修饰的方法不能被子类覆盖。有时也是出于设计安全的目的，父类中的方法不想被别人覆盖，这是可以使用final关键字修饰父类中方法。

示例代码如下：


```java
//SuperClass.java文件
package com.a51work6;

class SuperClass {
	final void doSomething() {
		System.out.println("in SuperClass.doSomething()");
	}
}

class SubClass extends SuperClass {
	@Override
	void doSomething() { //编译错误
		System.out.println("in SubClass.doSomething()");
	}
}

```


子类中的void doSomething()方法试图覆盖父类中void doSomething()方法，父类中的void doSomething()方法是final的，因此会发生编译错误。